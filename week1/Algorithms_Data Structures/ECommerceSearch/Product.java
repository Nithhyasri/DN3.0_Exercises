import java.util.Arrays;

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

public class ECommerceSearch {
    public static Product linearSearch(Product[] products, String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null; 
    }

    public static Product binarySearch(Product[] products, String productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId().equals(productId)) {
                return products[mid];
            } else if (products[mid].getProductId().compareTo(productId) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; 
    }

    public static void main(String[] args) {
      
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P003", "Tablet", "Electronics"),
            new Product("P004", "Headphones", "Accessories"),
            new Product("P005", "Smartwatch", "Wearables")
        };

        String searchId1 = "P003";
        Product result1 = linearSearch(products, searchId1);
        System.out.println("Linear Search Result for " + searchId1 + ": " + (result1 != null ? result1 : "Product not found"));

        Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId())); 
        String searchId2 = "P002";
        Product result2 = binarySearch(products, searchId2);
        System.out.println("Binary Search Result for " + searchId2 + ": " + (result2 != null ? result2 : "Product not found"));
    }
}
