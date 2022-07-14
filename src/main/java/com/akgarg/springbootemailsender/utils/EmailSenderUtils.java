package com.akgarg.springbootemailsender.utils;

import com.akgarg.springbootemailsender.config.EmailSenderConfigProperties;
import com.akgarg.springbootemailsender.dto.SendEmailRequest;
import com.akgarg.springbootemailsender.exception.BadRequestException;

/**
 * Author: Akhilesh Garg
 * GitHub: <a href="https://github.com/akgarg0472">https://github.com/akgarg0472</a>
 * Date: 14-07-2022
 */
public class EmailSenderUtils {

    public static void checkSendEmailRequest(SendEmailRequest request) {
        if (request.getToEmail() == null || request.getToEmail().trim().isEmpty()) {
            throw new BadRequestException("Invalid 'to' email in request");
        }

        if (request.getSubject() == null || request.getSubject().trim().isEmpty()) {
            throw new BadRequestException("Invalid email 'subject' in request");
        }

        if (request.getMessage() == null || request.getMessage().trim().isEmpty()) {
            throw new BadRequestException("Invalid email 'message' in request");
        }

    }

    public static void checkEmailSenderProperties(EmailSenderConfigProperties config) {
        if (config == null || config.getHost() == null || config.getPort() == 0 || config.getSenderEmail() == null || config.getSenderEmailPassword() == null) {
            throw new NullPointerException("Invalid email config properties");
        }
    }
}
