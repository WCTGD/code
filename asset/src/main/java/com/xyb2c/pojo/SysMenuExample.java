package com.xyb2c.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysMenuExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCTimestampIsNull() {
            addCriterion("c_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andCTimestampIsNotNull() {
            addCriterion("c_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andCTimestampEqualTo(Date value) {
            addCriterion("c_timestamp =", value, "cTimestamp");
            return (Criteria) this;
        }

        public Criteria andCTimestampNotEqualTo(Date value) {
            addCriterion("c_timestamp <>", value, "cTimestamp");
            return (Criteria) this;
        }

        public Criteria andCTimestampGreaterThan(Date value) {
            addCriterion("c_timestamp >", value, "cTimestamp");
            return (Criteria) this;
        }

        public Criteria andCTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("c_timestamp >=", value, "cTimestamp");
            return (Criteria) this;
        }

        public Criteria andCTimestampLessThan(Date value) {
            addCriterion("c_timestamp <", value, "cTimestamp");
            return (Criteria) this;
        }

        public Criteria andCTimestampLessThanOrEqualTo(Date value) {
            addCriterion("c_timestamp <=", value, "cTimestamp");
            return (Criteria) this;
        }

        public Criteria andCTimestampIn(List<Date> values) {
            addCriterion("c_timestamp in", values, "cTimestamp");
            return (Criteria) this;
        }

        public Criteria andCTimestampNotIn(List<Date> values) {
            addCriterion("c_timestamp not in", values, "cTimestamp");
            return (Criteria) this;
        }

        public Criteria andCTimestampBetween(Date value1, Date value2) {
            addCriterion("c_timestamp between", value1, value2, "cTimestamp");
            return (Criteria) this;
        }

        public Criteria andCTimestampNotBetween(Date value1, Date value2) {
            addCriterion("c_timestamp not between", value1, value2, "cTimestamp");
            return (Criteria) this;
        }

        public Criteria andUTimestampIsNull() {
            addCriterion("u_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andUTimestampIsNotNull() {
            addCriterion("u_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andUTimestampEqualTo(Date value) {
            addCriterion("u_timestamp =", value, "uTimestamp");
            return (Criteria) this;
        }

        public Criteria andUTimestampNotEqualTo(Date value) {
            addCriterion("u_timestamp <>", value, "uTimestamp");
            return (Criteria) this;
        }

        public Criteria andUTimestampGreaterThan(Date value) {
            addCriterion("u_timestamp >", value, "uTimestamp");
            return (Criteria) this;
        }

        public Criteria andUTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("u_timestamp >=", value, "uTimestamp");
            return (Criteria) this;
        }

        public Criteria andUTimestampLessThan(Date value) {
            addCriterion("u_timestamp <", value, "uTimestamp");
            return (Criteria) this;
        }

        public Criteria andUTimestampLessThanOrEqualTo(Date value) {
            addCriterion("u_timestamp <=", value, "uTimestamp");
            return (Criteria) this;
        }

        public Criteria andUTimestampIn(List<Date> values) {
            addCriterion("u_timestamp in", values, "uTimestamp");
            return (Criteria) this;
        }

        public Criteria andUTimestampNotIn(List<Date> values) {
            addCriterion("u_timestamp not in", values, "uTimestamp");
            return (Criteria) this;
        }

        public Criteria andUTimestampBetween(Date value1, Date value2) {
            addCriterion("u_timestamp between", value1, value2, "uTimestamp");
            return (Criteria) this;
        }

        public Criteria andUTimestampNotBetween(Date value1, Date value2) {
            addCriterion("u_timestamp not between", value1, value2, "uTimestamp");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("menu_name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menu_name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menu_name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menu_name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menu_name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menu_name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menu_name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menu_name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menu_name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menu_name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menu_name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menu_name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNull() {
            addCriterion("menu_url is null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNotNull() {
            addCriterion("menu_url is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlEqualTo(String value) {
            addCriterion("menu_url =", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotEqualTo(String value) {
            addCriterion("menu_url <>", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThan(String value) {
            addCriterion("menu_url >", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThanOrEqualTo(String value) {
            addCriterion("menu_url >=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThan(String value) {
            addCriterion("menu_url <", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThanOrEqualTo(String value) {
            addCriterion("menu_url <=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLike(String value) {
            addCriterion("menu_url like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotLike(String value) {
            addCriterion("menu_url not like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIn(List<String> values) {
            addCriterion("menu_url in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotIn(List<String> values) {
            addCriterion("menu_url not in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlBetween(String value1, String value2) {
            addCriterion("menu_url between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotBetween(String value1, String value2) {
            addCriterion("menu_url not between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuImg1IsNull() {
            addCriterion("menu_img1 is null");
            return (Criteria) this;
        }

        public Criteria andMenuImg1IsNotNull() {
            addCriterion("menu_img1 is not null");
            return (Criteria) this;
        }

        public Criteria andMenuImg1EqualTo(String value) {
            addCriterion("menu_img1 =", value, "menuImg1");
            return (Criteria) this;
        }

        public Criteria andMenuImg1NotEqualTo(String value) {
            addCriterion("menu_img1 <>", value, "menuImg1");
            return (Criteria) this;
        }

        public Criteria andMenuImg1GreaterThan(String value) {
            addCriterion("menu_img1 >", value, "menuImg1");
            return (Criteria) this;
        }

        public Criteria andMenuImg1GreaterThanOrEqualTo(String value) {
            addCriterion("menu_img1 >=", value, "menuImg1");
            return (Criteria) this;
        }

        public Criteria andMenuImg1LessThan(String value) {
            addCriterion("menu_img1 <", value, "menuImg1");
            return (Criteria) this;
        }

        public Criteria andMenuImg1LessThanOrEqualTo(String value) {
            addCriterion("menu_img1 <=", value, "menuImg1");
            return (Criteria) this;
        }

        public Criteria andMenuImg1Like(String value) {
            addCriterion("menu_img1 like", value, "menuImg1");
            return (Criteria) this;
        }

        public Criteria andMenuImg1NotLike(String value) {
            addCriterion("menu_img1 not like", value, "menuImg1");
            return (Criteria) this;
        }

        public Criteria andMenuImg1In(List<String> values) {
            addCriterion("menu_img1 in", values, "menuImg1");
            return (Criteria) this;
        }

        public Criteria andMenuImg1NotIn(List<String> values) {
            addCriterion("menu_img1 not in", values, "menuImg1");
            return (Criteria) this;
        }

        public Criteria andMenuImg1Between(String value1, String value2) {
            addCriterion("menu_img1 between", value1, value2, "menuImg1");
            return (Criteria) this;
        }

        public Criteria andMenuImg1NotBetween(String value1, String value2) {
            addCriterion("menu_img1 not between", value1, value2, "menuImg1");
            return (Criteria) this;
        }

        public Criteria andMenuImg2IsNull() {
            addCriterion("menu_img2 is null");
            return (Criteria) this;
        }

        public Criteria andMenuImg2IsNotNull() {
            addCriterion("menu_img2 is not null");
            return (Criteria) this;
        }

        public Criteria andMenuImg2EqualTo(String value) {
            addCriterion("menu_img2 =", value, "menuImg2");
            return (Criteria) this;
        }

        public Criteria andMenuImg2NotEqualTo(String value) {
            addCriterion("menu_img2 <>", value, "menuImg2");
            return (Criteria) this;
        }

        public Criteria andMenuImg2GreaterThan(String value) {
            addCriterion("menu_img2 >", value, "menuImg2");
            return (Criteria) this;
        }

        public Criteria andMenuImg2GreaterThanOrEqualTo(String value) {
            addCriterion("menu_img2 >=", value, "menuImg2");
            return (Criteria) this;
        }

        public Criteria andMenuImg2LessThan(String value) {
            addCriterion("menu_img2 <", value, "menuImg2");
            return (Criteria) this;
        }

        public Criteria andMenuImg2LessThanOrEqualTo(String value) {
            addCriterion("menu_img2 <=", value, "menuImg2");
            return (Criteria) this;
        }

        public Criteria andMenuImg2Like(String value) {
            addCriterion("menu_img2 like", value, "menuImg2");
            return (Criteria) this;
        }

        public Criteria andMenuImg2NotLike(String value) {
            addCriterion("menu_img2 not like", value, "menuImg2");
            return (Criteria) this;
        }

        public Criteria andMenuImg2In(List<String> values) {
            addCriterion("menu_img2 in", values, "menuImg2");
            return (Criteria) this;
        }

        public Criteria andMenuImg2NotIn(List<String> values) {
            addCriterion("menu_img2 not in", values, "menuImg2");
            return (Criteria) this;
        }

        public Criteria andMenuImg2Between(String value1, String value2) {
            addCriterion("menu_img2 between", value1, value2, "menuImg2");
            return (Criteria) this;
        }

        public Criteria andMenuImg2NotBetween(String value1, String value2) {
            addCriterion("menu_img2 not between", value1, value2, "menuImg2");
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