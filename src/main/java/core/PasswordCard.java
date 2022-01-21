package core;

import java.util.Objects;

public class PasswordCard implements Comparable<PasswordCard> {
    private int id;
    private String serviceName;
    private String email;
    private String pass;
    private String recoveryCode;
    private String secretQuestion;
    private String secretQuestionAnswer;
    private String description;

    public PasswordCard(int id,
                        String serviceName,
                        String email,
                        String pass,
                        String recoveryCode,
                        String secretQuestion,
                        String secretQuestionAnswer,
                        String description) {

        this.id = id;
        this.serviceName = serviceName;
        this.email = email;
        this.pass = pass;
        this.recoveryCode = recoveryCode;
        this.secretQuestion = secretQuestion;
        this.secretQuestionAnswer = secretQuestionAnswer;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRecoveryCode() {
        return recoveryCode;
    }

    public void setRecoveryCode(String recoveryCode) {
        this.recoveryCode = recoveryCode;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getSecretQuestionAnswer() {
        return secretQuestionAnswer;
    }

    public void setSecretQuestionAnswer(String secretQuestionAnswer) {
        this.secretQuestionAnswer = secretQuestionAnswer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    Old toString() method
//    @Override
//    public String toString() {
//        return "PasswordCard{" +
//                "serviceName='" + serviceName + '\'' +
//                ", email='" + email + '\'' +
//                ", pass='" + pass + '\'' +
//                ", recoveryCode='" + recoveryCode + '\'' +
//                ", secretQuestion='" + secretQuestion + '\'' +
//                ", secretQuestionAnswer='" + secretQuestionAnswer + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }


    @Override
    public int compareTo(PasswordCard o) {
        return this.getServiceName().compareTo(o.getServiceName());
    }

    @Override
    public String toString() {
        return "     " + serviceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordCard that = (PasswordCard) o;
        return Objects.equals(serviceName, that.serviceName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(pass, that.pass) &&
                Objects.equals(recoveryCode, that.recoveryCode) &&
                Objects.equals(secretQuestion, that.secretQuestion) &&
                Objects.equals(secretQuestionAnswer, that.secretQuestionAnswer) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                serviceName,
                email,
                pass,
                recoveryCode,
                secretQuestion,
                secretQuestionAnswer,
                description);
    }
}
