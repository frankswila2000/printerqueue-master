package com.example.printerqueue2.service;

import com.example.printerqueue2.model.PrintJob;
import java.util.List;

public interface PrinterQueueService {
    void submitPrintJob(PrintJob printJob);
    PrintJob getNextJob();
    List<PrintJob> getAllJobs();
    void clearQueue();
    int getQueueSize();
}