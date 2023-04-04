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

import deneme1.deneme1.business.abstracts.BrandService;
import deneme1.deneme1.business.requests.CreateBrandRequest;
import deneme1.deneme1.business.requests.UpdateBrandRequest;
import deneme1.deneme1.business.responses.GetAllBrandsResponse;
import deneme1.deneme1.business.responses.GetByIdBrandResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {

	private BrandService brandService;
	
	
	
	
	@GetMapping()
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();}
	
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(CreateBrandRequest createBrandRequest) {       ///(@RequestBody CreateBrandRequest createBrandRequest) eski kullanım hali
		
		this.brandService.add(createBrandRequest);
	}

	
	//////////////
	//////
	///
	
	
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id) {
		return brandService.getById(id);
	}
	
	@PutMapping
	public void update(@RequestBody() UpdateBrandRequest updateBrandRequest) {
		
		this.brandService.update(updateBrandRequest);
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		
		this.brandService.delete(id);
		
	}


	



}
