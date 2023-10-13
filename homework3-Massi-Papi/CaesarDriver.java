import java.util.Arrays;
import java.util.Scanner;
public class CaesarDriver {
    public static int shifts;

    public static String encryptMessage(String message, int shifts) {
        String encryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char charToBeEncrypted = message.charAt(i);
            if (Character.isLetter(charToBeEncrypted)){
                String charEncrypted = String.valueOf( (char) ('a' + (((charToBeEncrypted - 'a') + shifts) % 26)));
                encryptedMessage += charEncrypted;
            } else {
                encryptedMessage += Character.toString(charToBeEncrypted);
            }
        }
        return encryptedMessage;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the message you wish to decode");
        String userInput = scanner.nextLine();
        System.out.println("Encrypted text: " + encryptMessage(userInput.toLowerCase(), Integer.parseInt(args[0])));
        scanner.close();
    }
}
