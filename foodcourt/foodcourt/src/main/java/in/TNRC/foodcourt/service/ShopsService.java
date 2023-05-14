package in.TNRC.foodcourt.service;

import java.util.List;


import in.TNRC.foodcourt.model.Shop;


public interface ShopsService {
   
	List<Shop> getShops();
	
	Shop getSingleShop(Integer id);
	
	Shop saveShop (Shop shop);
	
	public String deleteShop(Integer id);
	
	Shop updateshop(Shop shop);
	
	
}
