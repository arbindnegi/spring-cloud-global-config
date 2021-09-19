package com.demo.springconfigclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigClientApplication.class, args);
	}
	
	@Autowired
	public void setEnv(Environment e)
	{
		System.out.println("-------------------->"+e.getProperty("msg"));
		//System.out.println("-------------------->"+e.getProperty("default-message"));
	}
}

@RefreshScope
@RestController
class MessageRestController {

	@Value("${msg:Config Server is not started or have some error. Please check...}")
	private String msg;
	
	@Value("${welcome.message:}")
	private String greeting;
	
	

	@GetMapping("/msg")
	public String getMsg() {
		return this.msg;
	}
	
	@GetMapping("/greeting")
	public String getGreeting() {
		return this.greeting;
	}
}
