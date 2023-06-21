package com.example.service;

import com.example.common.utils.UUIDUtil;
import com.example.dao.UserEntityMapper;
import com.example.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public int addUserInfo(UserEntity userEntity) throws ParseException {
        userEntity.setId(UUIDUtil.getOneUUID());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(new java.util.Date());
        userEntity.setCreationDate(new java.sql.Date(sdf.parse(currentTime).getTime()));
        userEntity.setStatus("1");
        int userResult = userEntityMapper.insert(userEntity);
        if(userResult != 0){
            return 3;
        }else{
            return userResult;
        }
    }

    public int modifyUserInfo(UserEntity userEntity) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(new java.util.Date());
        userEntity.setCreationDate(new java.sql.Date(sdf.parse(currentTime).getTime()));
        return userEntityMapper.updateByPrimaryKey(userEntity);
    }

    public int deleteUserByName(UserEntity userEntity) {
        int userResult = userEntityMapper.deleteUserByName(userEntity);
        return userResult;
    }

    public int closeUserById(UserEntity userEntity) {
        int userResult = userEntityMapper.closeUserById(userEntity);
        return userResult;
    }

    public UserEntity queryByUserName(String userName) {
        return userEntityMapper.selectAllByName(userName);
    }
}

