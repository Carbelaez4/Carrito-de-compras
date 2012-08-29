package co.edu.eafit.carritocompras.data;

import java.math.BigDecimal;

import co.edu.eafit.carritocompras.data.products.ElectronicProduct;
import co.edu.eafit.carritocompras.data.products.Furniture;

public abstract class Product {

	private String code;
	private String name;
	private BigDecimal price;
	
	public abstract BigDecimal calculateDiscount();
	
	public static Product buildProduct(String code) {
		if (code.startsWith("EL")) {
			return new ElectronicProduct(code, "Electronic_"+code, new BigDecimal(Math.random()*100000));
		} else if (code.startsWith("FU")) {
			return new Furniture(code, "Furniture_"+code, new BigDecimal(Math.random()*1000000));
		}
		
		throw new IllegalArgumentException("Code does not start with EL or FU");
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
