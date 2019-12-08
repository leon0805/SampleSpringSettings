package com.test.app.service;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
public class TestService {

	@Async
	public void say(SseEmitter emitter)
	{
		try {
			emitter.send(emitter.event()
					.id(UUID.randomUUID().toString()).data("hello ."));
			TimeUnit.SECONDS.sleep(2);
			
			
			emitter.send(emitter.event()
					.id(UUID.randomUUID().toString()).data("hello .."));
			TimeUnit.SECONDS.sleep(2);
			
			emitter.send(emitter.event()
					.id(UUID.randomUUID().toString()).data("hello ..."));
			TimeUnit.SECONDS.sleep(2);

			emitter.send(emitter.event()
					.id(UUID.randomUUID().toString()).data("hello ...."));
			TimeUnit.SECONDS.sleep(2);
			
			
			emitter.send(emitter.event()
					.id(UUID.randomUUID().toString()).data("hello ....."));
			TimeUnit.SECONDS.sleep(2);
			
			emitter.complete();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
