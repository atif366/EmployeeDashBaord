package com.employee.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
@Scope(value="prototype")
public class ResponseDTO {

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String responseStatus;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private int responseCode;
	
	private Object object;
	
}