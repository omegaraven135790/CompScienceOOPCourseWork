/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPgroupassignment;
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
    private LocalDate date;
    private int day;
    private int week;
    private int calorie;
    private int meals;
    private int water;
    private int steps;
    
    public int getDay(){return this.day;}
    public void setDay(int day){this.day = day;}
    
    public int getWeek(){return this.week;}
    public void setWeek(int week){this.week = week;}
    
    public int getCalorie(){return this.calorie;}
    public void setCalorie(int calorie){this.calorie = calorie;}
    
    public int getMeals(){return this.meals;}
    public void setMeals(int meals){this.meals = meals;}
    
    public int getWater(){return this.water;}
    public void setWater(int water){this.water = water;}
    
    public int getSteps(){return this.steps;}
    public void setSteps(int steps){this.steps = steps;}
    
    public String getName(){return this.name;}
    public void setName(String name){
        this.name = name;
        UpdateDate();
    }
    
    public int getAge(){return this.age;}
    public void setAge(int age){
        this.age = age;
        UpdateDate();
    }
    
    public double getWeight(){return this.weight;}
    public void setWeight(double weight){
        this.weight = weight;
        UpdateDate();
    }
    
    public double getHeight(){return this.height;}
    public void setHeight(double height){
        this.height = height;
        UpdateDate();
    }
    
    public HealthRecord(){
    this.name = "";
    this.age = 0;
    this.weight = 0.0;
    this.height = 0.0;
    this.date = LocalDate.now();
}
    
    public HealthRecord(String name, int age, double weight, double height){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.date = LocalDate.now();
    }
    
    public void displayAccountInfo() {
        System.out.print("\nUsername: " + this.name);
        System.out.print("\nAge: " + this.age);
        System.out.print("\nWeight: " + this.weight + " kg");
        System.out.print("\nHeight: " + this.height + " m");
        System.out.print("\nDate of Creation:" +date);
    }
    
    
    
    public String getDate(){
        return date.toString();
    }
    
    private void UpdateDate(){
        this.date = LocalDate.now();
    }
}
