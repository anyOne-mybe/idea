package com.hrsj.it.idea.core.permission.domain;

import java.util.ArrayList;
import java.util.List;

public class IdeaResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IdeaResourceExample() {
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

        public Criteria andResourceCodeIsNull() {
            addCriterion("resource_code is null");
            return (Criteria) this;
        }

        public Criteria andResourceCodeIsNotNull() {
            addCriterion("resource_code is not null");
            return (Criteria) this;
        }

        public Criteria andResourceCodeEqualTo(String value) {
            addCriterion("resource_code =", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeNotEqualTo(String value) {
            addCriterion("resource_code <>", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeGreaterThan(String value) {
            addCriterion("resource_code >", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("resource_code >=", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeLessThan(String value) {
            addCriterion("resource_code <", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeLessThanOrEqualTo(String value) {
            addCriterion("resource_code <=", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeLike(String value) {
            addCriterion("resource_code like", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeNotLike(String value) {
            addCriterion("resource_code not like", value, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeIn(List<String> values) {
            addCriterion("resource_code in", values, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeNotIn(List<String> values) {
            addCriterion("resource_code not in", values, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeBetween(String value1, String value2) {
            addCriterion("resource_code between", value1, value2, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceCodeNotBetween(String value1, String value2) {
            addCriterion("resource_code not between", value1, value2, "resourceCode");
            return (Criteria) this;
        }

        public Criteria andResourceDescIsNull() {
            addCriterion("resource_desc is null");
            return (Criteria) this;
        }

        public Criteria andResourceDescIsNotNull() {
            addCriterion("resource_desc is not null");
            return (Criteria) this;
        }

        public Criteria andResourceDescEqualTo(String value) {
            addCriterion("resource_desc =", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescNotEqualTo(String value) {
            addCriterion("resource_desc <>", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescGreaterThan(String value) {
            addCriterion("resource_desc >", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescGreaterThanOrEqualTo(String value) {
            addCriterion("resource_desc >=", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescLessThan(String value) {
            addCriterion("resource_desc <", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescLessThanOrEqualTo(String value) {
            addCriterion("resource_desc <=", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescLike(String value) {
            addCriterion("resource_desc like", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescNotLike(String value) {
            addCriterion("resource_desc not like", value, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescIn(List<String> values) {
            addCriterion("resource_desc in", values, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescNotIn(List<String> values) {
            addCriterion("resource_desc not in", values, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescBetween(String value1, String value2) {
            addCriterion("resource_desc between", value1, value2, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andResourceDescNotBetween(String value1, String value2) {
            addCriterion("resource_desc not between", value1, value2, "resourceDesc");
            return (Criteria) this;
        }

        public Criteria andOperationCodeIsNull() {
            addCriterion("operation_code is null");
            return (Criteria) this;
        }

        public Criteria andOperationCodeIsNotNull() {
            addCriterion("operation_code is not null");
            return (Criteria) this;
        }

        public Criteria andOperationCodeEqualTo(String value) {
            addCriterion("operation_code =", value, "operationCode");
            return (Criteria) this;
        }

        public Criteria andOperationCodeNotEqualTo(String value) {
            addCriterion("operation_code <>", value, "operationCode");
            return (Criteria) this;
        }

        public Criteria andOperationCodeGreaterThan(String value) {
            addCriterion("operation_code >", value, "operationCode");
            return (Criteria) this;
        }

        public Criteria andOperationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("operation_code >=", value, "operationCode");
            return (Criteria) this;
        }

        public Criteria andOperationCodeLessThan(String value) {
            addCriterion("operation_code <", value, "operationCode");
            return (Criteria) this;
        }

        public Criteria andOperationCodeLessThanOrEqualTo(String value) {
            addCriterion("operation_code <=", value, "operationCode");
            return (Criteria) this;
        }

        public Criteria andOperationCodeLike(String value) {
            addCriterion("operation_code like", value, "operationCode");
            return (Criteria) this;
        }

        public Criteria andOperationCodeNotLike(String value) {
            addCriterion("operation_code not like", value, "operationCode");
            return (Criteria) this;
        }

        public Criteria andOperationCodeIn(List<String> values) {
            addCriterion("operation_code in", values, "operationCode");
            return (Criteria) this;
        }

        public Criteria andOperationCodeNotIn(List<String> values) {
            addCriterion("operation_code not in", values, "operationCode");
            return (Criteria) this;
        }

        public Criteria andOperationCodeBetween(String value1, String value2) {
            addCriterion("operation_code between", value1, value2, "operationCode");
            return (Criteria) this;
        }

        public Criteria andOperationCodeNotBetween(String value1, String value2) {
            addCriterion("operation_code not between", value1, value2, "operationCode");
            return (Criteria) this;
        }

        public Criteria andOpetationDescIsNull() {
            addCriterion("opetation_desc is null");
            return (Criteria) this;
        }

        public Criteria andOpetationDescIsNotNull() {
            addCriterion("opetation_desc is not null");
            return (Criteria) this;
        }

        public Criteria andOpetationDescEqualTo(String value) {
            addCriterion("opetation_desc =", value, "opetationDesc");
            return (Criteria) this;
        }

        public Criteria andOpetationDescNotEqualTo(String value) {
            addCriterion("opetation_desc <>", value, "opetationDesc");
            return (Criteria) this;
        }

        public Criteria andOpetationDescGreaterThan(String value) {
            addCriterion("opetation_desc >", value, "opetationDesc");
            return (Criteria) this;
        }

        public Criteria andOpetationDescGreaterThanOrEqualTo(String value) {
            addCriterion("opetation_desc >=", value, "opetationDesc");
            return (Criteria) this;
        }

        public Criteria andOpetationDescLessThan(String value) {
            addCriterion("opetation_desc <", value, "opetationDesc");
            return (Criteria) this;
        }

        public Criteria andOpetationDescLessThanOrEqualTo(String value) {
            addCriterion("opetation_desc <=", value, "opetationDesc");
            return (Criteria) this;
        }

        public Criteria andOpetationDescLike(String value) {
            addCriterion("opetation_desc like", value, "opetationDesc");
            return (Criteria) this;
        }

        public Criteria andOpetationDescNotLike(String value) {
            addCriterion("opetation_desc not like", value, "opetationDesc");
            return (Criteria) this;
        }

        public Criteria andOpetationDescIn(List<String> values) {
            addCriterion("opetation_desc in", values, "opetationDesc");
            return (Criteria) this;
        }

        public Criteria andOpetationDescNotIn(List<String> values) {
            addCriterion("opetation_desc not in", values, "opetationDesc");
            return (Criteria) this;
        }

        public Criteria andOpetationDescBetween(String value1, String value2) {
            addCriterion("opetation_desc between", value1, value2, "opetationDesc");
            return (Criteria) this;
        }

        public Criteria andOpetationDescNotBetween(String value1, String value2) {
            addCriterion("opetation_desc not between", value1, value2, "opetationDesc");
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