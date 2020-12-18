package com.xsw.activitiapi.controller;

import com.xsw.activitiapi.model.dto.UserDTO;
import com.xsw.activitiapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xueshengwen
 * @since 2020/12/18 13:29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userInfo/{userId}")
    public List<UserDTO> userInfo(@PathVariable String userId) {
        return userService.getUserInfo(userId);
    }

}
