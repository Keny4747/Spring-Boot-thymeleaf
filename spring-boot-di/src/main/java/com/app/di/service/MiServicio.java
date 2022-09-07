package com.app.di.service;

//@Component
//@Primary
//@Qualifier
public class MiServicio implements IServicio{

	@Override
	public String operacion() {
		return "ejecutando algún proceso importante simple...";
	}
		

}
