package model;

public class SystemLog {
    private Integer systemLogId;

    private Byte logType;

    private Long systemLogTime;

    private Byte eventLevel;

    private Byte systemLogResult;

    private String logDescribe;

    public Integer getSystemLogId() {
        return systemLogId;
    }

    public void setSystemLogId(Integer systemLogId) {
        this.systemLogId = systemLogId;
    }

    public Byte getLogType() {
        return logType;
    }

    public void setLogType(Byte logType) {
        this.logType = logType;
    }

    public Long getSystemLogTime() {
        return systemLogTime;
    }

    public void setSystemLogTime(Long systemLogTime) {
        this.systemLogTime = systemLogTime;
    }

    public Byte getEventLevel() {
        return eventLevel;
    }

    public void setEventLevel(Byte eventLevel) {
        this.eventLevel = eventLevel;
    }

    public Byte getSystemLogResult() {
        return systemLogResult;
    }

    public void setSystemLogResult(Byte systemLogResult) {
        this.systemLogResult = systemLogResult;
    }

    public String getLogDescribe() {
        return logDescribe;
    }

    public void setLogDescribe(String logDescribe) {
        this.logDescribe = logDescribe == null ? null : logDescribe.trim();
    }
}