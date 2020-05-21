package com.example.appointment.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.appointment.entity.UserBean;
import com.example.appointment.service.UserService;
import com.example.appointment.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public JSONObject login(String user_account, String user_password, HttpSession session){
        return userService.login(user_account, user_password, session);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getPosition")
    public JSONObject getPosition(HttpSession session){
        return StringUtils.result(0, session.getAttribute("user_position"));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/registe")
    public JSONObject registe(@RequestBody UserBean userBean){
        return userService.registe(userBean);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public JSONObject getUserList(int limit, int page, int user_position){
        return userService.getUserList(limit, page, user_position);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/password")
    public JSONObject editPassword(String user_id, String oldPassword, String newPassword){
        return userService.editPassword(user_id, oldPassword, newPassword);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/checked/{user_id}")
    public JSONObject editChecked(@PathVariable String user_id){
        return userService.editChecked(user_id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/remove")
    public JSONObject remove(@RequestBody List<String> list){
        return userService.removeUser(list);
    }
}
