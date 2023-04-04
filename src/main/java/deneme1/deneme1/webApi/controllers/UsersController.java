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

import deneme1.deneme1.business.abstracts.UserService;
import deneme1.deneme1.business.requests.CreateUserRequest;
import deneme1.deneme1.business.requests.UpdateUserRequest;
import deneme1.deneme1.business.responses.GetAllUsersResponse;
import deneme1.deneme1.business.responses.GetByIdUserResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

	private UserService userService;
	
	
	
	
	@GetMapping()
	public List<GetAllUsersResponse> getAll(){
		return userService.getAll();}
	
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(CreateUserRequest createUserRequest) {       ///(@RequestBody CreateBrandRequest createBrandRequest) eski kullanım hali
		
		this.userService.add(createUserRequest);
	}



	
	////////////
	//////
	///
	
	
	
	@GetMapping("/{id}")
	public GetByIdUserResponse getById(@PathVariable int id) {
		return userService.getById(id);
	}
	
	@PutMapping
	public void update(@RequestBody() UpdateUserRequest updateUserRequest) {
		
		this.userService.update(updateUserRequest);
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		
		this.userService.delete(id);
		
	}
	
	
	



}
