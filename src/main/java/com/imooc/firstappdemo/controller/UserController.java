package com.imooc.firstappdemo.controller;


import com.imooc.firstappdemo.entity.UserEntity;
import com.imooc.firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RestController
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     * 存储用户请求对象和用户ID
     * @param name 用户名
     * @return 用户对象的名字和ID
     */
    @PostMapping("/person/save")
    public UserEntity save(@RequestParam String name){

        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        if(userRepository.save(userEntity)){
            System.out.printf("用户对象：%s 保存成功！\n",userEntity);
        }

        return userEntity;
    }

    /**
     * 返回所有用户列表
     * @return
     */
    public List<UserEntity> findAll(){
        //return userRepository.values();
        return null;
    }
}
