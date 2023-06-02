package com.example.dao;

import com.example.dao.entity.UserEntity;

import java.util.List;

public interface UserEntityMapper {
    List<UserEntity> queryUserList(UserEntity userEntity);
    int insert(UserEntity userEntity);
    int deleteUserById(UserEntity userEntity);
    int updateByPrimarySelective(UserEntity userEntity);
    List<UserEntity> selectUserInfo(UserEntity userEntity);
}
