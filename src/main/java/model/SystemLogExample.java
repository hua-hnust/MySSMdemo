package model;

import java.util.ArrayList;
import java.util.List;

public class SystemLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemLogExample() {
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

        public Criteria andSystemLogIdIsNull() {
            addCriterion("system_log_id is null");
            return (Criteria) this;
        }

        public Criteria andSystemLogIdIsNotNull() {
            addCriterion("system_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andSystemLogIdEqualTo(Integer value) {
            addCriterion("system_log_id =", value, "systemLogId");
            return (Criteria) this;
        }

        public Criteria andSystemLogIdNotEqualTo(Integer value) {
            addCriterion("system_log_id <>", value, "systemLogId");
            return (Criteria) this;
        }

        public Criteria andSystemLogIdGreaterThan(Integer value) {
            addCriterion("system_log_id >", value, "systemLogId");
            return (Criteria) this;
        }

        public Criteria andSystemLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("system_log_id >=", value, "systemLogId");
            return (Criteria) this;
        }

        public Criteria andSystemLogIdLessThan(Integer value) {
            addCriterion("system_log_id <", value, "systemLogId");
            return (Criteria) this;
        }

        public Criteria andSystemLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("system_log_id <=", value, "systemLogId");
            return (Criteria) this;
        }

        public Criteria andSystemLogIdIn(List<Integer> values) {
            addCriterion("system_log_id in", values, "systemLogId");
            return (Criteria) this;
        }

        public Criteria andSystemLogIdNotIn(List<Integer> values) {
            addCriterion("system_log_id not in", values, "systemLogId");
            return (Criteria) this;
        }

        public Criteria andSystemLogIdBetween(Integer value1, Integer value2) {
            addCriterion("system_log_id between", value1, value2, "systemLogId");
            return (Criteria) this;
        }

        public Criteria andSystemLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("system_log_id not between", value1, value2, "systemLogId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNull() {
            addCriterion("log_type is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNotNull() {
            addCriterion("log_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeEqualTo(Byte value) {
            addCriterion("log_type =", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotEqualTo(Byte value) {
            addCriterion("log_type <>", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(Byte value) {
            addCriterion("log_type >", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("log_type >=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(Byte value) {
            addCriterion("log_type <", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(Byte value) {
            addCriterion("log_type <=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeIn(List<Byte> values) {
            addCriterion("log_type in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotIn(List<Byte> values) {
            addCriterion("log_type not in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeBetween(Byte value1, Byte value2) {
            addCriterion("log_type between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("log_type not between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andSystemLogTimeIsNull() {
            addCriterion("system_log_time is null");
            return (Criteria) this;
        }

        public Criteria andSystemLogTimeIsNotNull() {
            addCriterion("system_log_time is not null");
            return (Criteria) this;
        }

        public Criteria andSystemLogTimeEqualTo(Long value) {
            addCriterion("system_log_time =", value, "systemLogTime");
            return (Criteria) this;
        }

        public Criteria andSystemLogTimeNotEqualTo(Long value) {
            addCriterion("system_log_time <>", value, "systemLogTime");
            return (Criteria) this;
        }

        public Criteria andSystemLogTimeGreaterThan(Long value) {
            addCriterion("system_log_time >", value, "systemLogTime");
            return (Criteria) this;
        }

        public Criteria andSystemLogTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("system_log_time >=", value, "systemLogTime");
            return (Criteria) this;
        }

        public Criteria andSystemLogTimeLessThan(Long value) {
            addCriterion("system_log_time <", value, "systemLogTime");
            return (Criteria) this;
        }

        public Criteria andSystemLogTimeLessThanOrEqualTo(Long value) {
            addCriterion("system_log_time <=", value, "systemLogTime");
            return (Criteria) this;
        }

        public Criteria andSystemLogTimeIn(List<Long> values) {
            addCriterion("system_log_time in", values, "systemLogTime");
            return (Criteria) this;
        }

        public Criteria andSystemLogTimeNotIn(List<Long> values) {
            addCriterion("system_log_time not in", values, "systemLogTime");
            return (Criteria) this;
        }

        public Criteria andSystemLogTimeBetween(Long value1, Long value2) {
            addCriterion("system_log_time between", value1, value2, "systemLogTime");
            return (Criteria) this;
        }

        public Criteria andSystemLogTimeNotBetween(Long value1, Long value2) {
            addCriterion("system_log_time not between", value1, value2, "systemLogTime");
            return (Criteria) this;
        }

        public Criteria andEventLevelIsNull() {
            addCriterion("event_level is null");
            return (Criteria) this;
        }

        public Criteria andEventLevelIsNotNull() {
            addCriterion("event_level is not null");
            return (Criteria) this;
        }

        public Criteria andEventLevelEqualTo(Byte value) {
            addCriterion("event_level =", value, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelNotEqualTo(Byte value) {
            addCriterion("event_level <>", value, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelGreaterThan(Byte value) {
            addCriterion("event_level >", value, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("event_level >=", value, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelLessThan(Byte value) {
            addCriterion("event_level <", value, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelLessThanOrEqualTo(Byte value) {
            addCriterion("event_level <=", value, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelIn(List<Byte> values) {
            addCriterion("event_level in", values, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelNotIn(List<Byte> values) {
            addCriterion("event_level not in", values, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelBetween(Byte value1, Byte value2) {
            addCriterion("event_level between", value1, value2, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("event_level not between", value1, value2, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andSystemLogResultIsNull() {
            addCriterion("system_log_result is null");
            return (Criteria) this;
        }

        public Criteria andSystemLogResultIsNotNull() {
            addCriterion("system_log_result is not null");
            return (Criteria) this;
        }

        public Criteria andSystemLogResultEqualTo(Byte value) {
            addCriterion("system_log_result =", value, "systemLogResult");
            return (Criteria) this;
        }

        public Criteria andSystemLogResultNotEqualTo(Byte value) {
            addCriterion("system_log_result <>", value, "systemLogResult");
            return (Criteria) this;
        }

        public Criteria andSystemLogResultGreaterThan(Byte value) {
            addCriterion("system_log_result >", value, "systemLogResult");
            return (Criteria) this;
        }

        public Criteria andSystemLogResultGreaterThanOrEqualTo(Byte value) {
            addCriterion("system_log_result >=", value, "systemLogResult");
            return (Criteria) this;
        }

        public Criteria andSystemLogResultLessThan(Byte value) {
            addCriterion("system_log_result <", value, "systemLogResult");
            return (Criteria) this;
        }

        public Criteria andSystemLogResultLessThanOrEqualTo(Byte value) {
            addCriterion("system_log_result <=", value, "systemLogResult");
            return (Criteria) this;
        }

        public Criteria andSystemLogResultIn(List<Byte> values) {
            addCriterion("system_log_result in", values, "systemLogResult");
            return (Criteria) this;
        }

        public Criteria andSystemLogResultNotIn(List<Byte> values) {
            addCriterion("system_log_result not in", values, "systemLogResult");
            return (Criteria) this;
        }

        public Criteria andSystemLogResultBetween(Byte value1, Byte value2) {
            addCriterion("system_log_result between", value1, value2, "systemLogResult");
            return (Criteria) this;
        }

        public Criteria andSystemLogResultNotBetween(Byte value1, Byte value2) {
            addCriterion("system_log_result not between", value1, value2, "systemLogResult");
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