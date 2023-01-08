import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Currency;

public class PresentQuestions {

    PresentQuestions() {

    }

    static NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
    static Scanner scan = new Scanner(System.in);
    int correctAnswerNumber;

    public static void main(String args[]) {
    }

    public void startQuestions(int rewardsMoney[]){
        String questions[] = new String[11];
        questions[0] = "What is the capital of France? \n A. London \t B. Paris \n C. Berlin \t D. Rome";
        questions[1] = "Who wrote the play \"Hamlet\"? \n A. William Shakespeare \t B. Charles Dickens \n C. Jane Austen \t D. Edgar Allan Poe";
        questions[2] = "Which of the following is not a planet in out solar system? \n A. Mars \t B. Venus \n C. Earth \t D. Pluton";
        questions[3] = "What is the largest ocean on earth? \n A. Pacific Ocean \t B. Atlantic Ocean \n C. Indian Ocean \t D. Artic Ocean";
        questions[4] = "Who is the current President of United States? \n A. Barack Obama \t B. Donald Trump \n C. Joe Biden \t D. George Washington";
        questions[5] = "Who painted the Mona Lisa? \n A. Leonardo da Vinci \t B. Michelangelo \n C. Vincent van Gogh \t D. Claude Monet";
        questions[6] = "What is the highest mountain in the world? \n A. Mount Everest \t B. K2 \n C. Makalu \t D. Lhotse";
        questions[7] = "Who wrote the novel \"Pride and Prejudice\"? \n A. Jane Austen \t B. Charles Dickens \n C. Emily Bronte \t D. Mark Twain";
        questions[8] = "What is the currency of Japan? \n A. Yen \t B. Dollar \n C. Euro \t D. Pound";
        questions[9] = "Which of the following is not a software development methodology? \n A. Agile \t B. Waterfall \n C. Scrum \t D. Microsoft Powerpoint";
        questions[10] = "Which of the following is not a computer operating system? \n A. Windows \t B. Linux \n C. MacOS \t D. Android";

        showQuestions(questions, rewardsMoney);
    }

    public void showQuestions(String questions[], int rewardsMoney[]) {
        int questionIndexes[] = new int[11];
        int count = 0;

        while(count < 10) {
            boolean toSkip = false;
            int queNo = (int) Math.floor(Math.random() * 11);

            for(int index : questionIndexes) {
                if(index == queNo) {
                    toSkip = true;
                }
            }

            if(toSkip) {
                continue;
            }

            // Presenting questions on console
            questionIndexes[count] = queNo;

            numberFormat.setCurrency(Currency.getInstance(Locale.UK));
            System.out.println("This question is for " + numberFormat.format(new Integer(rewardsMoney[count])));
            System.out.println(questions[queNo]);
            System.out.println();

            String answer = scan.nextLine();

            System.out.println();
            System.out.println("Is the answer given by player correct, Supervisor? (y/n) ");
            String supAnswer = scan.nextLine();
            System.out.println();

            if(supAnswer.equalsIgnoreCase("n")) {
                break;
            }

            count++;
        }

        count = 100;
        int i = 0;

        while(true) {
            count = questionIndexes[i];
            if(count == 0) {
                break;
            }

            i++;
        }

        correctAnswerNumber = i;
    }

    public int returnNumberOfAnsweredQuestions() {
        return correctAnswerNumber;
    }
}
