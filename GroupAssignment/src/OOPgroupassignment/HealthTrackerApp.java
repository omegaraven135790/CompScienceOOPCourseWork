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
    public static void main(String[]args){
        HealthTrackerApp menu = new HealthTrackerApp();
        menu.SetData();
    }
    public void SetData(){
        Scanner input = new Scanner(System.in);
        HealthRecord data = new HealthRecord();
        System.out.print("Welcome to LifeTracker! \n Please enter a username: ");
        String name = input.nextLine();
        data.setName(name);
        System.out.print("\nEnter your age: ");
        int age = input.nextInt();
        data.setAge(age);
        System.out.print("\nEnter your weight: ");
        double weight = input.nextDouble();
        data.setWeight(weight);
        System.out.print("\nEnter your height: ");
        double height = input.nextDouble();
        data.setHeight(height);
        System.out.print("\nThank you for filling your information!\nTaking you to main menu...");
        MainMenu(data);
    }
    
    public void MainMenu(HealthRecord data){
   
        boolean running = true;
        
        while(running){
            Scanner input = new Scanner(System.in);
            ActivityRecord activitygoal = new ActivityRecord();
            DietRecord dietgoal = new DietRecord();
            System.out.print("\nWelcome to Lifetracker menu! what record would you like to see?");
            System.out.print("\nPress 1 to view account information,");
            System.out.print("\nPress 2 to view Diet Record,");
            System.out.print("\nPress 3 to view Activity Record,");
            System.out.print("\nPress 4 to log out: ");
            int choice = input.nextInt();
            switch(choice){
                case 1:
                    System.out.print("\nYour Information: ");
                    data.displayAccountInfo();
                    break;
                case 2:
                    System.out.print("What is your calorie intake today?: ");
                    int calorie = input.nextInt();
                    data.setCalorie(calorie);
                    System.out.print("How many meals did you take today?: ");
                    int meals = input.nextInt();
                    data.setMeals(meals);
                    System.out.print("How many litres of water have you drunk?: ");
                    int waterDrunk = input.nextInt();
                    data.setWater(waterDrunk);
                    dietgoal.displayDiet();
                    break;
                case 3:
                    System.out.print("how many steps have you taken today?: ");
                    int steps = input.nextInt();
                    data.setSteps(steps);
                    activitygoal.displayActivity();
                    break;
                case 4:
                    System.out.print("\nLogging out...");
                    running = false;
                    break;
                default:
                    System.out.print("\nInvalid input! Please try again");
            }
        }
    }
} 
