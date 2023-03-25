import java.util.*;
public class NumberGuessingGame {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();
    public static void main(String[] args) {
        NumberGuessingGame obj = new NumberGuessingGame();
        obj.menu(scoreBoard);
    }
    public void menu(ArrayList<Integer> scoreBoard) {
        NumberGuessingGame obj = new NumberGuessingGame();
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Welcome to the number game");
        System.out.println("1) Play the Game");
        System.out.println("2) Score Board");
        System.out.println("3) Exit the game");
        System.out.println("----------------------------------------------------------------------------------");
        try {
            System.out.print("Enter option from 1 to 3: ");
            int Option = input.nextInt();
            switch (Option) {
                case 1:
                    System.out.print("\n"+"Enter the range of the numbers : ");
                    int Range = input.nextInt();
                    int randomNumber = obj.randomNumber(Range);
                    obj.guessNumber(randomNumber);
                    break;
                case 2:
                    obj.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n"+"Thanks for playing the game!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid  entry  please enter valid options ");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(scoreBoard);
        }
        finally
        {input.close();}
    }
    public int randomNumber(int Range) {
        Random random = new Random();
        int randomNumber = random.nextInt(Range) + 1;
        return randomNumber;
    }
    public void guessNumber(int randomNumber) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int count = 0;
        do {
            System.out.print("Enter your guess number: ");
            userGuess = input.nextInt();
            count++;
            if (userGuess > randomNumber) {
                System.out.println("Lower");
            } 
            else if (userGuess < randomNumber) {
                System.out.println("Higher");
            }
        } while (randomNumber != userGuess);
        System.out.println(" ");
        if (count== 1) {
            System.out.println("You answered number is right in " + count+ " try!");
        } else {
            System.out.println("You answered number is right in " + count+ " tries!");
        }
        scoreBoard.add(count);
        System.out.println(" ");

        menu(scoreBoard);
        input.close();
    }
    public void displayScoreBoard() {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Score Board");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("fastest games  out of all tries is: " +"\n");
        Collections.sort(scoreBoard);
        for (Integer scores : scoreBoard) {
            System.out.println("Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
        menu(scoreBoard);
    }
}