package library;

public class Book extends Item {
    
    private int numberOfPages;
    private static int idNumberB = 1;
 
    
    public Book() {
    	this.setId("B" + idNumberB);
		idNumberB++;
    } 
    public Book(String name, String author, int yearOfPublication, int numberOfPages) {
        super("B"+idNumberB, name, author, yearOfPublication);
        this.numberOfPages = numberOfPages;
        idNumberB++;
    }
   
	public Book(Book other) {
		super(other);
		this.setId("B" + idNumberB);
		this.numberOfPages = other.numberOfPages;
		idNumberB++;
	}
    
    
    public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	public int getNumberOfPages() {
		return this.numberOfPages;
	}
	
	@Override
	public String toString() {
		return "ID: " + getId() + ". Name: " + getName() + ". Author: " + getAuthor() + ". Year of publication: " +getYearOfPublication() + ". Number of pages: " + getNumberOfPages(); 
	}
	
	public boolean equals(Book other) {
		return (this.getAuthor() == other.getAuthor() && this.getName() == other.getName() && this.getYearOfPublication() == other.getYearOfPublication()  && this.getNumberOfPages() == other.getNumberOfPages()); 
	}
	
	
	
	
	
}


