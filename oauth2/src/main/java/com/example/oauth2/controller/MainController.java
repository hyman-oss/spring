package com.example.oauth2.controller;

import com.example.oauth2.dao.SysUserRepository;
import com.example.oauth2.entity.JwtUserDetails;
import com.example.oauth2.entity.SysUser;
import com.example.oauth2.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hua-cloud
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class MainController {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private  JwtTokenUtil jwtTokenUtil;

    @RequestMapping("/detail")
    public String hello(@RequestBody Map map) {

        return "hello";
    }

    @RequestMapping("/login")
    public Map login(@RequestBody Map map) {
        log.info("{}",map.get("username"));
        SysUser sysUser = sysUserRepository.getUserByName((String) map.get("username"));
        log.info("{}",sysUser);
        Map<String,String> p = new HashMap<>(16);
        if(sysUser == null){
            p.put("msg","用户不存在");
            return p;
        }
        JwtUserDetails jwtUserDetails = new JwtUserDetails();
        jwtUserDetails.setUserName(sysUser.getName());
        jwtUserDetails.setPassword(sysUser.getPassword());
        String token = jwtTokenUtil.generateToken(jwtUserDetails);
        p.put("username",sysUser.getName());
        p.put("token",token);
        return p;
    }
}