import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int length = 5;
        boolean genNumbers;
        String[] validResponses = {"yes", "no"};

        // Getting Password Lenght;
        System.out.print("Password length >> ");
        try {
            length = sc.nextInt();
            if(length < 5) {
                System.out.println("The password lenght must be at least 5 characters long!");
                System.exit(0);
            } else if(length > 15){
                System.out.println("Cannot generate passwords longer than 15 characters!");
                System.exit(0);
            }
        }
        catch(InputMismatchException e){
            System.out.println("Invalid number!");
            System.exit(0);
        }

        // Checking if we have to generate numbers;
        System.out.print("\nGenerate numbers? (yes or no) >> ");

        sc.nextLine();
        String genStr = sc.nextLine().toLowerCase();
        switch(genStr){
            case "yes":
                genNumbers = true;
                break;
            case "no":
                genNumbers = false;
                break;
            default:
                System.out.println("Invalid response! Using default option (no).");
                genNumbers = false;
                break;
        }

        System.out.println("Password generated: " + generatePassword(length, genNumbers));
    }

    private static String generatePassword(int maxSize, boolean generateNumbers){
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();
        Random rd = new Random();

        StringBuilder password = new StringBuilder();
        // Looping "i" times;
        for(int i = 0; i != maxSize; i++) {

            // Check if we are to generate numbers, if not, generate only chars;
            if(!generateNumbers) {
                char letter = abc.charAt(rd.nextInt(abc.length()));
                password.append(Character.toString(letter));
            }
            else {
                if (rd.nextBoolean()) {
                    int randomNum = rd.nextInt((9 - 1) + 1) + 1;
                    password.append(randomNum);
                } else {
                    char letter = abc.charAt(rd.nextInt(abc.length()));
                    password.append(Character.toString(letter));
                }
            }
        }
        return password.toString();
    }
}
