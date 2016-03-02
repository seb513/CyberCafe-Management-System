package cyber;

import javax.swing.JOptionPane;

public class validate {
    
    /*
    \d - any digit character same as [0-9]
    \D - any non digit character
    + - repetition modifier which means one or more times
    | - means OR
    () creates a group of characters which will be separated in the matches
    */
    
      public static boolean isNumber(String n,String message) {
        if(n.matches("\\d+" )){
            return true;
        }
        else{
                JOptionPane.showMessageDialog(null, "Enter  correct "+message);
                return false;
        }
        
    }
      public static boolean isDate(String n,String message) {
        if(n.matches("\\d{4}-\\d{2}-\\d{2}" )){
            return true;
        }
        else{
                JOptionPane.showMessageDialog(null, "Enter  correct "+message);
                return false;
        }
        
    }
      public static boolean isBlank(String n,String message) {
         if(n.matches(" " )){
            return true;
          }
        else{
                JOptionPane.showMessageDialog(null, "Enter  correct "+message);
                return false;
        }
        
    }
    
    public static boolean checklength(String n,String message) {
        
            if (n.length() <= 0 ) {
                JOptionPane.showMessageDialog(null, "Enter correct "+message);
                return false ;
             
            }else{
                return true;
            }  
     }
    
  /*  
     public static boolean isBlanks(String n,String message) {
        
            if (n.length() < 150 && n.length() > 0){
                JOptionPane.showMessageDialog(null, "Enter correct "+message);
                return false ;
             
            }else{
                return true;
            }  
     }*/
     
    
     public static boolean checkcontactlength(String n,String message) {
        
            if (n.length() <= 0 || n.length() <= 8 ||  n.length() > 10){
                JOptionPane.showMessageDialog(null, "Enter correct "+message);
                return false ;
             
            }else{
                return true;
            }  
     }
    
    public static boolean isValidEmailAddress(String email) {
           if(email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")){ 
               return true;
           }
           else{ 
               return false;
           }
    }
    public static boolean isString(String n,String message) {
		if (n.matches("[a-zA-Z]+$")) {
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter correct "+message);
                    return false;
                }
    }
    public static boolean isSpaceAlphabate(String n,String message) {
		if (n.matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$")) {
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter correct "+message);
                    return false;
                }
    }
    
    
}
