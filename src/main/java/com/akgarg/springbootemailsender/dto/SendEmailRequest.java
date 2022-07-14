package com.akgarg.springbootemailsender.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Author: Akhilesh Garg
 * GitHub: <a href="https://github.com/akgarg0472">https://github.com/akgarg0472</a>
 * Date: 14-07-2022
 */
@SuppressWarnings("unused")
public class SendEmailRequest {

    @JsonProperty("to")
    private String toEmail;
    private String message;
    private String subject;

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "SendEmailRequest{" +
                "toEmail='" + toEmail + '\'' +
                ", message='" + message + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }

}
