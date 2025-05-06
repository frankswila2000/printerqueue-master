package com.example.printerqueue2.controller;

import com.example.printerqueue2.model.PrintJob;
import com.example.printerqueue2.service.PrinterQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/printjobs")
public class PrintJobController {

    private final PrinterQueueService printerQueueService;

    @Autowired
    public PrintJobController(PrinterQueueService printerQueueService) {
        this.printerQueueService = printerQueueService;
    }

    @PostMapping
    public ResponseEntity<String> submitPrintJob(@RequestBody PrintJob printJob) {
        printerQueueService.submitPrintJob(printJob);
        return ResponseEntity.ok("Print job submitted successfully");
    }

    @GetMapping("/next")
    public ResponseEntity<PrintJob> getNextPrintJob() {
        PrintJob nextJob = printerQueueService.getNextJob();
        if (nextJob == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(nextJob);
    }

    @GetMapping
    public ResponseEntity<List<PrintJob>> getAllPrintJobs() {
        List<PrintJob> jobs = printerQueueService.getAllJobs();
        if (jobs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(jobs);
    }

    @DeleteMapping
    public ResponseEntity<String> clearPrintQueue() {
        printerQueueService.clearQueue();
        return ResponseEntity.ok("Print queue cleared");
    }

    @GetMapping("/size")
    public ResponseEntity<Integer> getQueueSize() {
        return ResponseEntity.ok(printerQueueService.getQueueSize());
    }
}