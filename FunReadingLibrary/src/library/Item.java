package library;

import client.Client;

public class Item {
	
	private String id;
	private String name;
	private String author;
	private int yearOfPublication;
	
	// declaring a private instance variable named leasedTo of type Client in the Item class. This variable is used to track the client who has leased the item.
	private Client leasedTo;
	
	// Add a field to track leased items by this client
    private Item[] leasedItems;
    private int leasedItemCount;
	
	
	
	public Item() {
	}
	
	public Item(String id, String name, String author, int yearOfPublication) {
		this.id = id; //fix
		this.name = name;
		this.author = author;
		this.yearOfPublication = yearOfPublication;
	}
	
	public Item(Item other) {
		this.id = other.id; //fix
		this.name = other.name;
		this.author = other.author;
		this.yearOfPublication = other.yearOfPublication;
	}
	 
	public String getId() {
	    return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	
	public String getAuthor() {
	    return author;
	}
	
	public void setAuthor(String author) {
	    this.author = author;
	}
	
	public int getYearOfPublication() {
	    return yearOfPublication;
	}
	
	public void setYearOfPublication(int yearOfPublication) {
	    this.yearOfPublication = yearOfPublication;
	}
	
	public String toString() {
		return "ID: " + getId() + ". Name: " + getName() + " Author: " + getAuthor() + " Year of publication: " +getYearOfPublication();
	}
	
	public boolean equals(Item other) {
		return (this.id == other.id && this.name == other.name && this.author == other.author && this.yearOfPublication == other.yearOfPublication); 
	}
	
	// Add methods to handle leasing and returning the item
    public void leaseItemTo(Client client) {
        this.leasedTo = client;
    }
    
    public void leasedItemsArray(Item item) {
    	if (leasedItems == null) {
            leasedItems = new Item[100]; // Initial capacity, adjust as needed
        }
        if (leasedItemCount < leasedItems.length) {
            leasedItems[leasedItemCount++] = item;
        } else {
            System.out.println("Maximum leased items reached.");
        }
    }

    public void returnItemClient() {
        this.leasedTo = null;
    }

    public Client getLeasedTo() {
        return leasedTo;
    }
    

    public void returnItem(Item item) {
    	 if (leasedItemCount > 0) {
             for (int i = 0; i < leasedItemCount; i++) {
                 if (leasedItems[i] == item) {
                     // Remove the item by shifting remaining items
                     for (int j = i; j < leasedItemCount - 1; j++) {
                         leasedItems[j] = leasedItems[j + 1];
                     }
                     leasedItems[leasedItemCount - 1] = null; // Clear the last reference
                     leasedItemCount--;
                     return;
                 }
             }
             System.out.println("Item not found in leased items.");
         } else {
             System.out.println("No items leased by this client.");
         }
    }

    public Item[] getLeasedItems() {
        return leasedItems;
    }


	

}
