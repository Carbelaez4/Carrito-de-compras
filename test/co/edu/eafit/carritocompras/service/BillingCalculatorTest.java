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
import co.edu.eafit.carritocompras.service.TaxCalculatorService;

public class BillingCalculatorTest {
	
	//private Customer customer;
	private Purchase p;
	private Customer c;
	
	@Before
	public void setUp() {
		c =  new Customer("001", "camilo", 2);
		p = BillingCalculator.calculateTotalPurchase(c, "EL01,FU01");
		
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
		TaxCalculatorService taxCalculator = Mockito.mock(TaxCalculatorService.class);
		BigDecimal iva = new BigDecimal(1.15);
		
		Mockito.when(taxCalculator.calculateIva(p)).thenReturn(iva.multiply(p.getTotalPrice()));
		
		Assert.assertEquals(iva.multiply(p.getTotalPrice()), taxCalculator.calculateIva(p));
	}
	
	@Test
	public void testcalculatePoints() {
		
		PointsService pointsSer = Mockito.mock(PointsService.class);
 		int points = 0;
		
	Mockito.when(pointsSer.calculatePoints(p, c)).thenReturn(p.getTotalPrice().intValue()/(1000));
	Assert.assertEquals(p.getTotalPrice().intValue()/(1000), pointsSer.calculatePoints(p, c));
	} 
	
	}
	

