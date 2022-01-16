package core;

import java.util.Objects;

public class PasswordCard implements Comparable <PasswordCard>{
    private String serviceName;
    private String email;
    private String pass;
    private String recoveryCode;
    private String secretQuestion;
    private String secretQuestionAnswer;
    private String description;

    public PasswordCard(String serviceName,
                        String email,
                        String pass,
                        String recoveryCode,
                        String secretQuestion,
                        String secretQuestionAnswer,
                        String description) {

        this.serviceName = serviceName;
        this.email = email;
        this.pass = pass;
        this.recoveryCode = recoveryCode;
        this.secretQuestion = secretQuestion;
        this.secretQuestionAnswer = secretQuestionAnswer;
        this.description = description;
    }

    /*
     * Replace String interpretation from passwordbase.txt to PasswordCard like object
     * */
    public static PasswordCard transferFromString(String strPassCard) {
        String serviceName = strPassCard.substring(
                strPassCard.indexOf("ServiceName:") + 12,
                strPassCard.indexOf("\nEmail:"));
        String email = strPassCard.substring(
                strPassCard.indexOf("Email:") + 6,
                strPassCard.indexOf("\nPass:"));
        String pass = strPassCard.substring(
                strPassCard.indexOf("Pass:") + 5,
                strPassCard.indexOf("\nRecoveryCode:"));
        String recoveryCode = strPassCard.substring(
                strPassCard.indexOf("RecoveryCode:") + 13,
                strPassCard.indexOf("\nSecretQuestion:"));
        String secretQuestion = strPassCard.substring(
                strPassCard.indexOf("SecretQuestion:") + 15,
                strPassCard.indexOf("\nSecretQuestionAnswer:"));
        String secretQuestionAnswer = strPassCard.substring(
                strPassCard.indexOf("SecretQuestionAnswer:") + 21,
                strPassCard.indexOf("\nDescription:"));
        String description = strPassCard.substring(
                strPassCard.indexOf("Description:") + 12,
                strPassCard.length() - 1);

        return new PasswordCard(
                serviceName,
                email,
                pass,
                recoveryCode,
                secretQuestion,
                secretQuestionAnswer,
                description);
    }

    /*
     * Replace PasswordCard like object in String interpretation
     * for writing in passwordbase.txt
     * */
    public String transferToString() {
        return ("ServiceName:" + serviceName + "\n" +
                "Email:" + email + "\n" +
                "Pass:" + pass + "\n" +
                "RecoveryCode:" + recoveryCode + "\n" +
                "SecretQuestion:" + secretQuestion + "\n" +
                "SecretQuestionAnswer:" + secretQuestionAnswer + "\n" +
                "Description:" + description + "\n" +
                "<card>\n");
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
