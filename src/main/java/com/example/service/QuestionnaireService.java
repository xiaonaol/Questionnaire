package com.example.service;

import com.example.common.utils.UUIDUtil;
import com.example.dao.QuestionnaireEntityMapper;
import com.example.dao.entity.ProjectEntity;
import com.example.dao.entity.QuestionnaireEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class QuestionnaireService {
    @Autowired
    private QuestionnaireEntityMapper questionnaireEntityMapper;

    public Map<QuestionnaireEntity, ProjectEntity> queryQuestionnaireList(QuestionnaireEntity questionnaireEntity, ProjectEntity projectEntity){
        Map<QuestionnaireEntity, ProjectEntity> result = questionnaireEntityMapper.queryQuestionnaireList(questionnaireEntity, projectEntity);
        return result;
    }

    public int insert(QuestionnaireEntity questionnaireEntity){
        questionnaireEntity.setId(UUIDUtil.getOneUUID());
        int questionnaireResult = questionnaireEntityMapper.insert(questionnaireEntity);
        if (questionnaireResult!=0){
            return 3;
        } else {
            return questionnaireResult;
        }
    }

    public int updateByPrimaryKeySelective(QuestionnaireEntity questionnaireEntity){
        return questionnaireEntityMapper.updateByPrimaryKeySelective(questionnaireEntity);
    }

    public int deleteQuestionnaireById(QuestionnaireEntity questionnaireEntity){
        return questionnaireEntityMapper.deleteQuestionnaireById(questionnaireEntity);
    }
}
