package Problem3;

import java.util.Scanner;

public class AccesControl {
    public static String username, password = "";
    public static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        startup();
        login();
        choice();
    }

    public static void startup() {//Køres ved starten, består af at lave username og password.
        changeUser();
        changePass();
        System.out.println("\n*** User " + username + " is registered.");
    }

    public static void changePass() {//Funktionen som ændre password
        boolean notValid = true;
        while (notValid) { //kører et while loop, indtil password er valid
            System.out.print("\nPlease enter a password       : ");
            password = read.nextLine();
            notValid = !Password.checkPWD(password); //Sætter notvalid til at være modsat valid.
            if(notValid) continue;//hvis password ikke er valid skal det ikke skrives igen.
            System.out.print("\nPlease repeat the password    : ");
            String pass2 = read.nextLine();
            if(!(pass2.equals(password))) notValid = true; //hvis password er ens begge gange, så er fukntionen færdig.
        }
    }

    public static void changeUser() { //funktionen laver username
        boolean notValid = true;
        while (notValid) {//kører mens username ikke er valid.
            System.out.print("Please enter a non-empty username: ");
            username = read.nextLine();
            notValid = !checkUsername(username);//tjekker om username er valid.
        }
    }

    public static void login() {//funktionen logger ind
        int tries = 0;//starter tries tælleren.
        boolean correct = false;
        while (!correct) {//kører indtil username er rigtigt
            System.out.print("To logon enter username: ");
            if (read.nextLine().equals(username))
                correct = true;
        }
        correct = false;
        while (!correct) {//kører indtil password er rigtigt
            System.out.print("\nTo logon enter password: ");
            if (read.nextLine().equals(password))//Tjekker om password er rigtigt
                correct = true;
            else{
                tries++;
            }
            if(tries == 3) System.exit(1);//Hvis tries når 3, så lukker programmet
        }
        System.out.println("\n*** User " + username + " is Logged on.");
    }

    public static void choice() {//Funktionen kører valget
        boolean running = true;
        while (running) {//kører mens programmet er "running"
            boolean checkingInput = true;
            String input = "";
            while (checkingInput) {//kører indtil man får validt input
                System.out.println("You now have the following choices:");
                System.out.println("    1 - Change Password");
                System.out.println("    2 - Log off");
                System.out.println("    3 - Shut down");
                System.out.print("Please select: ");
                input = read.nextLine();
                if (input.length() != 1)//hvis inputtet er længere end 1, så kan det iikke være korrekt input.
                    continue;
                char ch = input.charAt(0);//tjekker om input er validt
                if (ch == '1' || ch == '2' || ch == '3')
                    checkingInput = false;
            }
            if (input.charAt(0) == '1') {//hvis der tastes 1, så køres changePass funktionen
                changePass();
                System.out.println("*** Password changed for user " + username);
            }
            if (input.charAt(0) == '2') {//Hvis der tastes 2, så køres login funktionen
                System.out.println("*** User "+ username + " is logged off");
                login();
            }
            if (input.charAt(0) == '3') {//hvis der tastet 3, så sættes running tiil false og programmet slutter
                System.out.println("\n*** User "+ username + " is logged off");
                System.out.println("\n*** System shutting down.");
                running = false;
            }
        }
    }

    public static boolean checkUsername(String user) {//funktionen tjekker username mod kravene
        if (user == null)//hvis der ikke er et username
            return false;
        char ch = user.charAt(0);//kalder det aktive char for ch.

        if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {//Tjekker om det første char er et bogstav
            for (int i = 0; i < user.length(); i++) {
                ch = user.charAt(i);
                if (ch == ' ')//Tjekker om der er mellemrum
                    return false;
            }
            return true;
        }
        return false;
    }



    /*public static int PasswordLength = 8;    
    
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
            if(numberCount<numberCondition && active >= '0' && active <= '9'){
                numberCount++; //Checks if active is a number
            }
            if(lowerCount<lowerCondition && active >= 'a' && active <= 'z'){
                lowerCount++;
            }  //Checks if active is a lowercase letter, needs to check for letter conndition
            if(upperCount<upperCondition && active >= 'A' && active <= 'Z'){
                upperCount++;
            }  //Checks if active is an uppercase letter, needs to check for letter conndition
            if(numberCount>=numberCondition && lowerCount>=lowerCondition && upperCount>=upperCondition && upperCount+lowerCount >= letterCondition) return true; //combines upper- and lowercase to count letters. If all conditions are met, return true
        }
        return false;
    }*/
}

