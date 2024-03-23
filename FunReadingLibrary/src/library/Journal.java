package library;

public class Journal extends Item{
	
	private int volumeNumber;
	private static int idNumberJ = 1;
	
	public Journal() {
		this.setId("J" + idNumberJ);
		idNumberJ++;
	}
	
	public Journal(String name, String author, int yearOfPublication, int volumeNumber) {
        super("J"+idNumberJ, name, author, yearOfPublication);
        this.volumeNumber = volumeNumber;
        idNumberJ++;
    }
	
	public Journal(Journal other) {
		super(other);
		this.setId("J" + idNumberJ);
		this.volumeNumber = other.volumeNumber;
		idNumberJ++;
	}
	
	
	public void setVolumeNumber(int volumeNumber) {
		this.volumeNumber = volumeNumber;
	}
	
	public int getVolumeNumber() {
		return this.volumeNumber;
	}
	
	@Override
	public String toString() {
		return "ID: " + getId() + ". Name: " + getName() + ". Author: " + getAuthor() + ". Year of publication: " +getYearOfPublication() + ". Volume Number: " + getVolumeNumber(); 
	}
	
	public boolean equals(Journal other) {
		return (this.getAuthor() == other.getAuthor() && this.getName() == other.getName() && this.getYearOfPublication() == other.getYearOfPublication()  && this.getVolumeNumber() == other.getVolumeNumber()); 
	}
}
