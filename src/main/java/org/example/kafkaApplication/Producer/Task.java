package org.example.kafkaApplication.Producer;

import com.fasterxml.jackson.annotation.*;


public class Task {
    @JsonProperty("taskId")
    private String taskId;
    @JsonProperty("studentId")
    private String studentId;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("dateOfSubmission")
    private String dateOfSubmission;


   /* public Task(String taskId, String studentId, String subject, String dateOfSubmission) {
        this.taskId = taskId;
        this.studentId = studentId;
        this.subject = subject;
        this.dateOfSubmission = dateOfSubmission;
    }*/
    @JsonCreator
    public Task(@JsonProperty("taskId") String taskId, @JsonProperty("studentId") String studentId, @JsonProperty("subject") String subject, @JsonProperty("dateOfSubmission") String dateOfSubmission ) {
        this.taskId = taskId;
        this.studentId = studentId;
        this.subject = subject;
        this.dateOfSubmission = dateOfSubmission;
    }


    /*public String toJson() {
        // Convert Task object to JSON format (You can use a library like Jackson or Gson)
        return String.format("{\"taskId\":\"%s\",\"studentId\":\"%s\",\"subject\":\"%s\",\"dateOfSubmission\":\"%s\"}",
                taskId, studentId, subject, dateOfSubmission);
    }*/
}