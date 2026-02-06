import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Product{name='%s', price=%.1f}", name, price);
    }
}

public class Bai6 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1500.0));
        products.add(new Product("Phone", 800.0));
        products.add(new Product("Tablet", 1200.0));
        products.add(new Product("Mouse", 50.0));

        Collections.sort(products, new Comparator<Product>() {
        private int counter = 0;

            @Override
            public int compare(Product p1, Product p2) {
                counter++;
                return Double.compare(p1.price, p2.price);
            }
        });

        System.out.println("--- Sắp xếp theo giá (Anonymous Class) ---");
        products.forEach(System.out::println);
        Collections.sort(products, (p1, p2) -> p1.name.compareTo(p2.name));

        System.out.println("\n--- Sắp xếp theo tên (Lambda Expression) ---");
        products.forEach(System.out::println);
    }
}