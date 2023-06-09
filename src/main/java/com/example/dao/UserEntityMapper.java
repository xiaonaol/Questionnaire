package com.example.dao;

import com.example.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserEntityMapper {
    List<UserEntity> queryUserList(UserEntity userEntity);
    int insert(UserEntity userEntity);
    int deleteUserByName(UserEntity userEntity);
    int updateByPrimarySelective(UserEntity userEntity);
    List<UserEntity> selectUserInfo(UserEntity userEntity);

    int closeUserById(UserEntity userEntity);

    int updateByPrimaryKey(UserEntity userEntity);
    UserEntity selectAllByName(String username);
}
