package com.hthon.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {
	@JsonProperty("Cust_ID")
	private String custId;
	@JsonProperty("DaysOfWeek")
	private String daysOfWeek;
	@JsonProperty("TimeRange")
	private String timeRange;

}
