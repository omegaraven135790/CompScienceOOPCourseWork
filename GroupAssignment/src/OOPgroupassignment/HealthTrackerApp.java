/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPgroupassignment;
import java.util.Scanner;
/**
 *
 * @author Akmal Zikry
 */
public class HealthTrackerApp {
    private String name;
    private int age;
    private double weight;
    private double height;
    
    public static void main(String[]args){
        HealthTrackerApp menu = new HealthTrackerApp();
        HealthRecord data = new HealthRecord();
        
        menu.setData(data);
        menu.MainMenu(data);
    }
    
    public void setData(HealthRecord data){
        Scanner input = new Scanner (System.in);
        System.out.print("Hello \n Welcome to the Health tracker App!");
        
        System.out.print("\n Please enter a username: ");
        String username = input.nextLine();
        this.name = username;
        
        System.out.print("\n Please enter your age: ");
        int userAge = input.nextInt();
        this.age = userAge;
        
        System.out.print("\n Please enter your weight: ");
        double userWeight = input.nextDouble();
        this.weight = userWeight;
        
        System.out.print("\n Please enter your height: ");
        double userHeight = input.nextDouble();
        this.height = userHeight;
    }
    
    public void MainMenu(HealthRecord data){
        boolean systemUp = true;
        
        while(systemUp == true){
            Scanner input = new Scanner(System.in);
         System.out.print("Welcome to the ever the health tracking app so you get to start living healthy!");
            System.out.print ("\nInsert an input to get started\n Press 1 to view your health information: \n Press 2 to log out and leave: ");
            int choice = input.nextInt();
            switch(choice){
                case 1:
                    System.out.print("\n Your health record is: ");
                    //Declare the function here but for now hv a line)
                    System.out.print("u fat af bro");
                    systemUp = false;
                    break;
            
                case 2:
                    System.out.print("Logging out");
                    systemUp = false;
                    break;
            
                default:
                    System.out.print("INVALIDE INPUT!");
                    systemUp = false;
                    break;
            }
        }
    }
    
    //lets other parts of the program read and access the private things (which begs the question why make it private to begin with)
    public String getName(){return this.name;}
    public int getAge(){return this.age;}
    public double getWeight(){return this.weight;}
    public double getHeight(){return this.height;}
}
