
package gerhard.finalpoe;


import java.util.Scanner;
import javax.swing.JOptionPane;


class UserInfo {
    // declaring my variables
    private static int NumberOfTask;
    private static String TaskName;
    public static int TaskNumber;
    private static String Discription;
    private static String DeveloperNames;
    private static int Duration;
    private static int ID;
    private static String Status;
    static int duration = 0;
  
    // geeting inputs from the user
    Scanner input = new Scanner(System.in);
    public static void setNumberOfTask(){
        NumberOfTask = Integer.parseInt(JOptionPane.showInputDialog("Enter number of task you wish to perform"));
    }
    public static int getNumberOfTask(){
        return NumberOfTask;
    }
    public static void setTaskName(){
        
        TaskName = JOptionPane.showInputDialog("Enter Task Name");
        
    }
    public static String getTaskName(){
        return TaskName;
    }
    
    public static void setTaskNumber(int x){
          TaskNumber = x;
    }
    public static int getTaskNumber(){
        return TaskNumber;
    }
    
    public static void setDiscription(){
        
        Discription = JOptionPane.showInputDialog("Enter Task Discription");
        
    }
    public static String getDiscription(){
        return Discription;
    }
    public static void setDeveloperNames(){
        
        DeveloperNames = JOptionPane.showInputDialog("Enter DeveloperNames");
        
    }
    public static String getDeveloperNames(){
        return DeveloperNames;
    }
    
    public static void setDuration(){
        
        Duration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration"));
        
    }
    public static int getDuration(){
        return Duration;
    }
    
     public static void setStatus(){
         //creating option and organising the task that needs to be done
        
        Status = JOptionPane.showInputDialog("Choose task status \n"
                + "To DO\n"
                + "Doing\n"
                + "Done");
        
    }
    public static String getStatus(){
        return Status;
    }
    // this will work only if the user is succesfully logged in
    public static void WelcomeNote(){
    int option;
    int end = 0;
      Login log = new Login();
      Task obj = new Task();
      
      if(log.loginUser()){
          
          do{
              
               option = Integer.parseInt(JOptionPane.showInputDialog("Welcome to EasyKanban\n"
                  + "Please select an option \n"
                  + "1. Add task \n"
                  + "2. Show report \n"
                  + "3. Quit "));
         
              
            if(option == 1){
                
                setNumberOfTask();
                
                 String[] developer = new String[getNumberOfTask()];
                 String[] names = new String[getNumberOfTask()];
                 String[] IDs = new String[getNumberOfTask()];
                 String[] statuses = new String[getNumberOfTask()];
                 int[] durations = new int[getNumberOfTask()];
                
                for(int count= 0; count<getNumberOfTask(); count++){
                    //TaskNumber = count;
                    setStatus();
                    setTaskNumber(count);
                    setTaskName();
                    setDiscription();
                    setDuration();
                    setDeveloperNames();
                    
                     developer[count] = getDeveloperNames();
                     names[count] = getTaskName();
                     IDs[count] = Task.createTaskID();
                     statuses[count] = getStatus();
                     durations[count] = getDuration(); 
                    
                    duration = duration+ getDuration();
                    JOptionPane.showMessageDialog(null, obj.printTaskDetails());
                }
                JOptionPane.showMessageDialog(null, "These tasks will take " + duration + " to implement");
                
                finalPOE.manipulateArrays(developer, names, IDs, statuses, durations);
                
                continue;
            }
            else if(option == 2){
            JOptionPane.showMessageDialog(null,"Coming soon");
            continue;
            }
            else if(option == 3){

               end= 3; 
            }
          
      }while(end != 3);
    }
    }
    }
    
