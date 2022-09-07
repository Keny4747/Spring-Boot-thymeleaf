package com.app.di.domain;

public class ItemFactura {
	
	private Producto producto;
	
	private Integer cantidad;
	
	
	public ItemFactura() {
		
	}
	
	public ItemFactura(Producto producto, Integer cantidad) {
		
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public double calcularTotal() {
		double resultado =producto.getPrecio()*cantidad;
		
		return Math.round(resultado*100)/100; 
	}
	
}
