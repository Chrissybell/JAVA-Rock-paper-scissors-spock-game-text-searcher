import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;

public class Exercise02 {

    public static int exit_or_play = Prompt_or_Exit();
    public static final Random RANDOM = new Random();
    public static String computer = random_moves();
    public static String players_choice;
    public static int user_score = 0;
    public  static int computer_score = 0;
    public static void main(String[] args) {
        explain_rules();
        check_if_file_exists();
        Play_game();

    }
    public static void explain_rules() {
        System.out.println("Spock beats Scissors and Rock ");
        System.out.println("Lizard beats Spock and Paper");
        System.out.println("Rock beats Lizard and Scissors");
        System.out.println("Scissors beats Lizard and Paper");
        System.out.println("Paper beats Spock and Rock");
    }
    public static void Play_game() {
        do {
            System.out.print("Rock, Paper, Scissors, Spock, or Lizard?: ");
            Scanner ccin = new Scanner(System.in);
            players_choice = ccin.next();
            computer = random_moves();
            /* we'll be testing based on what the user selects
            if the computer chooses rock then we'll test against what the user chose.
             */
            if (players_choice.equals("Rock") && computer.equals("Rock")) {
                tie();
                user_score++;
                computer_score++;
                exit_or_play = Prompt_or_Exit();
            } else if (players_choice.equals("Rock") && computer.equals("Scissors")) {
                win();
                user_score++;
                exit_or_play = Prompt_or_Exit();
            } else if (players_choice.equals("Rock") && computer.equals("Lizard")) {
                win();
                user_score++;
                exit_or_play = Prompt_or_Exit();
            } else if (players_choice.equals("Paper") && computer.equals("Paper")) {
                tie();
                user_score++;
                computer_score++;
                exit_or_play = Prompt_or_Exit();
            } else if (players_choice.equals("Paper") && computer.equals("Spock")) {
                win();
                user_score++;
                exit_or_play = Prompt_or_Exit();
            } else if (players_choice.equals("Paper") && computer.equals("Rock")) {
                win();
                user_score++;
                exit_or_play = Prompt_or_Exit();
            } else if (players_choice.equals("Scissors") && computer.equals("Scissors")) {
                tie();
                user_score++;
                computer_score++;
                exit_or_play = Prompt_or_Exit();
            } else if (players_choice.equals("Scissors") && computer.equals("Lizard")) {
                win();
                user_score++;
                exit_or_play = Prompt_or_Exit();
            } else if (players_choice.equals("Scissors") && computer.equals("Paper")) {
                win();
                user_score++;
                exit_or_play = Prompt_or_Exit();
            } else if (players_choice.equals("Spock") && computer.equals("Spock")) {
                tie();
                user_score++;
                computer_score++;
                exit_or_play = Prompt_or_Exit();
            } else if (players_choice.equals("Spock") && computer.equals("Scissors")) {
                win();
                user_score++;
                exit_or_play = Prompt_or_Exit();
            } else if (players_choice.equals("Spock") && computer.equals("Rock")) {
                win();
                user_score++;
                exit_or_play = Prompt_or_Exit();
            } else if (players_choice.equals("Lizard") && computer.equals("Lizard")) {
                tie();
                user_score++;
                computer_score++;
                exit_or_play = Prompt_or_Exit();
            } else if (players_choice.equals("Lizard") && computer.equals("Spock")) {
                win();
                user_score++;
                exit_or_play = Prompt_or_Exit();
            } else if (players_choice.equals("Lizard") && computer.equals("Paper")) {
                win();
                user_score++;
                exit_or_play = Prompt_or_Exit();
            } else {
                lose();
                computer_score++;
                exit_or_play = Prompt_or_Exit();

            }
        }
        while (!(exit_or_play == -1));
            int sum_played = user_score + computer_score;
            System.out.print("You've played: " + sum_played + " Times " + " Your score is: " + user_score + " The computers score is: " + computer_score);
            System.out.println();
            System.out.print("Thanks for playing");
            savingGame();

    }
    public static void savingGame() {
        //when the user requests to save the game, this will write the current values to the file then close
        try {
            PrintWriter myWriter = new PrintWriter(new FileWriter("SaveFile.txt"));

            myWriter.println(user_score);
            myWriter.println(computer_score);
            myWriter.close();
            System.exit(0);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    // method to see if file exists. i borrowed this from Roberto since i wasn't sure how to go about it on my own at first
    public static void check_if_file_exists() {
        /*checks if file exists. */
        File save_score = new File("GameScore.txt");
        boolean exists = save_score.exists();

        if (!exists) {
            create_file();
        } else {
            readData();
        }
    }
    public static void readData() {
        //when the user has the SaveFile.txt this will read it and set the values to the game
        String[] storage = new String[2];
        try {
            File file = new File("SaveFile.txt");

            Scanner myReader = new Scanner(file);
            for (int i = 0; i <= 1; ) {
                storage[i] = myReader.next();
                i++;
            }
            user_score = Integer.parseInt(storage[0]);
            computer_score = Integer.parseInt(storage[1]);
            System.out.printf("In your game the score was :%d and the Computers score was:%d \n", user_score, computer_score);
            System.out.println();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // initially borrowed from Roberto.
    public static void create_file() {
        //creates a new file with default values 0, 0
        int startingUserValue = 0;
        int startingComputerValue = 0;

        try {
            PrintWriter myWriter = new PrintWriter(new FileWriter("SaveFile.txt"));
            myWriter.println(startingUserValue);
            myWriter.println(startingComputerValue);
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static String random_moves() {
        String[] list_of_moves = {"Rock", "Paper", "Scissors", "Spock", "Lizard"};
        int Choose_move = RANDOM.nextInt(list_of_moves.length);
        return list_of_moves[Choose_move];
    }
    /* method that handles win */
    public static void win(){
         System.out.print("You Won!");
        System.out.println();

    }
    /* method that handles loss */
    public static void lose(){
        System.out.print("You lost!");
        System.out.println();
    }
    public static void tie(){
        System.out.print("It's a tie!");
        System.out.println();
    }

    /* we want the user to set the rules */
    public static int Prompt_or_Exit() {
        Scanner cin = new Scanner(System.in);
        System.out.print("Press 0 to play or -1 to exit: ");
        return cin.nextInt();
    }
}
