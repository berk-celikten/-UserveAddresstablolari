package deneme1.deneme1.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import deneme1.deneme1.business.abstracts.AddressService;
import deneme1.deneme1.business.requests.CreateAddressRequest;
import deneme1.deneme1.business.requests.UpdateAddressRequest;
import deneme1.deneme1.business.responses.GetAllAddressesResponse;
import deneme1.deneme1.business.responses.GetByIdAddressResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressController {

	private AddressService addressService;
	
	
	
	
	@GetMapping()
	public List<GetAllAddressesResponse> getAll(){
		return addressService.getAll();}
	
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(CreateAddressRequest createAddressRequest) {       ///(@RequestBody CreateBrandRequest createBrandRequest) eski kullanım hali
		
		this.addressService.add(createAddressRequest);
	}


	
	////////////////
	////////
	/////
	
	
	
	
	@GetMapping("/{id}")
	public GetByIdAddressResponse getById(@PathVariable int id) {
		return addressService.getById(id);
	}
	
	@PutMapping
	public void update(@RequestBody() UpdateAddressRequest updateAddressRequest) {
		
		this.addressService.update(updateAddressRequest);
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		
		this.addressService.delete(id);
		
	}

	



}
