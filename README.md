Initialization:

The program starts with initializing three cashier queues (Cashier1, Cashier2, Cashier3) and corresponding burger lists (cashier1Bugers, cashier2Bugers, cashier3Bugers), along with a waiting list for customers who can't be immediately served.
Menu Display and User Input:

The Display_Menu method prints out the menu options for the user to interact with the program.
The main method repeatedly displays the menu and takes user input to perform various actions based on the selected option.
Queue Operations:

Users can view all queues (View_All_Queues), view empty queues (View_Empty_Queues), add a customer to a queue (Add_customer_Queue), remove a customer from a queue (Remove_customer_from_Queue), and remove a served customer (Remove_a_served_customer).
The queues are represented by arrays (Cashier1, Cashier2, Cashier3) where each element can hold customer names or "X" for empty slots.
Customer Class:

The Customer class defines a customer with attributes like first name, last name, and burgers required.
File Operations:

Users can store program data into a file (Store_Program_Data_into_file) and load program data from a file (Load_Program_Data_from_file).
Stock Management:

Users can view remaining burger stock (View_Remaining_burgers_Stock) and add burgers to the stock (Add_burgers_to_Stock).
Income Calculation:

The calculateIncome method calculates the income based on the number of burgers sold by each cashier queue.
Utility Methods:

Various utility methods are used for input validation, updating stock, sorting customers alphabetically, and managing the waiting list.
