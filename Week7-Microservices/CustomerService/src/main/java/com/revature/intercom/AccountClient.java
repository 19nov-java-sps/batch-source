package com.revature.intercom;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.models.Account;

@FeignClient(name="account-service", fallback=AccountClientFallback.class)
public interface AccountClient {
	
	@GetMapping("accounts/customer/{customerId}")
	public List<Account> getAccountByCustomerId(@PathVariable("customerId")int customerId);

}
