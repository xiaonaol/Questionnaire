package com.example.service;

import com.example.common.utils.UUIDUtil;
import com.example.dao.UserEntityMapper;
import com.example.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    @Autowired
    private UserEntityMapper userEntityMapper;

    public List<UserEntity> selectUserInfo(UserEntity userEntity){
        List<UserEntity> result = userEntityMapper.selectUserInfo(userEntity);
        return result;
    }

    public List<UserEntity> queryUserList(UserEntity userEntity) {
        List<UserEntity> result = userEntityMapper.queryUserList(userEntity);
        return result;
    }

    public int addUserInfo(UserEntity userEntity) {
        userEntity.setId(UUIDUtil.getOneUUID());
        int userResult = userEntityMapper.insert(userEntity);
        if(userResult != 0){
            return 3;
        }else{
            return userResult;
        }
    }

    public int modifyUserInfo(UserEntity userEntity) {
        int userResult = userEntityMapper.updateByPrimaryKeySelective(userEntity);
        return  userResult;
    }

    public int deleteUserById(UserEntity userEntity) {
        int userResult = userEntityMapper.deleteUserById(userEntity);
        return userResult;
    }
}

