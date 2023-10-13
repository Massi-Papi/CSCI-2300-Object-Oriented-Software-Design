import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Cypher cypher;
        if (args[1].equals("pig")){
            cypher = new PigLatinCypher();
        }
        else if (args[1].startsWith("shift:", 0)){
            int shifts = Integer.parseInt(args[1].substring(6));
            cypher = new CaesarCypher(shifts);
        }
        else {
            System.out.println("Invalid argument paramaters");
            cypher = null;
            System.exit(0);
        }

        SecretInterpreter interpreter = new SecretInterpreter(cypher);

        if (args[0].equals("e")) {
            System.out.println("Enter the message you wish to encode");
            String userInput = scanner.nextLine();
            System.out.println("Encrypted text: " + interpreter.hide(userInput.toLowerCase()));
        }
        else if(args[0].equals("d")) {
            System.out.println("Enter the message you wish to decode");
            String userInput = scanner.nextLine();
            System.out.println("Decrypted text: " + interpreter.reveal(userInput.toLowerCase()));
        } 
        else {
            System.out.println("Invalid argument paramaters");
        }
        scanner.close();
    }
}