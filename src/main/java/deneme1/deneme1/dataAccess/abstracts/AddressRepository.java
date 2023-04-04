package deneme1.deneme1.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import deneme1.deneme1.entities.concretes.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

	
}
