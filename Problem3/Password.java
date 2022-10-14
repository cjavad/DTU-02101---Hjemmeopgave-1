package Problem3;

public class Password {

    public static int PasswordLength = 8;    
    
    public static boolean checkPWD(String password){
        if(password.length()< PasswordLength) return false; //Checks length of password
        if(conditionCheck(password, 2, 1, 1,2)) return true;
        return false;
    }

    public static boolean conditionCheck(String password, int numberCondition, int lowerCondition, int upperCondition, int letterCondition){ //checks of conditions are met.
        int numberCount = 0;
        int lowerCount = 0;
        int upperCount = 0;

        for(int i = 0; i<password.length();i++){
            char active = password.charAt(i); //makes the current index char "active"
            if(!(active >= '0' && active <= '9') && !(active >= 'A' && active <= 'Z') && !(active >= 'a' && active <= 'z')) return false;
            if(numberCount<numberCondition && active >= '0' && active <= '9'){ //Checks if active is a number, skipped if number condition is met
                numberCount++; 
            }
            if(lowerCount<lowerCondition && active >= 'a' && active <= 'z'){//Checks if active is a lowercase letter, skipped if lower condition is met
                lowerCount++;
            }  
            if(upperCount<upperCondition && active >= 'A' && active <= 'Z'){//Checks if active is an uppercase letter, skipped if upper condition is met
                upperCount++;
            }  
            if(numberCount>=numberCondition && lowerCount>=lowerCondition && upperCount>=upperCondition && upperCount+lowerCount >= letterCondition) return true; //combines upper- and lowercase to count letters. If all conditions are met, return true
        }
        return false;
    }
}
