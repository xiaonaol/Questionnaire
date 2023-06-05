package com.example.service;

import com.example.common.utils.UUIDUtil;
import com.example.dao.UserEntityMapper;
import com.example.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        userEntity.setStatus("1");
        int userResult = userEntityMapper.insert(userEntity);
        if(userResult != 0){
            return 3;
        }else{
            return userResult;
        }
    }

    public int modifyUserInfo(UserEntity userEntity) {
        int userResult = userEntityMapper.updateByPrimaryKey(userEntity);
        return  userResult;
    }

    public int deleteUserById(UserEntity userEntity) {
        int userResult = userEntityMapper.deleteUserById(userEntity);
        return userResult;
    }

    public int closeUserById(UserEntity userEntity) {
        int userResult = userEntityMapper.closeUserById(userEntity);
        return userResult;
    }
}

