package com.cjzy.common.exception;

public class CustomerExistException extends Exception{

	CustomerExistException(){
		super("客户已存在！");
	}
	
}
