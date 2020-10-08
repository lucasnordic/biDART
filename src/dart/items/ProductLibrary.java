package DART.Data;

import DART.Data.Game;
import DART.Data.Product;
import DART.Data.SongAlbum;
import DART.UserInputHandler;

import java.util.ArrayList;

public class ProductLibrary {

    private ArrayList<Product> products = new ArrayList<>();


//    private static ArrayList<Product> games = new ArrayList<>();
//    private static ArrayList<Product> albums = new ArrayList<>();


    public Product find(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().toString().equals(id)) {
                return products.get(i);
            }
        }
        return null;
    }

    public void showAllGames() {
        for (Product product : products) {
            if (product instanceof Game) {
                System.out.println(product);
            }
        }
    }

    public void showAllAlbums() {
        for (Product product : products) {
            if (product instanceof SongAlbum) {
                System.out.println(product);
            }
        }
    }

    public void showAvailableAlbums() {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getRentStatus().equals("available")) {
                System.out.println(products.get(i));
            }
        }
    }
    public void showAvailableAll() {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getRentStatus().equals("available")) {
                System.out.println(products.get(i));
            }
        }
    }

    public void showAvailable() {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getRentStatus().equals("available")) {
                System.out.println(products.get(i));
            }
        }
    }
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Yay!Added!");
    }

    public void removeProduct(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().toString().equals(id)) {
                products.remove(i);
                System.out.println("Removed!");
                return;
            }
        }
        System.out.println("Album with ID " + id + " is not found.");
    }

    public void rentProduct(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().toString().equals(id)) {
                if (products.get(i).getRentStatus().equals("rented")) {
                    System.out.println("Product ID" + id + " is already rented");
                    return;
                }
                if (products.get(i).getRentStatus().equals("available")) {
                    products.get(i).rent();
                    System.out.println("Yay! Rented!");
                    return;
                }
                System.out.println("Product with ID " + id + " not found");
            }
        }
    }

    public void menuGiveARating(String id) {
        System.out.print("Please give any number between 0 and 5: ");
        int rating = UserInputHandler.inputInt();
        System.out.print("Please write a review: ");

        String review = UserInputHandler.inputString();
        for (Product product : products) {
            if (product.getId().equals(id)) {
                product.setUserRatings(rating);
                //product.setReview(review);
            }
        }
    }
}
