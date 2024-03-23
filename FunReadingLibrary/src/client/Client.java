package client;

import library.Item;

public class Client {
	
	private String id;
	private String name;
	private long phoneNumber;
	private String email;
	private static int idNumberC = 1;
	
	private Item[] leasedItems;
	
	
	public Client() {}
	
	public Client(String name, long phoneNumber, String email) {
		this.id = "C" + idNumberC;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		idNumberC++;
	}
	
	public Client(Client other) {
		this.id = "C" + idNumberC;
		this.name = other.name;
		this.phoneNumber = other.phoneNumber;
		this.email = other.email;
		idNumberC++;
	}
	
	 public String getId() {
		 return id;
	 }

	 public String getName() {
	     return name;
	 }

	 public void setName(String name) {
	     this.name = name;
	 }

	 public long getPhoneNumber() {
	     return phoneNumber;
	 }

	 public void setPhoneNumber(long phoneNumber) {
	     this.phoneNumber = phoneNumber;
	 }

	 public String getEmail() {
	     return email;
	 }

	 public void setEmail(String email) {
	     this.email = email;
	 }
	 
	 public boolean equals(Object obj) {
		 if (this == obj) {
		        return true;
		    }
		    if (obj == null) {
		        return false;
		    }
		    if (getClass() != obj.getClass()) {
		        return false;
		    }
		    
		    Client other = (Client) obj;
		    return phoneNumber == other.phoneNumber &&
		            id.equals(other.id) &&
		            name.equals(other.name) &&
		            email.equals(other.email);
		}

	    
	   
	    public String toString() {
	        return "Client{" +
	                "ID= '" + id + '\'' +
	                ", name= '" + name + '\'' +
	                ", phone number= " + phoneNumber +
	                ", email= '" + email + '\'' +
	                '}';
	    }

		
	    public Item[] getLeasedItems() {
	        return leasedItems;
	    }
	 
}
