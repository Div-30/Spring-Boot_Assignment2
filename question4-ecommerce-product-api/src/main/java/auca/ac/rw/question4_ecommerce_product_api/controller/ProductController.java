package auca.ac.rw.question4_ecommerce_product_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import auca.ac.rw.question4_ecommerce_product_api.model.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private List<Product> products = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                return new ResponseEntity<>(p, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                result.add(p);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getProductsByBrand(@PathVariable String brand) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getBrand().equalsIgnoreCase(brand)) {
                result.add(p);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {
        List<Product> result = new ArrayList<>();
        String key = keyword.toLowerCase();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(key) || p.getDescription().toLowerCase().contains(key)) {
                result.add(p);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
  
    @GetMapping("/price-range")
    public ResponseEntity<List<Product>> getProductsByPriceRange(@RequestParam Double min, @RequestParam Double max) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getPrice() >= min && p.getPrice() <= max) {
                result.add(p);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/in-stock")
    public ResponseEntity<List<Product>> getProductsInStock() {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getStockQuantity() > 0) {
                result.add(p);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        products.add(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product details) {
        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                p.setName(details.getName());
                p.setDescription(details.getDescription());
                p.setPrice(details.getPrice());
                p.setCategory(details.getCategory());
                p.setBrand(details.getBrand());
                p.setStockQuantity(details.getStockQuantity());
                return new ResponseEntity<>(p, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{productId}/stock")
    public ResponseEntity<Product> updateStock(@PathVariable Long productId, @RequestParam int quantity) {
        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                p.setStockQuantity(quantity);
                return new ResponseEntity<>(p, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        Product toRemove = null;
        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                toRemove = p;
                break;
            }
        }
        
        if (toRemove != null) {
            products.remove(toRemove);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}