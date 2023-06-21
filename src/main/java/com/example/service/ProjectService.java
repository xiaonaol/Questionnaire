package com.example.service;

import com.example.common.utils.UUIDUtil;
import com.example.dao.ProjectEntityMapper;
import com.example.dao.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectEntityMapper projectEntityMapper;
    public List<ProjectEntity> queryProjectList(ProjectEntity projectEntity) {
        List<ProjectEntity> result = projectEntityMapper.queryProjectList(projectEntity);
        return result;
    }

    public int addProjectInfo(ProjectEntity projectEntity, String user) throws ParseException {
        String id = UUIDUtil.getOneUUID();
        if(projectEntity.getId() == null) {
            projectEntity.setId(id);
        }
        projectEntity.setUserId(user);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(new java.util.Date());

        projectEntity.setCreationDate(new java.sql.Date(sdf.parse(currentTime).getTime()));
        projectEntity.setLastUpdateDate(new java.sql.Date(sdf.parse(currentTime).getTime()));
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
