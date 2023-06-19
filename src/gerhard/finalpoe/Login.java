
package gerhard.finalpoe;


import java.util.Scanner;
import javax.swing.JOptionPane;

class Login {
    
    public boolean checkUserName(){
        if(Registration.userName.contains("_") && Registration.userName.length()<=5){
            return true;
        }
        else{
            return false;
        }
        
 
    }
    
    public boolean checkPasswordComplexity(){
        
    boolean passwordStatus = false;
    boolean length = false;
    boolean number = false;
    boolean specialCharacter = false;
    boolean upperCase = false;
    char ch;
    
    if(Registration.password.length() >= 8){
        length = true;
    }
    for(int i =0; i < Registration.password.length(); i = i+1 ){
        ch = Registration.password.charAt(i);
        
        if(Character.isDigit(ch)){
            number = true;
        }
        if(Character.isUpperCase(ch)){
            upperCase = true;
        }
        if(!Character.isLetterOrDigit(ch)){
             specialCharacter = true;
        }
   
     passwordStatus = specialCharacter && number && length && upperCase;
    }
    return passwordStatus;
    }
    
    public void registerUser(){
    if(checkUserName()){
        JOptionPane.showMessageDialog(null,"USER REGISTRATION \n"
                + "Username successfully captured");
    }
    else{
        JOptionPane.showMessageDialog(null,"Username is not correctly formatted, please ensure that yur username contains"
                + " an underscore and is no more than five characters in leght.");
    }
    if(checkPasswordComplexity()){
        JOptionPane.showMessageDialog(null,"USER REGISTRATION \n"
                + "Password successfully captured");
    }
    else{
        JOptionPane.showMessageDialog(null,"Password is not correctly formatted, please ensure the passwprd"
                + " cntains at least 8 char, a cap letter, a number and a special char");
    }
 }
    
 boolean loginUser(){
    String username2;
    String password2;
   
     username2 = JOptionPane.showInputDialog("USER LOGIN \n"
             + "Enter Username: ");
     
      password2 = JOptionPane.showInputDialog("USER LOGIN \n"
              + "Enter Password");
   
     
    if(Registration.userName.equals(username2)&&Registration.password.equals(password2)){
        return true;
    }
    else{
        return false;
    }
 } 

public String returnLoginStatus(){
    if(loginUser()){
        return "Thank you \n"
                + "" + Registration.firstName + " " + Registration.surname + "\n"
                + "YOU HAVE SUCCESFULLY LOGIN ";
    }
    else{
        return "Username or password incorrect, please try again.";
    }
} 
}

