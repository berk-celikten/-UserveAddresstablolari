package deneme1.deneme1.business.abstracts;

import java.util.List;

import deneme1.deneme1.business.requests.CreateAddressRequest;
import deneme1.deneme1.business.requests.UpdateAddressRequest;
import deneme1.deneme1.business.responses.GetAllAddressesResponse;
import deneme1.deneme1.business.responses.GetByIdAddressResponse;

public interface AddressService {

	List<GetAllAddressesResponse> getAll();

	 GetByIdAddressResponse getById(int id);
	
	
	
	void add(CreateAddressRequest createAddressRequest);
	

	void update(UpdateAddressRequest updateAddressRequest);
	
	
	void delete(int id);
	
	///burdan itibaren veri tabanı nesnesi kullanmak yasak çünkü her şeyi kullanıcıya vermek istemiyoruz //datadaki verileri
}
 