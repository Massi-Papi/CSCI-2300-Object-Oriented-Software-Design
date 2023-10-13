import java.io.IOException;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        CatalogItemLoaderCSV catalogItemLoaderCSV = new CatalogItemLoaderCSV();
        if (args.length > 0) {
            try {
                catalogItemLoaderCSV.loadItems(args[0]);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        } else {
            System.out.println("Usage: java Driver <CSV FILE>");
            System.exit(1);
        }

        ArrayList<CatalogItem> catalogItemList = catalogItemLoaderCSV.getItems();
        Catalog catalog = new Catalog(catalogItemList);
        ArrayList<String> foundItems = catalog.search("Mike");
        System.out.println("Items with Mike");
        for (String item : foundItems) {
            System.out.println(catalog.getLibraryItem(item));
        }
    }
}
