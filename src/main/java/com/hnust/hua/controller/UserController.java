package com.hnust.hua.controller;

import com.hnust.hua.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hnust.hua.service.StudentsService;

/**
 * Created by hua on 2018-04-03.
 * Describe:
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private StudentsService studentsService;

    @RequestMapping(value = "/students")
    @ResponseBody
    public Students selectStudents(@RequestParam(value = "id") Integer id){
        return studentsService.getStudentsByName(id);
    }

}
