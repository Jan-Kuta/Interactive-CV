package com.cutesystems.CV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cutesystems.CV.model.Person;


@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class CvApplication {

	
	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {

		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);		
		return container;
	}
	
	@Bean
	RedisTemplate<String, Person> template(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Person> rt = new RedisTemplate<String, Person>();
		rt.setConnectionFactory(connectionFactory);
		
		return rt;
	}
	
	@RequestMapping("/")
	String home() {
		return "redirect:cv";
	}

	public static void main(String[] args) {
		SpringApplication.run(CvApplication.class, args);
	}
}
	