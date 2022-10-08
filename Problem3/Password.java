package Problem3;

public class Password {

    public static int PasswordLength = 8;    
    
    public static boolean checkPWD(String password){
        if(password.length()< PasswordLength) return false; //Checks length of password
        System.out.println("Passed Length");
        if(conditionCheck(password, 2, 1, 1,2)) return true;
        return false;
    }

    public static boolean conditionCheck(String password, int numberCondition, int lowerCondition, int upperCondition, int letterCondition){ //checks of conditions are met.
        int numberCount = 0;
        int lowerCount = 0;
        int upperCount = 0;

        for(int i = 0; i<password.length();i++){
            char active = password.charAt(i); //makes the current index char "active"
            
            if(numberCount<numberCondition && active >= '0' && active <= '9') numberCount++; //Checks if active is a number
            if(lowerCount<lowerCondition && active >= 'a' && active <= 'z') lowerCount++; //Checks if active is a lowercase letter
            if(upperCount<upperCondition && active >= 'A' && active <= 'Z') upperCount++; //Checks if active is an uppercase letter
            if(numberCount>=numberCondition && lowerCount>=lowerCondition && upperCount>=upperCondition && upperCount+lowerCount >= letterCondition) return true; //combines upper- and lowercase to count letters. If all conditions are met, return true
        }
        return false;
    }
}
