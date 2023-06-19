
package gerhard.finalpoe;

import javax.swing.JOptionPane;

public class finalPOE {  
    static int option = 0; // this variable will hold the user's choice to manipulate the arrays
    static String choice; //
    
    static int size = UserInfo.getNumberOfTask();
    
    static String[] developerNames = new String[size];
    static String[] taskNames = new String[size];
    static String[] taskIDs = new String[size];
    static String[] taskStatuses =new String[size];
    static int[] taskDurations = new int[size];
    
    /*
        In the following method, the user is given options to perform a number of different operations
        on the task details
    */
    public static void manipulateArrays(String developerName[], String taskName[], String taskID[], String[] status, int duration[]){
        //the following lines copy the local arrays into the global arrays so the information can be accessed anywhere
        System.arraycopy(developerName, 0, developerNames, 0, size);
        System.arraycopy(taskName, 0, taskNames, 0, size);
        System.arraycopy(taskID, 0, taskIDs, 0, size);
        System.arraycopy(status, 0, taskStatuses, 0, size);
        System.arraycopy(duration, 0, taskDurations, 0, size);
        
        
        /*
        The options to perform manipute the arrays is only presented to the user if they select 1
        */ 
        option = Integer.parseInt(JOptionPane.showInputDialog("""
                                                              All task details have been captured.
                                                              Press 1 to operate on the captured data or 0 to quit"""));
        do{
            choice = JOptionPane.showInputDialog("Enter\n"
                    + "a. >> To view the list of all tasks with the status of done\n"
                    + "b. >> To view the name of the developer whose task takes the longest to complete\n"
                    + "c. >> To search for a Task\n"
                    + "d. >> To view the list of tasks assigned to a developer\n"
                    + "e. >> To delete a task\n"
                    + "f. >> To get a report of all the captured Tasks");
            
            switch(choice){
                case "a": // the user gets the list of done tasks if they select a
                    doneTasks();
                    break;
                case "b":
                    longestTask();
                    break;
                case "c":
                    searchTask();
                    break;
                case "d":
                    developerTasks();
                    break;
                case "e":
                    deleteTask();
                    break;
                case "f":
                    displayReport();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input");
                    
            }
        
            // the user is asked whether they want to perfor more operations on the arrays
            option = Integer.parseInt(JOptionPane.showInputDialog("Press 1 to continue operating on the data and 0 to stop"));
            
        }while(option == 1);

        
    }
    // this methods searches for and displays the tasks with the status Done
    public static String doneTasks(){
        String x = "";
        for(int i = 0; i < size; i++){
            if(taskStatuses[i].equals("Done")){
                JOptionPane.showMessageDialog(null, developerNames[i]+"\n"
                        +taskNames[i]+ "\n"
                        +taskDurations[i]+ "");
                x = (developerNames[i]+"\n"
                        +taskNames[i]+ "\n"
                        +taskDurations[i]+ "");
            }
        }
        return x;
    }
    
    /* this method searches for the largest number in the taskDuration array and displays it together with the developerNames
    assigned to the task.
    */
    public static String longestTask(){
       String x = ""; 
        int maximum;
        maximum = taskDurations[0];
        int position = 0; // this variable will hold the location of the largest number in the taskDurations array
        // this loop finds the largest value in the taskDurations array and stores it in the maximum variable
        for(int i = 0; i < size; i++){
            
            if(taskDurations[i] > maximum){
                maximum = taskDurations[i];
                position = i;
            }                        
        }
        
        JOptionPane.showMessageDialog(null, developerNames[position]+ ", " + maximum);
        x = (developerNames[position]+ ", " + maximum);
     return x;   
    }
    
    /*
     This method allows a user to search for a Task using the task name
    */
    public static String searchTask(){
        String x = "";
        String search;
        search = JOptionPane.showInputDialog("Enter the name of the task to be searched");
        
        for(int i = 0; i < size; i++){
            if(taskNames[i].equals(search)){
                JOptionPane.showMessageDialog(null, taskNames[i] + ", " + developerNames[i] +", "+ taskStatuses[i]);
                i = size;
                x = (taskNames[i] + ", " + developerNames[i] +", "+ taskStatuses[i]);
            
            }           
        }
        return x;
    }
    
    /*
        This method allows the user to search for all the tasks assigned to  particular developer
    */
    public static String developerTasks(){
        String x = "";
        String devNames;
        devNames = JOptionPane.showInputDialog("Enter developer full names");
        
        for(int i = 0; i < size; i++){
            if(developerNames[i].equals(devNames)){
                JOptionPane.showMessageDialog(null, taskNames[i] + ", " + taskStatuses[i]);
                x = (taskNames[i] + ", " + taskStatuses[i]);
               
            }
        }
       return x; 
    }
    /*
     If the user enters a task that is in the array, the task will be deleted along with all the details related to it.
    */
    public static String deleteTask(){
        String x = "";
        String taskName;
        int deleteIndex; // this variable will hold the name of the task to be deleted
        taskName = JOptionPane.showInputDialog("Enter the name of the task to be deleted");
        /*
            The loop finds the task to be deleted, and if the task is found, its index is noted and everything at that
            index is removed iin the parallel arrays.
        */
        for(int i = 0; i < size; i++){
            
            if(taskNames[i].equals(taskName)){
               deleteIndex = i;
               
               JOptionPane.showMessageDialog(null, "Task " + taskNames[i] + " successfully deleted.");
               x = ("Task " + taskNames[i] + " successfully deleted.");
               
                taskNames[deleteIndex] = "";
                
                developerNames[deleteIndex] = "";
                
                taskIDs[deleteIndex] = "";
                
                taskStatuses[deleteIndex] = "";
                
                taskDurations[deleteIndex] = 0;
                
                i = size;
            }
                         
        }
        return x;
    }
    public static String displayReport(){
        String x = "";
        for(int i = 0; i < size; i++){
            JOptionPane.showMessageDialog(null, taskNames[i] + "\n"
                    +developerNames[i]+ "\n"
                    + taskIDs[i] + "\n"
                    + taskStatuses[i] +"\n"
                    + taskDurations[i] + "\n");
            x = (taskNames[i] + "\n"
                    +developerNames[i]+ "\n"
                    + taskIDs[i] + "\n"
                    + taskStatuses[i] +"\n"
                    + taskDurations[i] + "\n");
        }
        return x;
    }
    
}



