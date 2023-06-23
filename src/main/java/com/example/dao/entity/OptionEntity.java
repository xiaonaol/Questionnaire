package com.example.dao.entity;

public class OptionEntity {
    private String id;
    private String questionId;
    private String optionText;
    private String optionOrder;
    private String questionnaireId;
    private String fraction;
    private String leftTitle;

    @Override
    public String toString() {
        return "OptionEntity{" +
                "id='" + id + '\'' +
                ", questionId='" + questionId + '\'' +
                ", optionText='" + optionText + '\'' +
                ", optionOrder='" + optionOrder + '\'' +
                ", questionnaire_id='" + questionnaireId + '\'' +
                ", fraction='" + fraction + '\'' +
                ", leftTitle='" + leftTitle + '\'' +
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

    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    public String getLeftTitle() {
        return leftTitle;
    }

    public void setLeftTitle(String leftTitle) {
        this.leftTitle = leftTitle;
    }
}

