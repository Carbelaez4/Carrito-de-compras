package co.edu.eafit.carritocompras.service;

import java.math.BigDecimal;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.edu.eafit.carritocompras.data.Customer;
import co.edu.eafit.carritocompras.data.Purchase;
import co.edu.eafit.carritocompras.data.Product;
import co.edu.eafit.carritocompras.service.TaxCalculator;

public class BillingCalculatorTest {
	
	private Customer customer;
	private Purchase p;
	
	@Before
	public void setUp() {
		Customer customer = new Customer("001", "camilo");
		p = BillingCalculator.calculateTotalPurchase(customer, "EL01,FU01");
	}
	
	@Test
	public void testCalculateTotalPurchase() {
		List<Product> products = p.getProducts();
		BigDecimal aPrice = products.get(0).getPrice().subtract(products.get(0).calculateDiscount());
		BigDecimal bPrice = products.get(1).getPrice().subtract(products.get(1).calculateDiscount());
		
		Assert.assertEquals(aPrice.add(bPrice), p.getTotalPrice());
	}
	
	@Test
	public void testCalculateIva() {
		TaxCalculator taxCalculator = Mockito.mock(TaxCalculator.class);
		BigDecimal iva = new BigDecimal(1.15);
		
		Mockito.when(taxCalculator.calculateIva(p)).thenReturn(iva.multiply(p.getTotalPrice()));
		
		Assert.assertEquals(iva.multiply(p.getTotalPrice()), taxCalculator.calculateIva(p));
	}
	
}
