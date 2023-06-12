package com.example.controller;

import com.example.beans.HttpResponseEntity;
import com.example.dao.entity.ProjectEntity;
import com.example.dao.entity.UserEntity;
import com.example.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/queryProjectList", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity queryProjectList(@RequestBody ProjectEntity projectEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            List<ProjectEntity> hasProject = projectService.queryProjectList(projectEntity);
            if(CollectionUtils.isEmpty(hasProject)) {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(hasProject.get(0));
                httpResponseEntity.setMessage("无项目信息");
            }else{
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(hasProject);
                httpResponseEntity.setMessage("查询成功");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    @RequestMapping(value = "/addProjectInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity addUser(@RequestBody ProjectEntity projectEntity) {
        System.out.println(projectEntity.toString());
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = projectService.addProjectInfo(projectEntity);
            if(result != 0) {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("创建成功");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("创建失败");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
}
