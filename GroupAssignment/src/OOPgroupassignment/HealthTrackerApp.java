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
 */
public class HealthTrackerApp {
    private Scanner input = new Scanner(System.in);
    private HealthRecord data = new HealthRecord(); 
    private DietRecord dietgoal = new DietRecord();
    private ActivityRecord activitygoal = new ActivityRecord();

    
    public static void main(String[]args){
        HealthTrackerApp menu = new HealthTrackerApp();
        menu.SetData();
    }
    public void SetData(){
        System.out.print("Welcome to LifeTracker! \n Please enter a username: ");
        String name = input.nextLine();
        data.setName(name);
        boolean valid = false;
        while(!valid){
            try{
                System.out.print("\nEnter your age: ");
                int age = input.nextInt();
                if(age <=0){
                    System.out.print("Age must be above 0, Try again");
                    continue;
                }
                
                System.out.print("\nEnter your weight in kg: ");
                double weight = input.nextDouble();
                if(weight <= 0){
                    System.out.print("Weight must be above 0, Try again");
                    continue;
                }
                
                System.out.print("\nEnter your height in metres: ");
                double height = input.nextDouble();
                if(height <= 0){
                    System.out.print("Height must be above 0, Try again");
                    continue;
                }
                
                data.setAge(age);
                data.setWeight(weight);
                data.setHeight(height);
                
                valid = true;
            }
            catch(Exception e){
                System.out.print("Invalid value! Try again");
                input.nextLine();
            }
        }
        System.out.print("\nThank you for filling your information!\nTaking you to main menu...");
        MainMenu(data);
    }
    
    public void MainMenu(HealthRecord data){
   
        boolean running = true;
        
        while(running){
            System.out.print("\nWelcome to Lifetracker menu! what record would you like to see?");
            System.out.print("\nPress 1 to view account information,");
            System.out.print("\nPress 2 to edit account information,");
            System.out.print("\nPress 3 to access Diet Record,");
            System.out.print("\nPress 4 to access Activity Record,");
            System.out.print("\nPress 5 to log out: ");
            int choice = input.nextInt();
            input.nextLine();
            switch(choice){
                case 1:
                    System.out.print("\nYour Information: ");
                    data.displayAccountInfo();
                    break;
                case 2:
                    EditAccount();
                    break;
                case 3:
                    DietMenu();
                    break;
                case 4:
                    ActivityMenu();
                    break;
                case 5:
                    System.out.print("\nLogging out...");
                    running = false;
                    break;
                default:
                    System.out.print("\nInvalid input! Please try again");
            }
        }
    }
    
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
    
    public void DietMenu(){
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
                        System.out.print("Insert your calorie intake: ");
                        int calorie = input.nextInt();
                        System.out.print("Insert how many meals is taken: ");
                        int meals = input.nextInt();
                        System.out.print("Insert amount of water drunk: ");
                        int water = input.nextInt();
                    
                        dietgoal.setNewRecord(calorie, meals, water);
                        System.out.print("Record successfully saved");
                    }
                    catch(Exception e){
                        System.out.print("Invalid input! try again");
                        input.nextLine();
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
                        System.out.print("Insert amount of water drunk: ");
                        int water = input.nextInt();
                    
                        dietgoal.setNewRecord(year, day, week, calorie, meals, water, post);
                        System.out.print("Record added successfully!");
                    }
                    catch(Exception e){
                        System.out.print("Invalid input");
                        input.nextLine();
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
                        System.out.print("New water amount: "); int newWater = input.nextInt();
                        
                        dietgoal.setNewRecord(newYear, newDay, newWeek, newCalorie, newMeal, newWater, post);
                        System.out.print("Record changed succesfully!");
                    
                    }
                    catch(Exception e){
                        System.out.print("Invalid input");
                        input.nextLine();
                    }
                    break;
                case 4:
                    try{
                        System.out.print("What field would you like to check? (day/week/calorie/meal/water): ");
                        String field = input.nextLine();
                        System.out.print("Insert condition value: ");
                        int conditionValue = input.nextInt();
                        System.out.print("Insert the new value: ");
                        int newValue = input.nextInt();
                        
                        dietgoal.ChangeRecord(newValue, conditionValue, field);
                        System.out.print("Record changed successfully!");
                    }
                    catch(Exception e){
                        System.out.print("Invalid input");
                        input.nextLine();
                    }
                case 5:
                    System.out.print("\nYour Diet Record: ");
                    dietgoal.displayDiet();
                    break;
                case 6:
                    System.out.print("\nYour Average Diet Records: \n ");
                    dietgoal.average();
                    break;
                case 7:
                    run = false;
                    break;
                default:
                    System.out.print("Invalid input");
                    break;
            }
        }
    }
    
    public void ActivityMenu(){
        boolean run = true;
        
        while(run){
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
                        activitygoal.setNewRecord(steps);
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
                        
                        activitygoal.setNewRecord(year, day, week, steps, post);
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
                        
                        activitygoal.setNewRecord(newYear, newDay, newWeek, newSteps, post);
                        System.out.print("Record successfully changed!");
                    }
                    catch(Exception e){
                        System.out.print("Invalid input");
                        input.nextLine();
                    }
                 break;
                case 4:
                    try{
                        System.out.print("What field would you like to check? (day/week/steps)");
                        String field = input.nextLine();
                        System.out.print("Insert condition value: ");
                        int conditionValue = input.nextInt();
                        System.out.print("Insert new Value: ");
                        int newValue = input.nextInt();
                        
                        activitygoal.ChangeRecord(newValue, conditionValue, field);
                        System.out.print("Record changed succesfully!");
                    }
                    catch(Exception e){
                        System.out.print("Invalid input");
                        input.nextLine();
                    }
                case 5:
                    System.out.print("\nYour Activity Record: ");
                    activitygoal.displayActivity();
                    break;
                case 6:
                    System.out.print("\nYour Average Activity Records: \n ");
                    activitygoal.average();
                    break;
                case 7:
                    run = false;
                    break;
                default:
                    System.out.print("Invalid input");
                    break;
            }
        }
    }
} 