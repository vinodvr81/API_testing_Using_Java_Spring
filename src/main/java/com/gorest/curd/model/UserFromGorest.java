package com.gorest.curd.model;

import lombok.Data;
import reactor.core.publisher.Mono;

@Data
public class UserFromGorest {

	private Integer id;
	private String name;
	private String email;
	private String gender;
	private String status;
	
}
