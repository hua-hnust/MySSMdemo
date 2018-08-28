package service.impl;

import model.Students;
import dao.StudentsMapper;
import model.StudentsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.StudentsService;

/**
 * Created by hua on 2018-03-20.
 * Describe:
 */

@Service(value = "studentsService")
public class StudentsServiceImpl implements StudentsService{

    @Autowired
    private StudentsMapper studentsMapper;

    @Override
    public Students getStudentsByName(String name) {
        return studentsMapper.selectByPrimaryKey(name);
    }
}
