package deneme1.deneme1.business.abstracts;

import java.util.List;

import deneme1.deneme1.business.requests.CreateBrandRequest;
import deneme1.deneme1.business.requests.UpdateBrandRequest;
import deneme1.deneme1.business.responses.GetAllBrandsResponse;
import deneme1.deneme1.business.responses.GetByIdBrandResponse;

public interface BrandService {

	List<GetAllBrandsResponse> getAll();

	 GetByIdBrandResponse getById(int id);
	
	
	
	void add(CreateBrandRequest createBrandRequest);
	

	void update(UpdateBrandRequest updateBrandRequest);
	
	
	void delete(int id);
	
	///burdan itibaren veri tabanı nesnesi kullanmak yasak çünkü her şeyi kullanıcıya vermek istemiyoruz //datadaki verileri
}
 