package in.TNRC.foodcourt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.TNRC.foodcourt.Repository.ShopsRepository;

import in.TNRC.foodcourt.model.Shop;


@Service

@Transactional


public class ShopsServiceimpl implements ShopsService {
	
	@Autowired
	private ShopsRepository sRepository;

	@Override
	public List<Shop> getShops() {
		return sRepository.findAll();
	}

	@Override
	public Shop getSingleShop(Integer id) {
		Optional<Shop>shop = sRepository.findById(id);
		if(shop.isPresent()) {
			return shop.get();
		}
		throw new RuntimeException("Shop not found for the id"+id);
	}

	@Override
	public Shop saveShop(Shop shop) {
		return sRepository.save(shop);
	}

	@Override
	public String deleteShop(Integer id) {
		Shop shop = sRepository.findById(id).get();
		if(id != null) {
			sRepository.delete(shop);
			return "Shop Deleted Sucessfully ShopNo is" +id;
		}
		return "Something wrong on server";
	}

	@Override
	public Shop updateshop(Shop shop) {
		return sRepository.save(shop);
	}
	
	
	

}
