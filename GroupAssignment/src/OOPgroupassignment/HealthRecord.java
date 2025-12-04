/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPgroupassignment;
//base class needs local date im just unsure how to implement it 
import java.time.LocalDate;
/**
 *
 * @author Akmal Zikry
 * @author doshyant
 */
public class HealthRecord {
    private String name;
    private int age;
    private double weight;
    private double height;
    protected LocalDate date;
    private int calorie;
    private int meals;
    private int waterDrunk;
    private int steps;
    
    public int getCalorie(){return this.calorie;}
    public void setCalorie(int calorie){this.calorie = calorie;}
    
    public int getMeals(){return this.meals;}
    public void setMeals(int meals){this.meals = meals;}
    
    public int getWater(){return this.waterDrunk;}
    public void setWater(int waterDrunk){this.waterDrunk = waterDrunk;}
    
    public int getSteps(){return this.steps;}
    public void setSteps(int steps){this.steps = steps;}
    
    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
    
    public int getAge(){return this.age;}
    public void setAge(int age){this.age = age;}
    
    public double getWeight(){return this.weight;}
    public void setWeight(double weight){this.weight = weight;}
    
    public double getHeight(){return this.height;}
    public void setHeight(double height){this.height = height;}
    
    public HealthRecord(){
    this.name = "";
    this.age = 0;
    this.weight = 0.0;
    this.height = 0.0;
}
    
    public HealthRecord(String name, int age, double weight, double height){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;      
    }
    
    public void displayAccountInfo() {
        System.out.println("Username: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Weight: " + this.weight + " kg");
        System.out.println("Height: " + this.height + " m");
    }
    
    public String getDate(){
        LocalDate date = LocalDate.now();
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();
        
        String formatDate = day + "-" + month + "-" + year;
        
        return formatDate;
    }
}
