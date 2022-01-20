package com.thbs.bt.integrationtestingcrud.dao.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private Long id;
	    private String name;
	    private String email;
	    
	    
	    public UserEntity() {
		}


		public UserEntity(Long id, String name, String email, List<AddressEntity> addresses) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.addresses = addresses;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public List<AddressEntity> getAddresses() {
			return addresses;
		}


		public void setAddresses(List<AddressEntity> addresses) {
			this.addresses = addresses;
		}


		@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	    List<AddressEntity> addresses;


		

}
