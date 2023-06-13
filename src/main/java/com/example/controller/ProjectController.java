package com.example.controller;

import com.example.beans.HttpResponseEntity;
import com.example.dao.entity.ProjectEntity;
import com.example.dao.entity.UserEntity;
import com.example.service.ProjectService;
import com.example.service.UserService;
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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/queryProjectList",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity queryProjectList(@RequestBody(required = false) ProjectEntity projectEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        httpResponseEntity.setCode("666");
        List<ProjectEntity> resultList = projectService.queryProjectList(projectEntity);
        httpResponseEntity.setData(resultList);
        httpResponseEntity.setMessage("查询成功");
        return httpResponseEntity;
    }

    @RequestMapping(value = "/addProjectInfo",method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity addProjectInfo(@RequestBody ProjectEntity projectEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        boolean flag = projectService.queryProjectEntityIsExit(projectEntity);
        if(flag) {
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("项目已存在");
        }
        else {
            UserEntity userEntity = userService.queryByUserName(projectEntity.getCreatedBy());
            String user = userEntity.getId();
            projectService.addProjectInfo(projectEntity, user);
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(null);
            httpResponseEntity.setMessage("创建成功");
        }
        return httpResponseEntity;
    }

    @RequestMapping(value = "/deleteProjectById", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity deleteProjectById(@RequestBody ProjectEntity projectEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = projectService.deleteProjectById(projectEntity);
            if(result != 0) {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("删除成功");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("删除失败");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    @RequestMapping(value = "/modifyProjectInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity modifyProjectInfo(@RequestBody ProjectEntity projectEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = projectService.modifyProjectInfo(projectEntity);
            if(result != 0) {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("修改成功");
            }else{
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("修改失败");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
}
