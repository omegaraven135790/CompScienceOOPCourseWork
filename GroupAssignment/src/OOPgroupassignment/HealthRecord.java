/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPgroupassignment;
import java.time.LocalDate;
import java.util.Calendar;
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
    protected Calendar calendar;
    protected LocalDate date;
    protected int day;
    protected int week;
    protected int year;

    public int getDay(){return this.day;}
    public void setDay(int day){this.day = day;}
    
    public int getWeek(){return this.week;}
    public void setWeek(int week){this.week = week;}
    
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
        this.weight = 0;
        this.height = 0;
        this.date = LocalDate.now();
        this.calendar = Calendar.getInstance();
        this.day = calendar.get(Calendar.DAY_OF_WEEK);
        this.week = calendar.get(Calendar.WEEK_OF_YEAR);
        this.year = calendar.get(Calendar.YEAR);
    }

    public HealthRecord(String name, int age, double weight, double height){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.date = LocalDate.now();
        this.calendar = Calendar.getInstance();
        this.day = calendar.get(Calendar.DAY_OF_WEEK);
        this.week = calendar.get(Calendar.WEEK_OF_YEAR);
        this.year = calendar.get(Calendar.YEAR);

        
        
    }
    
    public void displayAccountInfo() {
        System.out.print("\nUsername: " + this.name);
        System.out.print("\nAge: " + this.age);
        System.out.print("\nWeight: " + this.weight + " kg");
        System.out.print("\nHeight: " + this.height + " m");
        System.out.print("\nDate Today:" +date);   

    }
    
    
    
    public String getDate(){
        return date.toString();
    }
    
    private void UpdateDate(){
        this.date = LocalDate.now();
    }


}
