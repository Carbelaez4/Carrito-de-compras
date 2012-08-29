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
import co.edu.eafit.carritocompras.data.products.ElectronicProduct;
import co.edu.eafit.carritocompras.data.products.Furniture;

public class BillingCalculatorTest {
	
	private Customer customer;
	
	@Before
	public void setUp() {
		Customer customer = new Customer("001", "camilo");
	}
	
	@Test
	public void testCalculateTotalPurchase() {
		Purchase p = BillingCalculator.calculateTotalPurchase(customer, "EL01,FU01");
		List<Product> products = p.getProducts();
		BigDecimal aPrice = products.get(0).getPrice().subtract(products.get(0).calculateDiscount());
		BigDecimal bPrice = products.get(1).getPrice().subtract(products.get(1).calculateDiscount());
		
		Assert.assertEquals(aPrice.add(bPrice), p.getTotalPrice());
	}
	
}
