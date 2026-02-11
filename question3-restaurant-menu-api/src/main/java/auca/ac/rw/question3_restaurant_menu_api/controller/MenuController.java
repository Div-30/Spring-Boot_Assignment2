package auca.ac.rw.question3_restaurant_menu_api.controller;

import auca.ac.rw.question3_restaurant_menu_api.model.MenuItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private List<MenuItem> menu = new ArrayList<>();

    
    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllMenu() {
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id) {
        for (MenuItem item : menu) {
            if (item.getId().equals(id)) {
                return new ResponseEntity<>(item, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<MenuItem>> getMenuByCategory(@PathVariable String category) {
        List<MenuItem> itemsByCategory = new ArrayList<>();
        for (MenuItem item : menu) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                itemsByCategory.add(item);
            }
        }
        return new ResponseEntity<>(itemsByCategory, HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<List<MenuItem>> getAvailableMenu(@RequestParam(defaultValue = "true") boolean available) {
        List<MenuItem> availableItems = new ArrayList<>();
        for (MenuItem item : menu) {
            if (item.isAvailable() == available) {
                availableItems.add(item);
            }
        }
        return new ResponseEntity<>(availableItems, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<MenuItem>> searchMenu(@RequestParam String name) {
        List<MenuItem> searchResults = new ArrayList<>();
        for (MenuItem item : menu) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                searchResults.add(item);
            }
        }
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem) {
        menu.add(menuItem);
        return new ResponseEntity<>(menuItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/availability")
    public ResponseEntity<MenuItem> toggleAvailability(@PathVariable Long id) {
        for (MenuItem item : menu) {
            if (item.getId().equals(id)) {
                item.setAvailable(!item.isAvailable());
                return new ResponseEntity<>(item, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {
        for (MenuItem item : menu) {
            if (item.getId().equals(id)) {
                menu.remove(item);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}