import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessString {
    /**
     * 
     */
    //Method to Print elements in tabular form
    public static void printList(List<String> arr){
        System.out.println("Table of Elements \n -------------");
        for(String str : arr){
            System.out.printf("%-10s%n", str);
                }
    }
    public static void main(String args[]){
        System.out.print("Hi");
        Scanner scanner = new Scanner(System.in);
        List<String> Months = new ArrayList<>();
        boolean play =true;
        String playAgain = "Yes";
        String userInput;
        String chosenWord;
        Random random = new Random();
        

        //List elements
        Months.add("January");
        Months.add("February");
        Months.add("March");
        Months.add("April");
        Months.add("May");
        Months.add("June");
        Months.add("July");
        Months.add("August");
        Months.add("September");
        Months.add("October");

        //Programming for looping the game each time the user wants to play again
        do{
            //Choose random element from the list
            int index = random.nextInt(Months.size());//This will be used to delete the element
            chosenWord = Months.get(index);
            int len = chosenWord.length();//This will be used for hints, it is the length of the word 
            int chances = 3;

            if(playAgain.equalsIgnoreCase("Yes")){
                //Print elements in tabular form
                printList(Months);

                //Play 1 game with 3 chances
                System.out.print("\n Enter Your guess :");
                while(chances >0){
                    chances--;
                    userInput = scanner.next();
                    if(userInput.equalsIgnoreCase(chosenWord)){
                        System.out.println("Correct! \nThe new list is: ");
                        Months.remove(index);//Delete element after guessing corect
                        printList(Months);
                        break;
                    }else if(chances == 2){
                        System.out.println("\n Try again.Hint: The word has " + Integer.toString(len) + " characters" );
                    }else if(chances == 1){   
                        System.out.println("\n Try again. Hint: The last alphabet is :" + chosenWord.charAt(len - 1));
                    }else{
                       break;
                    }
                }
            }else{
                System.out.println("\n End of game");
                break;
            }

            //Ask player if they want to play again after their 3 chances or getting it right
            System.out.println("\n Do you want to play again?");
            playAgain = scanner.next();
        }while(play);
        scanner.close();



                
    }
}
