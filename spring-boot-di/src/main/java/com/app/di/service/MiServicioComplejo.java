package com.app.di.service;

//@Component
//@Primary
//@Qualifier
public class MiServicioComplejo implements IServicio{

	@Override
	public String operacion() {
		return "ejecutando algún proceso importante complicado...";
	}
		

}
