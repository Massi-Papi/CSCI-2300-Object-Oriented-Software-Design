public class Book extends LibraryItem
{
   private String firstName;
   private String lastName;
   private String isbn;
   private String publisher;

   public Book(String title, int year, String firstName, String lastName, String publisher, String isbn)
   {
      super(title, year);
      this.firstName = firstName;
      this.lastName = lastName;
      this.publisher = publisher;
      this.isbn = isbn;
   }

   public String getAuthorFirstName()
   {
      return this.firstName;
   }

   public String getAuthorLastName()
   {
      return this.lastName;
   }

   public String getPublisher(){
      return this.publisher;
   }

   public String getISBN(){
      return this.isbn;
   }

   @Override
   public String toString()
   {
      return new String(this.title + ", " + this.year + " " + this.firstName + ", " + this.lastName + ", " + this.publisher + ", " + this.isbn);
   }

   @Override
   public boolean matches(String keyword)
   {
      if (
         keyword.equals(this.title) ||
         keyword.equals(this.firstName) ||
         keyword.equals(this.lastName) ||
         keyword.equals(this.publisher) ||
         keyword.equals(this.isbn)
      ) {
         return true;
      } else {
         return false;
      }
   }
   
}
