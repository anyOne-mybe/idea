package com.hrsj.it.idea.core.permission.domain;

public class IdeaResource {
    private Integer id;

    private String resourceCode;

    private String resourceDesc;

    private String operationCode;

    private String opetationDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode == null ? null : resourceCode.trim();
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc == null ? null : resourceDesc.trim();
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode == null ? null : operationCode.trim();
    }

    public String getOpetationDesc() {
        return opetationDesc;
    }

    public void setOpetationDesc(String opetationDesc) {
        this.opetationDesc = opetationDesc == null ? null : opetationDesc.trim();
    }
}