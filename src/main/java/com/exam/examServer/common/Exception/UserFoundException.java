package com.exam.examServer.common.Exception;


@SuppressWarnings("serial")
public class UserFoundException extends Exception {
	
	public UserFoundException()
	{
	super("user with this username is already exist,try with different username");
	}
	public UserFoundException(String msg) 
	{
	super(msg);
	}

}
