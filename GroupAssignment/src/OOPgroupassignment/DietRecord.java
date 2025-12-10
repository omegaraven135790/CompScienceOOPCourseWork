/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPgroupassignment;
import java.math.*;
import java.util.ArrayList;

/**
 *
 * @author Akmal Zikry
 * @author Doshyant Raj
 * 
 * Class is a derived class of healthrecord
 * Class takes input from healthtrackerapp to create or edit records for dietrecord
 * Class uses arraylist to store diet records
 * 
 */
public class DietRecord extends HealthRecord{
    //Make a array list to store records in 
     private ArrayList<int[]> TrackDiet = new ArrayList<>();
     private final int column_length = 6;
     private int array_length = TrackDiet.size();     
     private int condition_position; //used in the switch statement in the 2nd overide of ChangeRecord and the for loop to specify at what condition met should the data be altered
    

    public void setNewRecord( int calories, int meals, int waterDrunk )//used to insert a new record into the list, the record must include the data that is parsed inside to track things properly
    {
        
        int newRecord[] = {this.year,this.week,this.day,calories,meals,waterDrunk};  //create new array to store user input from healthtrackerapp
        if(newRecord.length !=column_length) //if the user record length is not the same as column lenght this message appears
        {

            
            System.out.println("invalid input, you must provide the calories,meals and waterDrunk to be able to add a new log, include position to insert it at a specific place");
            return;
        }
        else
        {
            TrackDiet.add(newRecord); //new record is added into array list 
            array_length = TrackDiet.size();
        }
    }

    public void setNewRecord(int year,int day, int week,int calories, int meals, int waterDrunk, int position )//Like above but with a specified posiiton to insert it into
    {
        
        int newRecord[] = {year,week,day,calories,meals,waterDrunk};
            if(newRecord.length !=column_length)
            {
                System.out.println("invalid input, you must provide the calories,meals and waterDrunk to be able to add a new log, include position to insert it at a specific place");
                return;
            }
            else if(position > array_length)
            {
                TrackDiet.add(newRecord); /*new record is added into array list at the end of the array as otherwise it would cause an error, it doenst make sense 
                 to inform the user of this error though since this will have a simialr effect to if we had implemented it another way */
            
            }

            else
            {
                TrackDiet.add(position,newRecord); //new record is added into the specific position in array list
                
            }
            array_length = TrackDiet.size();
    }

    public int GetLength() // returns length of the ArrayList
    {
        array_length = TrackDiet.size(); 
        return array_length;
    }

    public void ChangeRecord(int year,int day, int week, int calories, int meals, int waterDrunk, int position )// used to change a specific record in the table at a specified position
    {
        int ChangeRecord[] ={year,week,day,calories,meals,waterDrunk};

         if(ChangeRecord.length !=column_length) // check if they have inserted the correcct amount of data
            {
                System.out.println("invalid input, you must provide the calories,meals and waterDrunk to be able to add a new log, include position to insert it at a specific place");
                return;
            }
        else if(position > array_length) // check if the position selcected is invalid
            {
                System.out.println("invalid position, position exceeds length of array which is " + array_length);
                return;
            }
            else
            {
                TrackDiet.set(position,ChangeRecord);  //replace record from position with changed record
            }
             
    }

        public void ChangeRecord(int changeValue, int condition_value, String condition_checked )// used to change a specific record in the table where a requirement is met and to change just 1 element there
    {
        
        switch(condition_checked) //checks what specific element in a record is to be changed
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
        System.out.println("Records updated succesfully."); // indication to the user that the task has been completed succesfully
    }

    public void displayDiet()
    {
        array_length = TrackDiet.size(); //takes length of array and displays it 
        for(int i = 0;i<array_length;i++)
        {

            System.out.println("year:" +TrackDiet.get(i)[0] + "\tweek:" +TrackDiet.get(i)[1] + "\tday:" + TrackDiet.get(i)[2] + "\tcalories:" + TrackDiet.get(i)[3] + "\tmeals:" + TrackDiet.get(i)[4] + "\t water drunk:" + TrackDiet.get(i)[5]+ "L");

        }
    }

    /** 
    * Function takes the total amount for each element in dietrecord 
    * And divides it to see if the user has a healthy diet
    */
    public void average()
    {
        array_length = TrackDiet.size();

        if(array_length == 0){
            System.out.println("No diet records to calculate averages.");
            return;
        }
        int total_calories = 0;
        int total_meals = 0;
        int total_water = 0;
        for(int i = 0;i<array_length;i++)
        {
            total_calories += TrackDiet.get(i)[3];
            total_meals += TrackDiet.get(i)[4];
            total_water += TrackDiet.get(i)[5];
        }
        double BMR = (66.47 +(this.weight*13.75 ) +(5*this.height*100)-(6.755*this.age)+5.0); 
        long roundedAverage = Math.round(BMR); //rpunds of BMR number to nearest integer
        if(total_calories/array_length <BMR )
        {
            System.out.println("You are consuming less calories than your BMR recommends. Consider increasing your calorie intake to " + roundedAverage + " for better health.");
        }
        else if(total_calories/array_length >BMR )
        {
            System.out.println("You are consuming more calories than your BMR recommends. Consider reducing your calorie intake to " + roundedAverage + " for better health.");
        }
        else
        {
            System.out.println("Your average calorie intake is" + total_calories/array_length + " and it is aligned with your BMR recommendations. Keep up the good work!");
        }

        if (total_meals/array_length <3 )
        {
            System.out.println("You are having less than 3 meals a day. Consider having at least 3 balanced meals for better nutrition.");
        }
        else if(total_meals/array_length >5 )
        {
            System.out.println("You are having more than 5 meals a day. Consider reducing your meal frequency to avoid overeating.");
        }
        else
        {
            System.out.println("Your average meal intake is " + total_meals/array_length + " which is within the recommended range. Keep it up!");
        }

        if((total_water/array_length) > 2 )
        {
            System.out.println("Great job! You are drinking enough water with an average of " + (total_water/array_length) + "L per day.");
        } 
        else 
        {
            System.out.println("You might want to increase your water intake. Your average is " + (total_water/array_length) + "L per day. Aim for at least 2L daily.");
        }

    }
}
