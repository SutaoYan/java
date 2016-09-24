package com.sutao.aop;

public class Logging {
	public void beforeAdvice(){
		System.out.println("Before Advice");
	}

	public void afterAdvice(){
		System.out.println("After Advice");
	}

	public void afterReturningAdvice(Object retVal){
		System.out.println("After Advice Executed Successfully ... Returning: " + retVal.toString() );
	}

	public void AfterThrowingAdvice(IllegalArgumentException ex){
		System.out.println("There has been an exception when executing the advice: " + ex.toString());
	}
}