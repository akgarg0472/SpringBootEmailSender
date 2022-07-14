# Email Sender

Spring boot application to send email using Java

## Configurations

- Change following properties in application.properties file  
  <code>email.sender.host=<host-name></code><br>
  <code>email.sender.port=<port-number></code><br>
  <code>email.sender.sender-email=<email-username></code><br>
  <code>email.sender.sender-email-password=<email-password></code><br>
  <code>email.sender.protocol=<protocol-to-use></code><br>

## How to use

Make a <strong>POST</strong> request to <code>localhost:8080/email-sender/api/v1/</code> with following body:  
{  
&emsp;"to": "<receiver-email>",  
&emsp;"subject": "<email-subject>",  
&emsp;"message": "<email-body-message>"  
}