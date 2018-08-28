package com.hnust.hua.service.impl;

import com.hnust.hua.model.Students;
import com.hnust.hua.service.StudentsService;
import com.hnust.hua.dao.StudentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hua on 2018-03-20.
 * Describe:
 */

@Service(value = "studentsService")
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsMapper studentsMapper;

    @Override
    public Students getStudentsByName(Integer id) {
        return studentsMapper.selectByPrimaryKey(id);
    }
}
