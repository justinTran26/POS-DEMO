// ---------------------------------------------------------
// Assignment 4
// Written by: Justin Tran 40281429
// For COMP 248 Section H2232 – Fall 2023
// ---------------------------------------------------------

/*
 The PoS class manages sales and prepaid cards. The PoS class rpresentes the various meal categories
 and their count and sales while also tracking the prepaidcards. The class can check if two PoS have the same 
 amount of sales, check the number of prepaid cards per PoS, add and remove prepaid cards from a PoS as well as
 update the expiry date for each PoS. Finally, the PoS class checks if two PoS objects are equal and represents
 them as string using the equals and toString methods respectively. 
 */

public class PoS {
	    public Sales Sales;
	    public PrePaidCard[] prePaidcards;

	    // Default constructor
	    public PoS() {
	    	//Initialize the Sales and prepaid cards attributes with default values.
	    	 this.Sales = new Sales();
	    	 this.prePaidcards = null;
	    }
	    
	 // Constructor with parameters to set the initial value of each attribute
	    public PoS(Sales mealsSales, PrePaidCard[] prePaiCards) {
	    	// Initialize the Sales and prePaidcards attributes with specified values
	        this.Sales = mealsSales;
	        this.prePaidcards = prePaiCards;
	    }
	    //Getter method for mealsSales
	    public Sales getMealsSales() {
	        return Sales;
	    }

	    // Getter method for prePaidcards
	    public PrePaidCard[] getPrePaidcards() {
	        return prePaidcards;
	    }
	    
	    // Method to check if the total $ value of sales of two PoS objects are equal
	    public boolean isEqualTotalSales(PoS otherPos) {
	        return this.Sales.salesTotal() == otherPos.Sales.salesTotal();
	    }
	    
	    // Method to check if the number of each sales category of two PoS objects are equal
	    public boolean isEqualSalesCategories(PoS otherPos) {
	        return this.Sales.equals(otherPos.Sales);
	    }

	    // Method to get the total $ sales of a PoS
	    public int getTotalSales() {
	        return this.Sales.salesTotal();
	    }

	    // Method to get the number of prepaid cards in a PoS
	    public int getNumPrepaidCards() {
	        return (prePaidcards != null) ? prePaidcards.length : 0;
	    }
	    
	    // Method to add a new PrePaiCard to the PoS
	    public int addPrepaidCard(PrePaidCard newCard) {
	        if (prePaidcards == null) {
	            prePaidcards = new PrePaidCard[]{newCard};
	        } else {
	            PrePaidCard[] newArray = new PrePaidCard[prePaidcards.length + 1];
	            System.arraycopy(prePaidcards, 0, newArray, 0, prePaidcards.length);
	            newArray[prePaidcards.length] = newCard;
	            prePaidcards = newArray;
	        }
	        return prePaidcards.length;
	    }

	    
	    // Method to remove a prepaid card from the PoS
	    public boolean removePrepaidCard(int cardIndex) {
	        if (prePaidcards != null && cardIndex >= 0 && cardIndex < prePaidcards.length) {
	            PrePaidCard[] newArray = new PrePaidCard[prePaidcards.length - 1];
	            System.arraycopy(prePaidcards, 0, newArray, 0, cardIndex);
	            System.arraycopy(prePaidcards, cardIndex + 1, newArray, cardIndex, prePaidcards.length - cardIndex - 1);
	            prePaidcards = newArray;
	            return true;
	        }
	        return false;
	    }
	    
	    // Method to update the expiry day and month of a prepaid card
	    public void updatePrepaidCardExpiry(int cardIndex, int newExpiryDay, int newExpiryMonth) {
	        if (prePaidcards != null && cardIndex >= 0 && cardIndex < prePaidcards.length) {
	            prePaidcards[cardIndex].setExpiryDay(newExpiryDay);
	            prePaidcards[cardIndex].setExpiryMonth(newExpiryMonth);
	        }
	    }
	 // Check if two PoS objects are equal based on total $ amount sales value and the number of pre-paid cards
	    @Override
	    public boolean equals(Object obj) {
	        
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;

	        PoS otherPos = (PoS) obj;

	        return this.isEqualTotalSales(otherPos) && this.getNumPrepaidCards() == otherPos.getNumPrepaidCards();
	    }
	    
	 // Return a string clearly indicating the number of each meal
	    @Override
	    public String toString() {
	        
	        String result = "Meal Sales Categories:\n" + Sales.toString() + "\n";

	        if (prePaidcards != null && prePaidcards.length > 0) {
	            result += "Prepaid Cards:\n";
	            for (PrePaidCard card : prePaidcards) {
	                result += card.toString() + "\n";
	            }
	        } else {
	            result += "No prepaid cards\n";
	        }

	        return result;
	    }

}
	

