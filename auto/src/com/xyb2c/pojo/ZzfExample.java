package com.xyb2c.pojo;

import java.util.ArrayList;
import java.util.List;

public class ZzfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZzfExample() {
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

        public Criteria andData1IsNull() {
            addCriterion("data_1 is null");
            return (Criteria) this;
        }

        public Criteria andData1IsNotNull() {
            addCriterion("data_1 is not null");
            return (Criteria) this;
        }

        public Criteria andData1EqualTo(String value) {
            addCriterion("data_1 =", value, "data1");
            return (Criteria) this;
        }

        public Criteria andData1NotEqualTo(String value) {
            addCriterion("data_1 <>", value, "data1");
            return (Criteria) this;
        }

        public Criteria andData1GreaterThan(String value) {
            addCriterion("data_1 >", value, "data1");
            return (Criteria) this;
        }

        public Criteria andData1GreaterThanOrEqualTo(String value) {
            addCriterion("data_1 >=", value, "data1");
            return (Criteria) this;
        }

        public Criteria andData1LessThan(String value) {
            addCriterion("data_1 <", value, "data1");
            return (Criteria) this;
        }

        public Criteria andData1LessThanOrEqualTo(String value) {
            addCriterion("data_1 <=", value, "data1");
            return (Criteria) this;
        }

        public Criteria andData1Like(String value) {
            addCriterion("data_1 like", value, "data1");
            return (Criteria) this;
        }

        public Criteria andData1NotLike(String value) {
            addCriterion("data_1 not like", value, "data1");
            return (Criteria) this;
        }

        public Criteria andData1In(List<String> values) {
            addCriterion("data_1 in", values, "data1");
            return (Criteria) this;
        }

        public Criteria andData1NotIn(List<String> values) {
            addCriterion("data_1 not in", values, "data1");
            return (Criteria) this;
        }

        public Criteria andData1Between(String value1, String value2) {
            addCriterion("data_1 between", value1, value2, "data1");
            return (Criteria) this;
        }

        public Criteria andData1NotBetween(String value1, String value2) {
            addCriterion("data_1 not between", value1, value2, "data1");
            return (Criteria) this;
        }

        public Criteria andData2IsNull() {
            addCriterion("data_2 is null");
            return (Criteria) this;
        }

        public Criteria andData2IsNotNull() {
            addCriterion("data_2 is not null");
            return (Criteria) this;
        }

        public Criteria andData2EqualTo(String value) {
            addCriterion("data_2 =", value, "data2");
            return (Criteria) this;
        }

        public Criteria andData2NotEqualTo(String value) {
            addCriterion("data_2 <>", value, "data2");
            return (Criteria) this;
        }

        public Criteria andData2GreaterThan(String value) {
            addCriterion("data_2 >", value, "data2");
            return (Criteria) this;
        }

        public Criteria andData2GreaterThanOrEqualTo(String value) {
            addCriterion("data_2 >=", value, "data2");
            return (Criteria) this;
        }

        public Criteria andData2LessThan(String value) {
            addCriterion("data_2 <", value, "data2");
            return (Criteria) this;
        }

        public Criteria andData2LessThanOrEqualTo(String value) {
            addCriterion("data_2 <=", value, "data2");
            return (Criteria) this;
        }

        public Criteria andData2Like(String value) {
            addCriterion("data_2 like", value, "data2");
            return (Criteria) this;
        }

        public Criteria andData2NotLike(String value) {
            addCriterion("data_2 not like", value, "data2");
            return (Criteria) this;
        }

        public Criteria andData2In(List<String> values) {
            addCriterion("data_2 in", values, "data2");
            return (Criteria) this;
        }

        public Criteria andData2NotIn(List<String> values) {
            addCriterion("data_2 not in", values, "data2");
            return (Criteria) this;
        }

        public Criteria andData2Between(String value1, String value2) {
            addCriterion("data_2 between", value1, value2, "data2");
            return (Criteria) this;
        }

        public Criteria andData2NotBetween(String value1, String value2) {
            addCriterion("data_2 not between", value1, value2, "data2");
            return (Criteria) this;
        }

        public Criteria andData3IsNull() {
            addCriterion("data_3 is null");
            return (Criteria) this;
        }

        public Criteria andData3IsNotNull() {
            addCriterion("data_3 is not null");
            return (Criteria) this;
        }

        public Criteria andData3EqualTo(String value) {
            addCriterion("data_3 =", value, "data3");
            return (Criteria) this;
        }

        public Criteria andData3NotEqualTo(String value) {
            addCriterion("data_3 <>", value, "data3");
            return (Criteria) this;
        }

        public Criteria andData3GreaterThan(String value) {
            addCriterion("data_3 >", value, "data3");
            return (Criteria) this;
        }

        public Criteria andData3GreaterThanOrEqualTo(String value) {
            addCriterion("data_3 >=", value, "data3");
            return (Criteria) this;
        }

        public Criteria andData3LessThan(String value) {
            addCriterion("data_3 <", value, "data3");
            return (Criteria) this;
        }

        public Criteria andData3LessThanOrEqualTo(String value) {
            addCriterion("data_3 <=", value, "data3");
            return (Criteria) this;
        }

        public Criteria andData3Like(String value) {
            addCriterion("data_3 like", value, "data3");
            return (Criteria) this;
        }

        public Criteria andData3NotLike(String value) {
            addCriterion("data_3 not like", value, "data3");
            return (Criteria) this;
        }

        public Criteria andData3In(List<String> values) {
            addCriterion("data_3 in", values, "data3");
            return (Criteria) this;
        }

        public Criteria andData3NotIn(List<String> values) {
            addCriterion("data_3 not in", values, "data3");
            return (Criteria) this;
        }

        public Criteria andData3Between(String value1, String value2) {
            addCriterion("data_3 between", value1, value2, "data3");
            return (Criteria) this;
        }

        public Criteria andData3NotBetween(String value1, String value2) {
            addCriterion("data_3 not between", value1, value2, "data3");
            return (Criteria) this;
        }

        public Criteria andData4IsNull() {
            addCriterion("data_4 is null");
            return (Criteria) this;
        }

        public Criteria andData4IsNotNull() {
            addCriterion("data_4 is not null");
            return (Criteria) this;
        }

        public Criteria andData4EqualTo(String value) {
            addCriterion("data_4 =", value, "data4");
            return (Criteria) this;
        }

        public Criteria andData4NotEqualTo(String value) {
            addCriterion("data_4 <>", value, "data4");
            return (Criteria) this;
        }

        public Criteria andData4GreaterThan(String value) {
            addCriterion("data_4 >", value, "data4");
            return (Criteria) this;
        }

        public Criteria andData4GreaterThanOrEqualTo(String value) {
            addCriterion("data_4 >=", value, "data4");
            return (Criteria) this;
        }

        public Criteria andData4LessThan(String value) {
            addCriterion("data_4 <", value, "data4");
            return (Criteria) this;
        }

        public Criteria andData4LessThanOrEqualTo(String value) {
            addCriterion("data_4 <=", value, "data4");
            return (Criteria) this;
        }

        public Criteria andData4Like(String value) {
            addCriterion("data_4 like", value, "data4");
            return (Criteria) this;
        }

        public Criteria andData4NotLike(String value) {
            addCriterion("data_4 not like", value, "data4");
            return (Criteria) this;
        }

        public Criteria andData4In(List<String> values) {
            addCriterion("data_4 in", values, "data4");
            return (Criteria) this;
        }

        public Criteria andData4NotIn(List<String> values) {
            addCriterion("data_4 not in", values, "data4");
            return (Criteria) this;
        }

        public Criteria andData4Between(String value1, String value2) {
            addCriterion("data_4 between", value1, value2, "data4");
            return (Criteria) this;
        }

        public Criteria andData4NotBetween(String value1, String value2) {
            addCriterion("data_4 not between", value1, value2, "data4");
            return (Criteria) this;
        }

        public Criteria andData5IsNull() {
            addCriterion("data_5 is null");
            return (Criteria) this;
        }

        public Criteria andData5IsNotNull() {
            addCriterion("data_5 is not null");
            return (Criteria) this;
        }

        public Criteria andData5EqualTo(String value) {
            addCriterion("data_5 =", value, "data5");
            return (Criteria) this;
        }

        public Criteria andData5NotEqualTo(String value) {
            addCriterion("data_5 <>", value, "data5");
            return (Criteria) this;
        }

        public Criteria andData5GreaterThan(String value) {
            addCriterion("data_5 >", value, "data5");
            return (Criteria) this;
        }

        public Criteria andData5GreaterThanOrEqualTo(String value) {
            addCriterion("data_5 >=", value, "data5");
            return (Criteria) this;
        }

        public Criteria andData5LessThan(String value) {
            addCriterion("data_5 <", value, "data5");
            return (Criteria) this;
        }

        public Criteria andData5LessThanOrEqualTo(String value) {
            addCriterion("data_5 <=", value, "data5");
            return (Criteria) this;
        }

        public Criteria andData5Like(String value) {
            addCriterion("data_5 like", value, "data5");
            return (Criteria) this;
        }

        public Criteria andData5NotLike(String value) {
            addCriterion("data_5 not like", value, "data5");
            return (Criteria) this;
        }

        public Criteria andData5In(List<String> values) {
            addCriterion("data_5 in", values, "data5");
            return (Criteria) this;
        }

        public Criteria andData5NotIn(List<String> values) {
            addCriterion("data_5 not in", values, "data5");
            return (Criteria) this;
        }

        public Criteria andData5Between(String value1, String value2) {
            addCriterion("data_5 between", value1, value2, "data5");
            return (Criteria) this;
        }

        public Criteria andData5NotBetween(String value1, String value2) {
            addCriterion("data_5 not between", value1, value2, "data5");
            return (Criteria) this;
        }

        public Criteria andData6IsNull() {
            addCriterion("data_6 is null");
            return (Criteria) this;
        }

        public Criteria andData6IsNotNull() {
            addCriterion("data_6 is not null");
            return (Criteria) this;
        }

        public Criteria andData6EqualTo(String value) {
            addCriterion("data_6 =", value, "data6");
            return (Criteria) this;
        }

        public Criteria andData6NotEqualTo(String value) {
            addCriterion("data_6 <>", value, "data6");
            return (Criteria) this;
        }

        public Criteria andData6GreaterThan(String value) {
            addCriterion("data_6 >", value, "data6");
            return (Criteria) this;
        }

        public Criteria andData6GreaterThanOrEqualTo(String value) {
            addCriterion("data_6 >=", value, "data6");
            return (Criteria) this;
        }

        public Criteria andData6LessThan(String value) {
            addCriterion("data_6 <", value, "data6");
            return (Criteria) this;
        }

        public Criteria andData6LessThanOrEqualTo(String value) {
            addCriterion("data_6 <=", value, "data6");
            return (Criteria) this;
        }

        public Criteria andData6Like(String value) {
            addCriterion("data_6 like", value, "data6");
            return (Criteria) this;
        }

        public Criteria andData6NotLike(String value) {
            addCriterion("data_6 not like", value, "data6");
            return (Criteria) this;
        }

        public Criteria andData6In(List<String> values) {
            addCriterion("data_6 in", values, "data6");
            return (Criteria) this;
        }

        public Criteria andData6NotIn(List<String> values) {
            addCriterion("data_6 not in", values, "data6");
            return (Criteria) this;
        }

        public Criteria andData6Between(String value1, String value2) {
            addCriterion("data_6 between", value1, value2, "data6");
            return (Criteria) this;
        }

        public Criteria andData6NotBetween(String value1, String value2) {
            addCriterion("data_6 not between", value1, value2, "data6");
            return (Criteria) this;
        }

        public Criteria andData7IsNull() {
            addCriterion("data_7 is null");
            return (Criteria) this;
        }

        public Criteria andData7IsNotNull() {
            addCriterion("data_7 is not null");
            return (Criteria) this;
        }

        public Criteria andData7EqualTo(String value) {
            addCriterion("data_7 =", value, "data7");
            return (Criteria) this;
        }

        public Criteria andData7NotEqualTo(String value) {
            addCriterion("data_7 <>", value, "data7");
            return (Criteria) this;
        }

        public Criteria andData7GreaterThan(String value) {
            addCriterion("data_7 >", value, "data7");
            return (Criteria) this;
        }

        public Criteria andData7GreaterThanOrEqualTo(String value) {
            addCriterion("data_7 >=", value, "data7");
            return (Criteria) this;
        }

        public Criteria andData7LessThan(String value) {
            addCriterion("data_7 <", value, "data7");
            return (Criteria) this;
        }

        public Criteria andData7LessThanOrEqualTo(String value) {
            addCriterion("data_7 <=", value, "data7");
            return (Criteria) this;
        }

        public Criteria andData7Like(String value) {
            addCriterion("data_7 like", value, "data7");
            return (Criteria) this;
        }

        public Criteria andData7NotLike(String value) {
            addCriterion("data_7 not like", value, "data7");
            return (Criteria) this;
        }

        public Criteria andData7In(List<String> values) {
            addCriterion("data_7 in", values, "data7");
            return (Criteria) this;
        }

        public Criteria andData7NotIn(List<String> values) {
            addCriterion("data_7 not in", values, "data7");
            return (Criteria) this;
        }

        public Criteria andData7Between(String value1, String value2) {
            addCriterion("data_7 between", value1, value2, "data7");
            return (Criteria) this;
        }

        public Criteria andData7NotBetween(String value1, String value2) {
            addCriterion("data_7 not between", value1, value2, "data7");
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