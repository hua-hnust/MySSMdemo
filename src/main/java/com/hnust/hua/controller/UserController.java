package com.hnust.hua.controller;

import com.hnust.hua.model.Students;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hnust.hua.service.StudentsService;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hua on 2018-04-03.
 * Describe:
 */
@Controller
@RequestMapping(value = "/user")
@Api(value = "TestUserController",description = "用户接口测试")
public class UserController {

    @Autowired
    private StudentsService studentsService;

    @RequestMapping(value = "/students")
    @ResponseBody
    @ApiOperation(value = "根据ID获取学生信息",notes = "根据ID获取学生信息",httpMethod = "GET",response = ModelAndView.class)
    public ModelAndView selectStudents(@RequestParam(value = "id") Integer id){
        ModelAndView mv = new ModelAndView("hello");
        Students students = studentsService.getStudentsByName(id);
        mv.addObject("students",students);
        return mv;
    }
}
