package com.example;

import com.example.beans.HttpResponseEntity;
import com.example.controller.ProjectController;
import com.example.dao.entity.ProjectEntity;
import com.example.service.ProjectService;
import com.example.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoJUnitTest {
    @Resource
    private ProjectController projectController;
    Logger log = Logger.getLogger(DemoApplicationTests.class);
    @Test
    public void queryProjectList() throws Exception {

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectName("123");
        HttpResponseEntity httpResponseEntity = projectController.queryProjectList(projectEntity);
        log.info("结果");
        if (httpResponseEntity.getData().toString()!=null){
            log.info(">>queryProjectList项目列表查询测试成功");
        }else{
            log.info(">>queryProjectList项目列表查询失败");
        }
    }

    @Test
    public void deleteProjectById() throws Exception {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId("578b14af4baf427494e7cf381282e695");
        HttpResponseEntity httpResponseEntity = projectController.deleteProjectById(projectEntity);
        if (httpResponseEntity.getData().toString()!=null){
            //log.info(httpResponseEntity.getData().toString());
            log.info(">>deleteUserById项目删除成功");
        }else{
            log.info(">>deleteUserById项目删除失败");
        }
    }

    @Test
    public void addProjectInfo() throws Exception {

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectName("67891");
        projectEntity.setProjectContent("654321");
        projectEntity.setCreatedBy("123");
        HttpResponseEntity httpResponseEntity = projectController.addProjectInfo(projectEntity);
        if (httpResponseEntity.getCode()=="666"){
            log.info(">>addProjectInfo项目新增成功");
        }else if(httpResponseEntity.getCode()=="0"){
            log.info(">>addProjectInfo该项目已经存在");
        }else{
            log.info(">>addProjectInfo项目新增失败");
        }
    }
    @Test
    public void modifyProjectInfo() throws Exception {

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId("d3cd669ab849466aa557237a13bb26c2");
        projectEntity.setProjectName("111");
        projectEntity.setProjectContent("65431");
        HttpResponseEntity httpResponseEntity = projectController.modifyProjectInfo(projectEntity);
        log.info(httpResponseEntity.getCode());
        if (httpResponseEntity.getCode() == "666") {
            log.info(">>modifyProjectInfo项目修改成功");
        } else if (httpResponseEntity.getCode() == "10") {
            log.info(">>modifyProjectInfo要修改的项目不存在");
        } else {
            log.info(">modifyProjectInfo>修改失败");
        }

    }
}
