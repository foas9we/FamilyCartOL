package com.briup.app.estore.bean;

public class Customer {
    private Integer id;

    private String name;

    private String password;

    private String zip;

    private String address;

    private String telephone;

    private String email;

    public Customer() {}
    
    
    public Customer(Integer id, String name, String password, String zip, String address, String telephone,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}


	public Customer(String name, String password, String zip, String address, String telephone,
			String email) {
		super();
		this.name = name;
		this.password = password;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}

	public Customer(String password, String zip, String address, String telephone,
			String email) {
		super();
		this.password = password;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}

	public Customer(String string) {
		
		if(string!=null) {
			String[] split = string.split("-");
			this.id = Integer.parseInt(split[0]);
			this.name = split[1];
			this.password = split[2];
			this.zip = split[3];
			this.address = split[4];
			this.telephone = split[5];
			this.email = split[6];
		}
	}


	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", zip=" + zip + ", address="
				+ address + ", telephone=" + telephone + ", email=" + email + "]";
	}


	public String getAsString() {
		return id+"-"
			  +name+"-"
			  +password+"-"
			  + zip+"-"
			  +address+"-"
			  +telephone+"-"
			  +email;
	}
    
    
}