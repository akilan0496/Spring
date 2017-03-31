package com.akilan0496;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.akilan0496.Message;

@RestController
@SpringBootApplication
public class SpringSseEventApplication {
	
	private final List<SseEmitter> emitters = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(SpringSseEventApplication.class, args);
	}
	
	@RequestMapping(path = "/stream", method = RequestMethod.GET)
    public SseEmitter stream() throws IOException {
		
		System.out.println("/stream ---------------------");

        SseEmitter emitter = new SseEmitter();
        emitters.add(emitter);
        emitter.onCompletion(() -> emitters.remove(emitter));

        return emitter;
    }
	
	
	@ResponseBody
    @RequestMapping(path = "/chat", method = RequestMethod.POST)
    public Message sendMessage(@RequestBody Message message) {
		
		System.out.println("/chat ---------------------");

        emitters.forEach((SseEmitter emitter) -> {
            try {
                emitter.send(message, MediaType.APPLICATION_JSON);
            } catch (IOException e) {
                emitter.complete();
                emitters.remove(emitter);
                e.printStackTrace();
            }
        });
        return message;
    }

}
