package com.akgarg.springbootemailsender.controller;

import com.akgarg.springbootemailsender.dto.SendEmailRequest;
import com.akgarg.springbootemailsender.service.EmailSenderService;
import com.akgarg.springbootemailsender.utils.EmailSenderUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Akhilesh Garg
 * GitHub: <a href="https://github.com/akgarg0472">https://github.com/akgarg0472</a>
 * Date: 14-07-2022
 */
@RestController
@RequestMapping("/api/v1")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<?> sendEmail(@RequestBody SendEmailRequest request) {
        EmailSenderUtils.checkSendEmailRequest(request);
        emailSenderService.send(request.getToEmail(), request.getSubject(), request.getMessage());
        return ResponseEntity.ok(generateSuccessResponse());
    }

    private Map<String, Object> generateSuccessResponse() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Email sent successfully");
        response.put("status", HttpStatus.OK.value());
        response.put("success", true);
        response.put("timestamp", LocalDateTime.now());

        return response;
    }

}
