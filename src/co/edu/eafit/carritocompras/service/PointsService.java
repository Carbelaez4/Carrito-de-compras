package co.edu.eafit.carritocompras.service;



import java.math.BigDecimal;

import co.edu.eafit.carritocompras.data.Customer;
import co.edu.eafit.carritocompras.data.Purchase;

public class PointsService {
	
		 public int calculatePoints (Purchase purchase, Customer customer) {
	  //calcular
		 int pPurch = 0;
	
		 BigDecimal totalPrice;
	  
                       
	 totalPrice = purchase.getTotalPrice();
			 	  	
	  pPurch = (totalPrice.intValue() / 1000);
	  
	 
	  //asignar
	  int pCust = customer.getpoints();
			 
			    customer.setpoints(pPurch + pCust);
		
			    
			    return pPurch + pCust;
		}
		 
		 
		 public float calculateDiscountPunto (Purchase purchase, Customer customer) {
			 
			int pCust = customer.getpoints();
			 float DiscountPunt = 0;
			 
			 if (pCust >= 1000) {
				 
				 BigDecimal totalPrice;
				  
                 
				 totalPrice = purchase.getTotalPrice();
						 	  	
				  DiscountPunt = (totalPrice.intValue() *0.20f);
			
			 
			        }
			 
			 return  DiscountPunt;
			 
		 }
}
