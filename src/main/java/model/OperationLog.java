package model;

public class OperationLog {
    private Integer operationLogId;

    private String userName;

    private String longinIp;

    private Long operationTime;

    private String operationAction;

    private Byte operationResult;

    private String logDescribe;

    public Integer getOperationLogId() {
        return operationLogId;
    }

    public void setOperationLogId(Integer operationLogId) {
        this.operationLogId = operationLogId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getLonginIp() {
        return longinIp;
    }

    public void setLonginIp(String longinIp) {
        this.longinIp = longinIp == null ? null : longinIp.trim();
    }

    public Long getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Long operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperationAction() {
        return operationAction;
    }

    public void setOperationAction(String operationAction) {
        this.operationAction = operationAction == null ? null : operationAction.trim();
    }

    public Byte getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(Byte operationResult) {
        this.operationResult = operationResult;
    }

    public String getLogDescribe() {
        return logDescribe;
    }

    public void setLogDescribe(String logDescribe) {
        this.logDescribe = logDescribe == null ? null : logDescribe.trim();
    }
}