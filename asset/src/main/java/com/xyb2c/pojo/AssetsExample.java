package com.xyb2c.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AssetsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    private int start;

   	private int size;

    public int getStart() {
   		return start;
   	}

   	public void setStart(int start) {
   		this.start = start;
   	}

   	public int getSize() {
   		return size;
   	}

   	public void setSize(int size) {
   		this.size = size;
   	}

    public AssetsExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andContractorIdIsNull() {
            addCriterion("contractor_id is null");
            return (Criteria) this;
        }

        public Criteria andContractorIdIsNotNull() {
            addCriterion("contractor_id is not null");
            return (Criteria) this;
        }

        public Criteria andContractorIdEqualTo(Integer value) {
            addCriterion("contractor_id =", value, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdNotEqualTo(Integer value) {
            addCriterion("contractor_id <>", value, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdGreaterThan(Integer value) {
            addCriterion("contractor_id >", value, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("contractor_id >=", value, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdLessThan(Integer value) {
            addCriterion("contractor_id <", value, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdLessThanOrEqualTo(Integer value) {
            addCriterion("contractor_id <=", value, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdIn(List<Integer> values) {
            addCriterion("contractor_id in", values, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdNotIn(List<Integer> values) {
            addCriterion("contractor_id not in", values, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdBetween(Integer value1, Integer value2) {
            addCriterion("contractor_id between", value1, value2, "contractorId");
            return (Criteria) this;
        }

        public Criteria andContractorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("contractor_id not between", value1, value2, "contractorId");
            return (Criteria) this;
        }

        public Criteria andAssetDescIsNull() {
            addCriterion("asset_desc is null");
            return (Criteria) this;
        }

        public Criteria andAssetDescIsNotNull() {
            addCriterion("asset_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAssetDescEqualTo(String value) {
            addCriterion("asset_desc =", value, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescNotEqualTo(String value) {
            addCriterion("asset_desc <>", value, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescGreaterThan(String value) {
            addCriterion("asset_desc >", value, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescGreaterThanOrEqualTo(String value) {
            addCriterion("asset_desc >=", value, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescLessThan(String value) {
            addCriterion("asset_desc <", value, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescLessThanOrEqualTo(String value) {
            addCriterion("asset_desc <=", value, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescLike(String value) {
            addCriterion("asset_desc like", value, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescNotLike(String value) {
            addCriterion("asset_desc not like", value, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescIn(List<String> values) {
            addCriterion("asset_desc in", values, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescNotIn(List<String> values) {
            addCriterion("asset_desc not in", values, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescBetween(String value1, String value2) {
            addCriterion("asset_desc between", value1, value2, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andAssetDescNotBetween(String value1, String value2) {
            addCriterion("asset_desc not between", value1, value2, "assetDesc");
            return (Criteria) this;
        }

        public Criteria andWayIdIsNull() {
            addCriterion("way_id is null");
            return (Criteria) this;
        }

        public Criteria andWayIdIsNotNull() {
            addCriterion("way_id is not null");
            return (Criteria) this;
        }

        public Criteria andWayIdEqualTo(Integer value) {
            addCriterion("way_id =", value, "wayId");
            return (Criteria) this;
        }

        public Criteria andWayIdNotEqualTo(Integer value) {
            addCriterion("way_id <>", value, "wayId");
            return (Criteria) this;
        }

        public Criteria andWayIdGreaterThan(Integer value) {
            addCriterion("way_id >", value, "wayId");
            return (Criteria) this;
        }

        public Criteria andWayIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("way_id >=", value, "wayId");
            return (Criteria) this;
        }

        public Criteria andWayIdLessThan(Integer value) {
            addCriterion("way_id <", value, "wayId");
            return (Criteria) this;
        }

        public Criteria andWayIdLessThanOrEqualTo(Integer value) {
            addCriterion("way_id <=", value, "wayId");
            return (Criteria) this;
        }

        public Criteria andWayIdIn(List<Integer> values) {
            addCriterion("way_id in", values, "wayId");
            return (Criteria) this;
        }

        public Criteria andWayIdNotIn(List<Integer> values) {
            addCriterion("way_id not in", values, "wayId");
            return (Criteria) this;
        }

        public Criteria andWayIdBetween(Integer value1, Integer value2) {
            addCriterion("way_id between", value1, value2, "wayId");
            return (Criteria) this;
        }

        public Criteria andWayIdNotBetween(Integer value1, Integer value2) {
            addCriterion("way_id not between", value1, value2, "wayId");
            return (Criteria) this;
        }

        public Criteria andWarrantyDeadlineIsNull() {
            addCriterion("warranty_deadline is null");
            return (Criteria) this;
        }

        public Criteria andWarrantyDeadlineIsNotNull() {
            addCriterion("warranty_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andWarrantyDeadlineEqualTo(Date value) {
            addCriterionForJDBCDate("warranty_deadline =", value, "warrantyDeadline");
            return (Criteria) this;
        }

        public Criteria andWarrantyDeadlineNotEqualTo(Date value) {
            addCriterionForJDBCDate("warranty_deadline <>", value, "warrantyDeadline");
            return (Criteria) this;
        }

        public Criteria andWarrantyDeadlineGreaterThan(Date value) {
            addCriterionForJDBCDate("warranty_deadline >", value, "warrantyDeadline");
            return (Criteria) this;
        }

        public Criteria andWarrantyDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("warranty_deadline >=", value, "warrantyDeadline");
            return (Criteria) this;
        }

        public Criteria andWarrantyDeadlineLessThan(Date value) {
            addCriterionForJDBCDate("warranty_deadline <", value, "warrantyDeadline");
            return (Criteria) this;
        }

        public Criteria andWarrantyDeadlineLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("warranty_deadline <=", value, "warrantyDeadline");
            return (Criteria) this;
        }

        public Criteria andWarrantyDeadlineIn(List<Date> values) {
            addCriterionForJDBCDate("warranty_deadline in", values, "warrantyDeadline");
            return (Criteria) this;
        }

        public Criteria andWarrantyDeadlineNotIn(List<Date> values) {
            addCriterionForJDBCDate("warranty_deadline not in", values, "warrantyDeadline");
            return (Criteria) this;
        }

        public Criteria andWarrantyDeadlineBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("warranty_deadline between", value1, value2, "warrantyDeadline");
            return (Criteria) this;
        }

        public Criteria andWarrantyDeadlineNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("warranty_deadline not between", value1, value2, "warrantyDeadline");
            return (Criteria) this;
        }

        public Criteria andWayNoteIsNull() {
            addCriterion("way_note is null");
            return (Criteria) this;
        }

        public Criteria andWayNoteIsNotNull() {
            addCriterion("way_note is not null");
            return (Criteria) this;
        }

        public Criteria andWayNoteEqualTo(String value) {
            addCriterion("way_note =", value, "wayNote");
            return (Criteria) this;
        }

        public Criteria andWayNoteNotEqualTo(String value) {
            addCriterion("way_note <>", value, "wayNote");
            return (Criteria) this;
        }

        public Criteria andWayNoteGreaterThan(String value) {
            addCriterion("way_note >", value, "wayNote");
            return (Criteria) this;
        }

        public Criteria andWayNoteGreaterThanOrEqualTo(String value) {
            addCriterion("way_note >=", value, "wayNote");
            return (Criteria) this;
        }

        public Criteria andWayNoteLessThan(String value) {
            addCriterion("way_note <", value, "wayNote");
            return (Criteria) this;
        }

        public Criteria andWayNoteLessThanOrEqualTo(String value) {
            addCriterion("way_note <=", value, "wayNote");
            return (Criteria) this;
        }

        public Criteria andWayNoteLike(String value) {
            addCriterion("way_note like", value, "wayNote");
            return (Criteria) this;
        }

        public Criteria andWayNoteNotLike(String value) {
            addCriterion("way_note not like", value, "wayNote");
            return (Criteria) this;
        }

        public Criteria andWayNoteIn(List<String> values) {
            addCriterion("way_note in", values, "wayNote");
            return (Criteria) this;
        }

        public Criteria andWayNoteNotIn(List<String> values) {
            addCriterion("way_note not in", values, "wayNote");
            return (Criteria) this;
        }

        public Criteria andWayNoteBetween(String value1, String value2) {
            addCriterion("way_note between", value1, value2, "wayNote");
            return (Criteria) this;
        }

        public Criteria andWayNoteNotBetween(String value1, String value2) {
            addCriterion("way_note not between", value1, value2, "wayNote");
            return (Criteria) this;
        }

        public Criteria andAssetNoteIsNull() {
            addCriterion("asset_note is null");
            return (Criteria) this;
        }

        public Criteria andAssetNoteIsNotNull() {
            addCriterion("asset_note is not null");
            return (Criteria) this;
        }

        public Criteria andAssetNoteEqualTo(String value) {
            addCriterion("asset_note =", value, "assetNote");
            return (Criteria) this;
        }

        public Criteria andAssetNoteNotEqualTo(String value) {
            addCriterion("asset_note <>", value, "assetNote");
            return (Criteria) this;
        }

        public Criteria andAssetNoteGreaterThan(String value) {
            addCriterion("asset_note >", value, "assetNote");
            return (Criteria) this;
        }

        public Criteria andAssetNoteGreaterThanOrEqualTo(String value) {
            addCriterion("asset_note >=", value, "assetNote");
            return (Criteria) this;
        }

        public Criteria andAssetNoteLessThan(String value) {
            addCriterion("asset_note <", value, "assetNote");
            return (Criteria) this;
        }

        public Criteria andAssetNoteLessThanOrEqualTo(String value) {
            addCriterion("asset_note <=", value, "assetNote");
            return (Criteria) this;
        }

        public Criteria andAssetNoteLike(String value) {
            addCriterion("asset_note like", value, "assetNote");
            return (Criteria) this;
        }

        public Criteria andAssetNoteNotLike(String value) {
            addCriterion("asset_note not like", value, "assetNote");
            return (Criteria) this;
        }

        public Criteria andAssetNoteIn(List<String> values) {
            addCriterion("asset_note in", values, "assetNote");
            return (Criteria) this;
        }

        public Criteria andAssetNoteNotIn(List<String> values) {
            addCriterion("asset_note not in", values, "assetNote");
            return (Criteria) this;
        }

        public Criteria andAssetNoteBetween(String value1, String value2) {
            addCriterion("asset_note between", value1, value2, "assetNote");
            return (Criteria) this;
        }

        public Criteria andAssetNoteNotBetween(String value1, String value2) {
            addCriterion("asset_note not between", value1, value2, "assetNote");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNull() {
            addCriterion("position_id is null");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNotNull() {
            addCriterion("position_id is not null");
            return (Criteria) this;
        }

        public Criteria andPositionIdEqualTo(Integer value) {
            addCriterion("position_id =", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotEqualTo(Integer value) {
            addCriterion("position_id <>", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThan(Integer value) {
            addCriterion("position_id >", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("position_id >=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThan(Integer value) {
            addCriterion("position_id <", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThanOrEqualTo(Integer value) {
            addCriterion("position_id <=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIn(List<Integer> values) {
            addCriterion("position_id in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotIn(List<Integer> values) {
            addCriterion("position_id not in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdBetween(Integer value1, Integer value2) {
            addCriterion("position_id between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("position_id not between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(Integer value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(Integer value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(Integer value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(Integer value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<Integer> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<Integer> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(Integer value) {
            addCriterion("class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(Integer value) {
            addCriterion("class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(Integer value) {
            addCriterion("class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(Integer value) {
            addCriterion("class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(Integer value) {
            addCriterion("class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<Integer> values) {
            addCriterion("class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<Integer> values) {
            addCriterion("class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(Integer value1, Integer value2) {
            addCriterion("class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("class_id not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andStateIdIsNull() {
            addCriterion("state_id is null");
            return (Criteria) this;
        }

        public Criteria andStateIdIsNotNull() {
            addCriterion("state_id is not null");
            return (Criteria) this;
        }

        public Criteria andStateIdEqualTo(Integer value) {
            addCriterion("state_id =", value, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdNotEqualTo(Integer value) {
            addCriterion("state_id <>", value, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdGreaterThan(Integer value) {
            addCriterion("state_id >", value, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("state_id >=", value, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdLessThan(Integer value) {
            addCriterion("state_id <", value, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdLessThanOrEqualTo(Integer value) {
            addCriterion("state_id <=", value, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdIn(List<Integer> values) {
            addCriterion("state_id in", values, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdNotIn(List<Integer> values) {
            addCriterion("state_id not in", values, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdBetween(Integer value1, Integer value2) {
            addCriterion("state_id between", value1, value2, "stateId");
            return (Criteria) this;
        }

        public Criteria andStateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("state_id not between", value1, value2, "stateId");
            return (Criteria) this;
        }

        public Criteria andWokerIdIsNull() {
            addCriterion("woker_id is null");
            return (Criteria) this;
        }

        public Criteria andWokerIdIsNotNull() {
            addCriterion("woker_id is not null");
            return (Criteria) this;
        }

        public Criteria andWokerIdEqualTo(Integer value) {
            addCriterion("woker_id =", value, "wokerId");
            return (Criteria) this;
        }

        public Criteria andWokerIdNotEqualTo(Integer value) {
            addCriterion("woker_id <>", value, "wokerId");
            return (Criteria) this;
        }

        public Criteria andWokerIdGreaterThan(Integer value) {
            addCriterion("woker_id >", value, "wokerId");
            return (Criteria) this;
        }

        public Criteria andWokerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("woker_id >=", value, "wokerId");
            return (Criteria) this;
        }

        public Criteria andWokerIdLessThan(Integer value) {
            addCriterion("woker_id <", value, "wokerId");
            return (Criteria) this;
        }

        public Criteria andWokerIdLessThanOrEqualTo(Integer value) {
            addCriterion("woker_id <=", value, "wokerId");
            return (Criteria) this;
        }

        public Criteria andWokerIdIn(List<Integer> values) {
            addCriterion("woker_id in", values, "wokerId");
            return (Criteria) this;
        }

        public Criteria andWokerIdNotIn(List<Integer> values) {
            addCriterion("woker_id not in", values, "wokerId");
            return (Criteria) this;
        }

        public Criteria andWokerIdBetween(Integer value1, Integer value2) {
            addCriterion("woker_id between", value1, value2, "wokerId");
            return (Criteria) this;
        }

        public Criteria andWokerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("woker_id not between", value1, value2, "wokerId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSerialNoIsNull() {
            addCriterion("serial_no is null");
            return (Criteria) this;
        }

        public Criteria andSerialNoIsNotNull() {
            addCriterion("serial_no is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNoEqualTo(String value) {
            addCriterion("serial_no =", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotEqualTo(String value) {
            addCriterion("serial_no <>", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoGreaterThan(String value) {
            addCriterion("serial_no >", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoGreaterThanOrEqualTo(String value) {
            addCriterion("serial_no >=", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLessThan(String value) {
            addCriterion("serial_no <", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLessThanOrEqualTo(String value) {
            addCriterion("serial_no <=", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLike(String value) {
            addCriterion("serial_no like", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotLike(String value) {
            addCriterion("serial_no not like", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoIn(List<String> values) {
            addCriterion("serial_no in", values, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotIn(List<String> values) {
            addCriterion("serial_no not in", values, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoBetween(String value1, String value2) {
            addCriterion("serial_no between", value1, value2, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotBetween(String value1, String value2) {
            addCriterion("serial_no not between", value1, value2, "serialNo");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("manufacturer like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("manufacturer not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("manufacturer not between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNull() {
            addCriterion("supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNotNull() {
            addCriterion("supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdEqualTo(Integer value) {
            addCriterion("supplier_id =", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotEqualTo(Integer value) {
            addCriterion("supplier_id <>", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThan(Integer value) {
            addCriterion("supplier_id >", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("supplier_id >=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThan(Integer value) {
            addCriterion("supplier_id <", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThanOrEqualTo(Integer value) {
            addCriterion("supplier_id <=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIn(List<Integer> values) {
            addCriterion("supplier_id in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotIn(List<Integer> values) {
            addCriterion("supplier_id not in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdBetween(Integer value1, Integer value2) {
            addCriterion("supplier_id between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotBetween(Integer value1, Integer value2) {
            addCriterion("supplier_id not between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andAssetValueIsNull() {
            addCriterion("asset_value is null");
            return (Criteria) this;
        }

        public Criteria andAssetValueIsNotNull() {
            addCriterion("asset_value is not null");
            return (Criteria) this;
        }

        public Criteria andAssetValueEqualTo(Double value) {
            addCriterion("asset_value =", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueNotEqualTo(Double value) {
            addCriterion("asset_value <>", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueGreaterThan(Double value) {
            addCriterion("asset_value >", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueGreaterThanOrEqualTo(Double value) {
            addCriterion("asset_value >=", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueLessThan(Double value) {
            addCriterion("asset_value <", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueLessThanOrEqualTo(Double value) {
            addCriterion("asset_value <=", value, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueIn(List<Double> values) {
            addCriterion("asset_value in", values, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueNotIn(List<Double> values) {
            addCriterion("asset_value not in", values, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueBetween(Double value1, Double value2) {
            addCriterion("asset_value between", value1, value2, "assetValue");
            return (Criteria) this;
        }

        public Criteria andAssetValueNotBetween(Double value1, Double value2) {
            addCriterion("asset_value not between", value1, value2, "assetValue");
            return (Criteria) this;
        }

        public Criteria andPurchaserPriceIsNull() {
            addCriterion("purchaser_price is null");
            return (Criteria) this;
        }

        public Criteria andPurchaserPriceIsNotNull() {
            addCriterion("purchaser_price is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaserPriceEqualTo(Double value) {
            addCriterion("purchaser_price =", value, "purchaserPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaserPriceNotEqualTo(Double value) {
            addCriterion("purchaser_price <>", value, "purchaserPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaserPriceGreaterThan(Double value) {
            addCriterion("purchaser_price >", value, "purchaserPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaserPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("purchaser_price >=", value, "purchaserPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaserPriceLessThan(Double value) {
            addCriterion("purchaser_price <", value, "purchaserPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaserPriceLessThanOrEqualTo(Double value) {
            addCriterion("purchaser_price <=", value, "purchaserPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaserPriceIn(List<Double> values) {
            addCriterion("purchaser_price in", values, "purchaserPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaserPriceNotIn(List<Double> values) {
            addCriterion("purchaser_price not in", values, "purchaserPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaserPriceBetween(Double value1, Double value2) {
            addCriterion("purchaser_price between", value1, value2, "purchaserPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaserPriceNotBetween(Double value1, Double value2) {
            addCriterion("purchaser_price not between", value1, value2, "purchaserPrice");
            return (Criteria) this;
        }

        public Criteria andLifeSpanIsNull() {
            addCriterion("life_span is null");
            return (Criteria) this;
        }

        public Criteria andLifeSpanIsNotNull() {
            addCriterion("life_span is not null");
            return (Criteria) this;
        }

        public Criteria andLifeSpanEqualTo(String value) {
            addCriterion("life_span =", value, "lifeSpan");
            return (Criteria) this;
        }

        public Criteria andLifeSpanNotEqualTo(String value) {
            addCriterion("life_span <>", value, "lifeSpan");
            return (Criteria) this;
        }

        public Criteria andLifeSpanGreaterThan(String value) {
            addCriterion("life_span >", value, "lifeSpan");
            return (Criteria) this;
        }

        public Criteria andLifeSpanGreaterThanOrEqualTo(String value) {
            addCriterion("life_span >=", value, "lifeSpan");
            return (Criteria) this;
        }

        public Criteria andLifeSpanLessThan(String value) {
            addCriterion("life_span <", value, "lifeSpan");
            return (Criteria) this;
        }

        public Criteria andLifeSpanLessThanOrEqualTo(String value) {
            addCriterion("life_span <=", value, "lifeSpan");
            return (Criteria) this;
        }

        public Criteria andLifeSpanLike(String value) {
            addCriterion("life_span like", value, "lifeSpan");
            return (Criteria) this;
        }

        public Criteria andLifeSpanNotLike(String value) {
            addCriterion("life_span not like", value, "lifeSpan");
            return (Criteria) this;
        }

        public Criteria andLifeSpanIn(List<String> values) {
            addCriterion("life_span in", values, "lifeSpan");
            return (Criteria) this;
        }

        public Criteria andLifeSpanNotIn(List<String> values) {
            addCriterion("life_span not in", values, "lifeSpan");
            return (Criteria) this;
        }

        public Criteria andLifeSpanBetween(String value1, String value2) {
            addCriterion("life_span between", value1, value2, "lifeSpan");
            return (Criteria) this;
        }

        public Criteria andLifeSpanNotBetween(String value1, String value2) {
            addCriterion("life_span not between", value1, value2, "lifeSpan");
            return (Criteria) this;
        }

        public Criteria andClearDateIsNull() {
            addCriterion("clear_date is null");
            return (Criteria) this;
        }

        public Criteria andClearDateIsNotNull() {
            addCriterion("clear_date is not null");
            return (Criteria) this;
        }

        public Criteria andClearDateEqualTo(Date value) {
            addCriterionForJDBCDate("clear_date =", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("clear_date <>", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateGreaterThan(Date value) {
            addCriterionForJDBCDate("clear_date >", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("clear_date >=", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateLessThan(Date value) {
            addCriterionForJDBCDate("clear_date <", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("clear_date <=", value, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateIn(List<Date> values) {
            addCriterionForJDBCDate("clear_date in", values, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("clear_date not in", values, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("clear_date between", value1, value2, "clearDate");
            return (Criteria) this;
        }

        public Criteria andClearDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("clear_date not between", value1, value2, "clearDate");
            return (Criteria) this;
        }

        public Criteria andPublicPropertyIsNull() {
            addCriterion("public_property is null");
            return (Criteria) this;
        }

        public Criteria andPublicPropertyIsNotNull() {
            addCriterion("public_property is not null");
            return (Criteria) this;
        }

        public Criteria andPublicPropertyEqualTo(Integer value) {
            addCriterion("public_property =", value, "publicProperty");
            return (Criteria) this;
        }

        public Criteria andPublicPropertyNotEqualTo(Integer value) {
            addCriterion("public_property <>", value, "publicProperty");
            return (Criteria) this;
        }

        public Criteria andPublicPropertyGreaterThan(Integer value) {
            addCriterion("public_property >", value, "publicProperty");
            return (Criteria) this;
        }

        public Criteria andPublicPropertyGreaterThanOrEqualTo(Integer value) {
            addCriterion("public_property >=", value, "publicProperty");
            return (Criteria) this;
        }

        public Criteria andPublicPropertyLessThan(Integer value) {
            addCriterion("public_property <", value, "publicProperty");
            return (Criteria) this;
        }

        public Criteria andPublicPropertyLessThanOrEqualTo(Integer value) {
            addCriterion("public_property <=", value, "publicProperty");
            return (Criteria) this;
        }

        public Criteria andPublicPropertyIn(List<Integer> values) {
            addCriterion("public_property in", values, "publicProperty");
            return (Criteria) this;
        }

        public Criteria andPublicPropertyNotIn(List<Integer> values) {
            addCriterion("public_property not in", values, "publicProperty");
            return (Criteria) this;
        }

        public Criteria andPublicPropertyBetween(Integer value1, Integer value2) {
            addCriterion("public_property between", value1, value2, "publicProperty");
            return (Criteria) this;
        }

        public Criteria andPublicPropertyNotBetween(Integer value1, Integer value2) {
            addCriterion("public_property not between", value1, value2, "publicProperty");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andRegainTimeIsNull() {
            addCriterion("regain_time is null");
            return (Criteria) this;
        }

        public Criteria andRegainTimeIsNotNull() {
            addCriterion("regain_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegainTimeEqualTo(Date value) {
            addCriterionForJDBCTime("regain_time =", value, "regainTime");
            return (Criteria) this;
        }

        public Criteria andRegainTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("regain_time <>", value, "regainTime");
            return (Criteria) this;
        }

        public Criteria andRegainTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("regain_time >", value, "regainTime");
            return (Criteria) this;
        }

        public Criteria andRegainTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("regain_time >=", value, "regainTime");
            return (Criteria) this;
        }

        public Criteria andRegainTimeLessThan(Date value) {
            addCriterionForJDBCTime("regain_time <", value, "regainTime");
            return (Criteria) this;
        }

        public Criteria andRegainTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("regain_time <=", value, "regainTime");
            return (Criteria) this;
        }

        public Criteria andRegainTimeIn(List<Date> values) {
            addCriterionForJDBCTime("regain_time in", values, "regainTime");
            return (Criteria) this;
        }

        public Criteria andRegainTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("regain_time not in", values, "regainTime");
            return (Criteria) this;
        }

        public Criteria andRegainTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("regain_time between", value1, value2, "regainTime");
            return (Criteria) this;
        }

        public Criteria andRegainTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("regain_time not between", value1, value2, "regainTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNull() {
            addCriterion("delete_time is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNotNull() {
            addCriterion("delete_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeEqualTo(Date value) {
            addCriterionForJDBCTime("delete_time =", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("delete_time <>", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("delete_time >", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("delete_time >=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThan(Date value) {
            addCriterionForJDBCTime("delete_time <", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("delete_time <=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIn(List<Date> values) {
            addCriterionForJDBCTime("delete_time in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("delete_time not in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("delete_time between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("delete_time not between", value1, value2, "deleteTime");
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

        public Criteria andShowIsNull() {
            addCriterion("`show` is null");
            return (Criteria) this;
        }

        public Criteria andShowIsNotNull() {
            addCriterion("`show` is not null");
            return (Criteria) this;
        }

        public Criteria andShowEqualTo(Integer value) {
            addCriterion("`show` =", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowNotEqualTo(Integer value) {
            addCriterion("`show` <>", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowGreaterThan(Integer value) {
            addCriterion("`show` >", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("`show` >=", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowLessThan(Integer value) {
            addCriterion("`show` <", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowLessThanOrEqualTo(Integer value) {
            addCriterion("`show` <=", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowIn(List<Integer> values) {
            addCriterion("`show` in", values, "show");
            return (Criteria) this;
        }

        public Criteria andShowNotIn(List<Integer> values) {
            addCriterion("`show` not in", values, "show");
            return (Criteria) this;
        }

        public Criteria andShowBetween(Integer value1, Integer value2) {
            addCriterion("`show` between", value1, value2, "show");
            return (Criteria) this;
        }

        public Criteria andShowNotBetween(Integer value1, Integer value2) {
            addCriterion("`show` not between", value1, value2, "show");
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