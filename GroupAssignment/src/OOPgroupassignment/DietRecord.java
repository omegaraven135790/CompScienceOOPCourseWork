/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPgroupassignment;

import java.util.ArrayList;

/**
 *
 * @author Akmal Zikry
 * @author Doshyant Raj
 */
public class DietRecord extends HealthRecord{
     private ArrayList<int[]> TrackDiet = new ArrayList<>();
     private final int column_length = 6;
     private int array_length = TrackDiet.size();     
     private int condition_position; //used in the switch statement in the 2nd overide of ChangeRecord and the for loop to specify at what condition met should the data be altered
    

    public void setNewRecord( int calories, int meals, int waterDrunk )//used to insert a new record into the list, the record must include the data that is parsed inside to track things properly
    {
        
        int newRecord[] = {this.year,this.week,this.day,calories,meals,waterDrunk};
        if(newRecord.length !=6)
        {
            System.out.println("invalid input, you must provide the calories,meals and waterDrunk to be able to add a new log, include position to insert it at a specific place");
            return;
        }
        else
        {
            TrackDiet.add(newRecord);
        }
    }

    public void setNewRecord(int year,int day, int week,int calories, int meals, int waterDrunk, int position )//Like above but with a specified posiiton to insert it into
    {
        
        int newRecord[] = {year,week,day,calories,meals,waterDrunk};
            if(newRecord.length !=6)
            {
                System.out.println("invalid input, you must provide the calories,meals and waterDrunk to be able to add a new log, include position to insert it at a specific place");
                return;
            }
            else
            {
                TrackDiet.add(position,newRecord);
            }
    }

    public int GetLength() // returns length of the ArrayList
    {
        array_length = TrackDiet.size(); 
        return array_length;
    }

    public void ChangeRecord(int year,int day, int week, int calories, int meals, int waterDrunk, int position )// used to change a specific record in the table at a specified position
    {
        int ChangeRecord[] ={year,week,day,calories,meals,waterDrunk};
        TrackDiet.set(position,ChangeRecord);       
    }

        public void ChangeRecord(int changeValue, int condition_value, String condition_checked )// used to change a specific record in the table where a requirement is met and to change just 1 element there
    {
        
        switch(condition_checked)
        {
            case "year":
                condition_position = 0;
                break;
            case "week":
                condition_position = 1;
                break;
            case "day":
                condition_position = 2;
                break;
            case "calories":
                condition_position = 3;
                break;
            case "meals":
                condition_position = 4;
                break;
            case "waterDrunk":
                condition_position = 5;
                break;


            default:
                System.out.println("invalid condition being checked, the valid conditions to be checked are: \n day \n week \n calories \n meals \n waterDrunk \n");
                break;
        }

        for(int i = 0;i<array_length;i++)//once which condition to be changed has been found it is changed everywhere the requirment is met
        {
                if(TrackDiet.get(i)[condition_position]== condition_value)
                {
                    TrackDiet.get(i)[condition_position] = changeValue;
                }
        }
    }

    public void displayDiet()
    {
        for(int i = 0;i<array_length;i++)
        {

            System.out.println("year:" +TrackDiet.get(i)[0] + "\tweek:" +TrackDiet.get(i)[1] + "\tday:" + TrackDiet.get(i)[2] + "\tcalories:" + TrackDiet.get(i)[3] + "\tmeals:" + TrackDiet.get(i)[4] + "\t water drunk(in leters)" + TrackDiet.get(i)[5]);
/*             for(int j = 0; j<column_length;j++)
            {
            System.out.print(TrackDiet.get(i)[j] + "\t");
            } */
        }
    }

}
