package day03;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Webshop {

    Map<String, List<String>> allSoldProducts = new TreeMap<>();

    public Map<String, List<String>> getAllSoldProducts() {
        return allSoldProducts;
    }

    public void readFile(String fileRoute) {
        try (Scanner scanner = new Scanner(Paths.get(fileRoute))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] idAndProducts = line.split(" ");
                String[] tmp = idAndProducts[1].split(";");
                allSoldProducts.put(idAndProducts[0], new ArrayList<>(Arrays.asList(tmp)));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File cannot be found!", ioe);
        }
    }

    public void addNewProduct(String customer, String newProduct) { //egyik vásárláshoz adjunk terméket
        for (Map.Entry<String, List<String>> actual : allSoldProducts.entrySet()) {
            if ( actual.getKey().equals(customer)) {
                actual.getValue().add(newProduct);
                System.out.println("Megtalálta");
            }
        }
    }

    public List<String> shoppingListByCustomer(String customer) { //egyedi azonosító alapján melyek a vásárolt termékek ABC szerint
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> actual : allSoldProducts.entrySet()) {
            if (actual.getKey().equals(customer)) {
                return actual.getValue();
            }
        }
        return result;
    }


    public int  soldByProduct(String product) {  //mennyit adtak el az adott termékből
        List<String> allSold = new ArrayList<>();
        int count = 0;
        for (Map.Entry<String, List<String>> actual : allSoldProducts.entrySet()) {
            allSold.addAll(actual.getValue());
        }
        for (String actual : allSold) {
            if (actual.equals(product)) {
                count++;
            }
        }
        return count;
    }

    public int collectAllProducts(String customer) {   //vásárlási azonosító alapján hány termék szerepel a listán
        for (Map.Entry<String, List<String>> actual : allSoldProducts.entrySet()) {
            if (actual.getKey().equals(customer)) {
                actual.getValue().sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
                return actual.getValue().size();
            }
        }
        throw new IllegalArgumentException("Customer code is not correct!");
    }

   /* public Map<String, Integer> soldProductsStatistics() {  //az egyes termékek hányszor szerepelnek a listán
        List<String> allSoldProducts = new ArrayList<>();
        for (Map.Entry<String, List<String>> actual : allSoldProducts.en) {

        }
        for (Map.Entry<String, List<String>> actual : allSoldProducts.entrySet()) {

        }
        return null;
    }*/

    public static void main(String[] args) {
        Webshop webshop = new Webshop();
        webshop.readFile("src/test/resources/purchaselist.txt");
        System.out.println(webshop.getAllSoldProducts());
        webshop.addNewProduct("A001", "KALÁCS");
        System.out.println(webshop.shoppingListByCustomer("A001"));
        System.out.println("A vásárló összes terméke: "+webshop.shoppingListByCustomer("A001"));
        System.out.println("Darabszám: "+webshop.collectAllProducts("A001"));
        System.out.println("Egyes termékből eladottak összesen: "+webshop.soldByProduct("KALÁCS"));
        System.out.println("Egyes termékből eladottak összesen: "+webshop.soldByProduct("sör"));
    }
}
