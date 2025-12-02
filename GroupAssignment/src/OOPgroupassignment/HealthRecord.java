/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPgroupassignment;
import java.util.Scanner;
//base class needs local date im just unsure how to implement it 
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author Akmal Zikry
 * @author doshyant
 */
public class HealthRecord {
    protected String name;
    protected int age;
    protected double weight;
    protected double height;
    

    
    public void HealthRecord(HealthTrackerApp menu){
        Scanner input = new Scanner (System.in);
        ActivityRecord activitygoal = new ActivityRecord();
        DietRecord dietgoal = new DietRecord();
        this.name = menu.getName();
        this.age = menu.getAge();
        this.weight = menu.getWeight();
        this.height = menu.getHeight();
        
        System.out.print("Welcome to your Health Record, what kind of record would you like to access?");
        System.out.print("\n Press 1 to view your Activity Record \n Press 2 to view Diet Record \n Press 3 to log out");
        int recordChoice = input.nextInt();
         
        while(recordChoice != 3){
            switch(recordChoice){
                case 1:
                    System.out.print("Your Activity Record: ");
                    break;
                
                case 2:
                    System.out.print("Your Diet Record: ");
                    break;
                    
                default:
                    System.out.print("IVALID INPUT!");
                    break;
            }
        }
    }
}
