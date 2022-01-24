package day03;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.Collator;
import java.util.*;

public class WebShop24 {

    public Map<String, List<String>> getAllSoldProducts() {
        return allSoldProducts;
    }

    Map<String, List<String>> allSoldProducts = new TreeMap<>();

    public void readShoppingList(String fileName) {
        try (Scanner scanner = new Scanner(Paths.get(fileName))   ) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] tmp = row.split(" ");
                String[] products = tmp[1].split(";");
                List<String> productList = new ArrayList<>(Arrays.asList(products));
                allSoldProducts.put(tmp[0].trim(), productList);
            }
        } catch(IOException ioe) {
            throw new IllegalArgumentException("File cannot be found", ioe);
        }
    }

    public boolean sellingWebSopProducts(String customer, String newProduct) {

        if (allSoldProducts.containsKey(customer)) {
            allSoldProducts.get(customer).add(newProduct);
        } else {
            throw new IllegalArgumentException("Customer code is incerrect");
        }
        return false;
    }

    public List<String> soldProductsByID(String customerID) {
        if (allSoldProducts.containsKey(customerID)) {
            List<String> result = new ArrayList<>(allSoldProducts.get(customerID));
            Collections.sort(result, Collator.getInstance());
            return result;
        } else {
            throw new IllegalArgumentException("Customer ID is not correct");
        }
    }

    public int countSoldProductsByProductName(String product) {
        int count = 0;
        List<String> allProducts = new ArrayList<>();
        for (Map.Entry<String, List<String>> actual : allSoldProducts.entrySet()) {
            allProducts.addAll(actual.getValue());
        }
        for ( String actual : allProducts) {
            if (actual.equals(product)) {
                count++;
            }
        }
        return count;
    }

    public int  countSoldProductsByCustomerId(String customerID) {

        if (allSoldProducts.containsKey(customerID) ) {
            return allSoldProducts.get(customerID).size();
        } else {
            throw new IllegalArgumentException("Customer code is not correct!");
        }
    }

    public Map<String, Integer> countAllProductsByAllSale() {
        Map<String, Integer> salesStatistics = new TreeMap<>();
        List<String> allProducts = new ArrayList<>();
        //összes termék egy listában
        for (Map.Entry<String, List<String >> actual : allSoldProducts.entrySet()) {
            allProducts.addAll(actual.getValue());
        }
        //listában egyesével végig és beírni mapbe újfeljegyzésként, vagy növelni a value-t
        for ( String actual : allProducts ) {
            if (salesStatistics.containsKey(actual)) {
                salesStatistics.put(actual, salesStatistics.get(actual) + 1);
            } else {
                salesStatistics.put(actual, 1);
            }
        }
        return salesStatistics;
    }

    public static void main(String[] args) {
        WebShop24 webshop24 = new WebShop24();
        webshop24.readShoppingList("src/test/resources/purchaselist.txt");
        webshop24.sellingWebSopProducts("A001", "SÖR");
        System.out.println(webshop24.soldProductsByID("A001"));
        System.out.println("Vásárló összes termékeinek száma: "+webshop24.countSoldProductsByCustomerId("A001"));
        System.out.println("Egy adott termékből aladások száma: "+webshop24.countSoldProductsByProductName("cukor"));
        System.out.println("Egy adott termékből aladások száma: "+webshop24.countSoldProductsByProductName("áfonya"));
        System.out.println("Statisztika: "+webshop24.countAllProductsByAllSale());
    }
}
