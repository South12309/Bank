package com.takush.bank.controllers;

import com.takush.bank.dto.UserDto;
import com.takush.bank.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/userList")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userList(Model model) {
        List<UserDto> userList = userService.findAll();
        model.addAttribute("users", userList);
        return "userList";
    }
    @GetMapping("/user")
    public String newUser(@RequestParam("id") Long id, Model model) {
        UserDto userDto = userService.findById(id);
        model.addAttribute("user", userDto);
        return "user";
    }
    @GetMapping(value = "/user", params = "new")
    public String newUser(Model model) {
        model.addAttribute("user", new UserDto());
        return "user";
    }

    @PostMapping("/user")
    public String newUserSave(UserDto userDto, Model model) {

        if (userService.save(userDto))
            return "redirect:/";
        else {
            model.addAttribute("user", userDto);
            return "user";
        }


    }

}
