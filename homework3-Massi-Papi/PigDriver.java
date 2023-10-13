import java.util.Scanner;

public class PigDriver {

    public static String encode(String message) {
        String[] words = message.toLowerCase().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char firstChar = word.charAt(0);
            if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u' || firstChar == 'y') {
                words[i] = word + "way";
            } else {
                words[i] = word.substring(1) + word.charAt(0) + "ay";
            }
        }
        return String.join(" ", words);
    }

    public static String decode(String message) {
        String[] words = message.toLowerCase().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.endsWith("way")) {
                words[i] = word.substring(0, word.length() - 3);
            } else if (word.endsWith("ay")) {
                words[i] = word.charAt(word.length() - 3) + word.substring(0, word.length() - 3);
            }
        }
        return String.join(" ", words);
    }
    

    public void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        if (args[0].equals("e")) {
            System.out.println("Enter the message you wish to encode");
            String userInput = scanner.nextLine();
            System.out.println("Encrypted text: " + encode(userInput.toLowerCase()));
        }
        else if(args[0].equals("d")) {
            System.out.println("Enter the message you wish to decode");
            String userInput = scanner.nextLine();
            System.out.println("Decrypted text: " + decode(userInput.toLowerCase()));
        } 
        else {
            System.out.println("Invalid argument paramaters");
        }
        scanner.close();
    }

}
