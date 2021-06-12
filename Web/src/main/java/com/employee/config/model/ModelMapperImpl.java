package com.employee.config.model;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component("restModelMapperImp")
public class ModelMapperImpl {

	ModelMapper modelMapper;

	public ModelMapperImpl(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public <T> Object convert(Object source, Class<T> clazz) {
		Configuration configuration = this.modelMapper.getConfiguration();
		configuration.setAmbiguityIgnored(true);
		return modelMapper.map(source, clazz);
	}
	
	
}
