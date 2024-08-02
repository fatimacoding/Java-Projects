/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.uj.amc;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author aseel
 */
public class MyMovieApp {

    public static void main(String[] args) throws IOException {
  
        Scanner input = new Scanner(System.in); //scanner object
        
        //Declaring varibles
        int cost = 0;
        String phone = null;
        String name = null;
        int age;
        int time;
        boolean check2;
        boolean check3;
        CustomerInfo info = new CustomerInfo(name, phone); //create an object from UserInformation class//obj1
     
    //Introduction to the program
    System.out.println("\n\t\t\t        __  __       __  __            _      \n"
            + "\t\t\t       |  \\/  |     |  \\/  |          (_)     \n"
            + "\t\t\t       | \\  / |_   _| \\  / | _____   ___  ___ \n"
            + "\t\t\t       | |\\/| | | | | |\\/| |/ _ \\ \\ / / |/ _ \\\n"
            + "\t\t\t       | |  | | |_| | |  | | (_) \\ V /| |  __/\n"
            + "\t\t\t       |_|  |_|\\__, |_|  |_|\\___/ \\_/ |_|\\___|\n"
            + "\t\t\t               __/ |                         \n"
            + "\t\t\t              |___/                          ");


        System.out.println("\n\n\t**************************************************************************************************");
        System.out.println( "\t××××××××××                          WELCOME TO MyMovie!!                                ××××××××××");
        System.out.println("\t*********** YOU CAN COUNT ON US TO GIVE YOU THE FINEST SERVICE WHEN BOOKING YOUR MOIVE ***********");
        System.out.println("\t××××××××××              OUR GOAL IS TO ENSURE YOU HAVE A PLEASANT TIME                  ××××××××××");
        System.out.println("\t**************************************************************************************************\n");

        
        
        System.out.print("What's your name:");
        name = input.nextLine();
        info.setName(name); //set user name

        System.out.print("What's your age:");
        age = input.nextInt();//stores users input 
        info.setAge(age);

        while(age<=0 || age>120){//checks if age is valid
        System.out.println("\nWrong! try again please...");
        System.out.println("**Enter an actual age**");
        System.out.print("What's your age:");
        age = input.nextInt();
    }
        info.setAge(age);
        
        input.nextLine();//Consume the line

        System.out.print("What's your phone:");
        phone = input.nextLine();


        while (phone.length() != 10) {//checks if the phone number is vaild
            System.out.println("\nWrong! try again please...");
            System.out.println("**Enter a valid phone number 10 digit**");
            System.out.print("Enter your phone: ");
            phone = input.nextLine();
        }
        info.setPhone(phone); //set phone number

 //////////////////////////////////   //////////////////////////////////   //////////////////////////////////
 
        System.out.println();
        //create an arrayList which contain a movie list
        ArrayList< String> MovieList = new ArrayList<>();
        //using add method to add the movie to the list
        MovieList.add("Up");
        MovieList.add("Harry Potter");
        MovieList.add("Hush");


        //array for the seats
        String[] Seat = {" 0", " 1", " 2", "X", " 4", " 5", " 6", " 7", "8", "9\n", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19\n", "20", "21",
            "22", "23", "24 ", "X", "26", "27", "28", "29"};

        Reservation reserve = new Reservation();//Obj2
        reserve.setSeat(Seat); //Set the Seat


//////////////////////////////////   //////////////////////////////////   //////////////////////////////////
       
        // Generates random numbers for thr rooms
        Random rooms = new Random();
        int roomNO = rooms.nextInt(10) + 1;

        //Storys for each movie
        String story1 = "78-year-old Carl Fredricksen travels to Paradise Falls in his house equipped with balloons,inadvertently taking a young stowaway";
        String story2 = "A lonely orphan discovers he is a wizard and enrolls at Hogwarts School of Witchcraft and Wizardry";
        String story3 = "When a masked killer appears at the window of a deaf writer living in the woods, she must fight for her life in silence";

        //Age rating for every movie
        String movie1AgeRating = "PG";
        String movie2AgeRating = "13+";
        String movie3AgeRating = "18+";

        //Display the movies availabe to the user
        System.out.println("**************************************************************************************************************************************");
        System.out.println("=========================================           MOVIES AVAILABLE          ========================================================");
        System.out.println("**************************************************************************************************************************************");
        System.out.printf("\n>>>----------------------------------------------------- Up %s---------------------------------------------------------------------<<<\n", movie1AgeRating);
        System.out.printf("*** %s ***\n", story1);
        System.out.printf("\n>>>-------------------------------------------------- Harry Potter %s----------------------------------------------------------------<<<\n", movie2AgeRating);
        System.out.printf("              *** %s ***\n", story2);
        System.out.printf("\n>>>------------------------------------------------------ Hush %s-------------------------------------------------------------------<<<\n", movie3AgeRating);
        System.out.printf("      *** %s ***\n", story3);
        System.out.println("======================================================================================================================================\n");
        
        System.out.println(MovieList);
        System.out.println("which movie do you want ? ");
        String chooseMovie = input.nextLine(); //input from user

        MovieDetails movie=new MovieDetails();//obj3
        
        //Do while to check users movie choice
        do {
            switch (chooseMovie.toLowerCase()) { //Using switch to determine the next step based on the choice 
                case "up":

                    movie.setMovieName("Up");
                    movie.setMovieAgeRating(movie1AgeRating);
                    check2 = false;
                    reserve.setRoomNo(roomNO);//Set room

                    break;

                case "harry potter":

                    movie.setMovieName("Harry Potter");
                    movie.setMovieAgeRating(movie2AgeRating);
                    check2 = false;
                    reserve.setRoomNo(roomNO);//Set room
                    if(age<13){ //Ensure the user is age-appropriate
                        System.out.println("Sorry not Age-Appropriate choose another movie!!!");
                        System.out.println(MovieList); //print the movielist
                        chooseMovie = input.nextLine(); //input from user
                        check2=true;
                    }

                    break;

                case "hush":

                    movie.setMovieName("Hush");
                    movie.setMovieAgeRating(movie3AgeRating);
                    check2 = false;
                    reserve.setRoomNo(roomNO);//Set room
                     if(age<18){//Ensure the user is age-appropriate
                        System.out.println("Sorry not Age-Appropriate choose another movie!!!");
                        System.out.println(MovieList); //print the movielist
                        chooseMovie = input.nextLine(); //input from user
                        check2=true;
                    }

                    break;

                default:
                    
                    System.out.println("wrong choice please choose a movie from the following");
                    check2 = true;
                    System.out.println("which movie do you want ? ");
                    System.out.println(MovieList); //print the movielist
                    chooseMovie = input.nextLine(); //input from user
                    break;

            }
        } while (check2);
        
        
 //////////////////////////////////   //////////////////////////////////   //////////////////////////////////
       
        
     //Display the times availabe to the user
     System.out.println("\n\t      .'`~~~~~~~~~~~`'.\n"
            + "\t      (  .'11 12 1'.  )\n"
            + "\t      |  :10 \\    2:  |\n"
            + "\t      |  :9   @-> 3:  |\n"
            + "\t      |  :8       4;  |\n"
            + "\t      '. '..7 6 5..' .'\n"
            + " \t       ~-------------~ ");
         
        System.out.println("\t-----------------------------");
        System.out.println("\t××××    TIME AVAILABLE   ××××");
        System.out.println("\t=============================");
        System.out.println("\t#No.        TIME           ×");
        System.out.println("\t=============================");
        System.out.println("\t#1        6:00 AM          ×");
        System.out.println("\t#2        9:00 AM          ×");
        System.out.println("\t#3        12:00 AM         ×");
        System.out.println("\t#4        2:00 PM          ×");
        System.out.println("\t#5        6:00 PM          ×");
        System.out.println("\t#6        9:00 PM          ×");
        System.out.println("\t-----------------------------");
        System.out.print("\tpick a choice: ");
        time = input.nextInt();

        //checks if the users pick was out of range
        while (time < 1 || time > 6) {
            System.out.println("\n\tWrong choice!!!!!");
            System.out.print("\tpick a choice again:");
            time = input.nextInt();
        }

        //set the time that has been chosen
        switch (time) {
            case 1:
                movie.setMovieTime("6:00 AM ");
                break;

            case 2:
                movie.setMovieTime("9:00 AM");
                break;

            case 3:
                movie.setMovieTime("12:00 AM");
                break;

            case 4:
                movie.setMovieTime("2:00 PM");
                break;

            case 5:
                movie.setMovieTime("6:00 PM");
                break;

            case 6:
                movie.setMovieTime("9:00 PM");
                break;
        }
        
        System.out.println("\n\n============================================================================================================\n");
        
//////////////////////////////////   //////////////////////////////////   //////////////////////////////////
       
       //Display the screens availabe to the user
      
      System.out.println("\n\t.---..-----------------------------------------------..---.\n"
            + "\t|   ||.---------------------------------------------.||   |\n"
            + "\t| o ||| _0_o O/oo  _0_ \\O/ _   _0_  O_0_o_O/ooO _0_ ||| o |\n"
            + "\t| _ |||O oo _0_ _0_o\\O  _O/~'       O oo__0_ _0_o\\O ||| _ |\n"
            + "\t|(_)|||_0_ \\O oo        /)    _0_ \\O_0_ \\O oo       |||(_)|\n"
            + "\t|   |||---------------------------------------------|||   |\n"
            + "\t|.-.|||     __....------------------------....___   |||.-.|\n"
            + "\t| o |||---''                         _.--._      `  ||| o |\n"
            + "\t|`-'|||             _.--._          'O---O-'        |||`-'|\n"
            + "\t|   |||     _.--._ 'O---O-'_.--._  _.--._           |||   |\n"
            + "\t|.-.|||    'O---O-'       'O---O-''O---O-'          |||.-.|\n"
            + "\t| O |||__,,...,----------------------....___        ||| O |\n"
            + "\t|`-'||`---------------------------------------------'||`-'|\n"
            + "\t`---'`-----------------------------------------------'`---'\n"
            + "\t       _||_                                    _||_");

 
  
        System.out.println("\n\t\t    -----------------------------");
        System.out.println("\t\t    ××××  SCREENS AVAILABLE  ××××");
        System.out.println("\t\t    -----------------------------");
        System.out.println("\t\t    ××           TYPES         ××");
        System.out.println("\t\t    -----------------------------");
        System.out.println("\t\t    ×       Standard 60 SAR     ×");
        System.out.println("\t\t    ×        Prime 100 SAR      ×");
        System.out.println("\t\t    ×         VIP 150 SAR       ×");
        System.out.println("\t\t    -----------------------------");
    
        input.nextLine();
  
        System.out.print("\t\t    Which Screen do you like:");
        String chooseScreen = input.nextLine();
  

        //Do while to check users screen choice       
        do {
            switch (chooseScreen.toLowerCase()) {//Using switch to determine the next step based on the choice 
                case "standard":
                    check3 = false;
                    cost = 60;
                    System.out.println("\t\t    price : " + cost);

                    break;

                case "prime":
                    check3 = false;
                    cost = 100;
                    System.out.println("\t\t    price : " + cost);

                    break;

                case "vip":
                    check3 = false;
                    cost = 150;
                    System.out.println("\t\t    price : " + cost);
                   
                    break;

                default:
                    check3 = true;
                    System.out.print("\t\t    Wrong choice please choose a type from the list above :");
                    chooseScreen = input.nextLine();
                    

                    break;

            }

        } while (check3);

        /////////////////////////////////////////////////////////////////////////////////
   
        System.out.println("\n\n============================================================================================================\n\n");

        
        int userSeat;
        int choice;
        boolean boolcheck = true;
        ArrayList< Integer> bookedSeat = new ArrayList<>();//An array list to store each time a user selects a seat
           

        //Do while to check and continue the process of users choice/choices of seats
        do {
  
            //Display the screen
            System.out.println("\n              _ _.-'`-._ _\n"
                    + "             ;.’ SCREEN '.;\n"
                    + "  _________n.[____________].n_________\n"
                    + "| \"\"_\"\"_\"\"_\"\"||==||==||==||\"\"_\"\"_\"\"_”” |");

            System.out.println(Arrays.toString(reserve.getSeat()));//Calling the array
            System.out.print("\nWhich seat do you want:");
            userSeat = input.nextInt();
            
            //If the user picks a seat thats not ava
             if (userSeat>29) { //check if the user entered a taken seat or not
                System.out.println("Sorry!! that seat isnt available");
                System.out.print("Enter another seat:");
                userSeat = input.nextInt();
            }
            
            //When the user picks a seat thats is already taken
            if (Seat[userSeat].equals("X")) { //check if the user entered a taken seat or not
                System.out.println("Sorry! Seat taken.");
                System.out.print("Enter another seat:");
                userSeat = input.nextInt();
            }
            
         
            bookedSeat.add(userSeat);//Adds the choosen seat to the array list
            reserve.setSeatReserved(bookedSeat);//Sets the user bookedSeat
            Seat[userSeat] = "X";//Puts an X each time a the user picks a seat
            System.out.println("Would you like to booking another seat ? PLEASE Enter (0 for no or 1 for yes)");
            choice = input.nextInt();
            while (choice < 0 || choice > 1) {//Checks if the user inputs a choice out of the range 
                System.out.println("\nWrong!! Try again...");
                System.out.println("Would you like to booking another seat ? PLEASE Enter (0 for no or 1 for yes)");
                choice = input.nextInt();
            }
            //Process the user pick 
            if (choice == 1) {
                boolcheck = true;
            } else if (choice == 0) {
                boolcheck = false;
            }

        } while (boolcheck);


        
  

 //////////////////////////////////   //////////////////////////////////   //////////////////////////////////
 
       
        System.out.println("\n\n============================================================================================================\n\n");

        //Asks the user if they have a promocode or not
        System.out.println("Do you have a DISCOUNT CODE? (0 for no or 1 for yes)");
        int ask = input.nextInt();//Takes input from user
        
        input.nextLine();//consume next line
        boolean check4;
        int totalCost = 0; 
        String code;
        
        //Do while to check users choice
        do {
            switch (ask) {//Using switch to determine the next step based on the choice 
                case 1:
                    
                    System.out.println("Enter the DISCOUNT CODE:");
                    code = input.nextLine();
                    totalCost = reserve.TotalPriceWithDiscount(bookedSeat.size(), cost, code);
                    PaymentMethod(totalCost);
                    check4 = false;
                    break;
                    
                case 0:
                    
                    totalCost = reserve.TotalPrice(bookedSeat.size(), cost);
                    PaymentMethod(totalCost);
                    check4 = false;
                    break;

                default:
                    System.out.println("\nWrong!! Try again...");
                    System.out.println("Do you have a DISCOUNT CODE? (0 for no or 1 for yes)");
                    ask = input.nextInt();
                    check4 =true;
                break;
               
            }
        } while (check4);
        
        
        Reservation ticket=new Reservation(info,movie,bookedSeat,roomNO);//obj4 to then sent it to the WriteToFile method and display it
        int seatReserveNum = bookedSeat.size();//Assign bookedSeat size to then calculate total
        WriteToFile(chooseScreen, seatReserveNum, ticket, totalCost); //Calling WriteToFile method
        ReadFromFile(); //Calling ReadFromFile method
        
        
//////////////////////////////////   //////////////////////////////////   //////////////////////////////////
   
        System.out.println("\n\n\n\t\t  ___ _  _ ___     ___  ___   ___ ___  ___   ___ ___    _   __  __ \n"
                + "\t\t | __| \\| |   \\   / _ \\| __| | _ \\ _ \\/ _ \\ / __| _ \\  /_\\ |  \\/  |\n"
                + "\t\t | _|| .` | |) | | (_) | _|  |  _/   / (_) | (_ |   / / _ \\| |\\/| |\n"
                + "\t\t |___|_|\\_|___/   \\___/|_|   |_| |_|_\\\\___/ \\___|_|_\\/_/ \\_\\_|  |_|\n\n");
        
        
    }

//////////////////////////////////   //////////////////////////////////   //////////////////////////////////
    


    
//////////////////////////////////   //////////////////////////////////   //////////////////////////////////
   
    //Method for to process payment choices
    public static void PaymentMethod(int totalCost) {
        boolean checkpay;
        Scanner input = new Scanner(System.in);

        System.out.println("___________________________________________");
        System.out.println("\n×××××   SELECT YOUR PEYMENT METHOD    ×××××");
        System.out.println("===========================================");
        System.out.println("#No.             METHODS              ×××××");
        System.out.println("===========================================");
        System.out.println("#1                CARD                ×××××");
        System.out.println("#2              APPLE PAY             ×××××");
        System.out.println("#3                CASH                ×××××");
        System.out.println("___________________________________________");
        System.out.print("Enter your choice: ");

        int paymentChoice = input.nextInt();

        input.nextLine();//Consume line

        do {
            switch (paymentChoice) {
                case 1:
                    //input.nextLine();
                    System.out.println("\nEnter Your card number : ");
                    String cardNumber = input.nextLine();
                    System.out.println("Enter Your card password : ");
                    String cardPass = input.nextLine();

                    System.out.println("\nYour seat has been booked successfully... YAY !!!\n");
                    checkpay=false;
                    break;
                    
                case 2:
                    System.out.println("\nPlease Enter your Apple pay : ");
                    String applePay = input.nextLine();

                    System.out.println("\nYour seat has been booked successfully... YAY !!!\n");
                    checkpay=false;
                    break;

                case 3:
                    System.out.println("The total amount must be paid " + totalCost + " At the cashier's");
                    System.out.println("Your seat has been booked successfully.. YAY !!!\n");
                    checkpay=false;
                    break;

                default:
                    System.out.println("PLEASE TRY AGAIN!");
                    System.out.print("Enter your choice: ");
                    paymentChoice = input.nextInt();
                    checkpay = true;

                    break;

            }
        } while (checkpay);
    }

 
    //////////////////////////////////   //////////////////////////////////   //////////////////////////////////
 
    
    //Method to print info and details so it can be display later on
    public static void WriteToFile(String Screen, int seatReserveNO, Reservation all, int totalCost) throws IOException {
        
        PrintWriter write = new PrintWriter("ticket.txt");

        write.println("==================================");
        write.println("********      TICKET     ********");
        write.println("==================================");
        write.print(">>>>>    ENJOY THE MOVIE!    <<<<<\n"
                + all.toString()
                + "\nNumber of Seats Booked : " + seatReserveNO
                + "\nSCREEN : " + Screen.toUpperCase()
                + "\nCOST : " + totalCost + "SR\n"
                + "==================================");

        write.close();
    }

    
    //////////////////////////////////   //////////////////////////////////   //////////////////////////////////
    
    //Method to display the ticket to the user
    public static void ReadFromFile() throws IOException {
        File read = new File("ticket.txt");
        Scanner scan = new Scanner(read);

        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }

    }

    
    
}
