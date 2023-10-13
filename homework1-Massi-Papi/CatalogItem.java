public class CatalogItem {
    private Book book;
    private String id;
    private boolean availability; 

    //This is a constructor that creates a CatalogItem object with the provided values
    public CatalogItem (Book book, String id, boolean availability){
        this.book = book;
        this.id = id;
        this.availability = availability;
    }

//Returns the Book object associated with this CatalogItem
    public Book getBook(){
       return book; 
    }
//Returns the unique identifier associated with this CatalogItem
    public String getId(){
        return id;
    }
//Returns true if the book is available for checkout, false otherwise
    public boolean isAvailable(){
        return availability;
    }
//Sets availability of the book to true
    public void setAvailable(){
        availability = true;
    }
//Sets availability of the book to false
    public void setUnavailable(){
        availability = false;
    }
}
