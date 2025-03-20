package com.proa.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proa.app.entities.Client;

@FeignClient(name="micro-client") //@FeignClient(name="micro-client", url="http://localhost:8081/client") //sin EUREKA
public interface IFeignClientM {
	
	@GetMapping("/client/id")     //@GetMapping("/id")//sin EUREKA
	Client selectById(@RequestParam long id);
}
