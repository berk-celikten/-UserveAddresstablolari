package deneme1.deneme1.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAddressesResponse {
	
	private int id;
	private String name;
	private String address;

}
