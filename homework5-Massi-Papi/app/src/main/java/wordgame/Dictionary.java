package wordgame;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Random;

public class Dictionary
{
   private String fileName;
   private ArrayList<String> words;
   private Random random;
   private String word;

   public Dictionary(String fileName)
   {
      this.fileName = fileName;
      words = new ArrayList<String>();
      random = new Random();
      try {
         BufferedReader reader = new BufferedReader(new FileReader(fileName));
         String line = reader.readLine();
         while (line != null) {
            words.add(line);
            line = reader.readLine();
            setRandomWord();
         }
         //setRandomWord();
         reader.close();
      
      } catch (Exception e) {
         System.out.println("Error");
         
      }

      // for (String x : words){
      //    System.out.println(x);
      // }
   
   }

   public ArrayList<String> getWords()
   {
      return words;
   }

   public void setRandomWord() {
      int randomIndex = random.nextInt(words.size());
      this.word = words.get(randomIndex);
      
   }

   public String getRandomWord(){
      return this.word;
   }

}
