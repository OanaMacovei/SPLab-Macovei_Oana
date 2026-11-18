package org.example;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SseObserver implements Observer{
    public SseEmitter emmiter;

    public SseObserver(SseEmitter emmiter) {
        this.emmiter = emmiter;
    }

    @Override
    public void update(Book book) {
        try {
            Map<String, Object> payload = new HashMap<>();
            payload.put("id", book.getId());
            payload.put("title", book.getTitle());

            this.emmiter.send(book, MediaType.APPLICATION_JSON);
        }catch (IOException e) {
            this.emmiter.completeWithError(e);
        }
    }
}
