package co.edu.eafit.carritocompras.service;

import java.math.BigDecimal;

import co.edu.eafit.carritocompras.data.Purchase;

public class taxCalculator {

	
	public void calculateIva (Purchase purchase) {
		
		BigDecimal totalPrice;
		float iva;
		totalPrice = purchase.getTotalPrice();
		iva = (float) (totalPrice.floatValue() * 0.16);
		purchase.setIva(iva);
	
		
		
	}
}
