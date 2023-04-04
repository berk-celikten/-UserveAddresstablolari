package deneme1.deneme1.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import deneme1.deneme1.business.abstracts.BrandService;
import deneme1.deneme1.business.requests.CreateBrandRequest;
import deneme1.deneme1.business.requests.UpdateBrandRequest;
import deneme1.deneme1.business.responses.GetAllBrandsResponse;
import deneme1.deneme1.business.responses.GetByIdBrandResponse;
import deneme1.deneme1.core.utilities.mappers.ModelMapperService;
import deneme1.deneme1.dataAccess.abstracts.BrandRepository;
import deneme1.deneme1.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

	private BrandRepository brandRepository;

	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllBrandsResponse> getAll() {

		List<Brand> brands = brandRepository.findAll(); /// bunu get allbrandsresponsea çevirmem lazım// ondan yeni
														/// oluşturuyom

		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());
		// TODO Auto-generated method stub
		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		// TODO Auto-generated method stub
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);

		this.brandRepository.save(brand);

	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		
		GetByIdBrandResponse response 
		= this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		
		
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);

		this.brandRepository.save(brand);

	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
	}


	

	

	

}
