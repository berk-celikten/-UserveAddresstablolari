package deneme1.deneme1.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import deneme1.deneme1.business.abstracts.UserService;
import deneme1.deneme1.business.requests.CreateUserRequest;
import deneme1.deneme1.business.requests.UpdateUserRequest;
import deneme1.deneme1.business.responses.GetAllUsersResponse;
import deneme1.deneme1.business.responses.GetByIdUserResponse;
import deneme1.deneme1.core.utilities.mappers.ModelMapperService;
import deneme1.deneme1.dataAccess.abstracts.UserRepository;
import deneme1.deneme1.entities.concretes.User;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

	private UserRepository userRepository;

	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllUsersResponse> getAll() {
		List<User> users = userRepository.findAll(); /// bunu get allbrandsresponsea çevirmem lazım// ondan yeni
		/// oluşturuyom

		List<GetAllUsersResponse> usersResponse = users.stream()
				.map(user -> this.modelMapperService.forResponse().map(user, GetAllUsersResponse.class))
				.collect(Collectors.toList());
// TODO Auto-generated method stub
		return usersResponse;
	}

	@Override
	public void add(CreateUserRequest createUserRequest) {
		// TODO Auto-generated method stub
		User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);

		this.userRepository.save(user);

	}

	@Override
	public GetByIdUserResponse getById(int id) {
		
		User user = this.userRepository.findById(id).orElseThrow();
		
		GetByIdUserResponse response 
		= this.modelMapperService.forResponse().map(user, GetByIdUserResponse.class);
		
		
		return response;
	}

	@Override
	public void update(UpdateUserRequest updateUserRequest) {
		User user = this.modelMapperService.forRequest().map(updateUserRequest, User.class);

		this.userRepository.save(user);

	}

	@Override
	public void delete(int id) {
		this.userRepository.deleteById(id);
	}

}
