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
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/queryProjectList",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity queryProjectList(@RequestBody(required = false) ProjectEntity projectEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode("666");
        List<ProjectEntity> resultList = projectService.queryProjectList(projectEntity);
        httpResponseEntity.setData(resultList);
        httpResponseEntity.setMessage("查询成功");
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
