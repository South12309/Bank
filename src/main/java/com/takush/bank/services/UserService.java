package com.takush.bank.services;

import com.takush.bank.dto.UserDto;
import com.takush.bank.entities.UserAbs;
import com.takush.bank.mappers.UserMapper;

import com.takush.bank.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;


@Service
public class UserService implements UserDetailsService  {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        return userRepository.findByLogin(login)
                .map(user -> new User(
                        user.getLogin(),
                        user.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()))
                ))
                .orElseThrow(() ->new UsernameNotFoundException("Пользователь не найден"));

    }

    public List<UserDto> findAll() {
        return userMapper.toDtoList(userRepository.findAll());
    }


    public boolean save(UserDto userDto) {

        UserAbs userAbs = userMapper.fromDto(userDto);
        if(!(userRepository.save(userAbs)==null))
            return true;
        return false;
    }

    public UserDto findById(Long id) {
        UserAbs userAbs = userRepository.findById(id).get();
        return userMapper.toDto(userAbs);
    }
}
