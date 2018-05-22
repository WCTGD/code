package com.xyb2c.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MaintainExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	private int start;

	private int length;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public MaintainExample() {
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

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andNoIsNull() {
			addCriterion("no is null");
			return (Criteria) this;
		}

		public Criteria andNoIsNotNull() {
			addCriterion("no is not null");
			return (Criteria) this;
		}

		public Criteria andNoEqualTo(String value) {
			addCriterion("no =", value, "no");
			return (Criteria) this;
		}

		public Criteria andNoNotEqualTo(String value) {
			addCriterion("no <>", value, "no");
			return (Criteria) this;
		}

		public Criteria andNoGreaterThan(String value) {
			addCriterion("no >", value, "no");
			return (Criteria) this;
		}

		public Criteria andNoGreaterThanOrEqualTo(String value) {
			addCriterion("no >=", value, "no");
			return (Criteria) this;
		}

		public Criteria andNoLessThan(String value) {
			addCriterion("no <", value, "no");
			return (Criteria) this;
		}

		public Criteria andNoLessThanOrEqualTo(String value) {
			addCriterion("no <=", value, "no");
			return (Criteria) this;
		}

		public Criteria andNoLike(String value) {
			addCriterion("no like", value, "no");
			return (Criteria) this;
		}

		public Criteria andNoNotLike(String value) {
			addCriterion("no not like", value, "no");
			return (Criteria) this;
		}

		public Criteria andNoIn(List<String> values) {
			addCriterion("no in", values, "no");
			return (Criteria) this;
		}

		public Criteria andNoNotIn(List<String> values) {
			addCriterion("no not in", values, "no");
			return (Criteria) this;
		}

		public Criteria andNoBetween(String value1, String value2) {
			addCriterion("no between", value1, value2, "no");
			return (Criteria) this;
		}

		public Criteria andNoNotBetween(String value1, String value2) {
			addCriterion("no not between", value1, value2, "no");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andUnitIsNull() {
			addCriterion("unit is null");
			return (Criteria) this;
		}

		public Criteria andUnitIsNotNull() {
			addCriterion("unit is not null");
			return (Criteria) this;
		}

		public Criteria andUnitEqualTo(String value) {
			addCriterion("unit =", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotEqualTo(String value) {
			addCriterion("unit <>", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitGreaterThan(String value) {
			addCriterion("unit >", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitGreaterThanOrEqualTo(String value) {
			addCriterion("unit >=", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLessThan(String value) {
			addCriterion("unit <", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLessThanOrEqualTo(String value) {
			addCriterion("unit <=", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLike(String value) {
			addCriterion("unit like", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotLike(String value) {
			addCriterion("unit not like", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitIn(List<String> values) {
			addCriterion("unit in", values, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotIn(List<String> values) {
			addCriterion("unit not in", values, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitBetween(String value1, String value2) {
			addCriterion("unit between", value1, value2, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotBetween(String value1, String value2) {
			addCriterion("unit not between", value1, value2, "unit");
			return (Criteria) this;
		}

		public Criteria andFrequencyIsNull() {
			addCriterion("frequency is null");
			return (Criteria) this;
		}

		public Criteria andFrequencyIsNotNull() {
			addCriterion("frequency is not null");
			return (Criteria) this;
		}

		public Criteria andFrequencyEqualTo(Integer value) {
			addCriterion("frequency =", value, "frequency");
			return (Criteria) this;
		}

		public Criteria andFrequencyNotEqualTo(Integer value) {
			addCriterion("frequency <>", value, "frequency");
			return (Criteria) this;
		}

		public Criteria andFrequencyGreaterThan(Integer value) {
			addCriterion("frequency >", value, "frequency");
			return (Criteria) this;
		}

		public Criteria andFrequencyGreaterThanOrEqualTo(Integer value) {
			addCriterion("frequency >=", value, "frequency");
			return (Criteria) this;
		}

		public Criteria andFrequencyLessThan(Integer value) {
			addCriterion("frequency <", value, "frequency");
			return (Criteria) this;
		}

		public Criteria andFrequencyLessThanOrEqualTo(Integer value) {
			addCriterion("frequency <=", value, "frequency");
			return (Criteria) this;
		}

		public Criteria andFrequencyIn(List<Integer> values) {
			addCriterion("frequency in", values, "frequency");
			return (Criteria) this;
		}

		public Criteria andFrequencyNotIn(List<Integer> values) {
			addCriterion("frequency not in", values, "frequency");
			return (Criteria) this;
		}

		public Criteria andFrequencyBetween(Integer value1, Integer value2) {
			addCriterion("frequency between", value1, value2, "frequency");
			return (Criteria) this;
		}

		public Criteria andFrequencyNotBetween(Integer value1, Integer value2) {
			addCriterion("frequency not between", value1, value2, "frequency");
			return (Criteria) this;
		}

		public Criteria andDaynumIsNull() {
			addCriterion("daynum is null");
			return (Criteria) this;
		}

		public Criteria andDaynumIsNotNull() {
			addCriterion("daynum is not null");
			return (Criteria) this;
		}

		public Criteria andDaynumEqualTo(Integer value) {
			addCriterion("daynum =", value, "daynum");
			return (Criteria) this;
		}

		public Criteria andDaynumNotEqualTo(Integer value) {
			addCriterion("daynum <>", value, "daynum");
			return (Criteria) this;
		}

		public Criteria andDaynumGreaterThan(Integer value) {
			addCriterion("daynum >", value, "daynum");
			return (Criteria) this;
		}

		public Criteria andDaynumGreaterThanOrEqualTo(Integer value) {
			addCriterion("daynum >=", value, "daynum");
			return (Criteria) this;
		}

		public Criteria andDaynumLessThan(Integer value) {
			addCriterion("daynum <", value, "daynum");
			return (Criteria) this;
		}

		public Criteria andDaynumLessThanOrEqualTo(Integer value) {
			addCriterion("daynum <=", value, "daynum");
			return (Criteria) this;
		}

		public Criteria andDaynumIn(List<Integer> values) {
			addCriterion("daynum in", values, "daynum");
			return (Criteria) this;
		}

		public Criteria andDaynumNotIn(List<Integer> values) {
			addCriterion("daynum not in", values, "daynum");
			return (Criteria) this;
		}

		public Criteria andDaynumBetween(Integer value1, Integer value2) {
			addCriterion("daynum between", value1, value2, "daynum");
			return (Criteria) this;
		}

		public Criteria andDaynumNotBetween(Integer value1, Integer value2) {
			addCriterion("daynum not between", value1, value2, "daynum");
			return (Criteria) this;
		}

		public Criteria andStartdateIsNull() {
			addCriterion("startdate is null");
			return (Criteria) this;
		}

		public Criteria andStartdateIsNotNull() {
			addCriterion("startdate is not null");
			return (Criteria) this;
		}

		public Criteria andStartdateEqualTo(Date value) {
			addCriterionForJDBCDate("startdate =", value, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateNotEqualTo(Date value) {
			addCriterionForJDBCDate("startdate <>", value, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateGreaterThan(Date value) {
			addCriterionForJDBCDate("startdate >", value, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("startdate >=", value, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateLessThan(Date value) {
			addCriterionForJDBCDate("startdate <", value, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("startdate <=", value, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateIn(List<Date> values) {
			addCriterionForJDBCDate("startdate in", values, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateNotIn(List<Date> values) {
			addCriterionForJDBCDate("startdate not in", values, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("startdate between", value1, value2, "startdate");
			return (Criteria) this;
		}

		public Criteria andStartdateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("startdate not between", value1, value2, "startdate");
			return (Criteria) this;
		}

		public Criteria andEnddateIsNull() {
			addCriterion("enddate is null");
			return (Criteria) this;
		}

		public Criteria andEnddateIsNotNull() {
			addCriterion("enddate is not null");
			return (Criteria) this;
		}

		public Criteria andEnddateEqualTo(Date value) {
			addCriterionForJDBCDate("enddate =", value, "enddate");
			return (Criteria) this;
		}

		public Criteria andEnddateNotEqualTo(Date value) {
			addCriterionForJDBCDate("enddate <>", value, "enddate");
			return (Criteria) this;
		}

		public Criteria andEnddateGreaterThan(Date value) {
			addCriterionForJDBCDate("enddate >", value, "enddate");
			return (Criteria) this;
		}

		public Criteria andEnddateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("enddate >=", value, "enddate");
			return (Criteria) this;
		}

		public Criteria andEnddateLessThan(Date value) {
			addCriterionForJDBCDate("enddate <", value, "enddate");
			return (Criteria) this;
		}

		public Criteria andEnddateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("enddate <=", value, "enddate");
			return (Criteria) this;
		}

		public Criteria andEnddateIn(List<Date> values) {
			addCriterionForJDBCDate("enddate in", values, "enddate");
			return (Criteria) this;
		}

		public Criteria andEnddateNotIn(List<Date> values) {
			addCriterionForJDBCDate("enddate not in", values, "enddate");
			return (Criteria) this;
		}

		public Criteria andEnddateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("enddate between", value1, value2, "enddate");
			return (Criteria) this;
		}

		public Criteria andEnddateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("enddate not between", value1, value2, "enddate");
			return (Criteria) this;
		}

		public Criteria andLastDateIsNull() {
			addCriterion("last_date is null");
			return (Criteria) this;
		}

		public Criteria andLastDateIsNotNull() {
			addCriterion("last_date is not null");
			return (Criteria) this;
		}

		public Criteria andLastDateEqualTo(Date value) {
			addCriterionForJDBCDate("last_date =", value, "lastDate");
			return (Criteria) this;
		}

		public Criteria andLastDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("last_date <>", value, "lastDate");
			return (Criteria) this;
		}

		public Criteria andLastDateGreaterThan(Date value) {
			addCriterionForJDBCDate("last_date >", value, "lastDate");
			return (Criteria) this;
		}

		public Criteria andLastDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("last_date >=", value, "lastDate");
			return (Criteria) this;
		}

		public Criteria andLastDateLessThan(Date value) {
			addCriterionForJDBCDate("last_date <", value, "lastDate");
			return (Criteria) this;
		}

		public Criteria andLastDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("last_date <=", value, "lastDate");
			return (Criteria) this;
		}

		public Criteria andLastDateIn(List<Date> values) {
			addCriterionForJDBCDate("last_date in", values, "lastDate");
			return (Criteria) this;
		}

		public Criteria andLastDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("last_date not in", values, "lastDate");
			return (Criteria) this;
		}

		public Criteria andLastDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("last_date between", value1, value2, "lastDate");
			return (Criteria) this;
		}

		public Criteria andLastDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("last_date not between", value1, value2, "lastDate");
			return (Criteria) this;
		}

		public Criteria andWorkdayIsNull() {
			addCriterion("workday is null");
			return (Criteria) this;
		}

		public Criteria andWorkdayIsNotNull() {
			addCriterion("workday is not null");
			return (Criteria) this;
		}

		public Criteria andWorkdayEqualTo(Integer value) {
			addCriterion("workday =", value, "workday");
			return (Criteria) this;
		}

		public Criteria andWorkdayNotEqualTo(Integer value) {
			addCriterion("workday <>", value, "workday");
			return (Criteria) this;
		}

		public Criteria andWorkdayGreaterThan(Integer value) {
			addCriterion("workday >", value, "workday");
			return (Criteria) this;
		}

		public Criteria andWorkdayGreaterThanOrEqualTo(Integer value) {
			addCriterion("workday >=", value, "workday");
			return (Criteria) this;
		}

		public Criteria andWorkdayLessThan(Integer value) {
			addCriterion("workday <", value, "workday");
			return (Criteria) this;
		}

		public Criteria andWorkdayLessThanOrEqualTo(Integer value) {
			addCriterion("workday <=", value, "workday");
			return (Criteria) this;
		}

		public Criteria andWorkdayIn(List<Integer> values) {
			addCriterion("workday in", values, "workday");
			return (Criteria) this;
		}

		public Criteria andWorkdayNotIn(List<Integer> values) {
			addCriterion("workday not in", values, "workday");
			return (Criteria) this;
		}

		public Criteria andWorkdayBetween(Integer value1, Integer value2) {
			addCriterion("workday between", value1, value2, "workday");
			return (Criteria) this;
		}

		public Criteria andWorkdayNotBetween(Integer value1, Integer value2) {
			addCriterion("workday not between", value1, value2, "workday");
			return (Criteria) this;
		}

		public Criteria andPIdIsNull() {
			addCriterion("p_id is null");
			return (Criteria) this;
		}

		public Criteria andPIdIsNotNull() {
			addCriterion("p_id is not null");
			return (Criteria) this;
		}

		public Criteria andPIdEqualTo(Integer value) {
			addCriterion("p_id =", value, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdNotEqualTo(Integer value) {
			addCriterion("p_id <>", value, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdGreaterThan(Integer value) {
			addCriterion("p_id >", value, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("p_id >=", value, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdLessThan(Integer value) {
			addCriterion("p_id <", value, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdLessThanOrEqualTo(Integer value) {
			addCriterion("p_id <=", value, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdIn(List<Integer> values) {
			addCriterion("p_id in", values, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdNotIn(List<Integer> values) {
			addCriterion("p_id not in", values, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdBetween(Integer value1, Integer value2) {
			addCriterion("p_id between", value1, value2, "pId");
			return (Criteria) this;
		}

		public Criteria andPIdNotBetween(Integer value1, Integer value2) {
			addCriterion("p_id not between", value1, value2, "pId");
			return (Criteria) this;
		}

		public Criteria andJobIdIsNull() {
			addCriterion("job_id is null");
			return (Criteria) this;
		}

		public Criteria andJobIdIsNotNull() {
			addCriterion("job_id is not null");
			return (Criteria) this;
		}

		public Criteria andJobIdEqualTo(Integer value) {
			addCriterion("job_id =", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdNotEqualTo(Integer value) {
			addCriterion("job_id <>", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdGreaterThan(Integer value) {
			addCriterion("job_id >", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("job_id >=", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdLessThan(Integer value) {
			addCriterion("job_id <", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdLessThanOrEqualTo(Integer value) {
			addCriterion("job_id <=", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdIn(List<Integer> values) {
			addCriterion("job_id in", values, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdNotIn(List<Integer> values) {
			addCriterion("job_id not in", values, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdBetween(Integer value1, Integer value2) {
			addCriterion("job_id between", value1, value2, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdNotBetween(Integer value1, Integer value2) {
			addCriterion("job_id not between", value1, value2, "jobId");
			return (Criteria) this;
		}

		public Criteria andAIdIsNull() {
			addCriterion("a_id is null");
			return (Criteria) this;
		}

		public Criteria andAIdIsNotNull() {
			addCriterion("a_id is not null");
			return (Criteria) this;
		}

		public Criteria andAIdEqualTo(Integer value) {
			addCriterion("a_id =", value, "aId");
			return (Criteria) this;
		}

		public Criteria andAIdNotEqualTo(Integer value) {
			addCriterion("a_id <>", value, "aId");
			return (Criteria) this;
		}

		public Criteria andAIdGreaterThan(Integer value) {
			addCriterion("a_id >", value, "aId");
			return (Criteria) this;
		}

		public Criteria andAIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("a_id >=", value, "aId");
			return (Criteria) this;
		}

		public Criteria andAIdLessThan(Integer value) {
			addCriterion("a_id <", value, "aId");
			return (Criteria) this;
		}

		public Criteria andAIdLessThanOrEqualTo(Integer value) {
			addCriterion("a_id <=", value, "aId");
			return (Criteria) this;
		}

		public Criteria andAIdIn(List<Integer> values) {
			addCriterion("a_id in", values, "aId");
			return (Criteria) this;
		}

		public Criteria andAIdNotIn(List<Integer> values) {
			addCriterion("a_id not in", values, "aId");
			return (Criteria) this;
		}

		public Criteria andAIdBetween(Integer value1, Integer value2) {
			addCriterion("a_id between", value1, value2, "aId");
			return (Criteria) this;
		}

		public Criteria andAIdNotBetween(Integer value1, Integer value2) {
			addCriterion("a_id not between", value1, value2, "aId");
			return (Criteria) this;
		}

		public Criteria andWorkerorderStateIdIsNull() {
			addCriterion("workerorder_state_id is null");
			return (Criteria) this;
		}

		public Criteria andWorkerorderStateIdIsNotNull() {
			addCriterion("workerorder_state_id is not null");
			return (Criteria) this;
		}

		public Criteria andWorkerorderStateIdEqualTo(Integer value) {
			addCriterion("workerorder_state_id =", value, "workerorderStateId");
			return (Criteria) this;
		}

		public Criteria andWorkerorderStateIdNotEqualTo(Integer value) {
			addCriterion("workerorder_state_id <>", value, "workerorderStateId");
			return (Criteria) this;
		}

		public Criteria andWorkerorderStateIdGreaterThan(Integer value) {
			addCriterion("workerorder_state_id >", value, "workerorderStateId");
			return (Criteria) this;
		}

		public Criteria andWorkerorderStateIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("workerorder_state_id >=", value, "workerorderStateId");
			return (Criteria) this;
		}

		public Criteria andWorkerorderStateIdLessThan(Integer value) {
			addCriterion("workerorder_state_id <", value, "workerorderStateId");
			return (Criteria) this;
		}

		public Criteria andWorkerorderStateIdLessThanOrEqualTo(Integer value) {
			addCriterion("workerorder_state_id <=", value, "workerorderStateId");
			return (Criteria) this;
		}

		public Criteria andWorkerorderStateIdIn(List<Integer> values) {
			addCriterion("workerorder_state_id in", values, "workerorderStateId");
			return (Criteria) this;
		}

		public Criteria andWorkerorderStateIdNotIn(List<Integer> values) {
			addCriterion("workerorder_state_id not in", values, "workerorderStateId");
			return (Criteria) this;
		}

		public Criteria andWorkerorderStateIdBetween(Integer value1, Integer value2) {
			addCriterion("workerorder_state_id between", value1, value2, "workerorderStateId");
			return (Criteria) this;
		}

		public Criteria andWorkerorderStateIdNotBetween(Integer value1, Integer value2) {
			addCriterion("workerorder_state_id not between", value1, value2, "workerorderStateId");
			return (Criteria) this;
		}

		public Criteria andPlanIsNull() {
			addCriterion("plan is null");
			return (Criteria) this;
		}

		public Criteria andPlanIsNotNull() {
			addCriterion("plan is not null");
			return (Criteria) this;
		}

		public Criteria andPlanEqualTo(Integer value) {
			addCriterion("plan =", value, "plan");
			return (Criteria) this;
		}

		public Criteria andPlanNotEqualTo(Integer value) {
			addCriterion("plan <>", value, "plan");
			return (Criteria) this;
		}

		public Criteria andPlanGreaterThan(Integer value) {
			addCriterion("plan >", value, "plan");
			return (Criteria) this;
		}

		public Criteria andPlanGreaterThanOrEqualTo(Integer value) {
			addCriterion("plan >=", value, "plan");
			return (Criteria) this;
		}

		public Criteria andPlanLessThan(Integer value) {
			addCriterion("plan <", value, "plan");
			return (Criteria) this;
		}

		public Criteria andPlanLessThanOrEqualTo(Integer value) {
			addCriterion("plan <=", value, "plan");
			return (Criteria) this;
		}

		public Criteria andPlanIn(List<Integer> values) {
			addCriterion("plan in", values, "plan");
			return (Criteria) this;
		}

		public Criteria andPlanNotIn(List<Integer> values) {
			addCriterion("plan not in", values, "plan");
			return (Criteria) this;
		}

		public Criteria andPlanBetween(Integer value1, Integer value2) {
			addCriterion("plan between", value1, value2, "plan");
			return (Criteria) this;
		}

		public Criteria andPlanNotBetween(Integer value1, Integer value2) {
			addCriterion("plan not between", value1, value2, "plan");
			return (Criteria) this;
		}

		public Criteria andFlagIsNull() {
			addCriterion("flag is null");
			return (Criteria) this;
		}

		public Criteria andFlagIsNotNull() {
			addCriterion("flag is not null");
			return (Criteria) this;
		}

		public Criteria andFlagEqualTo(Integer value) {
			addCriterion("flag =", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagNotEqualTo(Integer value) {
			addCriterion("flag <>", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagGreaterThan(Integer value) {
			addCriterion("flag >", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
			addCriterion("flag >=", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagLessThan(Integer value) {
			addCriterion("flag <", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagLessThanOrEqualTo(Integer value) {
			addCriterion("flag <=", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagIn(List<Integer> values) {
			addCriterion("flag in", values, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagNotIn(List<Integer> values) {
			addCriterion("flag not in", values, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagBetween(Integer value1, Integer value2) {
			addCriterion("flag between", value1, value2, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagNotBetween(Integer value1, Integer value2) {
			addCriterion("flag not between", value1, value2, "flag");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("create_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("create_time >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("create_time not between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeIsNull() {
			addCriterion("modify_time is null");
			return (Criteria) this;
		}

		public Criteria andModifyTimeIsNotNull() {
			addCriterion("modify_time is not null");
			return (Criteria) this;
		}

		public Criteria andModifyTimeEqualTo(Date value) {
			addCriterion("modify_time =", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeNotEqualTo(Date value) {
			addCriterion("modify_time <>", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeGreaterThan(Date value) {
			addCriterion("modify_time >", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("modify_time >=", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeLessThan(Date value) {
			addCriterion("modify_time <", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
			addCriterion("modify_time <=", value, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeIn(List<Date> values) {
			addCriterion("modify_time in", values, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeNotIn(List<Date> values) {
			addCriterion("modify_time not in", values, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeBetween(Date value1, Date value2) {
			addCriterion("modify_time between", value1, value2, "modifyTime");
			return (Criteria) this;
		}

		public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
			addCriterion("modify_time not between", value1, value2, "modifyTime");
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