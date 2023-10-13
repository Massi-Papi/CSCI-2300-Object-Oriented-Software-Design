import java.io.*;
import java.util.ArrayList;

public class CatalogItemLoaderCSV {
    private ArrayList<CatalogItem> catalog;

    public CatalogItemLoaderCSV() {
        this.catalog = new ArrayList<CatalogItem>();
    }

    public void loadItems(String fileName) throws IOException {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split(",");
                CatalogItem catalogItem;
                if (array.length == 9) {
                    Book book = new Book(array[2], Integer.parseInt(array[3]), array[5], array[6], array[7], array[8]);
                    catalogItem = new CatalogItem(book, array[0], array[1] == "1" ? true : false);
                    this.catalog.add(catalogItem);
                } 
                if (array.length == 8) {
                    Movie movie = new Movie(array[2], Integer.parseInt(array[3]), array[5], array[6], array[7]);
                    catalogItem = new CatalogItem(movie, array[0], array[1] == "1" ? true : false);
                    this.catalog.add(catalogItem);
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }
    
    public ArrayList<CatalogItem> getItems() {
        return this.catalog;
    }
}
