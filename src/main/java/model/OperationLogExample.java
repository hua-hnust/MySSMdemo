package model;

import java.util.ArrayList;
import java.util.List;

public class OperationLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperationLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOperationLogIdIsNull() {
            addCriterion("operation_log_id is null");
            return (Criteria) this;
        }

        public Criteria andOperationLogIdIsNotNull() {
            addCriterion("operation_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperationLogIdEqualTo(Integer value) {
            addCriterion("operation_log_id =", value, "operationLogId");
            return (Criteria) this;
        }

        public Criteria andOperationLogIdNotEqualTo(Integer value) {
            addCriterion("operation_log_id <>", value, "operationLogId");
            return (Criteria) this;
        }

        public Criteria andOperationLogIdGreaterThan(Integer value) {
            addCriterion("operation_log_id >", value, "operationLogId");
            return (Criteria) this;
        }

        public Criteria andOperationLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("operation_log_id >=", value, "operationLogId");
            return (Criteria) this;
        }

        public Criteria andOperationLogIdLessThan(Integer value) {
            addCriterion("operation_log_id <", value, "operationLogId");
            return (Criteria) this;
        }

        public Criteria andOperationLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("operation_log_id <=", value, "operationLogId");
            return (Criteria) this;
        }

        public Criteria andOperationLogIdIn(List<Integer> values) {
            addCriterion("operation_log_id in", values, "operationLogId");
            return (Criteria) this;
        }

        public Criteria andOperationLogIdNotIn(List<Integer> values) {
            addCriterion("operation_log_id not in", values, "operationLogId");
            return (Criteria) this;
        }

        public Criteria andOperationLogIdBetween(Integer value1, Integer value2) {
            addCriterion("operation_log_id between", value1, value2, "operationLogId");
            return (Criteria) this;
        }

        public Criteria andOperationLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("operation_log_id not between", value1, value2, "operationLogId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andLonginIpIsNull() {
            addCriterion("longin_ip is null");
            return (Criteria) this;
        }

        public Criteria andLonginIpIsNotNull() {
            addCriterion("longin_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLonginIpEqualTo(String value) {
            addCriterion("longin_ip =", value, "longinIp");
            return (Criteria) this;
        }

        public Criteria andLonginIpNotEqualTo(String value) {
            addCriterion("longin_ip <>", value, "longinIp");
            return (Criteria) this;
        }

        public Criteria andLonginIpGreaterThan(String value) {
            addCriterion("longin_ip >", value, "longinIp");
            return (Criteria) this;
        }

        public Criteria andLonginIpGreaterThanOrEqualTo(String value) {
            addCriterion("longin_ip >=", value, "longinIp");
            return (Criteria) this;
        }

        public Criteria andLonginIpLessThan(String value) {
            addCriterion("longin_ip <", value, "longinIp");
            return (Criteria) this;
        }

        public Criteria andLonginIpLessThanOrEqualTo(String value) {
            addCriterion("longin_ip <=", value, "longinIp");
            return (Criteria) this;
        }

        public Criteria andLonginIpLike(String value) {
            addCriterion("longin_ip like", value, "longinIp");
            return (Criteria) this;
        }

        public Criteria andLonginIpNotLike(String value) {
            addCriterion("longin_ip not like", value, "longinIp");
            return (Criteria) this;
        }

        public Criteria andLonginIpIn(List<String> values) {
            addCriterion("longin_ip in", values, "longinIp");
            return (Criteria) this;
        }

        public Criteria andLonginIpNotIn(List<String> values) {
            addCriterion("longin_ip not in", values, "longinIp");
            return (Criteria) this;
        }

        public Criteria andLonginIpBetween(String value1, String value2) {
            addCriterion("longin_ip between", value1, value2, "longinIp");
            return (Criteria) this;
        }

        public Criteria andLonginIpNotBetween(String value1, String value2) {
            addCriterion("longin_ip not between", value1, value2, "longinIp");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNull() {
            addCriterion("operation_time is null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNotNull() {
            addCriterion("operation_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeEqualTo(Long value) {
            addCriterion("operation_time =", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotEqualTo(Long value) {
            addCriterion("operation_time <>", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThan(Long value) {
            addCriterion("operation_time >", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("operation_time >=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThan(Long value) {
            addCriterion("operation_time <", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThanOrEqualTo(Long value) {
            addCriterion("operation_time <=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIn(List<Long> values) {
            addCriterion("operation_time in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotIn(List<Long> values) {
            addCriterion("operation_time not in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeBetween(Long value1, Long value2) {
            addCriterion("operation_time between", value1, value2, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotBetween(Long value1, Long value2) {
            addCriterion("operation_time not between", value1, value2, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationActionIsNull() {
            addCriterion("operation_action is null");
            return (Criteria) this;
        }

        public Criteria andOperationActionIsNotNull() {
            addCriterion("operation_action is not null");
            return (Criteria) this;
        }

        public Criteria andOperationActionEqualTo(String value) {
            addCriterion("operation_action =", value, "operationAction");
            return (Criteria) this;
        }

        public Criteria andOperationActionNotEqualTo(String value) {
            addCriterion("operation_action <>", value, "operationAction");
            return (Criteria) this;
        }

        public Criteria andOperationActionGreaterThan(String value) {
            addCriterion("operation_action >", value, "operationAction");
            return (Criteria) this;
        }

        public Criteria andOperationActionGreaterThanOrEqualTo(String value) {
            addCriterion("operation_action >=", value, "operationAction");
            return (Criteria) this;
        }

        public Criteria andOperationActionLessThan(String value) {
            addCriterion("operation_action <", value, "operationAction");
            return (Criteria) this;
        }

        public Criteria andOperationActionLessThanOrEqualTo(String value) {
            addCriterion("operation_action <=", value, "operationAction");
            return (Criteria) this;
        }

        public Criteria andOperationActionLike(String value) {
            addCriterion("operation_action like", value, "operationAction");
            return (Criteria) this;
        }

        public Criteria andOperationActionNotLike(String value) {
            addCriterion("operation_action not like", value, "operationAction");
            return (Criteria) this;
        }

        public Criteria andOperationActionIn(List<String> values) {
            addCriterion("operation_action in", values, "operationAction");
            return (Criteria) this;
        }

        public Criteria andOperationActionNotIn(List<String> values) {
            addCriterion("operation_action not in", values, "operationAction");
            return (Criteria) this;
        }

        public Criteria andOperationActionBetween(String value1, String value2) {
            addCriterion("operation_action between", value1, value2, "operationAction");
            return (Criteria) this;
        }

        public Criteria andOperationActionNotBetween(String value1, String value2) {
            addCriterion("operation_action not between", value1, value2, "operationAction");
            return (Criteria) this;
        }

        public Criteria andOperationResultIsNull() {
            addCriterion("operation_result is null");
            return (Criteria) this;
        }

        public Criteria andOperationResultIsNotNull() {
            addCriterion("operation_result is not null");
            return (Criteria) this;
        }

        public Criteria andOperationResultEqualTo(Byte value) {
            addCriterion("operation_result =", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultNotEqualTo(Byte value) {
            addCriterion("operation_result <>", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultGreaterThan(Byte value) {
            addCriterion("operation_result >", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultGreaterThanOrEqualTo(Byte value) {
            addCriterion("operation_result >=", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultLessThan(Byte value) {
            addCriterion("operation_result <", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultLessThanOrEqualTo(Byte value) {
            addCriterion("operation_result <=", value, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultIn(List<Byte> values) {
            addCriterion("operation_result in", values, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultNotIn(List<Byte> values) {
            addCriterion("operation_result not in", values, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultBetween(Byte value1, Byte value2) {
            addCriterion("operation_result between", value1, value2, "operationResult");
            return (Criteria) this;
        }

        public Criteria andOperationResultNotBetween(Byte value1, Byte value2) {
            addCriterion("operation_result not between", value1, value2, "operationResult");
            return (Criteria) this;
        }

        public Criteria andLogDescribeIsNull() {
            addCriterion("log_describe is null");
            return (Criteria) this;
        }

        public Criteria andLogDescribeIsNotNull() {
            addCriterion("log_describe is not null");
            return (Criteria) this;
        }

        public Criteria andLogDescribeEqualTo(String value) {
            addCriterion("log_describe =", value, "logDescribe");
            return (Criteria) this;
        }

        public Criteria andLogDescribeNotEqualTo(String value) {
            addCriterion("log_describe <>", value, "logDescribe");
            return (Criteria) this;
        }

        public Criteria andLogDescribeGreaterThan(String value) {
            addCriterion("log_describe >", value, "logDescribe");
            return (Criteria) this;
        }

        public Criteria andLogDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("log_describe >=", value, "logDescribe");
            return (Criteria) this;
        }

        public Criteria andLogDescribeLessThan(String value) {
            addCriterion("log_describe <", value, "logDescribe");
            return (Criteria) this;
        }

        public Criteria andLogDescribeLessThanOrEqualTo(String value) {
            addCriterion("log_describe <=", value, "logDescribe");
            return (Criteria) this;
        }

        public Criteria andLogDescribeLike(String value) {
            addCriterion("log_describe like", value, "logDescribe");
            return (Criteria) this;
        }

        public Criteria andLogDescribeNotLike(String value) {
            addCriterion("log_describe not like", value, "logDescribe");
            return (Criteria) this;
        }

        public Criteria andLogDescribeIn(List<String> values) {
            addCriterion("log_describe in", values, "logDescribe");
            return (Criteria) this;
        }

        public Criteria andLogDescribeNotIn(List<String> values) {
            addCriterion("log_describe not in", values, "logDescribe");
            return (Criteria) this;
        }

        public Criteria andLogDescribeBetween(String value1, String value2) {
            addCriterion("log_describe between", value1, value2, "logDescribe");
            return (Criteria) this;
        }

        public Criteria andLogDescribeNotBetween(String value1, String value2) {
            addCriterion("log_describe not between", value1, value2, "logDescribe");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}