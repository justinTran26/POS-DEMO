package library;

public class Media extends Item{

	private String type;
	private static int idNumberM = 1;
	
	public Media() {
		this.setId("M" + idNumberM);
		idNumberM++;
	}
	
	public Media(String name, String author, int yearOfPublication, String type) {
        super("M"+idNumberM, name, author, yearOfPublication);
        this.type  = type;
        idNumberM++;
    }
	
	public Media(Media other) {
		super(other);
		this.type = other.type;
		this.setId("M" + idNumberM);
		idNumberM++;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	@Override
	public String toString() {
		return "ID: " + getId() + ". Name: " + getName() + ". Author: " + getAuthor() + ". Year of publication: " +getYearOfPublication() + ". Type: " + getType(); 
	}
	
	public boolean equals(Media other) {
		return (this.getAuthor() == other.getAuthor() && this.getName() == other.getName() && this.getYearOfPublication() == other.getYearOfPublication()  && this.getType() == other.getType()); 
	}

}
