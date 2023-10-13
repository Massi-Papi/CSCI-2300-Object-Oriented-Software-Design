import java.util.ArrayList;

public class Catalog {
   private ArrayList<CatalogItem> catalog = new ArrayList<CatalogItem>();
   private static int uniqueId = 0;

   //adds book
   public String add(Book book){
      CatalogItem bookItem = new CatalogItem(book, String.valueOf(uniqueId), true);
      catalog.add(bookItem);
      int bookUniqueId = uniqueId;
      uniqueId++;
      return String.valueOf(bookUniqueId);
   } 

   //Checks out book and sets to unavailable
   public boolean checkout (String id){
      for (CatalogItem item: catalog){
         String bookId = item.getId();
         if (bookId.equals(id) && item.isAvailable()){
            item.setUnavailable();
            return true;
         }
      }
      return false;
   }

   //Checks in book and sets to available
   public boolean checkin(String id) {
      for (CatalogItem item: catalog){
         String bookId = item.getId();
         if (bookId.equals(id) && !item.isAvailable()) {
            item.setAvailable();
            return true;
         }
      }
      return false;
   }

   //Searched the catalog for books that match with the searchTerm
   public ArrayList <String> search(String searchTerm){
      ArrayList<String> results = new ArrayList<String>();
      for(CatalogItem item: catalog){
         Book bookItem = item.getBook();
         String firstName = bookItem.getAuthorFirstName();
         String lastName = bookItem.getAuthorLastName();
         String title = bookItem.getTitle();
         if (searchTerm == firstName || searchTerm == lastName || searchTerm == title){
            results.add(item.getId());
         }
      }
      return results;
   }

   //Returns book that corresponds to unique id
   public Book getBook(String id){
      for (CatalogItem item: catalog){
         String bookId = item.getId();
         if (bookId.equals(id)) {
            return item.getBook();
         }
      }
      return null;
   }

   //Checks Catalog and removes book from collection
   public boolean remove(String id){
      for (CatalogItem item: catalog){
         String bookId = item.getId();
         if (bookId.equals(id)) {
            catalog.remove(item);
            return true;
         }
      }
      return false;
   }

}
