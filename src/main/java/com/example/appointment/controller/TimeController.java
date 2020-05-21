package com.example.appointment.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.appointment.entity.TimeBean;
import com.example.appointment.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/time")
@RestController
public class TimeController {
    @Autowired
    private TimeService timeService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public JSONObject addTime(@RequestBody TimeBean timeBean, HttpSession session){
        timeBean.setUser_id((String) session.getAttribute("user_id"));
        return timeService.addTime(timeBean);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public JSONObject getTimeList(int page, int limit, int schedule, HttpSession session){
        int user_position = (Integer) session.getAttribute("user_position");
        String user_id = user_position == 0 ? null : (String) session.getAttribute("user_id");
        return timeService.getTimeList(limit, page, user_id, schedule, null);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/myList")
    public JSONObject getMyTimeList(int page, int limit, HttpSession session){
        String user_id = (String) session.getAttribute("user_id");
        return timeService.getTimeList(limit, page, null, 1, user_id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public JSONObject editTime(String address, String starttime, String endtime, String tid){
        return timeService.editTime(address, starttime, endtime, tid);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/submit")
    public JSONObject submitTime(String detail, String tid, HttpSession session){
        String user_id = (String) session.getAttribute("user_id");
        return timeService.editTime(user_id, detail, tid);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/remove")
    public JSONObject remove(@RequestBody List<String> list){
        return timeService.remove(list);
    }
}
