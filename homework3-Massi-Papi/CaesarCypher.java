public class CaesarCypher implements Cypher {
    private int shifts;

    public CaesarCypher(int shifts) {
        this.shifts = shifts;
    }

    public String encode(String message) {
        String encryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char charToBeEncrypted = message.charAt(i);
            if (Character.isLetter(charToBeEncrypted)){
                String charEncrypted = String.valueOf( (char) ('a' + (((charToBeEncrypted - 'a') + this.shifts) % 26)));
                encryptedMessage += charEncrypted;
            } else {
                encryptedMessage += Character.toString(charToBeEncrypted);
            }
        }
        return encryptedMessage;
    }

    public String decode(String message) {
        String decryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char charToBeDecrypted = message.charAt(i);
            if (Character.isLetter(charToBeDecrypted)){
                String charEncrypted = String.valueOf( (char) ('a' + (((charToBeDecrypted - 'a') - this.shifts + 26) % 26)));
                decryptedMessage += charEncrypted;
            } else {
                decryptedMessage += Character.toString((charToBeDecrypted));
            }
        }
        return decryptedMessage;
    }
}
