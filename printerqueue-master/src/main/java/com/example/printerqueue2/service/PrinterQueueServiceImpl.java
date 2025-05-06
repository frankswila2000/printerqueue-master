package com.example.printerqueue2.service;

import com.example.printerqueue2.model.PrintJob;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class PrinterQueueServiceImpl implements PrinterQueueService {
    private final Queue<PrintJob> printQueue = new LinkedList<>();

    @Override
    public void submitPrintJob(PrintJob printJob) {
        printQueue.add(printJob);
    }

    @Override
    public PrintJob getNextJob() {
        return printQueue.poll();
    }

    @Override
    public List<PrintJob> getAllJobs() {
        return new LinkedList<>(printQueue);  // LinkedList is a List implementation
    }

    @Override
    public void clearQueue() {
        printQueue.clear();
    }

    @Override
    public int getQueueSize() {
        return printQueue.size();
    }
}