// ---------------------------------------------------------
// Assignment 4
// Written by: Justin Tran 40281429
// For COMP 248 Section H2232 – Fall 2023
// ---------------------------------------------------------

/*
 the PrePaidCard class represents a pre-paid card with 4 attributes, type, id,
 expiry day and month. The constructors are used to create instances with specified attribute values.
 Accessor methods retrieve the values of the attributes and the mutator methods validate while setting the 
 expiry date and month. The toString method generates a string representation of the prepaid card displaying the
 4 attributes while the equals method compares two prepaid cards for equality based on their attributes. 
 */

public class PrePaidCard {
	//Attributes of the pre-paid cards
	private String cardType;
    private String cardHolderID;
    private int expiryDay;
    private int expiryMonth;
    
    // Constants for validation
    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    
    // Default constructor
    public PrePaidCard() {
    }
    
 // Constructor with parameters to set the initial value of each attribute
    public PrePaidCard(String cardType, String cardHolderID, int expiryDay, int expiryMonth) {
        this.cardType = cardType;
        this.cardHolderID = cardHolderID;
        setExpiryDay(expiryDay);
        setExpiryMonth(expiryMonth);
    }

    // Copy constructor
    public PrePaidCard(PrePaidCard otherCard) {
        this.cardType = otherCard.cardType;
        this.cardHolderID = otherCard.cardHolderID;
        this.expiryDay = otherCard.expiryDay;
        this.expiryMonth = otherCard.expiryMonth;
    }
    
    // Method to access each attribute
    public String getCardType() {
        return cardType;
    }

    public String getCardHolderID() {
        return cardHolderID;
    }

    public int getExpiryDay() {
        return expiryDay;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }
    
 // Mutator methods for the due date
    public void setExpiryDay(int expiryDay) {
        if (expiryDay >= MIN_DAY && expiryDay <= MAX_DAY) {
            this.expiryDay = expiryDay;
        } else {
            this.expiryDay = 0; // Invalid day, set to 0
        }
    }

    // Mutator method for the due month
    public void setExpiryMonth(int expiryMonth) {
        if (expiryMonth >= MIN_MONTH && expiryMonth <= MAX_MONTH) {
            this.expiryMonth = expiryMonth;
        } else {
            this.expiryMonth = 0; // Invalid month, set to 0
        }
    }
    
    //String representation of pre-paid card
    @Override
    public String toString() {
        String formattedExpiryDay = String.format("%02d", expiryDay);
        String formattedExpiryMonth = String.format("%02d", expiryMonth);

        return String.format("'%s, - %s, - %s/%s",
                cardType, cardHolderID, formattedExpiryDay, formattedExpiryMonth);
    }
    
    //Check if two pre-paid cards are identical.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        PrePaidCard otherCard = (PrePaidCard) obj;

        return cardType.equals(otherCard.cardType) &&
               cardHolderID.equals(otherCard.cardHolderID) &&
               expiryDay == otherCard.expiryDay &&
               expiryMonth == otherCard.expiryMonth;
    }

}
