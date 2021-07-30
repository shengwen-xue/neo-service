package com.xsw.neo.service.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andCheckUserIsNull() {
            addCriterion("check_user is null");
            return (Criteria) this;
        }

        public Criteria andCheckUserIsNotNull() {
            addCriterion("check_user is not null");
            return (Criteria) this;
        }

        public Criteria andCheckUserEqualTo(String value) {
            addCriterion("check_user =", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotEqualTo(String value) {
            addCriterion("check_user <>", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserGreaterThan(String value) {
            addCriterion("check_user >", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserGreaterThanOrEqualTo(String value) {
            addCriterion("check_user >=", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserLessThan(String value) {
            addCriterion("check_user <", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserLessThanOrEqualTo(String value) {
            addCriterion("check_user <=", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserLike(String value) {
            addCriterion("check_user like", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotLike(String value) {
            addCriterion("check_user not like", value, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserIn(List<String> values) {
            addCriterion("check_user in", values, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotIn(List<String> values) {
            addCriterion("check_user not in", values, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserBetween(String value1, String value2) {
            addCriterion("check_user between", value1, value2, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckUserNotBetween(String value1, String value2) {
            addCriterion("check_user not between", value1, value2, "checkUser");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNull() {
            addCriterion("check_date is null");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNotNull() {
            addCriterion("check_date is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDateEqualTo(Date value) {
            addCriterion("check_date =", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotEqualTo(Date value) {
            addCriterion("check_date <>", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThan(Date value) {
            addCriterion("check_date >", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThanOrEqualTo(Date value) {
            addCriterion("check_date >=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThan(Date value) {
            addCriterion("check_date <", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThanOrEqualTo(Date value) {
            addCriterion("check_date <=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateIn(List<Date> values) {
            addCriterion("check_date in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotIn(List<Date> values) {
            addCriterion("check_date not in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateBetween(Date value1, Date value2) {
            addCriterion("check_date between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotBetween(Date value1, Date value2) {
            addCriterion("check_date not between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andFixUserIsNull() {
            addCriterion("fix_user is null");
            return (Criteria) this;
        }

        public Criteria andFixUserIsNotNull() {
            addCriterion("fix_user is not null");
            return (Criteria) this;
        }

        public Criteria andFixUserEqualTo(String value) {
            addCriterion("fix_user =", value, "fixUser");
            return (Criteria) this;
        }

        public Criteria andFixUserNotEqualTo(String value) {
            addCriterion("fix_user <>", value, "fixUser");
            return (Criteria) this;
        }

        public Criteria andFixUserGreaterThan(String value) {
            addCriterion("fix_user >", value, "fixUser");
            return (Criteria) this;
        }

        public Criteria andFixUserGreaterThanOrEqualTo(String value) {
            addCriterion("fix_user >=", value, "fixUser");
            return (Criteria) this;
        }

        public Criteria andFixUserLessThan(String value) {
            addCriterion("fix_user <", value, "fixUser");
            return (Criteria) this;
        }

        public Criteria andFixUserLessThanOrEqualTo(String value) {
            addCriterion("fix_user <=", value, "fixUser");
            return (Criteria) this;
        }

        public Criteria andFixUserLike(String value) {
            addCriterion("fix_user like", value, "fixUser");
            return (Criteria) this;
        }

        public Criteria andFixUserNotLike(String value) {
            addCriterion("fix_user not like", value, "fixUser");
            return (Criteria) this;
        }

        public Criteria andFixUserIn(List<String> values) {
            addCriterion("fix_user in", values, "fixUser");
            return (Criteria) this;
        }

        public Criteria andFixUserNotIn(List<String> values) {
            addCriterion("fix_user not in", values, "fixUser");
            return (Criteria) this;
        }

        public Criteria andFixUserBetween(String value1, String value2) {
            addCriterion("fix_user between", value1, value2, "fixUser");
            return (Criteria) this;
        }

        public Criteria andFixUserNotBetween(String value1, String value2) {
            addCriterion("fix_user not between", value1, value2, "fixUser");
            return (Criteria) this;
        }

        public Criteria andFixDateIsNull() {
            addCriterion("fix_date is null");
            return (Criteria) this;
        }

        public Criteria andFixDateIsNotNull() {
            addCriterion("fix_date is not null");
            return (Criteria) this;
        }

        public Criteria andFixDateEqualTo(Date value) {
            addCriterion("fix_date =", value, "fixDate");
            return (Criteria) this;
        }

        public Criteria andFixDateNotEqualTo(Date value) {
            addCriterion("fix_date <>", value, "fixDate");
            return (Criteria) this;
        }

        public Criteria andFixDateGreaterThan(Date value) {
            addCriterion("fix_date >", value, "fixDate");
            return (Criteria) this;
        }

        public Criteria andFixDateGreaterThanOrEqualTo(Date value) {
            addCriterion("fix_date >=", value, "fixDate");
            return (Criteria) this;
        }

        public Criteria andFixDateLessThan(Date value) {
            addCriterion("fix_date <", value, "fixDate");
            return (Criteria) this;
        }

        public Criteria andFixDateLessThanOrEqualTo(Date value) {
            addCriterion("fix_date <=", value, "fixDate");
            return (Criteria) this;
        }

        public Criteria andFixDateIn(List<Date> values) {
            addCriterion("fix_date in", values, "fixDate");
            return (Criteria) this;
        }

        public Criteria andFixDateNotIn(List<Date> values) {
            addCriterion("fix_date not in", values, "fixDate");
            return (Criteria) this;
        }

        public Criteria andFixDateBetween(Date value1, Date value2) {
            addCriterion("fix_date between", value1, value2, "fixDate");
            return (Criteria) this;
        }

        public Criteria andFixDateNotBetween(Date value1, Date value2) {
            addCriterion("fix_date not between", value1, value2, "fixDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Byte value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Byte value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Byte value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Byte value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Byte value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Byte> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Byte> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andFloorIsNull() {
            addCriterion("floor is null");
            return (Criteria) this;
        }

        public Criteria andFloorIsNotNull() {
            addCriterion("floor is not null");
            return (Criteria) this;
        }

        public Criteria andFloorEqualTo(String value) {
            addCriterion("floor =", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotEqualTo(String value) {
            addCriterion("floor <>", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThan(String value) {
            addCriterion("floor >", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThanOrEqualTo(String value) {
            addCriterion("floor >=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThan(String value) {
            addCriterion("floor <", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThanOrEqualTo(String value) {
            addCriterion("floor <=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLike(String value) {
            addCriterion("floor like", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotLike(String value) {
            addCriterion("floor not like", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorIn(List<String> values) {
            addCriterion("floor in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotIn(List<String> values) {
            addCriterion("floor not in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorBetween(String value1, String value2) {
            addCriterion("floor between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotBetween(String value1, String value2) {
            addCriterion("floor not between", value1, value2, "floor");
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

        public Criteria andUptimeIsNull() {
            addCriterion("uptime is null");
            return (Criteria) this;
        }

        public Criteria andUptimeIsNotNull() {
            addCriterion("uptime is not null");
            return (Criteria) this;
        }

        public Criteria andUptimeEqualTo(Date value) {
            addCriterion("uptime =", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotEqualTo(Date value) {
            addCriterion("uptime <>", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeGreaterThan(Date value) {
            addCriterion("uptime >", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("uptime >=", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLessThan(Date value) {
            addCriterion("uptime <", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLessThanOrEqualTo(Date value) {
            addCriterion("uptime <=", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeIn(List<Date> values) {
            addCriterion("uptime in", values, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotIn(List<Date> values) {
            addCriterion("uptime not in", values, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeBetween(Date value1, Date value2) {
            addCriterion("uptime between", value1, value2, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotBetween(Date value1, Date value2) {
            addCriterion("uptime not between", value1, value2, "uptime");
            return (Criteria) this;
        }

        public Criteria andUpdataIsNull() {
            addCriterion("updata is null");
            return (Criteria) this;
        }

        public Criteria andUpdataIsNotNull() {
            addCriterion("updata is not null");
            return (Criteria) this;
        }

        public Criteria andUpdataEqualTo(String value) {
            addCriterion("updata =", value, "updata");
            return (Criteria) this;
        }

        public Criteria andUpdataNotEqualTo(String value) {
            addCriterion("updata <>", value, "updata");
            return (Criteria) this;
        }

        public Criteria andUpdataGreaterThan(String value) {
            addCriterion("updata >", value, "updata");
            return (Criteria) this;
        }

        public Criteria andUpdataGreaterThanOrEqualTo(String value) {
            addCriterion("updata >=", value, "updata");
            return (Criteria) this;
        }

        public Criteria andUpdataLessThan(String value) {
            addCriterion("updata <", value, "updata");
            return (Criteria) this;
        }

        public Criteria andUpdataLessThanOrEqualTo(String value) {
            addCriterion("updata <=", value, "updata");
            return (Criteria) this;
        }

        public Criteria andUpdataLike(String value) {
            addCriterion("updata like", value, "updata");
            return (Criteria) this;
        }

        public Criteria andUpdataNotLike(String value) {
            addCriterion("updata not like", value, "updata");
            return (Criteria) this;
        }

        public Criteria andUpdataIn(List<String> values) {
            addCriterion("updata in", values, "updata");
            return (Criteria) this;
        }

        public Criteria andUpdataNotIn(List<String> values) {
            addCriterion("updata not in", values, "updata");
            return (Criteria) this;
        }

        public Criteria andUpdataBetween(String value1, String value2) {
            addCriterion("updata between", value1, value2, "updata");
            return (Criteria) this;
        }

        public Criteria andUpdataNotBetween(String value1, String value2) {
            addCriterion("updata not between", value1, value2, "updata");
            return (Criteria) this;
        }

        public Criteria andAlarmDateIsNull() {
            addCriterion("alarm_date is null");
            return (Criteria) this;
        }

        public Criteria andAlarmDateIsNotNull() {
            addCriterion("alarm_date is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmDateEqualTo(Date value) {
            addCriterion("alarm_date =", value, "alarmDate");
            return (Criteria) this;
        }

        public Criteria andAlarmDateNotEqualTo(Date value) {
            addCriterion("alarm_date <>", value, "alarmDate");
            return (Criteria) this;
        }

        public Criteria andAlarmDateGreaterThan(Date value) {
            addCriterion("alarm_date >", value, "alarmDate");
            return (Criteria) this;
        }

        public Criteria andAlarmDateGreaterThanOrEqualTo(Date value) {
            addCriterion("alarm_date >=", value, "alarmDate");
            return (Criteria) this;
        }

        public Criteria andAlarmDateLessThan(Date value) {
            addCriterion("alarm_date <", value, "alarmDate");
            return (Criteria) this;
        }

        public Criteria andAlarmDateLessThanOrEqualTo(Date value) {
            addCriterion("alarm_date <=", value, "alarmDate");
            return (Criteria) this;
        }

        public Criteria andAlarmDateIn(List<Date> values) {
            addCriterion("alarm_date in", values, "alarmDate");
            return (Criteria) this;
        }

        public Criteria andAlarmDateNotIn(List<Date> values) {
            addCriterion("alarm_date not in", values, "alarmDate");
            return (Criteria) this;
        }

        public Criteria andAlarmDateBetween(Date value1, Date value2) {
            addCriterion("alarm_date between", value1, value2, "alarmDate");
            return (Criteria) this;
        }

        public Criteria andAlarmDateNotBetween(Date value1, Date value2) {
            addCriterion("alarm_date not between", value1, value2, "alarmDate");
            return (Criteria) this;
        }

        public Criteria andIsAlarmIsNull() {
            addCriterion("is_alarm is null");
            return (Criteria) this;
        }

        public Criteria andIsAlarmIsNotNull() {
            addCriterion("is_alarm is not null");
            return (Criteria) this;
        }

        public Criteria andIsAlarmEqualTo(Byte value) {
            addCriterion("is_alarm =", value, "isAlarm");
            return (Criteria) this;
        }

        public Criteria andIsAlarmNotEqualTo(Byte value) {
            addCriterion("is_alarm <>", value, "isAlarm");
            return (Criteria) this;
        }

        public Criteria andIsAlarmGreaterThan(Byte value) {
            addCriterion("is_alarm >", value, "isAlarm");
            return (Criteria) this;
        }

        public Criteria andIsAlarmGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_alarm >=", value, "isAlarm");
            return (Criteria) this;
        }

        public Criteria andIsAlarmLessThan(Byte value) {
            addCriterion("is_alarm <", value, "isAlarm");
            return (Criteria) this;
        }

        public Criteria andIsAlarmLessThanOrEqualTo(Byte value) {
            addCriterion("is_alarm <=", value, "isAlarm");
            return (Criteria) this;
        }

        public Criteria andIsAlarmIn(List<Byte> values) {
            addCriterion("is_alarm in", values, "isAlarm");
            return (Criteria) this;
        }

        public Criteria andIsAlarmNotIn(List<Byte> values) {
            addCriterion("is_alarm not in", values, "isAlarm");
            return (Criteria) this;
        }

        public Criteria andIsAlarmBetween(Byte value1, Byte value2) {
            addCriterion("is_alarm between", value1, value2, "isAlarm");
            return (Criteria) this;
        }

        public Criteria andIsAlarmNotBetween(Byte value1, Byte value2) {
            addCriterion("is_alarm not between", value1, value2, "isAlarm");
            return (Criteria) this;
        }

        public Criteria andAlarmDataIsNull() {
            addCriterion("alarm_data is null");
            return (Criteria) this;
        }

        public Criteria andAlarmDataIsNotNull() {
            addCriterion("alarm_data is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmDataEqualTo(String value) {
            addCriterion("alarm_data =", value, "alarmData");
            return (Criteria) this;
        }

        public Criteria andAlarmDataNotEqualTo(String value) {
            addCriterion("alarm_data <>", value, "alarmData");
            return (Criteria) this;
        }

        public Criteria andAlarmDataGreaterThan(String value) {
            addCriterion("alarm_data >", value, "alarmData");
            return (Criteria) this;
        }

        public Criteria andAlarmDataGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_data >=", value, "alarmData");
            return (Criteria) this;
        }

        public Criteria andAlarmDataLessThan(String value) {
            addCriterion("alarm_data <", value, "alarmData");
            return (Criteria) this;
        }

        public Criteria andAlarmDataLessThanOrEqualTo(String value) {
            addCriterion("alarm_data <=", value, "alarmData");
            return (Criteria) this;
        }

        public Criteria andAlarmDataLike(String value) {
            addCriterion("alarm_data like", value, "alarmData");
            return (Criteria) this;
        }

        public Criteria andAlarmDataNotLike(String value) {
            addCriterion("alarm_data not like", value, "alarmData");
            return (Criteria) this;
        }

        public Criteria andAlarmDataIn(List<String> values) {
            addCriterion("alarm_data in", values, "alarmData");
            return (Criteria) this;
        }

        public Criteria andAlarmDataNotIn(List<String> values) {
            addCriterion("alarm_data not in", values, "alarmData");
            return (Criteria) this;
        }

        public Criteria andAlarmDataBetween(String value1, String value2) {
            addCriterion("alarm_data between", value1, value2, "alarmData");
            return (Criteria) this;
        }

        public Criteria andAlarmDataNotBetween(String value1, String value2) {
            addCriterion("alarm_data not between", value1, value2, "alarmData");
            return (Criteria) this;
        }

        public Criteria andAlarmValueIsNull() {
            addCriterion("alarm_value is null");
            return (Criteria) this;
        }

        public Criteria andAlarmValueIsNotNull() {
            addCriterion("alarm_value is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmValueEqualTo(Integer value) {
            addCriterion("alarm_value =", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueNotEqualTo(Integer value) {
            addCriterion("alarm_value <>", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueGreaterThan(Integer value) {
            addCriterion("alarm_value >", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarm_value >=", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueLessThan(Integer value) {
            addCriterion("alarm_value <", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueLessThanOrEqualTo(Integer value) {
            addCriterion("alarm_value <=", value, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueIn(List<Integer> values) {
            addCriterion("alarm_value in", values, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueNotIn(List<Integer> values) {
            addCriterion("alarm_value not in", values, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueBetween(Integer value1, Integer value2) {
            addCriterion("alarm_value between", value1, value2, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmValueNotBetween(Integer value1, Integer value2) {
            addCriterion("alarm_value not between", value1, value2, "alarmValue");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageIsNull() {
            addCriterion("alarm_message is null");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageIsNotNull() {
            addCriterion("alarm_message is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageEqualTo(String value) {
            addCriterion("alarm_message =", value, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageNotEqualTo(String value) {
            addCriterion("alarm_message <>", value, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageGreaterThan(String value) {
            addCriterion("alarm_message >", value, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_message >=", value, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageLessThan(String value) {
            addCriterion("alarm_message <", value, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageLessThanOrEqualTo(String value) {
            addCriterion("alarm_message <=", value, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageLike(String value) {
            addCriterion("alarm_message like", value, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageNotLike(String value) {
            addCriterion("alarm_message not like", value, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageIn(List<String> values) {
            addCriterion("alarm_message in", values, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageNotIn(List<String> values) {
            addCriterion("alarm_message not in", values, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageBetween(String value1, String value2) {
            addCriterion("alarm_message between", value1, value2, "alarmMessage");
            return (Criteria) this;
        }

        public Criteria andAlarmMessageNotBetween(String value1, String value2) {
            addCriterion("alarm_message not between", value1, value2, "alarmMessage");
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