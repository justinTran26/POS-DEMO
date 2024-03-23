// ---------------------------------------------------------
// Assignment 4
// Written by: Justin Tran 40281429
// For COMP 248 Section H2232 – Fall 2023
// ---------------------------------------------------------

/*
 The POSDemo class is the driver program, using the main method as a console menu to 
 interact with the other classes. The program displayes a welcome message displaying the options and
 prompts the user to pick one of the options using a while loop. The program uses a switch function
 to read to users choice. If the user enters 0 (the quit option), the loop will end and a goodbye message
 will be displayed. the program has 9 different operations; 1. See all the content of the PoSs, 2. See the content of
 one Pos, 3. list the PoS with the same amount of sales, 4. List the PoS with the same amount of sales categories, 5.
 list the Pos with the same amount of sales and categories, 6. add a prepaid card. 7. remove a prepaid card, 
 8.  Update the expiry date of a prepaid card and 9. Add sales to a prepaid card.  The purpose of the 
 PoSDemo class is the serve as the main program to interact with the 3 other classes to allow users to perform 
 a number of different operations.
 */
import java.util.Scanner;

public class PoSDemo {

    public static void main(String[] args) {
    	
    	//Initialize scanner
        Scanner scanner = new Scanner(System.in);

        // Creating PoS instances
        PoS pos1 = createPoS();
        PoS pos2 = createPoS();
        PoS pos3 = createPoS();
        PoS pos4 = createPoS();
        PoS pos5 = createPoS();
        
        //While loop that allows users to choose from 10 different operations, ending when the user selects 0.
        while (true) {
        	System.out.println(" ");
            System.out.println("What would you like to do?");
            System.out.println("1. See the content of all PoSs");
            System.out.println("2. See the content of one PoS");
            System.out.println("3. List PoSs with same $ amount of sales");
            System.out.println("4. List PoS with the same number of Sales categories");
            System.out.println("5. List PoSs with the same $ amount of Sales and same number of Prepaid cards");
            System.out.println("6. Add a Prepaid card to an existing PoS");
            System.out.println("7. Remove an existing Prepaid card from a PoS");
            System.out.println("8. Update the expiry date of an existing Prepaid card");
            System.out.println("9. Add sales to a PoS");
            System.out.println("0. To quit");
            System.out.print("Please enter your choice and press <Enter>:");
            int choice = scanner.nextInt();
            System.out.println(" ");
            
            switch (choice) {
                case 1:
                    displayAllPoS(pos1, pos2, pos3, pos4, pos5);
                    break;
                case 2:
                    displayOnePoS(pos1, pos2, pos3, pos4, pos5);
                    break;
                case 3:
                    listPoSsWithSameSalesAmount(pos1, pos2, pos3, pos4, pos5);
                    break;
                case 4:
                    listPoSsWithSameSalesCategories(pos1, pos2, pos3, pos4, pos5);
                    break;
                case 5:
                    listPoSsWithSameSalesAndPrePaidCards(pos1, pos2, pos3, pos4, pos5);
                    break;
                case 6:
                    addPrePaidCardToPoS(scanner, pos1, pos2, pos3, pos4, pos5);
                    break;
                case 7:
                    removePrePaidCardFromPoS(scanner, pos1, pos2, pos3, pos4, pos5);
                    break;
                case 8:
                    updatePrePaidCardExpiry(scanner, pos1, pos2, pos3, pos4, pos5);
                    break;
                case 9:
                    addSalesToPoS(scanner, pos1, pos2, pos3, pos4, pos5);
                    break;
                case 0:
                    System.out.println("Thank you for using Concordia CostLessBites Catering Sales Counter Application!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry that is not a valid choice. Try again.");
            }
        }
    }
    //Creates a new PoS instance with default sales and no prepaid cards. 
    private static PoS createPoS() {
        Sales sales = new Sales();
        PrePaidCard[] prePaidCards = null;  
        return new PoS(sales, prePaidCards);
    }
    //Method that displays all content of PoSs by calling on the displayPoS method. 
    private static void displayAllPoS(PoS... posArray) {
        for (int i = 0; i < posArray.length; i++) {
            System.out.println("PoS " + i + ":");
            displayPoS(posArray[i]);
        }
    }
    //Method that displays the content of one Pos
    private static void displayOnePoS(PoS... posArray) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the PoS number you want to display (0-4): ");
        int posNumber = scanner.nextInt();
        if (posNumber >= 0 && posNumber <= posArray.length) {
            displayPoS(posArray[posNumber]);
        } else {
            System.out.println("Invalid PoS number.");
        }
        scanner.close();
    }

    //displays the content of the specific PoS in a structured way.
    private static void displayPoS(PoS pos) {
        System.out.println("Content of each PoS:");
        System.out.println("---------------------");

        Sales sales = pos.getMealsSales();
        PrePaidCard[] prePaidCards = pos.getPrePaidcards();

        System.out.println("Total Sales: $" + pos.getTotalSales());
        System.out.println("Sales Categories: " + sales.toString());


        if (prePaidCards != null) {
            for (PrePaidCard card : prePaidCards) {
                if (card != null) {
                    System.out.println(card.toString());
                }
            }
        } else {
            System.out.println("No Prepaid Cards");
        }

        System.out.println();
    }

    //Method that lists the PoSs with the same amount of sales
    private static void listPoSsWithSameSalesAmount(PoS... posArray) {
        for (int i = 0; i < posArray.length - 1; i++) {
            for (int j = i + 1; j < posArray.length; j++) {
                if (posArray[i].isEqualTotalSales(posArray[j])) {
                    System.out.println("PoS " + (i + 1) + " and PoS " + (j + 1) +
                            " have the same total $ amount of sales: $" + posArray[i].getTotalSales());
                }
            }
        }
    }
  //Method that lists the PoSs with the same sales categories
    private static void listPoSsWithSameSalesCategories(PoS... posArray) {
        for (int i = 0; i < posArray.length - 1; i++) {
            for (int j = i + 1; j < posArray.length; j++) {
                if (posArray[i].isEqualSalesCategories(posArray[j])) {
                    System.out.println("PoS " + (i + 1) + " and PoS " + (j + 1) +
                            " have the same number of sales categories.");
                }
            }
        }
    }
    ////Method that lists the PoSs with the same amount of sales and sales categories
    private static void listPoSsWithSameSalesAndPrePaidCards(PoS... posArray) {
        for (int i = 0; i < posArray.length - 1; i++) {
            for (int j = i + 1; j < posArray.length; j++) {
                if (posArray[i].isEqualTotalSales(posArray[j]) &&
                        posArray[i].getNumPrepaidCards() == posArray[j].getNumPrepaidCards()) {
                    System.out.println("PoS " + (i + 1) + " and PoS " + (j + 1) +
                            " have the same total $ amount of sales and the same number of prepaid cards.");
                }
            }
        }
    }
    //Method to add prepaid card to PoS
    private static void addPrePaidCardToPoS(Scanner scanner, PoS... posArray) {
        System.out.println("Which PoS do you want to add a PrePaidCard to? (enter a number from 0-4)");
        int posNumber = scanner.nextInt();
        System.out.println("Please enter the following information so that we may complete the PrePaiCard-");
        if (posNumber >= 0 && posNumber <= posArray.length) {
            PrePaidCard newCard = createPrePaidCard(scanner);
            posArray[posNumber].addPrepaidCard(newCard);
            System.out.println("Prepaid card added to PoS " + posNumber);
        } else {
            System.out.println("Invalid PoS number.");
        }
    }
    //Method that creates a prepaid card with 4 attributes
    private static PrePaidCard createPrePaidCard(Scanner scanner) {
        System.out.println("--> Type of PrePaiCard (Carnivore, Halal, Kosher, Pescatarian, Vegetarian, Vegan) ");
        String dietType = scanner.next();

        System.out.println("--> Id of the prepaid card owner: ");
        String cardHolderID = scanner.next();

        System.out.println("--> Expiry day number and month (seperate by a space):");
        int expiryDay = scanner.nextInt();
        int expiryMonth = scanner.nextInt();

        return new PrePaidCard(dietType, cardHolderID, expiryDay, expiryMonth);
    }
    //Method that removes a prepaid card from a PoS
    private static void removePrePaidCardFromPoS(Scanner scanner, PoS... posArray) {
        System.out.println("Enter the PoS number to remove a prepaid card (0-4): ");
        int posNumber = scanner.nextInt();
        if (posNumber >= 0 && posNumber <= posArray.length) {
            PoS pos = posArray[posNumber];
            int numPrePaidCards = pos.getNumPrepaidCards();

            if (numPrePaidCards > 0) {
                System.out.println("Select a prepaid card to remove (1-" + numPrePaidCards + "): ");
                int cardIndex = scanner.nextInt();

                if (cardIndex >= 1 && cardIndex <= numPrePaidCards) {
                    pos.removePrepaidCard(cardIndex - 1);
                    System.out.println("Prepaid card removed from PoS " + posNumber);
                } else {
                    System.out.println("Invalid prepaid card index.");
                }
            } else {
                System.out.println("No prepaid cards to remove.");
            }
        } else {
            System.out.println("Invalid PoS number.");
        }
    }
    //Method that updates the expiry date of a prepaid card.
    private static void updatePrePaidCardExpiry(Scanner scanner, PoS... posArray) {
        System.out.println("Enter the PoS number to update a prepaid card (1-5): ");
        int posNumber = scanner.nextInt();
        if (posNumber >= 1 && posNumber <= posArray.length) {
            PoS pos = posArray[posNumber - 1];
            int numPrePaidCards = pos.getNumPrepaidCards();

            if (numPrePaidCards > 0) {
                System.out.println("Select a prepaid card to update (1-" + numPrePaidCards + "): ");
                int cardIndex = scanner.nextInt();

                if (cardIndex >= 1 && cardIndex <= numPrePaidCards) {
                    System.out.println("Enter the new expiry day (1-31): ");
                    int newExpiryDay = scanner.nextInt();

                    System.out.println("Enter the new expiry month (1-12): ");
                    int newExpiryMonth = scanner.nextInt();

                    pos.updatePrepaidCardExpiry(cardIndex - 1, newExpiryDay, newExpiryMonth);
                    System.out.println("Prepaid card expiry date updated for PoS " + posNumber);
                } else {
                    System.out.println("Invalid prepaid card index.");
                }
            } else {
                System.out.println("No prepaid cards to update.");
            }
        } else {
            System.out.println("Invalid PoS number.");
        }
    }
    //Method that adds sales to a PoS
    private static void addSalesToPoS(Scanner scanner, PoS... posArray) {
        System.out.println("Enter the PoS number to add sales (0-4): ");
        int posNumber = scanner.nextInt();
        if (posNumber >= 0 && posNumber <= posArray.length) {
            System.out.println("How many junior, teen ,medium,big and family meal menu do you want to add?\n"
            		+ "Enter 5 numbers seperated by a space: ");
            int junior = scanner.nextInt();

            int teen = scanner.nextInt();

            int medium = scanner.nextInt();

            int big = scanner.nextInt();

            int family = scanner.nextInt();

            posArray[posNumber].Sales.addSales(junior, teen, medium, big, family);
            System.out.println("You now have: $" +
                    posArray[posNumber].getTotalSales());
        } else {
            System.out.println("Invalid PoS number.");
        }
    }
}


