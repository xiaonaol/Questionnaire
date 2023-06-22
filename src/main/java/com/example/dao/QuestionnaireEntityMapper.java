package com.example.dao;

import com.example.dao.entity.ProjectEntity;
import com.example.dao.entity.QuestionnaireEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Mapper
public interface QuestionnaireEntityMapper {
    int insert(QuestionnaireEntity questionnaireEntity);
    int updateByPrimaryKeySelective(QuestionnaireEntity questionnaireEntity);
    int deleteQuestionnaireById(QuestionnaireEntity questionnaireEntity);
    Map<QuestionnaireEntity, ProjectEntity> queryQuestionnaireList(QuestionnaireEntity questionnaireEntity, ProjectEntity projectEntity);
}
