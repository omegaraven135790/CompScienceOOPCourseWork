/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPgroupassignment;
import java.util.Scanner;
/**
 *
 * @author Akmal Zikry
 * @author Doshyant Raj
 * 
 * This class is where user inputs data and returns all values from dietrecord and activitrecord
 * Class uses try and catch for exception handling to ensure all values input is correct
 * Class has functions to create a main menu, menu to edit and view diet record, and menu to edit and view activityrecord
 * 
 */
public class HealthTrackerApp {
    //make access modifiers for all the different classes and object for Scanner
    private Scanner input = new Scanner(System.in);
    private HealthRecord data; 
    private DietRecord dietgoal;
    private ActivityRecord activitygoal;

    
    public static void main(String[]args){
        //create object for healthapp to allow main to call functions and call function to set user data
        HealthTrackerApp menu = new HealthTrackerApp();
        menu.SetData();
    }

    //function to set user data
    public void SetData(){
        System.out.print("Welcome to LifeTracker! \n Please enter a username: ");
        String name = input.nextLine();
        data = new HealthRecord(); //create object for healthrecord
        data.setName(name); //set name into setter method in healthrecord
        int age= 0;
        double weight = 0;
        double height = 0;
        boolean valid = false;
        while(!valid){ //while loop used to make sure all data is correct when setting user data
            try{ //try and catch is used for exception handling in healthtrackerapp
                System.out.print("\nEnter your age: ");
                age = input.nextInt();
                if(age <=0){ //used to make sure age, height and weight is above 0
                    System.out.print("Age must be above 0, Try again");
                    continue;
                }
                
                System.out.print("\nEnter your weight in kg: ");
                weight = input.nextDouble();
                if(weight <= 0){
                    System.out.print("Weight must be above 0, Try again");
                    continue;
                }
                
                System.out.print("\nEnter your height in metres: ");
                height = input.nextDouble();
                if(height <= 0){
                    System.out.print("Height must be above 0, Try again");
                    continue;
                }
                
                //set age, weight and height into setter method
                data.setAge(age);
                data.setWeight(weight);
                data.setHeight(height);
                
                valid = true; //ends while loop
            }
            catch(Exception e){
                System.out.print("Invalid value! Try again");
                input.nextLine(); //used to clear Scanner newline
            }
        }
        
        /**
         * create object for dietrecord and activityrecord
         * setter method is called onto dietgoal here so value can be used in dietrecord
        */
        dietgoal = new DietRecord();
        dietgoal.setAge(age);
        dietgoal.setWeight(weight);
        dietgoal.setHeight(height);
        activitygoal = new ActivityRecord();
        
        System.out.print("\nThank you for filling your information!\nTaking you to main menu...");
        MainMenu(data,dietgoal,activitygoal); //calls function to the mainmenu
    }
    
    //function to view and access diet and activity record as well as view and change user data
    public void MainMenu(HealthRecord data, DietRecord dietgoal, ActivityRecord activitygoal){
   
        boolean running = true;
        
        //while loop used so the user can keep doing things in the program until they wish to log out
        while(running){
            try{
            System.out.print("\nWelcome to Lifetracker menu! what record would you like to see?");
            System.out.print("\nPress 1 to view account information,");
            System.out.print("\nPress 2 to edit account information,");
            System.out.print("\nPress 3 to access Diet Record,");
            System.out.print("\nPress 4 to access Activity Record,");
            System.out.print("\nPress 5 to log out: ");
            int choice = input.nextInt();
            input.nextLine();
            switch(choice){ //switch case is used to account for all available inputs
                case 1:
                    System.out.print("\nYour Information: ");
                    data.displayAccountInfo(); //display user data
                    break;
                case 2:
                    EditAccount(); //edit user data
                    break;
                case 3:
                    DietMenu(data); //call function to menu for dietrecord
                    break;
                case 4:
                    ActivityMenu(); //call function to menu for activityrecord
                    break;
                case 5:
                    System.out.print("\nLogging out...");
                    running = false; //breaks while loop and end program
                    break;
                default:
                    System.out.print("\nInvalid input! Please try again");
            }
            }
            catch(Exception e){
                System.out.print("Invalid value! Try again");
                input.nextLine(); //used to clear Scanner newline
            }
        }
    }
    
    //function to edit user data
    public void EditAccount(){
        System.out.print("Insert new username: ");
        String newUsername = input.nextLine();
        data.setName(newUsername);
        
        boolean datavalid = false;
        
        while(!datavalid){
            try{
                System.out.print("Enter your age: ");
                int newAge = input.nextInt();
                if(newAge <=0){
                    System.out.print("Age must be above 0, Try again");
                    continue;
                }
                
                System.out.print("Enter your weight in kg: ");
                double newWeight = input.nextDouble();
                if(newWeight <= 0){
                    System.out.print("Weight must be above 0, Try again");
                    continue;
                }
                
                System.out.print("Enter your height in metres: ");
                double newHeight = input.nextDouble();
                if(newHeight <= 0){
                    System.out.print("Height must be above 0, Try again");
                    continue;
                }
                
                data.setAge(newAge);
                data.setWeight(newWeight);
                data.setHeight(newHeight);
                
                datavalid = true;
                System.out.print("Account updated successfully!");
            }
        
            catch(Exception e){
                System.out.print("Invalid input");
                input.nextLine();
            }
        }
        
    }
    
    //function for user to add and edit record in dietrecord and displays the options.
    public void DietMenu(HealthRecord data){
        boolean run = true;
        while(run){
            System.out.print("You are now at Diet Record \nWhat do you plan to do?");
            System.out.print("\nPress 1 to add data for diet record");
            System.out.print("\nPress 2 to insert new data by position");
            System.out.print("\nPress 3 to update record by position");
            System.out.print("\nPress 4 to update record by condition");
            System.out.print("\nPress 5 to view Diet Record");
            System.out.print("\nPress 6 to view your average Diet Record");
            System.out.print("\nPress 7 to return to main menu: ");
            int choice = input.nextInt();
            input.nextLine();
            switch(choice){
                case 1:
                    try{
                        System.out.print("Insert your calorie intake: ");//prompt the user for relevant data that they must input
                        int calorie = input.nextInt();
                        System.out.print("Insert how many meals is taken: ");
                        int meals = input.nextInt();
                        System.out.print("Insert amount of water drunk in liters: ");
                        int water = input.nextInt();
                    
                        dietgoal.setNewRecord(calorie, meals, water); // Insert data input into a dietrecord
                        System.out.println("Record successfully saved");
                    }
                    catch(Exception e){
                        System.out.print("Invalid input! try again");
                        input.nextLine();//clear the scanner for next inputs
                    }
                    break;
                case 2:
                    try{
                        System.out.print("What position would you like? Start from 0: ");
                        int post = input.nextInt();
                        System.out.print("Insert year: ");
                        int year = input.nextInt();
                        System.out.print("Insert day: ");
                        int day = input.nextInt();
                        System.out.print("Insert week: ");
                        int week = input.nextInt();
                        System.out.print("Insert your calorie intake: ");
                        int calorie = input.nextInt();
                        System.out.print("Insert how many meals is taken: ");
                        int meals = input.nextInt();
                        System.out.print("Insert amount of water drunk in liters: ");
                        int water = input.nextInt();
                    
                        dietgoal.setNewRecord(year, day, week, calorie, meals, water, post); //Insert data input into dietrecord into a specific position in array list
                        System.out.print("Record added successfully!");
                    }
                    catch(Exception e){
                        System.out.print("Invalid input");
                        input.nextLine();//clear the scanner for next inputs
                    }
                    break;
                case 3:
                    try{
                        System.out.print("What position would you like to change(start from 0): ");
                        int post = input.nextInt();
                        System.out.print("New Year: "); int newYear = input.nextInt();
                        System.out.print("New week: "); int newWeek = input.nextInt();
                        System.out.print("New day: "); int newDay = input.nextInt();
                        System.out.print("New calorie: "); int newCalorie = input.nextInt();
                        System.out.print("New meal amount: "); int newMeal = input.nextInt();
                        System.out.print("New water amount in liters: "); int newWater = input.nextInt();
                        
                        dietgoal.ChangeRecord(newYear, newDay, newWeek, newCalorie, newMeal, newWater, post); //change record in dietrecord based on array list position                       
                        input.nextLine();//clear the scanner for next inputs
                    
                    }
                    catch(Exception e){
                        System.out.print("Invalid input");
                        input.nextLine();
                    }
                    break;
                case 4:
                    try{
                        System.out.print("What field would you like to check? (year/week/day/calories/meal/waterDrunk): ");
                        String field = input.nextLine();
                        System.out.print("Insert condition value: ");
                        int conditionValue = input.nextInt();
                        System.out.print("Insert the new value: ");
                        int newValue = input.nextInt();
                        
                        dietgoal.ChangeRecord(newValue, conditionValue, field); //change specific record based on condition
                        System.out.print("Record changed successfully!");
                        input.nextLine();
                    }
                    catch(Exception e){
                        System.out.print("Invalid input");
                        input.nextLine();
                        
                    }
                    break;
                case 5:
                    System.out.print("\nYour Diet Record:\n ");
                    dietgoal.displayDiet(); //display dietrecord
                    break;
                case 6:
                    System.out.print("\nYour Average Diet Records: \n ");
                    dietgoal.average(); //shows average of all dietrecord
                    break;
                case 7:
                    run = false; //returns user to main menu
                    break;
                default:
                    System.out.print("Invalid input");
                    break;
            }
        }
    }
    
    //function for user to add and change record in activityrecord
    public void ActivityMenu(){
        boolean run = true;
        
        while(run)//display options for user to choose from relating to their acitvity record
            {
            System.out.print("\nYou are now at Activity Record. \nWhat would you like to do?");
            System.out.print("\nPress 1 to insert data into record");
            System.out.print("\nPress 2 to insert data into record by position");
            System.out.print("\nPress 3 to update record by position");
            System.out.print("\nPress 4 to update record by condition");
            System.out.print("\nPress 5 to view Activity Record");
            System.out.print("\nPress 6 to view your average Activity Record");
            System.out.print("\nPress 7 to return to main menu: ");
            int choice = input.nextInt();
            input.nextLine();
            switch(choice){
                case 1:
                    try{
                        System.out.print("Insert amout of steps taken: ");
                        int steps = input.nextInt();                  
                        activitygoal.setNewRecord(steps); //insert data into activityrecord
                        System.out.print("Record succesfully added");
                    }
                    catch(Exception e){
                        System.out.print("Invalid input");
                        input.nextLine();
                    }
                    break;
                case 2:
                    try{
                        System.out.print("What position would you want? Start from 0: ");
                        int post = input.nextInt();
                        System.out.print("Insert year: ");
                        int year = input.nextInt();
                        System.out.print("Insert day: ");
                        int day = input.nextInt();
                        System.out.print("Insert week: ");
                        int week = input.nextInt();
                        System.out.print("Insert amount of steps taken: ");
                        int steps = input.nextInt();
                        
                        activitygoal.setNewRecord(year, day, week, steps, post); //insert data input into activityrecord based on specified position in arraylist
                        System.out.print("Record added successfully!");
                    }
                    catch(Exception e){
                        System.out.print("Invalid input");
                        input.nextLine();
                    }
                    break;
                case 3:
                    try{
                        System.out.print("What position would you like to change? Start from 0: ");
                        int post = input.nextInt();
                        System.out.print("New Year: "); int newYear = input.nextInt();
                        System.out.print("New week: "); int newWeek = input.nextInt();
                        System.out.print("New day: "); int newDay = input.nextInt();
                        System.out.print("New steps taken: "); int newSteps = input.nextInt();
                        
                        activitygoal.ChangeRecord(newYear, newDay, newWeek, newSteps, post); //change record in activityrecord based on arraylist position
                        
                    }
                    catch(Exception e){
                        System.out.print("Invalid input");
                        input.nextLine();
                    }
                 break;
                case 4:
                    try{
                        System.out.print("What field would you like to check? (week/day/steps): ");
                        String field = input.nextLine();
                        System.out.print("Insert condition value: ");
                        int conditionValue = input.nextInt();
                        System.out.print("Insert new Value: ");
                        int newValue = input.nextInt();
                        
                        activitygoal.ChangeRecord(newValue, conditionValue, field); //change specific record based on condition
                        System.out.print("Record changed succesfully!");
                    }
                    catch(Exception e){
                        System.out.print("Invalid input");
                        input.nextLine();
                    }
                    break;
                case 5:
                    System.out.print("\nYour Activity Record: ");
                    activitygoal.displayActivity(); //display activityrecord
                    break;
                case 6:
                    System.out.print("\nYour Average Activity Records: \n ");
                    activitygoal.average(); //show average of all activityrecord
                    break;
                case 7:
                    run = false; //return to main menu
                    break;
                default:
                    System.out.print("Invalid input");
                    break;
            }
        }
    }
} 
