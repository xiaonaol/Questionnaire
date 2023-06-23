package com.example.dao.entity;

import java.util.Date;

public class QuestionnaireEntity {
    private String id;
    private String questionnaireTitle;
    private String questionnaireDescription;
    private Date startTime;
    private Date endTime;
    private Date creationTime;
    private String createdBy;
    private String questionnaireType;
    private int questionCount;
    private String status;
    private String projectName;

    @Override
    public String toString() {
        return "QuestionnaireEntity{" +
                "id=" + id +
                ", questionnaireTitle='" + questionnaireTitle + '\'' +
                ", questionnaireDescription='" + questionnaireDescription + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", creationTime=" + creationTime +
                ", createdBy='" + createdBy + '\'' +
                ", questionnaireType='" + questionnaireType + '\'' +
                ", questionCount=" + questionCount +
                ", status='" + status + '\'' +
                ", projectId='" + projectName + '\'' +
                '}';
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionnaireTitle() {
        return questionnaireTitle;
    }

    public void setQuestionnaireTitle(String questionnaireTitle) {
        this.questionnaireTitle = questionnaireTitle;
    }

    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    public void setQuestionnaireDescription(String questionnaireDescription) {
        this.questionnaireDescription = questionnaireDescription;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getQuestionnaireType() {
        return questionnaireType;
    }

    public void setQuestionnaireType(String questionnaireType) {
        this.questionnaireType = questionnaireType;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}

