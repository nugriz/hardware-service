package com.microservice.hardware.util;

import com.microservice.hardware.model.Hardware;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/*Generic Method*/
@Setter /*Setter*/
@Getter /*Getter*/
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Response<T> {
    public String service;
    public String message;
    public T data;
//	public void setService(String service) {
//		// TODO Auto-generated method stub
//		this.service = service;
//	}
//	public void setMessage(String message) {
//		// TODO Auto-generated method stub
//		this.message = message; 
//	}
//	public void setData(T data) {
//		// TODO Auto-generated method stub
//		this.data = data;
//	}
	
}