package MenuController;

import View.mainMenu;

import java.util.Scanner;

public class MenuRepeat {


    // method to display the menu after finishing one task
    public void Repeat(){

        System.out.println("\n Would you like to go back to the main menu? Y/N");

        try{
            // get the user answer
            Scanner userAnswer = new Scanner(System.in);
            String answer = userAnswer.next().toLowerCase();
            // if the user wants yes display the main menu
            if(answer.equals("y")){
                new mainMenu();
                // if no, close the program
            }else if(answer.equals("n")){
                System.exit(0);

            }else{
                // any other option we ask again
                System.out.println("This Option is not recognized. Try Y or N");
                Repeat();
            }

        }catch (Exception e){
            System.out.println("Main menu not found. Reset the program");
        }


    }
}
