package com.example.myspring.springboot1;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tiantian")
public class SpringContrer {
    private static final Log log = LogFactory.getLog(SpringContrer.class);
//    @Value("${com.waiting.custom.one}")
//    private String message;


    @GetMapping
    public Map<String,Object> result() {
        if (log.isTraceEnabled()) {
            log.trace("log==========2222");
        }
        log.error("log==========");
        Map<String, Object> map = new HashMap<>();
        map.put("message", "45678");
        return map;
    }

    @GetMapping("/{id}")
    public String getid(@PathVariable int id){
        return "---"+id;
    }

}

