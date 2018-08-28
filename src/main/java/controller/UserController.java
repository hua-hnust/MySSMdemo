package controller;

import model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.StudentsService;

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
    public Students selectStudents(String name){
        return studentsService.getStudentsByName(name);
    }

}
