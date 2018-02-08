package com.imooc.firstappdemo.repository;

import com.imooc.firstappdemo.entity.UserEntity;

import java.util.Collection;

public interface UserRepository1 {

    Collection<UserEntity> findAll();
}
