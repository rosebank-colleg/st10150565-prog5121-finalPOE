
package gerhard.finalpoe;


import javax.swing.JOptionPane;
// declaring our string data types
public class Registration {
    
     static String firstName;
     static String userName;
     static String surname;
     static String password;
 // put the scanner we have imported to use and also declaring userDetails method   
    public static void userDetails(){
        
        firstName =  JOptionPane.showInputDialog("Please enter you first name");
        
        surname = JOptionPane.showInputDialog("Please enter your surname");
                
        userName = JOptionPane.showInputDialog("Please enter your userName");
       
        password = JOptionPane.showInputDialog("Please enter your password");
       
        
    }
    public static void main(String[] args) {
       userDetails();
        Login logObject = new Login();
        
        logObject.checkUserName();
        logObject.registerUser();
        UserInfo info = new UserInfo();
        info.WelcomeNote();
        
    }
    

}
