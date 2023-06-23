package com.example.service;

import com.example.common.utils.UUIDUtil;
import com.example.dao.QuestionEntityMapper;
import com.example.dao.entity.QuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionEntityMapper questionEntityMapper;

    public List<QuestionEntity> queryQuestionList(QuestionEntity questionEntity){
        List<QuestionEntity> result = questionEntityMapper.queryQuestionList(questionEntity);
        return result;
    }

    public int insert(QuestionEntity questionEntity){
        questionEntity.setId(UUIDUtil.getOneUUID());
        int result = questionEntityMapper.insert(questionEntity);
        if (result != 0)
            return 3;
        else
            return result;
    }

    public int updateByPrimaryKeySelective(QuestionEntity questionEntity){
        int result = questionEntityMapper.updateByPrimaryKeySelective(questionEntity);
        return result;
    }

    public int deleteQuestionById(QuestionEntity questionEntity){
        int result = questionEntityMapper.deleteQuestionById(questionEntity);
        return result;
    }
}
