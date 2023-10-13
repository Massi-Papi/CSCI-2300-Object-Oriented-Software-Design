package wordgame;

public class SecretWord
{
   private char []secret;
   private boolean []opened;
   private UsedLetters usedLetters;
   public SecretWord(String word)
   {
      this.secret = word.toCharArray();
      this.opened = new boolean[secret.length];
      this.usedLetters = new UsedLetters();
   }

   public boolean makeGuess(char letter)
   {
      boolean result = false;
      if(usedLetters.hasBeenUsed(letter)){
         System.out.println("You already used that letter, try another one");
         return true;
      }

      for (int i = 0; i < this.secret.length; i++)
      {
         if (Character.toLowerCase(this.secret[i]) == letter && !this.opened[i])
         {
            result = true;
            this.opened[i] = true;
            usedLetters.addLetter(letter);
      
         }
      }

      return result;
   }

   public boolean hasUnopenedLetters()
   {
      for (int i = 0; i < this.opened.length; i++)
      {
         if (!this.opened[i])
         {
            return true;
         }
      }
      return false;
   }

   public String getCurrentGuess()
   {
      String result = "";
      for (int i = 0; i < this.opened.length; i++)
      {
         if (this.opened[i])
         {
            result+=this.secret[i];
         }
         else
         {
            result+='_';
         }
      }
      return result;
   }

   public String reveal()
   {
      String result = new String(this.secret);
      return result;
   }
}
