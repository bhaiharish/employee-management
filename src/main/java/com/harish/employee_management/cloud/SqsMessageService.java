package com.harish.employee_management.cloud;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harish.employee_management.model.AppraisalRequestModel;
import com.harish.employee_management.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SqsMessageService {
    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    public void send(String queue, AppraisalRequestModel employee) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMessage = objectMapper.writeValueAsString(employee);
        queueMessagingTemplate.convertAndSend(queue, jsonMessage);
    }

    @SqsListener("processed-message-to-organization")
    public void loadMessagesFromQueue(String message) {
        System.out.println("Queue Messages: " + message);
    }
}
