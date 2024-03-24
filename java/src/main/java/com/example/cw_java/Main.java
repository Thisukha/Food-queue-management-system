package com.example.cw_java;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class Main {
    private static String[] Cashier1 = {"X" , "X"} ;
    private static ArrayList<Integer> cashier1Bugers=new ArrayList<>();
    private static String[] Cashier2 = {"X" , "X" , "X"};
    private static ArrayList<Integer> cashier2Bugers=new ArrayList<>();
    private static String[] Cashier3 = {"X" , "X" , "X" , "X" , "X"};
    private static ArrayList<Integer> cashier3Bugers=new ArrayList<>();
    private static List<Customer> waitingList = new ArrayList<>();
    static boolean empty1 = true;
    static boolean empty2 = true;
    static boolean empty3 = true;
    private static int MAX_STOCK = 50; // Assign the the stock ony 50 Burgurs can at be at the stock
    private String FirstName ;
    private String LastName;
    private int BurgersRequired;
    private static int Burger_Prize = 650;





    public static void main(String args []){
        Scanner input = new Scanner (System.in);
        String x;

        do{
            Display_Menu(); // Displaying the menu what the user should enter , what ever his choie
            System.out.print("Enter the option you want to enter: ");
            x = input.nextLine();

            // Asiginig the inputs
            switch(x){
                case "100":
                case "VFQ":
                    View_All_Queues();
                    break;
                case "101":
                case "VEQ":
                    View_Empty_Queues();
                    break;
                case "102":
                case "ACQ":
                    Add_customer_Queue();
                    break;
                case "103":
                case "RCQ":
                    Remove_customer_from_Queue();
                    break;
                case "104":
                case "RSQ":
                    Remove_a_served_customer();
                    break;
                case "105":
                case "VCS":
                    View_Customers_Sorted_in_alphabetical_order();
                    break;
                case "106":
                case "SPD":
                    Store_Program_Data_into_file();
                    break;
                case "107":
                case "LPD":
                    Load_Program_Data_from_file();
                    break;
                case "108":
                case "STK":
                    View_Remaining_burgers_Stock();
                    break;
                case "109":
                case "AFS":
                    Add_burgers_to_Stock();
                    break;
                case "110":
                case "IFQ":
                    calculateIncome();
                    break;
                default:
                    System.out.println("Invalied input enter a valied input :( ");
                    break;
            }

            System.out.println();
        } while (!x.equals("999") && !x.equals("EXT"));
        input.close(); // program ending ans exit.
    }
    private static void Display_Menu() { // Displaying the menu for the user.
        System.out.println("\n                                            ****************** welcome to the Foodies Fave Food Center ******************");
        System.out.println("\n                                                                1. 100 or VFQ: View all Queues");
        System.out.println("\n                                                                2. 101 or VEQ: View all Empty Queues.");
        System.out.println("\n                                                                3. 102 or ACQ: Add customer to a Queue.");
        System.out.println("\n                                                                4. 103 or RCQ: Remove a customer from a Queue.");
        System.out.println("\n                                                                5. 104 or PCQ: Remove a served customer.");
        System.out.println("\n                                                                6. 105 or VCS: View Customers Sorted in alphabetical order");
        System.out.println("\n                                                                7. 106 or SPD: Store Program Data into file.");
        System.out.println("\n                                                                8. 107 or LPD: Load Program Data from file.");
        System.out.println("\n                                                                9. 108 or STK: View Remaining burgers Stock.");
        System.out.println("\n                                                                10. 109 or AFS: Add burgers to Stock.");
        System.out.println("\n                                                                11. 110 or IFQ calculateIncome");
        System.out.println("\n                                                                12. 999 or EXT: Exit the Program");
    }
    private static void View_All_Queues(){ // in here Whwn the user enter 100 it will show all the qs weather it is ocupied or not
        System.out.println("\n     *****************");
        System.out.println("       * Cashiers *");
        System.out.println("     *****************");

        int Max_Length = Math.max(Math.max(Cashier1.length, Cashier2.length), Cashier3.length);

        // viewIng Q for Cashier 1
        for (int i = 0; i < Max_Length; i++) {
            if (i < Cashier1.length) {
                System.out.print(Cashier1[i]);
            } else {
                System.out.print(" ");
            }

            System.out.print("\t\t\t"); // To get tab space

            // viewIng Q for Cashier 2
            if (i < Cashier2.length) {
                System.out.print(Cashier2[i]);
            } else {
                System.out.print(" ");
            }

            System.out.print("\t\t\t"); // To get tab space

            // viewIng Q for Cashier 3
            if (i < Cashier3.length) {
                System.out.print(Cashier3[i]);
            }

            System.out.println();
        }

    }
    private static void View_Empty_Queues() { // in here when the user enter 101 it will show the all empty q by "X" symbol
        System.out.println("Empty Queues: ");


        // in here it will show wich position it is blank in Q1
        System.out.print("Queue 1: ");
        for (String sort : Cashier1) {
            if (sort.equals("X")) {
                System.out.print("X ");
                empty1 = false;
            } else {
                System.out.print("O ");
            }
        }
        System.out.println();

        // in here it will show wich position it is blank in Q2
        System.out.print("Queue 2: ");
        for (String sort : Cashier2) {
            if (sort .equals("X")) {
                System.out.print("X ");
                empty2 = false;
            } else {
                System.out.print("O ");
            }
        }
        System.out.println();

        // in here it will show wich position it is blank in Q3
        System.out.print("Queue 3: ");
        for (String sort: Cashier3) {
            if (sort.equals("X")) {
                System.out.print("X ");
                empty3 = false;
            } else {
                System.out.print("O ");
            }
        }
        System.out.println();

        // if all q are not empty it will show a out put no empty q
        if (empty1 && empty2 && empty3) {
            System.out.println("No empty queues.");
        }
    }
    private static void Add_customer_Queue(){
        Scanner insert = new Scanner(System.in);


        System.out.println("                                                             ***** From the Cashier Line, greetings! *****           ");
        System.out.print("\nWould you wish to add a customer to queue 1, 2, or 3? : " );
        int Q_Choice = insert.nextInt();

        // To select a proper Q Choice
        String[] selected_queue;
        switch (Q_Choice) {
            case 1:
                selected_queue = Cashier1;
                break;
            case 2:
                selected_queue = Cashier2;
                break;
            case 3:
                selected_queue = Cashier3;
                break;
            default:
                System.out.print("Invalid queue choice. Exiting program.");
                return;
        }

        // to enter the position you want in thee Q
        System.out.print("Eneter the position from (1 to" + selected_queue.length +") to add the customer : ");
        int Position = insert.nextInt();
        insert.nextLine();

        // To chek Valied position.
        if (Position < 1 || Position > selected_queue.length) {
            System.out.println("A unfilled position. Eneter valied position: ( ");
            return;
        }

        // to print an eroor if the position is allredy ocupied
        if (!selected_queue[Position - 1].equals("X")) {
            System.out.println("Position already occupied. ");
            System.out.print("\nDo you want to add the customer to the waiting list (YES / NO)): ");
            String addWaitinglsit = insert.nextLine();

            if((addWaitinglsit != "NO") || (addWaitinglsit != "no")){
                System.out.print("\nEnter custome name: ");
                String customerFirstName = insert.nextLine();

                System.out.print("Enter customer last name: ");
                String customerLastName = insert.nextLine();

                System.out.print("Enter the number of burgers required: ");
                int burgersRequired = insert.nextInt();

                Customer Customer = new Customer(customerFirstName,customerLastName,burgersRequired);
                waitingList.add(Customer);

                System.out.println("* Customer added to the waiting list successfully * ");
                return;
            }



        }

        // if stock is below user canot enter his detayels
        if (MAX_STOCK < 5) {
            System.out.println("Not enough stock. Customer cannot be added to the queue.");
            return;
        }

        // Entering the custome name
        System.out.print("\nEnter customer first name: ");
        String customer_data = insert.nextLine();

        System.out.print("Enter Custome Last name: ");
        String customer_lastname = insert.nextLine();

        System.out.print("Enter the No. of burgers required: ");
        int N_B_G = insert.nextInt();

        switch (Q_Choice){
            case 1:
                cashier1Bugers.add(N_B_G);
                break;
            case 2:
                cashier2Bugers.add(N_B_G);
                break;
            case 3:
                cashier3Bugers.add(N_B_G);
                break;
            default:
                System.out.print("Invalid queue choice. Exiting program.");
                return;

        }

        // reduce 5 burgers in every time
        MAX_STOCK -= N_B_G;

        selected_queue[Position - 1] = customer_data;
        System.out.println("*Customer add to the queue and position successfully * ");

        System.out.println("Updated queue" + Q_Choice + ": ");
        for (String sort : selected_queue) {
            System.out.println(sort);
        }

    }
    private static void Remove_customer_from_Queue() {
        Scanner insert = new Scanner(System.in);

        System.out.println("              * Welcome to the Customer Removal *");
        System.out.println("\nWhich queue would you like to remove a customer from? (1, 2, 3):");
        int Q_Choice = insert.nextInt();

        // to choice q
        String[] S_Queue;
        switch (Q_Choice) {
            case 1:
                S_Queue= Cashier1;
                break;
            case 2:
                S_Queue = Cashier2;
                break;
            case 3:
                S_Queue = Cashier3;
                break;
            default:
                System.out.println("Invalid queue choice. Exiting program.");
                return;
        }

        // in the Q wich position you have to remove
        System.out.print("Enter the position (1 to " + S_Queue.length + ") to remove the customer: ");
        int position = insert.nextInt();
        insert.nextLine();

        // if it is invalied position it will prin a erro msg
        if (position < 1 || position > S_Queue.length) {
            System.out.println("Invalid position. Exiting program.");
            return;
        }

        // to see therer if is there any spesifc customer in
        if (S_Queue[position - 1].equals("X")) {
            System.out.println("No customer found at the specified position. Exiting program.");
            return;
        }

        // to print customer remove sucefully
        S_Queue[position - 1] = "X";
        System.out.println("Customer removed successfully!");

        // to print update q
        System.out.println("\nUpdated queue " + Q_Choice + ":");
        for (String sort : S_Queue) {
            System.out.println(sort);
        }
    }
    private static void Remove_a_served_customer(){
        Scanner insert = new Scanner(System.in);

        System.out.println("              * Welcome to the Served Customer Removal *");
        System.out.print("\nWhich queue would you like to remove a customer from? (1, 2, 3):");
        int Q_Choice = insert.nextInt();

        String[] S_Queue;
        switch (Q_Choice) {
            case 1:
                S_Queue= Cashier1;
                break;
            case 2:
                S_Queue = Cashier2;
                break;
            case 3:
                S_Queue = Cashier3;
                break;
            default:
                System.out.println("Invalid queue choice. Exiting program.");
                return;
        }

        System.out.print("Enter the position (1 to " + S_Queue.length + ") to remove the customer: ");
        int position = insert.nextInt();
        insert.nextLine();

        if (position < 1 || position > S_Queue.length) {
            System.out.println("Invalid position. Exiting program.");
            return;
        }

        if (S_Queue[position - 1].equals("X")) {
            System.out.println("No customer found at the specified position. Exiting program.");
            return;
        }

        S_Queue[position - 1] = "X";
        System.out.println("Served customer removed successfully!");

        if (!waitingList.isEmpty()) {
            Customer customerFromWaitingList = waitingList.remove(0);
            S_Queue[position - 1] = customerFromWaitingList.getFirstName() + " " + customerFromWaitingList.getLastName();
            System.out.println("Customer from the waiting list added to position " + position + ".");
        }


        System.out.println("\nUpdated queue " + Q_Choice + ":");
        for (String sort : S_Queue) {
            System.out.println(sort);
        }

    }
    private static void View_Customers_Sorted_in_alphabetical_order()
    {
        String[] customers = new String[Cashier1.length + Cashier2.length + Cashier3.length];

        // Copy customers from all queues to the array
        int index = 0;
        for (String slot : Cashier1) {
            if (!slot.equals("X")) {
                customers[index] = slot;
                index++;
            }
        }
        for (String slot : Cashier2) {
            if (!slot.equals("X")) {
                customers[index] = slot;
                index++;
            }
        }
        for (String slot : Cashier3) {
            if (!slot.equals("X")) {
                customers[index] = slot;
                index++;
            }
        }

        // Sort the array using bubble sort
        for (int i = 0; i < customers.length - 1; i++) {
            for (int j = 0; j < customers.length - i - 1; j++) {
                if (customers[j].compareTo(customers[j + 1]) > 0) {
                    // Swap customers[j] and customers[j + 1]
                    String temp = customers[j];
                    customers[j] = customers[j + 1];
                    customers[j + 1] = temp;
                }
            }
        }

        // Print the sorted customer names
        System.out.println("Customers Sorted in alphabetical order:");
        for (String customer : customers) {
            System.out.println(customer);
        }
    }
    private static void Store_Program_Data_into_file() { // to create the text file
        try {
            FileWriter fileWriter = new FileWriter("CWTHSIUuuuuuuuuuuuuuuuuu.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);


            printWriter.println("Queue 1:");
            for (String slot : Cashier1) {
                printWriter.println(slot);
            }
            printWriter.println("Queue 2:");
            for (String slot : Cashier2) {
                printWriter.println(slot);
            }
            printWriter.println("Queue 3:");
            for (String slot : Cashier3) {
                printWriter.println(slot);
            }

            printWriter.close();
            System.out.println("successfully storing program data in program_data");
        } catch (IOException e) {
            System.out.println("A mistake was made when storing program data: " + e.getMessage());
        }
    }
    private static void Load_Program_Data_from_file() {
        try {
            FileReader fileReader = new FileReader("CWTHSIUuuuuuuuuuuuuuuuuu.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            int queueNumber = 1;

            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Queue " + queueNumber + ":");
                while (!line.isEmpty()) {
                    System.out.println(line);
                    line = bufferedReader.readLine();
                }
                System.out.println();
                queueNumber++;
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while loading program data: " + e.getMessage());
        }
        return;
    }
    private static void View_Remaining_burgers_Stock(){
        System.out.println("Remaning burger stock:  " + MAX_STOCK);
    }
    private static void Add_burgers_to_Stock(){
        Scanner incert = new Scanner(System.in);

        System.out.print("Enter how many burgers you want: ");
        int BG = incert.nextInt();

        Update_Stock(BG);
        System.out.println("Added " + BG + " burgers to stock.");
    }
    private static void Update_Stock(int BG) {
        MAX_STOCK +=  BG ;
        if (MAX_STOCK <= 10);
        System.out.println("Warning: Burger stock is low. Remaning Stock: " + MAX_STOCK);
    }
    private static void calculateIncome(){

        for (int i = 0; i<cashier1Bugers.size();i++){
            int count = 0;
            count =count+ cashier1Bugers.get(i);
            int income = Burger_Prize*count;
            System.out.println(income );
        }

        for (int i = 0; i<cashier2Bugers.size();i++){
            int count = 0;
            count =count+ cashier2Bugers.get(i);
            int income = Burger_Prize*count;
            System.out.println(income);
        }

        for (int i = 0; i<cashier3Bugers.size();i++){
            int count = 0;
            count =count+ cashier3Bugers.get(i);
            int income = Burger_Prize*count;
            System.out.println(income);
        }


    }


}








