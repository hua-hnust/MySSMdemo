package com.hnust.hua.controller;

import com.hnust.hua.model.Students;
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
public class UserController {

    @Autowired
    private StudentsService studentsService;

    @RequestMapping(value = "/students")
    @ResponseBody
    public ModelAndView selectStudents(@RequestParam(value = "id") Integer id){
        ModelAndView mv = new ModelAndView("hello");
        Students students = studentsService.getStudentsByName(id);
        mv.addObject("students",students);
        return mv;
    }

}
