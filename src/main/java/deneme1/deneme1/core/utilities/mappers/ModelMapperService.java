package deneme1.deneme1.core.utilities.mappers;

import org.modelmapper.ModelMapper;




public interface ModelMapperService {

	
	ModelMapper forResponse();
	ModelMapper forRequest();
	
}
