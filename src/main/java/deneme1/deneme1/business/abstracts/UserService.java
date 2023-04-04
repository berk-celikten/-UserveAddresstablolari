package deneme1.deneme1.business.abstracts;

import java.util.List;

import deneme1.deneme1.business.requests.CreateUserRequest;
import deneme1.deneme1.business.requests.UpdateUserRequest;
import deneme1.deneme1.business.responses.GetAllUsersResponse;
import deneme1.deneme1.business.responses.GetByIdUserResponse;

public interface UserService {

	List<GetAllUsersResponse> getAll();

	 GetByIdUserResponse getById(int id);
	
	
	
	void add(CreateUserRequest createUserRequest);
	

	void update(UpdateUserRequest updateUserRequest);
	
	
	void delete(int id);
	
	///burdan itibaren veri tabanı nesnesi kullanmak yasak çünkü her şeyi kullanıcıya vermek istemiyoruz //datadaki verileri
}
 