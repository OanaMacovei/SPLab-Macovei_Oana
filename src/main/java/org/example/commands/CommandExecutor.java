package org.example.commands;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class CommandExecutor {
    public ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public HashMap<String, String> asyncTasks = new HashMap<>();

    public <T> T executeSynchronous(Command<T> command) {
        return command.execute();
    }

    public String executeAsync(Command<?> command) {
        String trackingId = UUID.randomUUID().toString();
        asyncTasks.put(trackingId, "PENDING");

        threadPool.submit(() -> {
            try {
                command.execute();
                asyncTasks.put(trackingId, "COMPLETED");
            } catch (Exception e) {
                asyncTasks.put(trackingId, "FAILED");
            }
        });

        return trackingId;
    }

    public String getTaskStatus(String trackingId) {
        return asyncTasks.getOrDefault(trackingId, "NOT_FOUND");
    }
}