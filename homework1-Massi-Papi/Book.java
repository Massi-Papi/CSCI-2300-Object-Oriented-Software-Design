class Book {
   private String title;
   private String firstName;
   private String lastName;

//Sets the title, first name, last name of the author, and catalog id to the specified values. 
   public Book(String title, String firstName, String lastName){
      this.title = title;
      this.firstName = firstName;
      this.lastName = lastName;
   } 
//Returns title of the book
   public String getTitle(){      
    return title;
   }
//Returns the first name of the author
   public String getAuthorFirstName(){
    return firstName;
   }
//Returns the last name of the author
   public String getAuthorLastName(){
    return lastName;
   }
//Returns a human readable representation of the book in the following format: 
//Title, Author Last Name, Author First Name

   public String toString(){
    return title + ", " + lastName + ", " + firstName;
   }
}