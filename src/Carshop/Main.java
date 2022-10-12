package Carshop;
import CarshopImplement.MyOwnAutoShop;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    //a method to show up the work of app
    public static void main (String[] args) throws IOException{
        MyOwnAutoShop shop = new MyOwnAutoShop();
        Scanner num = new Scanner(System.in);
        int menu;
        System.out.println("\nWelcome to the car shop!");
        do {
            System.out.println("\nChoose the type of car you want to buy:\n\t1. Truck\n\t2. Ford\n\t3. Sedan");
            menu = num.nextInt();
        } while (menu>3||menu<1);
        menu--;
        shop.purchaseCar(menu);
    }
}
