// For input purpose
import java.util.Scanner;

// For File reading
import java.io.FileReader;
import java.io.BufferedReader;

// For exception regarding files
import java.io.IOException;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static Main execute = new Main();

    static PresentQuestions presentQuestions = new PresentQuestions();

    public static void main(String[] args) {
        String inputCommand = "";

        // Introduction to what KBC (NCER) is
        System.out.println("Welcome to the KBC (NCER)");
        System.out.println("To help yourself with Game, enter @help in responce otherwise enter anything you wish... ");
        inputCommand = scan.nextLine();
        execute.executeCommand(inputCommand);

        // Proceeding further with collecting info of a player
        // Decalring varibles where the basic information of the player will be stored
        String playerName = "";
        String playerBranch = "";
        long playerMobileNo = 0;
        char playerDivision = Character.MIN_VALUE;

        // Getting the basic information of a player
        System.out.println("\n");
        System.out.println("To start the game, first enter your basic info to register for the game.");
        System.out.print("Player Name: ");
        playerName = scan.nextLine();
        System.out.print("Player Mobile No: ");
        playerMobileNo = scan.nextLong();
        scan.nextLine();
        System.out.print("Player Branch: ");
        playerBranch = scan.nextLine();
        System.out.print("Player Division: ");
        playerDivision = scan.next().charAt(0);

        // Registering player into the text file
        Player player = new Player(playerName, playerMobileNo, playerBranch, playerDivision);
        System.out.println("\n");
        player.register();
        System.out.println("\n");

        System.out.println("Alright! Everything is set up.");
        System.out.println("Let's start with real KBC!");
        System.out.println("Here comes the first question on the screen. \n");

        // PresentQuestions
        // Money for answering the questions
        int rewardsMoney[] = {100, 500, 1000, 5000, 7500, 10_000, 25_000, 50_000, 75_000, 1_00_000, 00};
        int reward = 0;

        presentQuestions.startQuestions(rewardsMoney);

        int correctAnswers = presentQuestions.returnNumberOfAnsweredQuestions();
        for(int i = 0; i < correctAnswers; i++) {
            reward += rewardsMoney[i];
        }

//        reward -= rewardsMoney[correctAnswers];
        reward -= rewardsMoney[correctAnswers - 1];
        execute.rewardPlayer(playerName, reward);
    }

    void rewardPlayer(String playerName, int reward) {
        System.out.println();
        System.out.println(playerName + "has given the wrong answer!");
        if((presentQuestions.returnNumberOfAnsweredQuestions() - 1) == 0) {
            System.out.println("Player " + playerName + " doesn't get any reward. :/");
            System.out.println("Try your luck next time!");
        } else {
            System.out.println("Player " + playerName + " gets rewarded with $" + reward + " for answering " + (presentQuestions.returnNumberOfAnsweredQuestions() - 1) + " questions.");
        }
    }

    void executeCommand(String inputCommand) {
        if(inputCommand.equals("@help")) {
            execute.helpYourself();
        }
    }

    void helpYourself() {
        System.out.println();
        execute.readFile("help.txt");
        System.out.println();
    }

    void readFile(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
