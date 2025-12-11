/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPgroupassignment;
import java.util.*;

//import javax.sound.midi.Track;
/**
 *
 * @author Akmal Zikry
 * @author Doshyant Raj
 * Derived class for healthrecord
 * Takes user input in healthtrackerapp to create and edit records for activityrecord
 * uses arraylist to store records
 * Coding similar to dietrecord but uses input from ActivityMenu from healthtrackerapp
 * 
 */
public class ActivityRecord extends HealthRecord {
    //array list to append the data from activity and diet record
    ArrayList<int[]> TrackActivity = new ArrayList<>();
    private final int column_length = 4;
     private int array_length = TrackActivity.size();     
     private int condition_position; //used in the switch statement in the 2nd overide of ChangeRecord and the for loop to specify at what condition met should the data be altered

    public void setNewRecord( int steps)//used to insert a new record into the list, the record must include the data that is parsed inside to track things properly
    {
        int newRecord[] = {this.year,this.day, this.week, steps};
        if(newRecord.length !=column_length)
        {
            System.out.println("invalid input, you must provide the steps walked today to add a new log, include position to insert it at a specific place");
            return;
        }
        else
        {
            TrackActivity.add(newRecord);
            array_length = TrackActivity.size();
        }
        
    }

    public void setNewRecord(int year,int day, int week, int steps, int position )//Like above but with a specified posiiton to insert it into
    {
        
        int newRecord[] = {year,day, week, steps};
        if(newRecord.length !=column_length)
        {
            System.out.println("invalid input, you must provide the calories,meals and waterDrunk to be able to add a new log, include position to insert it at a specific place");
            return;
        }
        else if(position > array_length)
            {
                TrackActivity.add(newRecord); /*new record is added into array list at the end of the array as otherwise it would cause an error, it doenst make sense 
                 to inform the user of this error though since this will have a simialr effect to if we had implemented it another way */
            
            }
        else
        {
            TrackActivity.add(position,newRecord);
            array_length = TrackActivity.size();
        }
        
    }

    public int GetLength() // returns length of the ArrayList
    {
        array_length = TrackActivity.size(); 
        return array_length;
    }

    public void ChangeRecord(int year,int day, int week, int steps, int position )// used to change a specific record in the table at a specified position
    {
        int ChangeRecord[] ={year,day, week, steps};

        if(ChangeRecord.length !=column_length)
        {
            System.out.println("invalid input, you must provide the steps walked today to add a new log, include position to insert it at a specific place");
            return;
        }
        else if(position > array_length) // check if the position selcected is invalid
        {
            System.out.println("invalid position, position exceeds length of array which is " + array_length);
            return;
        }
        else
        {
            TrackActivity.set(position,ChangeRecord);   
            System.out.print("Record successfully changed!");
        }
            
    }

    public void ChangeRecord(int changeValue, int condition_value, String condition_checked )// used to change a specific record in the table where a requirement is met and to change just 1 element there
    {
        
        switch(condition_checked)
        {
            case "week":
                condition_position = 0;
                break;
            case "day":
                condition_position = 1;
                break;
            case "steps":
                condition_position = 2;
                break;



            default:
                System.out.println("invalid condition being checked, the valid conditions to be checked are: \n year \n day \n week \n steps \n");
                break;
        }

        for(int i = 0;i<array_length;i++)//once which condition to be changed has been found it is changed everywhere the requirment is met
        {
                if(TrackActivity.get(i)[condition_position]== condition_value)
                {
                    TrackActivity.get(i)[condition_position] = changeValue;
                }
        }
        System.out.println("Records updated succesfully."); // indication to the user that the task has been completed succesfully
    }

    public void displayActivity() //displays all records in the array list in a formatted manner
    {
        array_length = TrackActivity.size();
        System.out.println(array_length);
        for(int i = 0;i<array_length;i++)
        {
                        System.out.println("year:" +TrackActivity.get(i)[0] + "\tday:" +TrackActivity.get(i)[1] + "\tweek:" + TrackActivity.get(i)[2] + "\tsteps:" + TrackActivity.get(i)[3]);
        }
    }

    public void average() //takes average steps from all the records to see if user has sufficient activity or not, gives feedback accordingly.
    {
        array_length = TrackActivity.size();
        if(array_length == 0){
            System.out.println("No Step records to calculate averages.");
            return;
        }
        int total_steps = 0;
        for(int i = 0;i<array_length;i++)
        {
            total_steps += TrackActivity.get(i)[3];
        }
        if ((total_steps/array_length) > 8000)
        {
            System.out.println("Great job! You are meeting your activity goals with an average of " + (total_steps/array_length) + " steps taken.");
        } 
        else 
        {
            System.out.println("You might want to increase your activity levels. Your average steps taken is " + (total_steps/array_length) + " try to aim for 8000 to 10000 steps.");
        }
    }

}
