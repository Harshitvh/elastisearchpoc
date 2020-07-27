package com.hthon.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@PostMapping("/send")
	public void post(@RequestBody List<CustomerValue> customerValues)
	{
		customerValues.forEach(x->{
			customerRepository.save(x);

		});
	}
	
	@GetMapping("/customers")
	public List<CustomerResponse> get()
	{
		List<CustomerResponse> customerValues = new ArrayList<>();
		customerRepository.findAll().forEach(x->{
			customerValues.add(mapResponse(x));
		});
		return customerValues;
		
	}
	
	private CustomerResponse mapResponse(CustomerValue x) {
		return CustomerResponse.builder().custId(x.getCustomerId()).daysOfWeek(setDays(x))
				.timeRange(setPrefferedTime(x)).build();
	}

	private String setPrefferedTime(CustomerValue x) {
		if(null==x.getPreferredTime())
		{
			String wt = x.getWorkTimings();
			String endTime = wt.substring(wt.indexOf("-")+1, wt.length());
			return endTime+"-22";
		}
		return x.getPreferredTime() ;
	}

	private String setDays(CustomerValue x) {
		if(null==x.getPreferredDay())
		{
			return "Saturday,Sunday";
		}
		return x.getPreferredDay();
	}

	@GetMapping("/customer")
	public CustomerResponse getCustomerById(@RequestParam String customerId)
	{
		return mapResponse(customerRepository.findById(customerId).get());
		
	}

}
