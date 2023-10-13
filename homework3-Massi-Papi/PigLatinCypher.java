public class PigLatinCypher implements Cypher {
    public String encode(String message) {
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

    public String decode(String message) {
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
}
