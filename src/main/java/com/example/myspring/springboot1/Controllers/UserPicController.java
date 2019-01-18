package com.example.myspring.springboot1.Controllers;


import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.IOUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;

@RestController
@RequestMapping("/picture")
public class UserPicController {


    @PostMapping("/addpic")
    public @ResponseBody String addUserPic(@RequestParam("file") MultipartFile imgfile,@RequestParam("id") String id){


        System.out.println("id:===="+id+"文件名：===="+imgfile.getOriginalFilename());
        try {
            FileOutputStream outputStream=new FileOutputStream("target/"+imgfile.getOriginalFilename());
            IOUtils.copy(imgfile.getInputStream(),outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return "target/"+imgfile.getOriginalFilename();
    }
}
