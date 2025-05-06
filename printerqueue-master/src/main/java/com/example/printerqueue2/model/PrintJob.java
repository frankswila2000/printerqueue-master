package com.example.printerqueue2.model;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PrintJob {
    private String id;
    private String documentName;
    private int pages;
    private PrintJobPriority priority;
    private LocalDateTime submissionTime = LocalDateTime.now();
    private String submittedBy;
}