package com.example.dao;

import com.example.dao.entity.QuestionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface QuestionEntityMapper {
    List<QuestionEntity> queryQuestionList(QuestionEntity questionEntity);
    int insert(QuestionEntity questionEntity);
    int updateByPrimaryKeySelective(QuestionEntity questionEntity);
    int deleteQuestionById(QuestionEntity questionEntity);
}
