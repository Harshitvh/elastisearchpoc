package com.hthon.data;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CustomerRepository extends ElasticsearchRepository<CustomerValue, String> {
 
   
}