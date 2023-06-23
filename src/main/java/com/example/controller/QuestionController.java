package com.example.controller;

import com.example.beans.HttpResponseEntity;
import com.example.dao.entity.QuestionEntity;
import com.example.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/queryQuestionList", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity queryQuestionList(@RequestBody QuestionEntity questionEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            List<QuestionEntity> hasQuestion = questionService.queryQuestionList(questionEntity);
            if (CollectionUtils.isEmpty(hasQuestion)) {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("无问题信息");
            } else {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(hasQuestion);
                httpResponseEntity.setMessage("查询成功");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    @RequestMapping(value = "/addQuestionInfo", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity addQuestionInfo(@RequestBody QuestionEntity questionEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = questionService.insert(questionEntity);
            if (result != 0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("新增问题成功");
            }else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("新增问题失败");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    @RequestMapping(value = "/modifyQuestionInfo", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity modifyQuestionInfo(@RequestBody QuestionEntity questionEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = questionService.updateByPrimaryKeySelective(questionEntity);
            if (result != 0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("修改成功");
            }else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("修改失败");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    @RequestMapping(value = "/deleteQuestionById", method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity deleteQuestionById(@RequestBody QuestionEntity questionEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = questionService.deleteQuestionById(questionEntity);
            if (result != 0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("删除成功");
            }else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("删除失败");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }
}
