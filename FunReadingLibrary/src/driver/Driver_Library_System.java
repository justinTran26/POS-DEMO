
package driver;

import client.Client;
import library.Item;
import library.Book;
import library.Media;
import library.Journal;
import java.util.Scanner;

public class Driver_Library_System {
	
	static Scanner scan = new Scanner(System.in);
	final private static int MAX_ITEMS = 100;
	private static Item[] items = new Item[MAX_ITEMS];
	
	// Define an instance variable to hold the clients array
	private static final int MAX_CLIENTS = 100;
	private static Client[] clients = new Client[MAX_CLIENTS];
	private static int clientCount = 0;
			
	
	public static void main(String[] args) {
		
	System.out.println("Welcome to the Fun Readings Library Manager!");
	System.out.println("Pick 1 for main menu.");
	System.out.println("Pick 2 for predefined scenario.");
	int pick = scan.nextInt();
	switch(pick) {
	case 1: mainMenu(); break;
	case 2: predefinedScenario(); break;
	default: System.out.println("Invalid pick. System closing"); System.exit(0);
	}
	
	
	}
	
	//Main menu option
	public static void mainMenu() {
		boolean more = true;
		while (more) {
			System.out.println("\nPlease select one of the following options");
			System.out.println("1. Add an item.");
			System.out.println("2. Delete an item.");
			System.out.println("3. Change information of an item.");
			System.out.println("4. List all items in a specific category (book, journal, or media).");
			System.out.println("5. Print all items (from all categories).");
			System.out.println("6. Add an client.");
			System.out.println("7. Edit a client");
			System.out.println("8. Delete a client");
			System.out.println("9. Lease an item to a client.");
			System.out.println("10. Return an item from a client.");
			System.out.println("11. Show all items leased by a client.");
			System.out.println("12. Show all leased items (by all clients).");
			System.out.println("13. Display the biggest book (see below).");
			System.out.println("14. Make a copy of the books array (see below).");

			System.out.println("Pick an option from 1-14");
			int choice = scan.nextInt();
			scan.nextLine();
			
				switch(choice) {
				
				case 1: addItem(); break;
				case 2: removeItem(); break;
				case 3: changeInfoOfItem(); break;
				case 4: listItemsFromCategory(); break;
				case 5: System.out.println(displayAllItems()); break;
				case 6: addClient(); break;
				case 7: editClient(); break;
				case 8: deleteClient(); break;
				case 9: leaseItemToClient(); break;
				case 10: returnItemFromClient(); break;
				case 11: showLeasedItemsByClient(); break;
				case 12: showAllLeasedItems(); break;
				case 13: System.out.println(getBiggestBook(items)); break;
				// figure out what we will put in it
				case 14: copyBooks(null); break;
					
				default:
					System.out.println("Invalid choice. Please select a valid option.");
				}
		}
	}

			
		
	
	//Predefined scenario option
	public static void predefinedScenario() {
		
		// Create 3 objects from each type of items
	    Book book1 = new Book("Book1", "Author1", 2000, 300);
	    Book book2 = new Book("Book2", "Author2", 2000, 400);
	    Book book3 = new Book("Book3", "Author3", 2010, 500);

	    Journal journal1 = new Journal("Journal1", "JournalAuthor1", 2008, 10);
	    Journal journal2 = new Journal("Journal2", "JournalAuthor2", 2012, 15);
	    Journal journal3 = new Journal("Journal3", "JournalAuthor3", 2016, 20);

	    Media media1 = new Media("Media1", "MediaAuthor1", 2015, "Type1");
	    Media media2 = new Media("Media2", "MediaAuthor2", 2017, "Type2");
	    Media media3 = new Media("Media3", "MediaAuthor3", 2019, "Type3");
	    
	    // Create 3 users
	    // By appending L to the numbers, you're explicitly indicating that they are of type long, which can hold larger values than int.
	    Client user1 = new Client("User1", 1234567890L, "user1@example.com");
	    Client user2 = new Client("User2", 9876543210L, "user2@example.com");
	    Client user3 = new Client("User3", 5555555555L, "user3@example.com");

	    // Display information of the created items
	    System.out.println("\nInformation of the created items:");
	    System.out.println(book1.toString());
	    System.out.println(book2.toString());
	    System.out.println(book3.toString());
	    System.out.println(journal1.toString());
	    System.out.println(journal2.toString());
	    System.out.println(journal3.toString());
	    System.out.println(media1.toString());
	    System.out.println(media2.toString());
	    System.out.println(media3.toString());
	    
	    // Display information of the created users
	    System.out.println("\nInformation of the created users:");
	    System.out.println(user1.toString());
	    System.out.println(user2.toString());
	    System.out.println(user3.toString());
	    

	    // Test equality of some objects
	    System.out.println("\nTesting equality of objects:");
	    System.out.println("Equality of two objects from different classes: " + book1.equals(media1));
	    System.out.println("Equality of two objects from the same class with different values: " + book1.equals(book3));
	    System.out.println("Equality of two objects of the same class with similar values: " + book1.equals(book2)); // same year of publication
	    
	    // Create arrays for each type of items
	    Book[] booksArray = {book1, book2, book3};
	    Journal[] journalsArray = {journal1, journal2, journal3};
	    Media[] mediaArray = {media1, media2, media3};

	    // Create another array for all items
	    Item[] items = {book1, book2, book3, journal1, journal2, journal3, media1, media2, media3};
	    		
	    // Display the biggest book
	    System.out.println("\nThe biggest book:");
	    Book biggestBook = getBiggestBook(booksArray);
	    System.out.println(biggestBook.toString());

	    // Call the method copyBooks() on the array of Media
	    Book[] copiedBooks = copyBooks(booksArray);
	    System.out.println("Copied books:");
	    for (int i = 0; i< copiedBooks.length; i++) {
	        System.out.println(copiedBooks[i].toString());
	    }
		
	}
	
	//Finds the lowest empty array index
	private static int findEmptyIndex() {
	    for(int i = 0; i < items.length; i++) {
	        if(items[i] == null) {
	            return i;
	        }
	    }
	    return -1;
	}
	
	//Adds the item to the array
	private static void addItemToArray(Item item) {
	    int index = findEmptyIndex();
	 
	    if(index == -1) {
	        System.out.println("The library is full. Cannot add more items.");
	        return;
	    }

	    items[index] = item;
	}
	
	//Case 1: add an item
	public static void addItem() {
	    System.out.println("Which type of item would you like to add? (Book, Journal, Media)");
	    String choice = scan.nextLine();
	    System.out.println(" ");

	    

	    if(choice.equalsIgnoreCase("book")) {
	    	System.out.println("Insert name: ");
		    String name = scan.nextLine();
		    System.out.println("Insert author: ");
		    String author = scan.nextLine();
		    System.out.println("Insert year of publication: ");
		    int yearOfPublication = scan.nextInt();
		    scan.nextLine();
	        System.out.println("Insert the number of pages: ");
	        int numberOfPages = scan.nextInt();
	        scan.nextLine();
	        Book newBook = new Book(name, author, yearOfPublication, numberOfPages);
	        addItemToArray(newBook);
	    }
	    else if(choice.equalsIgnoreCase("journal")) {
	    	System.out.println("Insert name: ");
		    String name = scan.nextLine();
		    System.out.println("Insert author: ");
		    String author = scan.nextLine();
		    System.out.println("Insert year of publication: ");
		    int yearOfPublication = scan.nextInt();
		    scan.nextLine();
	        System.out.println("Insert volume number: ");
	        int volumeNumber = scan.nextInt();
	        scan.nextLine();
	        Journal newJournal = new Journal(name, author, yearOfPublication, volumeNumber);
	        addItemToArray(newJournal);
	    }
	    else if(choice.equalsIgnoreCase("media")) {
	    	System.out.println("Insert name: ");
		    String name = scan.nextLine();
		    System.out.println("Insert author: ");
		    String author = scan.nextLine();
		    System.out.println("Insert year of publication: ");
		    int yearOfPublication = scan.nextInt();
		    scan.nextLine();
	        System.out.println("Insert type: ");
	        String type = scan.nextLine();
	        Media newMedia = new Media(name, author, yearOfPublication, type);
	        addItemToArray(newMedia);
	    }
	}
	
	//counts items
	public static int countItems(Object[] items) {
	    int count = 0;
	    for (Object item : items) {
	        if (item != null) {
	            count++;
	        }
	    }
	    return count;
	}
	//case 2 remove Item
	public static void removeItem() {
	    System.out.println("Give me the id of the item you would like to remove: ");
	    String removeID = scan.nextLine();

	    boolean itemFound = false; 

	    for(int i = 0; i < items.length; i++) {
	        if(removeID.equals(items[i].getId())) {
	            System.out.println("Item removed successfully");
	            itemFound = true;
	            for(int j = i; j < countItems(items) - 1; j++) {
	                items[j] = items[j+1];
	            }
	            items[countItems(items) - 1] = null;
	            break;
	        }
	    }

	
	    if (!itemFound) {
	        System.out.println("Invalid id number.");
	    }
	}


	
		  
	
	 
    // case 3 change info of an item
    public static void changeInfoOfItem() {
    // Display all items to the user
    	System.out.println("Current Items:");
        for (int i = 0; i < findEmptyIndex(); i++) {
            System.out.println((i) + ". " + items[i].toString());
        }
        
    System.out.println("Which item would you like to modify?");   
    int itemChoice = scan.nextInt();
    
    Item selectedItem = items[itemChoice];
    
    
    System.out.println("What would you like to change? \n1. Name \n2. Author \n3. year of publication \n4. Book number of pages \n5. Journal volume number \n6. Media type ");
    int changeItemChoice = scan.nextInt();
    
    switch (changeItemChoice) {
    case 1:
        System.out.println("Enter the new name:");
        String newName = scan.next();
        selectedItem.setName(newName);
        break;
    case 2:
        System.out.println("Enter the new author:");
        String newAuthor = scan.next();
        selectedItem.setAuthor(newAuthor);
        break;
    case 3:
        System.out.println("Enter the new year of publication:");
        int newYear = scan.nextInt();
        selectedItem.setYearOfPublication(newYear);
        break;
    case 4:
        if (selectedItem instanceof Book) {
            System.out.println("Enter the new number of pages:");
            int newPages = scan.nextInt();
            ( (Book) selectedItem).setNumberOfPages(newPages);
        } else {
            System.out.println("Item is not a book.");
        }
        break;
    case 5:
        if (selectedItem instanceof Journal) {
            System.out.println("Enter the new volume number:");
            int newVolume = scan.nextInt();
            ((Journal) selectedItem).setVolumeNumber(newVolume);
        } else {
            System.out.println("Item is not a journal.");
        }
        break;
    case 6:
        if (selectedItem instanceof Media) {
            System.out.println("Enter the new media type:");
            String newType = scan.next();
            ((Media) selectedItem).setType(newType);
        } else {
            System.out.println("Item is not media.");
        }
        break;
    default: 
    	System.out.println("Invalid option.");
    	return;
    }
    
    System.out.println("Info of the item was successfully modified.");

    }
    
	
    // case 4:
    public static void listItemsFromCategory() {
    	System.out.println("Which category would you like to list all items for? (1. Book 2. Journal 3. Media)");
    	int choice = scan.nextInt();
    	
    	String result = "";
    	
		if (choice == 1) {
			for (int i=0; i < findEmptyIndex(); i++) {
				if (items[i] instanceof Book)
				result += items[i].toString()+ "\n";
			}
			System.out.println(result);
		}
			
		else if (choice == 2) {
			for (int i=0; i < findEmptyIndex(); i++) {
				if (items[i] instanceof Journal)
					result += items[i].toString()+ "\n";
			}
			System.out.println(result);
		}
		
		else if (choice == 3) {
			for (int i=0; i < findEmptyIndex(); i++) {
				if (items[i] instanceof Media)
					result += items[i].toString()+ "\n";
			}
			System.out.println(result);				
		}
		
		else {
			System.out.println("Incorrect input. Please enter 1, 2, or 3 next time.");
			return;
		}
    }
    
    
    // case 5:
	public static String displayAllItems() {
		String result = "";
	    for (int i = 0; i < items.length; i++) {
	        if (items[i] != null) { // Check if the item at index i is not null
	            result += items[i].toString() + "\n"; // Concatenate the item's string representation to the result
	        }
	    }
	    return result; // Return the accumulated string
		
	}
    
	// case 6
	public static void addClient() {
		if (clientCount < MAX_CLIENTS) {
	        System.out.println("Please enter the new client's name: ");
	        String clientNewName = scan.next();
	        System.out.println("Please enter the new client's phone number: ");
	        long clientNewNumber = scan.nextLong();
	        System.out.println("Please enter the new client's email: ");
	        String clientNewEmail = scan.next();

	        Client client = new Client(clientNewName, clientNewNumber, clientNewEmail);
	        clients[clientCount] = client; // Assigning the new client to the next available index
	        clientCount++; // Increment the client count

	        System.out.println("Here is the new client added: " + client.toString());
	    } else {
	        System.out.println("Maximum number of clients reached.");
	    }
	}
	
	//case 7
	public static void editClient() {
		
		if (clientCount == 0) {
			System.out.println("There are currently no clients.");
		}
		else {
		System.out.println("Here is the current list of clients: ");
		for (int i =0; i<clientCount; i++) {
			System.out.println(i +". " + clients[i].toString()+"\n");
		}
		System.out.println("Enter which of the clients you would like to edit: ");
		int clientChoice = scan.nextInt();
		
		System.out.println("what would you like to edit: \n1. Name \n2. Phone Number \n3. Email ");
		int editChoice = scan.nextInt();
		
		if (editChoice == 1) {
			System.out.println("Enter the new name: ");
			String newName = scan.next();
			clients[clientChoice].setName(newName);
		}
		if (editChoice == 2) {
			System.out.println("Enter the new phone number: ");
	        long newNumber = scan.nextLong();
			clients[clientChoice].setPhoneNumber(newNumber);
		}
		if (editChoice == 3) {
			System.out.println("Enter the new email: ");
			String newEmail = scan.nextLine();
			clients[clientChoice].setEmail(newEmail);
		}
		
		System.out.println("Here is the newly edited client information: "+clients[clientChoice].toString());
		}
	}
	
	//case 8
	public static void deleteClient() {
		if (clientCount == 0) {
			System.out.println("There are currently no clients.");
			return; // exits method prematurely
		}
		
		
		System.out.println("Here is the current list of clients: ");
		for (int i =0; i<clientCount; i++) {
			System.out.println(i +". " + clients[i].toString()+"\n");
		}
		System.out.println("Enter which of the clients you would like to delete: ");
		int clientChoice = scan.nextInt();
		
		if (clientChoice < 0 || clientChoice >= clientCount) {
	        System.out.println("Invalid client number.");
	        return; // exits method prematurely
	    }

	    // Shift elements to the left
	    for (int i = clientChoice; i < clientCount - 1; i++) {
	        clients[i] = clients[i + 1];
	    }

	    // Set the last element to null
	    clients[clientCount - 1] = null;
	    clientCount--;

	    System.out.println("Client has been successfully removed.");
	
	}
	
	// case 9: Lease an item to a client
    public static void leaseItemToClient() {
    	
    	System.out.println("Current Items:");
        for (int i = 0; i < findEmptyIndex(); i++) {
            System.out.println((i) + ". " + items[i].toString());
        }
        
        System.out.println("Choose which item you would like to lease: ");
        int leaseItemChoice = scan.nextInt();
        
        //create an item object and then call method that stores that item in the array of leased items
      	Item chosenItem = items[leaseItemChoice];
      	chosenItem.leasedItemsArray(chosenItem);
		
		if (chosenItem.getLeasedTo() != null) { // Check if the item is leased already
            System.out.println("The item you have chosen is already leased. Sorry.");
            return; // exit method early so user can try again and pick another item
        }
        
        System.out.println("Here is the current list of clients: ");
		for (int i =0; i<clientCount; i++) {
			System.out.println(i +". " + clients[i].toString()+"\n");
		}
		System.out.println("Enter which client you are: ");
		int clientChoiceToLease = scan.nextInt();
				
		//calls method in Item that assigns a client to the leased item
		chosenItem.leaseItemTo(clients[clientChoiceToLease]);
		
		System.out.println("Item " + chosenItem.getName() + " leased to client " + clients[clientChoiceToLease].getName() + " successfully.");

    }

    // case 10: Return an item from a client
    public static void returnItemFromClient() {
    	
    	System.out.println("Available Items:");
        for (int i = 0; i < findEmptyIndex(); i++) {
            System.out.println((i) + ". " + items[i].toString());
        }
        
        System.out.println("Choose which item you would like to return: ");
        int returnItemChoice = scan.nextInt();
        
        System.out.println("Here is the current list of clients: ");
		for (int i =0; i<clientCount; i++) {
			System.out.println(i +". " + clients[i].toString()+"\n");
		}
		System.out.println("Enter which client you are: ");
		int clientChoiceToReturn = scan.nextInt();
    	
		
		//create an item object and then call method that removed the item from the array of leased items 
		Item chosenItem = items[returnItemChoice];
		chosenItem.returnItem(chosenItem);
    	
		// now leasedTo is null
    	chosenItem.returnItemClient();
    	
		System.out.println("Leased item " + chosenItem.getName() + " is returned from client " + clients[clientChoiceToReturn].getName() + " successfully.");

    }
    
    // case 11: Show all items leased by a client
    public static void showLeasedItemsByClient() {
    	
    	if (clientCount == 0) {
    		 System.out.println("Option unavailable. There are currently no clients.");
    		return;
    	}
    	
    	System.out.println("Here is the current list of clients: ");
		for (int i =0; i<clientCount; i++) {
			System.out.println(i +". " + clients[i].toString()+"\n");
		}
		System.out.println("Enter which client you would like to see the leased items of: ");
		int clientChoice = scan.nextInt();
	
		Client chosenClient = clients[clientChoice];
        Item[] leasedItems = chosenClient.getLeasedItems();
        
		// verify client choice is valid
		if (clientChoice >= 0 && clientChoice < clientCount) {
			
		boolean foundLeasedItem = false;
			
			for (int i = 0; i < findEmptyIndex(); i++) {
				Client client = items[i].getLeasedTo();
				if (chosenClient.equals(client)) {
					System.out.println(items[i].toString()+"\n");
					foundLeasedItem = true;
				}
				
			}
			
			if (!foundLeasedItem) {
	               System.out.println("No items leased by " + chosenClient.getName() + ".");
	         }
	    }
		
    }
		
    // case 12: Show all leased items (by all clients)
    public static void showAllLeasedItems() {
    	
    	 boolean anyLeasedItem = false;
    	    System.out.println("Leased Items:");
    	    for (int i = 0; i < findEmptyIndex(); i++) {
    	        Item currentItem = items[i];
    	        if (currentItem.getLeasedTo() != null) { // Check if the item is leased
    	            anyLeasedItem = true;
    	            System.out.println(currentItem.toString());
    	        }
    	    }
    	    if (!anyLeasedItem) {
    	        System.out.println("No items are currently leased.");
    	    }
      
    }
	
    // case 13: display the biggest book
    public static Book getBiggestBook(Item[] array) {
        Book biggestBook = null;
        int maxPages = 0;

        // Iterate through all items to find books
        for (int i = 0; i < array.length; i++) {
            if (array[i] instanceof Book) {
                Book currentBook = (Book) array[i];
                if (currentBook.getNumberOfPages() > maxPages) {
                    maxPages = currentBook.getNumberOfPages();
                    biggestBook = currentBook;
                }
            }
        }

        return biggestBook;
    }
    

    
    // case 14: make a deep copy of the books
    public static Book[] copyBooks(Book[] books) {
        if (books == null) {
            return null; // Return null if the input array is null
        }

        Book[] copiedBooks = new Book[books.length];

        // Iterate through the original array and create deep copies
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                copiedBooks[i] = new Book(books[i]);
            }
        }

        return copiedBooks;
    }
    
	
	
}

