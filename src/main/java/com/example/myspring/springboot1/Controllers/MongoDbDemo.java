package com.example.myspring.springboot1.Controllers;

import com.example.myspring.springboot1.Beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/login")
public class MongoDbDemo {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/getdata")
    public String getData(String name,String token){
        return "name :"+name+"token :"+token;
    }
    @PostMapping("/setuser")
    public String login(@RequestBody Map<String,Object>  request, @RequestHeader HttpHeaders headers){

       System.out.println("===========headers"+headers.get("Content-Type"));
        User user=new User();
        user.setId(Integer.parseInt(request.get("id").toString())  );
        user.setToken(request.get("token").toString());
        user.setName(request.get("name").toString());
        user.setPhone("123123123");

        mongoTemplate.save(user);
        return user.getName()+"----"+user.getId();
    }
    @GetMapping("/getuser")
    public String getUser(String id){
        User user=mongoTemplate.findById(Integer.parseInt(id),User.class);
        return  user.toString();
    }
    @PutMapping("/changeuser")
    public String changeUser(@RequestBody Map <String, Object>request){
        Query query=Query.query(Criteria.where("id").is(request.get("id")));
        Update update=new Update();
//        update.set("token",request.get("token"));
        update.set("name",request.get("name"));
        mongoTemplate.updateFirst(query,update,User.class);
         return mongoTemplate.findById(request.get("id"),User.class).toString();
    }
    @DeleteMapping("/deletuser")
    public String deletUser(String id){
        System.out.println("-----"+id);
        List<User> list=mongoTemplate.findAll(User.class);
        for (User user :list){
            System.out.println("-----"+user.getId());
        }
        mongoTemplate.remove(Query.query(Criteria.where("token").is("59")),User.class);

//        mongoTemplate.findAndRemove(Query.query(Criteria.where("id").is(id)),User.class);
        List<User> list2=mongoTemplate.findAll(User.class);
        for (User user :list2){
            System.out.println("-----"+user.getId());
        }
        return "success"+list2.size()+"------"+list.size();
    }


}
