package com.leszr.hunter.menhu.controller;

import com.leszr.hunter.menhu.dao.SessionInstanceMapper;
import com.leszr.hunter.menhu.pojo.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private  SessionInstanceMapper sessionInstanceMapper;

    @RequestMapping(value = "/request",method = RequestMethod.GET)
    @ResponseBody
    public String getRequest(){
        Session session = new Session();
        session.setSessionId("id_" + new Date().getTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String createtime=df.format(new Date());
        session.setCreateTime(createtime);
        session.setUpdateTime(createtime);
        sessionInstanceMapper.addSession(session);
        return "ok";
    }
}
