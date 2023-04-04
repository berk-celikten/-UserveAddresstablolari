package deneme1.deneme1.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import deneme1.deneme1.business.abstracts.AddressService;
import deneme1.deneme1.business.requests.CreateAddressRequest;
import deneme1.deneme1.business.requests.UpdateAddressRequest;
import deneme1.deneme1.business.responses.GetAllAddressesResponse;
import deneme1.deneme1.business.responses.GetByIdAddressResponse;
import deneme1.deneme1.core.utilities.mappers.ModelMapperService;
import deneme1.deneme1.dataAccess.abstracts.AddressRepository;
import deneme1.deneme1.entities.concretes.Address;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {

	private AddressRepository addressRepository;

	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllAddressesResponse> getAll() {
		List<Address> addresses = addressRepository.findAll(); /// bunu get allbrandsresponsea çevirmem lazım// ondan yeni
		/// oluşturuyom

		List<GetAllAddressesResponse> addressesResponse = addresses.stream()
				.map(address -> this.modelMapperService.forResponse().map(address, GetAllAddressesResponse.class))
				.collect(Collectors.toList());
// TODO Auto-generated method stub
		return addressesResponse;
	}

	@Override
	public void add(CreateAddressRequest createAddressRequest) {
		// TODO Auto-generated method stub
		Address address = this.modelMapperService.forRequest().map(createAddressRequest, Address.class);

		this.addressRepository.save(address);

	}

	@Override
	public GetByIdAddressResponse getById(int id) {
		
		Address address = this.addressRepository.findById(id).orElseThrow();
		
		GetByIdAddressResponse response 
		= this.modelMapperService.forResponse().map(address, GetByIdAddressResponse.class);
		
		
		return response;
	}

	@Override
	public void update(UpdateAddressRequest updateAddressRequest) {
		Address address = this.modelMapperService.forRequest().map(updateAddressRequest, Address.class);

		this.addressRepository.save(address);

	}

	@Override
	public void delete(int id) {
		this.addressRepository.deleteById(id);
	}

}
