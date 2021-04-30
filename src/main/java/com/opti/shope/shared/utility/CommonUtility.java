package com.opti.shope.shared.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class CommonUtility <S,T>{
	private  ModelMapper mp = new ModelMapper();

	public  List<T> mapList(List<S> source, Class<T> targetClass) {
		return source.stream().map(element -> mp.map(element, targetClass)).collect(Collectors.toList());
	}
}
