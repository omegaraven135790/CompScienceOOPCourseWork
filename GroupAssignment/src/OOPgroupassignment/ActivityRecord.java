/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPgroupassignment;
import java.util.*;
/**
 *
 * @author Akmal Zikry
 * @author Doshyant
 */
public class ActivityRecord extends HealthRecord {
    //array list to append the data from activity and diet record
    ArrayList<String[]> TrackActivity = new ArrayList<>();
    private final int column_length = 3;
     private int array_length = TrackActivity.size();     
     private int condition_position; //used in the switch statement in the 2nd overide of ChangeRecord and the for loop to specify at what condition met should the data be altered

    public void setNewRecord(int day, int week, int steps)//used to insert a new record into the list, the record must include the data that is parsed inside to track things properly
    {
        
        int newRecord[] = {day, week, steps};
        TrackActivity.add(newRecord);
    }

    public void setNewRecord(int day, int week, int steps, int position )//Like above but with a specified posiiton to insert it into
    {
        
        int newRecord[] = {day, week, steps};
        TrackActivity.add(position,newRecord);
    }

    public int GetLength() // returns length of the ArrayList
    {
        array_length = TrackActivity.size(); 
        return array_length;
    }

    public void ChangeRecord(int day, int week, int steps, int position )// used to change a specific record in the table at a specified position
    {
        int ChangeRecord[] ={day, week, steps};
        TrackActivity.set(position,ChangeRecord);       
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
                System.out.println("invalid condition being checked, the valid conditions to be checked are: \n day \n week \n steps \n");
                break;
        }

        for(int i = 0;i<array_length;i++)//once which condition to be changed has been found it is changed everywhere the requirment is met
        {
                if(TrackActivity.get(i)[condition_position]== condition_value)
                {
                    TrackActivity.get(i)[condition_position] = condition_value;
                }
        }
    }

    public void displayDiet()
    {
        for(int i = 0;i<array_length;i++)
        {
            for(int j = 0; j<column_length;j++)
            {
            System.out.print(TrackActivity.get(i)[j] + "\t");
            }
        }
    }

}
