package com.thbs.bt.integrationtestingcrud.translator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class BaseTranslator<S,D>{
    private ModelMapper mapper;

	public BaseTranslator(ModelMapper mapper) {
		super();
		this.mapper = mapper;
	}
	 public D translate(S source,Class<D> targetType){
	       return mapper.map(source,targetType);
	    }

	    public List<D> translate(List<S> source, Class<D> targetType){
	        if(Objects.nonNull(source)) {
	            return source.stream()
	                    .map(element -> translate(element, targetType))
	                    .collect(Collectors.toList());
	        }
	        return new ArrayList<>();
	    }

}
