package com.example.myspring.springboot1;

import com.example.myspring.springboot1.Beans.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
   public   User findByName(String name);
}
