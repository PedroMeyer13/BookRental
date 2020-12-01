package MenuController;

import java.util.Scanner;

public class MenuRepeat {

    public void Repeat(){

        System.out.println("\n Would you like to go back to the main menu? Y/N");

        try{

            Scanner userAnswer = new Scanner(System.in);
            String answer = userAnswer.next().toLowerCase();

            if(answer.equals("y")){
                new mainMenu();

            }else if(answer.equals("n")){
                System.exit(0);

            }else{
                System.out.println("This Option is not recognized. Try Y or N");
                Repeat();
            }

        }catch (Exception e){
            System.out.println("Main menu not found. Reset the program");
        }


    }
}
