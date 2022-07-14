package com.akgarg.springbootemailsender.service;

/**
 * Author: Akhilesh Garg
 * GitHub: <a href="https://github.com/akgarg0472">https://github.com/akgarg0472</a>
 * Date: 14-07-2022
 */
public interface EmailSenderService {

    void send(String toEmail, String subject, String message);

}
