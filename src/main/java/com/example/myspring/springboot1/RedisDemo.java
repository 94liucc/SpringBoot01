package com.example.myspring.springboot1;


import com.example.myspring.springboot1.Beans.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@RestController
//@RequestMapping("/login")
//public class RedisDemo {
//
//    @Autowired
//    RedisTemplate redisTemplate;
//    @GetMapping("/set/{id}/{name}")
//    public String login(@PathVariable("id") String id,@PathVariable("name") String name){
//        User user=new User();
//        user.setId(1);
//        user.setToken(id);
//        user.setName(name);
//        redisTemplate.opsForValue().set(id,user);
//        return "success"+id+"---"+name;
//    }
//    @GetMapping("/get/{id}")
//    public String getUser(@PathVariable("id") String id){
//        return ((User) redisTemplate.opsForValue().get(id)).getName();
//    }
//
//}
