package com.hthon.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "customer_value")
public class CustomerValue {
	@Id
	@JsonProperty("Cust_ID")
	private String customerId;
	@JsonProperty("Customer Value")
	private String customerValue;
	@JsonProperty("Income level")
	private String incomeLevel;
	@JsonProperty("Marital Status")
	private String martialStatus;
	@JsonProperty("Receptive")
	private String receptive;
	@JsonProperty("Number of Contacts")
	private String numberOfContacts;
	@JsonProperty("Preferred_Contact")
	private String preferredTime;
	@JsonProperty("Preferred_Contact_Day")
	private String preferredDay;
	@JsonProperty("Work_Timings")
	private String workTimings;
}
