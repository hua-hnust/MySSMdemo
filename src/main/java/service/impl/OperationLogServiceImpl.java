package service.impl;

import dao.OperationLogMapper;
import model.OperationLog;
import model.OperationLogExample;
import org.springframework.beans.factory.annotation.Autowired;
import service.OperationLogService;

import java.util.List;

/**
 * Created by hua on 2018-04-03.
 * Describe:
 */
public class OperationLogServiceImpl implements OperationLogService{

    @Autowired
    private OperationLogMapper operationLogMapper;

    @Override  //获得所有日志信息
    public List<OperationLog> getAllLog() {
        OperationLogExample oe = new OperationLogExample();
        oe.createCriteria();
        return operationLogMapper.selectByExample(oe);
    }
}
