package com.example.dao.entity;

public class OptionEntity {
    private String id;
    private String questionId;
    private String optionText;
    private String optionOrder;

    @Override
    public String toString() {
        return "OptionEntity{" +
                "id='" + id + '\'' +
                ", questionId='" + questionId + '\'' +
                ", optionText='" + optionText + '\'' +
                ", optionOrder='" + optionOrder + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public String getOptionOrder() {
        return optionOrder;
    }

    public void setOptionOrder(String optionOrder) {
        this.optionOrder = optionOrder;
    }
}

