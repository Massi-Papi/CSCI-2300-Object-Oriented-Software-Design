import java.util.ArrayList;

public class Driver
{
   public static int testAdd()
   {
      Catalog catalog = new Catalog();
      int numErrors = 0;
      boolean status = false;
      Book book = new Book("Introduction to Java", "Kate", "Holdener");
      String bookId = catalog.add(book);
      ArrayList<String> foundBooks = catalog.search("Kate");

      if (foundBooks.size() != 1)
      {
         System.out.println("Error: search method should have found one book");
         numErrors++;
      }
      return numErrors;
   }

   // TODO: MORE STATIC TEST METHODS HERE

   public static int testCheckout()
   {
      Catalog catalog = new Catalog();
      int numErrors = 0;
      Book book = new Book("Book of Uncle", "Uncle", "Javier");
      String bookId = catalog.add(book);
      boolean status = catalog.checkout(bookId);
      if (status == false)
      {
         System.out.println("Error: search method should have found one book");
         numErrors++;
      }
      return numErrors;
   }

   public static int testCheckin()
   {
      Catalog catalog = new Catalog();
      int numErrors = 0;
      Book book = new Book("How to Fly Like A Bird: The Human Edition", "Jackson", "Arnolds");
      String bookId = catalog.add(book);
      boolean status = catalog.checkout(bookId);
      boolean status2 = catalog.checkin(bookId);
      if (status == false)
      {
         System.out.println("Error: search method should have found one book");
         numErrors++;
      }
      return numErrors;
   }

   public static int testSearch()
   {
      Catalog catalog = new Catalog();
      int numErrors = 0;
      boolean status = false;
      Book book = new Book("The Art of War", "Sun", "Tzu");
      Book book2 = new Book("Yes, No Gas", "Son", "Tzu");
      String bookId = catalog.add(book);
      String bookId2 = catalog.add(book2);
      ArrayList<String> foundBooks = catalog.search("Tzu");

      if (foundBooks.size() != 1)

      {

         System.out.println("The term searched is not found in this catalog.");

      }
      else{

        System.out.println("The term searched is in the catalog.");

      }

      System.out.println(foundBooks);
      return numErrors;
   }

   public static int testGetBook()
   {
      Catalog catalog = new Catalog();
      int numErrors = 0;
      boolean status = false;
      Book book = new Book("The Stranger", "Albert", "Camus");
      String bookId = catalog.add(book);
      Book BookStatus = catalog.getBook(bookId);
      
      return numErrors;
   }

   public static int testRemove()
   {
      Catalog catalog = new Catalog();
      int numErrors = 0;
      Book book = new Book("Love Island", "James", "Griffin");
      String bookId = catalog.add(book);
      catalog.remove(bookId);
      ArrayList<String> booksfound = catalog.search("James");

      if (booksfound.size() >= 1)
      {
         System.out.println("Error: search method should not have found a book");
         numErrors++;
      }
      return numErrors;
   }


   public static void main(String []args)
   { 
      int numErrors = 0;
      numErrors += testAdd();

      // TODO: Call more test methods here

      numErrors += testCheckout();
      numErrors += testCheckin();
      numErrors += testRemove();
      numErrors += testSearch();
      numErrors += testGetBook();

      if (numErrors > 0)
      {
         System.out.println("Fix your errors");
      }
      else
      {
         System.out.println("No errors were found");
      }
   }
}