import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class CAI {

    /* Create method that asks student question and doesn't end until they answer right
    *  Once correct it calls the method again
    *  pass scanner and secure random into method
    *  use
    *
    */

    public static int problems(Scanner scnr, SecureRandom sRNum, Random rNum, double pD, int pT){
        //Init
        int num1; //random number 1
        int num2; //random number 2
        int a = 5; //while loop enumerator
        double num3; //Student input
        double ans = 0; //answer to problem
        String type = "";

        num1 = sRNum.nextInt(9 * (int) Math.pow(10.0, pD)) + (int) Math.pow(10.0, pD);
        num2 = sRNum.nextInt(9 * (int) Math.pow(10.0, pD)) + (int) Math.pow(10.0, pD);
        while(a > 4){
            switch (pT){
                case 1:
                    type = "plus";
                    ans = num1 + num2;
                    a = 1;
                    break;

                case 2:
                    type = "times";
                    ans = ((double) num1) * num2;
                    a = 2;
                    break;

                case 3:
                    type = "minus";
                    ans = num1 - num2;
                    a = 3;
                    break;

                case 4:
                    type = "divided by";
                    ans = ((double) num1) / num2;
                    a = 4;
                    break;

                case 5:
                    pT = rNum.nextInt(4) + 1;
                    break;
            }
        }

        System.out.printf("How much is %d %s %d?", num1, type, num2);
        num3 = scnr.nextDouble();

        if(Math.abs(num3 - ans) < 0.0001){
            coResponse(rNum);
            return 1;
        }else {
            inResponse(rNum);
            return 0;
        }
    }

    public static void coResponse(Random rNum){
        switch (rNum.nextInt(4) + 1){
            case 1:
                System.out.println("Excellent!");
                break;

            case 2:
                System.out.println("Correct!");
                break;

            case 3:
                System.out.println("Good work!");
                break;

            case 4:
                System.out.println("Very good!");
                break;
        }
    }

    public static void inResponse(Random rNum){
        switch (rNum.nextInt(4) + 1){
            case 1:
                System.out.println("Incorrect.");
                break;

            case 2:
                System.out.println("That's not right.");
                break;

            case 3:
                System.out.println("No. Keep Trying.");
                break;

            case 4:
                System.out.println("Wrong.");
                break;
        }
    }

    public static double pDifficulty(Scanner scnr){
        double pDiffChoice;
        System.out.print("Enter a difficulty from 1 to 4:");
        pDiffChoice = scnr.nextDouble();
        return pDiffChoice - 1.0;
    }

    public static int pType(Scanner scnr){
        int pTypeChoice;
        System.out.print("Enter 1 for addition, 2 for multiplication, 3 for subtraction, 4 for division, or 5 for a mix:");
        pTypeChoice = scnr.nextInt();
        return pTypeChoice;
    }

    public static void score(int c, int i){
        double score;

        score = c / 10.0;

        System.out.printf("You had %d correct answers and %d incorrect answers.\n", c, i);
        if (score >= 0.75){
            System.out.printf("Your score is %d%%. Congratulations, you are ready to go to the next level!\n", c);
        } else {
            System.out.printf("Your score is %d%%. Please ask your teacher for extra help.\n", c);
        }
    }

    public static void main(String[] args){
        //Init
        Scanner scnr = new Scanner(System.in);
        SecureRandom sRNum = new SecureRandom();
        Random rNum = new Random();
        int reset = 1; // while loop enumerator
        int result; //result of problem method
        int correct;
        int incorrect;
        double pD;
        int pT;

        while(reset == 1){
            correct = 0;
            incorrect = 0;
            pD = pDifficulty(scnr);
            pT = pType(scnr);
            for(int i = 0; i < 10; i++) {
                result = problems(scnr, sRNum, rNum, pD, pT);
                if(result == 1){
                    correct++;
                } else {
                    incorrect++;
                }
            }
            score(correct, incorrect);
            System.out.print("Press 1 for new session or 2 to quit:");
            reset = scnr.nextInt();
        }
    }
}