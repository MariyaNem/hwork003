package onlineShop;

import exceptions.ProductDatabaseException;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private final List<Product> stock;

    public List<Product> getStock() {
        return stock;
    }

    public ProductDatabase() {
        this.stock = new ArrayList<>();
        this.stock.add(new Product("Product 1", 10, 7.99));
        this.stock.add(new Product("Product 2", 20, 4.99));
        this.stock.add(new Product("Product 3", 5, 70.99));
        this.stock.add(new Product("Product 4", 30, 2.99));
        this.stock.add(new Product("Product 5", 2, 30.99));
    }

    public Product getProduct(int productId) throws ProductDatabaseException {

        if ((productId > 0) && (productId <= stock.size())) {
            return stock.get(productId - 1);
        }
        throw new ProductDatabaseException("Product not found.");
    }

    public void reduceProductQuantity(Product product, int quantity) {
        product.setAvailableQuantity(product.getAvailableQuantity() - quantity);
    }
}