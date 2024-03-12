import java.util.*;

public class SalesManager {
    private TreeMap<String, Integer> sales;
    public SalesManager() {
        this.sales = new TreeMap<>();
    }

    public void addSale(String product, int quantity) {
        if (sales.containsKey(product)) {
            int currentQuantity = sales.get(product);
            sales.put(product, currentQuantity + quantity);
        } else {
            sales.put(product, quantity);
        }
    }

    public void displaySales() {
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public int getTotalSales() {
        int totalSales = 0;
        for (int quantity : sales.values()) {
            totalSales += quantity;
        }
        return totalSales;
    }

    public String mostPopularProduct() {
        String mostPopularProduct = "";
        int maxQuantity = 0;
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maxQuantity) {
                mostPopularProduct = entry.getKey();
                maxQuantity = entry.getValue();
            }
        }
        return mostPopularProduct;
    }
}
