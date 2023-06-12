package com.example.service;

import com.example.common.utils.UUIDUtil;
import com.example.dao.ProjectEntityMapper;
import com.example.dao.entity.ProjectEntity;
import com.example.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectEntityMapper projectEntityMapper;
    public List<ProjectEntity> queryProjectList(ProjectEntity projectEntity) {
        List<ProjectEntity> result = projectEntityMapper.queryProjectList(projectEntity);
        return result;
    }

    public int addProjectInfo(ProjectEntity projectEntity) {
        projectEntity.setId(UUIDUtil.getOneUUID());
        int projectResult = projectEntityMapper.insert(projectEntity);
        if(projectResult != 0){
            return 3;
        }else{
            return projectResult;
        }
    }
}
