package com.thbs.bt.integrationtestingcrud.dao.entity;
import javax.persistence.*;
@Entity
@Table(name = "address")
public class AddressEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private long id;
	    private String city;
	    private String addressLine1;
	    private String addressLine2;
		public AddressEntity() {
		
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getAddressLine1() {
			return addressLine1;
		}
		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}
		public String getAddressLine2() {
			return addressLine2;
		}
		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}
	    
		 @ManyToOne
		    @JoinColumn(name = "userId")
		    private UserEntity user;
	    

}
