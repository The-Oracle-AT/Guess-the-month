import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Q1{

    public static class Guess{
        private List<String> input_arr;//We will ise this to store the array as a list
        private int index;// We will use this to remove the words from list

    public Guess(String [] input_arr){
         this.input_arr = new ArrayList<>(Arrays.asList(input_arr));
    }

    //Method for printing items in tabular form
    public void printList(List<String> list){
        //Display info in tabular form
        System.out.println("Months:");
        System.out.print("-----------\n");
        for(String month : list){
            System.out.printf("%-10s%n", month); // Display each element in a new row
        }
    }

    //Method used to randomly choose a string
    public String chooseString() {
        Random randomNum = new Random();
        this.index = randomNum.nextInt(10);//Set bound to be 10
        String res = this.input_arr.get(index);
        printList(input_arr);
        return res;
    }

    //Method used to play the game(Guess answer and check for correctness)
    public void guessString(String entry,String answer){
        int chances = 3;
        String guess;
        int len = answer.length();
        System.out.println("Guess which name was chosen");
        while (chances != 0){
            guess = entry;
            chances -= 1;
                if(guess.equals(answer)){
                    System.out.println("Correct! \nThe new list is: ");
                    this.input_arr.remove(this.index);//Delete element after guessing corect
                    printList(input_arr);
                }else if(chances == 2){
                    System.out.println("Try again \n Hint: The word has " + Integer.toString(len) + " characters" );
                }else if(chances == 1){
                    System.out.println("Try again \n Hint: The last alphabet is :" + answer.charAt(len - 1));   
                }else{
                    continue;
                }
        }
    }
    }
    
    public static void main(String[] args) {
        //Create list with 10 values
        String[] arr = {"January", "February", "March", "April", "May","June", "July", "August", "September", "October"};
        boolean playAgain = true;
        Scanner scanner = new Scanner(System.in);
        //String input_ = scanner.nextLine();
        while(playAgain){
            Guess list = new Guess(arr);
            String answer = list.chooseString();
            list.guessString(scanner.nextLine(), answer);
            System.out.println("\n Do you want to play again?(No:0 or Yes:Any char except 0)");
            String playAns = scanner.nextLine();
            
            if(playAns.equals("0")){
                playAgain = !playAgain;
                scanner.close();
            } else{
                continue; 
            }
        }  
    }
}