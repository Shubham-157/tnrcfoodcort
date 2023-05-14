package in.TNRC.foodcourt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.TNRC.foodcourt.model.Shop;
import in.TNRC.foodcourt.service.ShopsService;

import jakarta.validation.Valid;


@RestController //@Controller + @ResponseBody
@CrossOrigin("http://localhost:3000")
@RequestMapping

public class ShopsController {

	@Autowired
	private ShopsService sService;
	
	@GetMapping("/shops")
	public ResponseEntity <List<Shop>> getShops () {
		return new ResponseEntity<List<Shop>>(sService.getShops(),HttpStatus.OK) ;
	
	}
	
	@GetMapping("/shops/{id}")
	public ResponseEntity <Shop> getShops (@PathVariable("id") Integer id) {
		return new ResponseEntity<Shop>(sService.getSingleShop(id),HttpStatus.OK) ;
	}
	
	@PostMapping("/shops")
	public ResponseEntity<Shop> saveEmployee (@Valid @RequestBody Shop shop) {
		return new ResponseEntity<>( sService.saveShop(shop),HttpStatus.CREATED);
	}
	
	@PutMapping("/shops/{id}")
	public ResponseEntity<Shop> updateEmployee(@RequestBody Shop shop,@PathVariable Integer id) {
		shop.setId(id);
		return new ResponseEntity<Shop>(sService.updateshop(shop),HttpStatus.OK);
}
	
	@DeleteMapping("/shops/{id}")
	public ResponseEntity<?> deleteShops (@PathVariable ("id")Integer id) {
		  return new ResponseEntity<>(sService.deleteShop(id),HttpStatus.NO_CONTENT);
	
	}
}
