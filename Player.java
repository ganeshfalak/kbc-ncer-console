import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Player {

    static Player player = new Player();
    String playerName;
    long playerMobileNo;
    String playerBranch;
    char playerDivision;


    Player(String name, long mobileNo, String branch, char division) {
        playerName = name;
        playerMobileNo = mobileNo;
        playerBranch = branch;
        playerDivision = division;
    }

    Player() {

    }

    public void meow() {
        System.out.println(this.playerName);
        System.out.println(this.playerMobileNo);
        System.out.println(this.playerBranch);
        System.out.println(this.playerDivision);
    }

    public void register() {
        try {
            FileWriter writer = new FileWriter("playerInfo.txt", true);

            writer.write("Player's Information");
            writer.write("\n Name: " + this.playerName);
            writer.write("\n Mobile No: " + this.playerMobileNo);
            writer.write("\n Branch: " + this.playerBranch);
            writer.write("\n Division: " + this.playerDivision + "\n\n");
            writer.close();

            System.out.println("Player has been successfully registered...");

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void playerInfo() {
        try {
            FileReader reader = new FileReader("src/playerInfo.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        player.register();
    }

}
