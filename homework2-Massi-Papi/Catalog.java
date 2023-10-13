import java.util.ArrayList;

public class Catalog
{
   private ArrayList<CatalogItem> catalogItems;
   private int nextId;

   /**
    * Instantiate an empty list of catalog itemss
    */
   public Catalog()
   {
      catalogItems = new ArrayList<CatalogItem>();
      nextId = 0;
   }

   public Catalog(ArrayList<CatalogItem> items) throws IllegalArgumentException
   {
      catalogItems = items;
      nextId = 0;
      if (!uniqueIdCheck(items)) {
         throw new IllegalArgumentException("Ids not unique");
      }
   }

   private boolean uniqueIdCheck(ArrayList<CatalogItem> items)
   {
      for (int i = 0; i <= items.size(); i++) {
         for (int j = i+1; j <= (items.size() - (i+1)); j++) {
            if (items.get(i).getId() == items.get(j).getId()) {
               return false;
            } 
         }
      }
      return true;
   }

   /**
    * Adds a Library Item to the catalog
    */
   public String add(LibraryItem libraryItem)
   {
      nextId++;
      String libraryItemId = String.valueOf(nextId);
      addLibraryItemWithId(libraryItem, libraryItemId);
      return libraryItemId;
   }


   /**
    * If the book with the specified id is in the catalog's book collection and is available for checkout, 
    * the Catalog class marks this book as unavailable and returns True (meaning, checkout was successful). 
    * Otherwise, the method returns false.
    */
   public boolean checkout(String id)
   {
      CatalogItem matchedItem = findItem(id);
      boolean retValue = false;

      // if the book is available, make it not available
      // checkout is successful
      if (matchedItem != null && matchedItem.isAvailable())
      {
         matchedItem.setUnavailable();
         retValue = true;
      }

      return retValue;
   }

   /**
    * If the book with the specified id is in the catalog's book collection and is currently checked out, 
    * the Catalog marks this book as available and returns true (meaning, the return was successful). 
    * Otherwise, the method returns false. 
    */
   public boolean checkin(String id)
   {
      CatalogItem matchedItem = findItem(id);
      boolean retValue = false;

      // if the book is found and is currently unavailable, mark it as available
      if (matchedItem != null && !matchedItem.isAvailable())
      {
         matchedItem.setAvailable();
         retValue = true;
      }

      return retValue;
   }

   /*
    * Searches the book catalog for books that match the searchTerm exactly (equals) in the 
    * Title, First Name, or Last name attributes of the LibraryItem class. Returns the ArrayList of 
    * String objects - ids of the items that matched the searchTerm
    **/
   public ArrayList<String> search(String searchTerm)
   {
      ArrayList<String> retValue = new ArrayList<String>();

      // go through every book int the catalog and check if it matches the searchTerm
      // look at title, author first name, and author last name 
      for (CatalogItem item: this.catalogItems)
      { 
         LibraryItem libraryItem = item.getLibraryItem();
         //System.out.println(libraryItem.matches(searchTerm));
         if(libraryItem.matches(searchTerm)) 
         {
            retValue.add(item.getId());
         }
      }

      return retValue;
   }

   public LibraryItem getLibraryItem(String id)
   {
      CatalogItem item = findItem(id);
      LibraryItem retValue = null;
      if (item != null)
      {
         retValue = item.getLibraryItem();
      }
      return retValue;
   }
   /*
    * If the book with the specified bookId is in the Catalog's book collection and is available for checkout, 
    * removes the book from the collection and returns true. Otherwise, returns false.
    **/
   public boolean remove(String id)
   {
      CatalogItem item = findItem(id);
      boolean retValue = false;

      if (item != null && item.isAvailable())
      {
         this.catalogItems.remove(item);
         retValue = true;
      }
      return retValue;
   }


   private void addLibraryItemWithId(LibraryItem libraryItem, String id)
   {
      CatalogItem item = new CatalogItem(libraryItem, id, true);
      catalogItems.add(item);
   }


   private CatalogItem findItem(String id)
   {
      CatalogItem matchedItem   = null;

      // find the book with the specified id
      for (CatalogItem item: this.catalogItems)
      {
         if (item.getId().equals(id))
         {
            matchedItem = item;
            break;
         }
      }
      return matchedItem;
   }


}
