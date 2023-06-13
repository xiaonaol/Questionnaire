package com.example.service;

import com.example.common.utils.DateUtil;
import com.example.common.utils.UUIDUtil;
import com.example.dao.ProjectEntityMapper;
import com.example.dao.entity.ProjectEntity;
import com.example.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectEntityMapper projectEntityMapper;
    public List<ProjectEntity> queryProjectList(ProjectEntity projectEntity) {
        List<ProjectEntity> result = projectEntityMapper.queryProjectList(projectEntity);
        return result;
    }

    public int addProjectInfo(ProjectEntity projectEntity, String user) {
        String id = UUIDUtil.getOneUUID();
        projectEntity.setId(id);
        projectEntity.setUserId(user);
        Date date = DateUtil.getCreateTime();
        projectEntity.setCreationDate(date);
        projectEntity.setLastUpdateDate(date);
        projectEntityMapper.insertSelective(projectEntity);
        return 0;
    }

    public boolean queryProjectEntityIsExit(ProjectEntity projectEntity) {
        ProjectEntity projectEntity2 = projectEntityMapper.queryProjectEntity(projectEntity);
        if(projectEntity2==null) {
            return false;
        }
        else {
            return true;
        }
    }

    public int deleteProjectById(ProjectEntity projectEntity) {
        int result = projectEntityMapper.deleteProjectById(projectEntity);
        return result;
    }

    public int modifyProjectInfo(ProjectEntity projectEntity) {
        int result = projectEntityMapper.updateByPrimaryKeySelective(projectEntity);
        return result;
    }
}
