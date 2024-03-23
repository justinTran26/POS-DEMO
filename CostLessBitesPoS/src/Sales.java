// ---------------------------------------------------------
// Assignment 4
// Written by: Justin Tran 40281429
// For COMP 248 Section H2232 – Fall 2023
// ---------------------------------------------------------

/*
 The sales class tracks, adds, and calculates the total value of sales for the PoS system.
 The constants are defined for the prices of each of the different meal categories. The sales class
 keeps the count of each meal type sale made for each PoS. It also keep track of the total sales in $ made
 per PoS. Finally, the sales class provides a string representation of the sales breakdown using the 
 toString method and checks if two sales objects have the same breakdown using the equals method.
 */

public class Sales {
	//declare constants for the prices of meals
	public static final int JUNIOR_PRICE = 5;
	public static final int TEEN_PRICE = 10;
	public static final int MEDIUM_PRICE = 12;
	public static final int BIG_PRICE= 15;
	public static final int FAMILY_PRICE = 20;
	
	//Track number of sales
	private int juniorCount;
	private int teenCount;
	private int mediumCount;
	private int bigCount;
	private int familyCount;
	
	//default constructor
	public Sales() {
		
	}
	
	// Set the initial count of each meal category
	public Sales(int juniorCount, int teenCount, int mediumCount, int bigCount, int familyCount) {
		
	    this.juniorCount = juniorCount;
	    this.teenCount = teenCount;
	    this.mediumCount = mediumCount;
	    this.bigCount = bigCount;
	    this.familyCount = familyCount;
	}
	
	 // Copy constructor
	public Sales(Sales otherSales) {
		// Copy the counts of each meal category from another Sales object
	    this.juniorCount = otherSales.juniorCount;
	    this.teenCount = otherSales.teenCount;
	    this.mediumCount = otherSales.mediumCount;
	    this.bigCount = otherSales.bigCount;
	    this.familyCount = otherSales.familyCount;
	}
	
	// Method to add sales for each meal category
	public void addSales(int junior, int teen, int medium, int big, int family) {
		 // Increase the number of sales for each meal category
	    juniorCount += junior;
	    teenCount += teen;
	    mediumCount += medium;
	    bigCount += big;
	    familyCount += family;
	}
	 //Method to calculate the total value of sales in the PoS
	public int salesTotal() {
	   
	    return (juniorCount * JUNIOR_PRICE) + (teenCount * TEEN_PRICE) +
	           (mediumCount * MEDIUM_PRICE) + (bigCount * BIG_PRICE) + (familyCount * FAMILY_PRICE);
	}
	
	
	// Return a string indicating the count of each meal
	@Override
	public String toString() {
	    
	    return String.format("5 x $%d, 10 x $%d, 12 x $%d, 15 x $%d, 20 x $%d",
	                         juniorCount, teenCount, mediumCount, bigCount, familyCount);
	}
	
	 // Check if two Sales objects have the same breakdown of meal category
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;

	    Sales otherSales = (Sales) obj;
	    
	    return juniorCount == otherSales.juniorCount &&
	               teenCount == otherSales.teenCount &&
	               mediumCount == otherSales.mediumCount &&
	               bigCount == otherSales.bigCount &&
	               familyCount == otherSales.familyCount;
	    }
	    

}
