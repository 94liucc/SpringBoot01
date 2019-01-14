package com.example.myspring.springboot1;

import com.example.myspring.springboot1.Beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.function.Predicate;

@RestController
@RequestMapping("/login")
public class MongoDbDemo {

    @Autowired
    private MongoTemplate mongoTemplate;



    private class Bean{
        private String name;
        private String id;
        public String getName(){
            return  this.name;
        }
    }
    @GetMapping("/getdata")
    public String getData(String name,String token){
        return "name :"+name+"token :"+token;
    }
    @PostMapping("/setuser")
    public String login(@RequestBody Map<String,Object>  request){

       System.out.println("==========="+request.get("name").toString());
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
    public String changeUser(@RequestBody Map<String,Object> request){
        Query query=Query.query(Criteria.where("id").is(request.get("id")));
        Update update=new Update();
        update.set("token",request.get("token"));
        update.set("name",request.get("name"));
        mongoTemplate.updateFirst(query,update,User.class);
         return mongoTemplate.findById(request.get("id"),User.class).toString();
    }
    @DeleteMapping("/deletuser")
    public String deletUser(@RequestBody Map<String,String> request){
        System.out.println("-----"+request.get("id"));
        mongoTemplate.remove(Query.query(Criteria.where("id").is(request.get("id"))),User.class);
        return "success";
    }


}
