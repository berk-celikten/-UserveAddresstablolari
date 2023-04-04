package deneme1.deneme1.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 
@Entity  ///sen bir veri tabanı var ////veri tabanı nesnelerimiz
public class Address {
	////veri tabanı nesnesi son kullanıcıya açmamalıyız
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	private User user;
	
	
//	public Brand() {
//		
//	}
//	public Brand(int id, String name) {
//		
//		this.id = id;
//		this.name = name;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
	
	
	
	/// brand-->>id,name,quantity
	//GetAllBrandsResponse-->>id,name
	//mapping deniyo bu işleme  // brandte id name quantity diye 3 bilgi var ancak sen hepsini döndürmek istemediğin için getallresponseun içine id ve name koyarım
	
	
	
	
	
}
