
package gerhard.finalpoe;

public class Task {
    //creating our objects
    
    UserInfo taskinput = new UserInfo();
    
    public boolean checkTaskDescription(){
        if(taskinput.getDiscription().length()<=50){
            return true;
        }
        else {
            return false;
        }
    }
    // this is were i created the task id to display info we getting from the user as is requested by the question
    public static String createTaskID(){
        String count = " ";
        char charecter;
        for(int x = 0; x < UserInfo.getDeveloperNames().length(); x++){
            charecter = UserInfo.getDeveloperNames().charAt(x);
            if(charecter == ' '){
            count = UserInfo.getDeveloperNames().substring(x-3, x);
        }
        }
        String iD = UserInfo.getTaskName().substring(0, 2)+":"+ UserInfo.getTaskNumber()+":"+count;
                
        return iD.toUpperCase();
      
    }
    
    public static String printTaskDetails(){
        return UserInfo.getStatus()+"\n"+UserInfo.getDeveloperNames()+"\n"+UserInfo.getTaskNumber()+"\n"+
                UserInfo.getTaskName()+"\n"+UserInfo.getDiscription()+"\n"+ createTaskID()+"\n"+UserInfo.getDuration();
    }
    
   public int returnTotalHours(){
       return UserInfo.duration;
    }
}

