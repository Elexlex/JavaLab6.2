package CarshopImplement;
import CarshopInterface.Admin;
import CarshopInterface.Customer;
import Carshop.Car;
import Carshop.Truck;
import Carshop.Ford;
import Carshop.Sedan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

//an interface that implements 2 interfaces
public class MyOwnAutoShop implements Admin, Customer {
    private final int range = 10;

    //array of objects
    Car[] carArray = {new Truck(range), new Ford(range), new Sedan(range)};

    //a method that sums up all made purchases
    public void getIncome(double price) throws IOException{
        File summaryText = new File("E:\\Pawa\\Lab 6\\Income.txt");
        Scanner file = new Scanner (summaryText);
        double sum = 0;
        while (file.hasNextLine()){
        sum = Double.parseDouble(file.nextLine());
        }
        sum+=price;
        FileWriter writer = new FileWriter(summaryText, false);
        System.out.printf("\n\nTotal Company Income: %.2f$", sum);
        writer.write(String.valueOf(sum));
        writer.close();
    }

    //a method that is responsible for the availability of cars
    public void getIsSellOut(int id){
        Random rand = new Random();
        boolean[] bool = new boolean[range];
        for (int i = 0; i<range; i++)
            bool[i] = rand.nextBoolean();
        carArray[id].setIsSellOut(bool);
    }

    //reads the speed values from a file and passes them to the setter
    public void getCarSpeed(int id) throws FileNotFoundException{
        File speedText = new File("E:\\Pawa\\Lab 6\\Speed.txt");
        Scanner file = new Scanner (speedText);
        int[] speed = new int[range];
        int i = 0;
        while (file.hasNextLine()){
            speed[i] = Integer.parseInt(file.nextLine());
            if (id == 0)
                speed[i] -= 20;
            else if (id == 2)
                speed[i] += 20;
            i++;
        }
        carArray[id].setSpeed(speed);
    }

    //reads the price values from a file and passes them to the setter
    public void getCarPrice(int id) throws FileNotFoundException{
        File priceText = new File("E:\\Pawa\\Lab 6\\Price.txt");
        Scanner file = new Scanner (priceText);
        double[] price = new double[range];
        int i = 0;
        while (file.hasNextLine()){
            price[i] = Integer.parseInt(file.nextLine());
            if (id == 0)
                price[i] -= 2000;
            else if (id == 2)
                price[i] += 2000;
            i++;
        }
        carArray[id].setRegularPrice(price);
    }

    //reads the color from a file and passes them to the setter
    public void getCarColor(int id) throws FileNotFoundException{
        File colorText = new File("E:\\Pawa\\Lab 6\\Color.txt");
        Scanner file = new Scanner (colorText);
        String[] color = new String[range];
        int i = 0;
        while (file.hasNextLine()){
            color[i] = file.nextLine();
            i++;
        }
        carArray[id].setColor(color);
    }

    //shows up a selection of cars and lets the user choose one
    public void purchaseCar(int id) throws IOException{
        setCarSetting(id);
        Scanner num = new Scanner(System.in);
        int menu;
        double truePrice;
        for(int i = 0; i<range; i++){
            System.out.print("\n#" + (i+1) + " - " + carArray[id].getSpeed()[i] + " km/h, " + carArray[id].getColor()[i] + ", ");
            if (id==0)
                System.out.print(((Truck)carArray[id]).getWeight()[i] + " kg, ");
            else if (id==1)
                System.out.printf(((Ford)carArray[id]).getYear()[i] + " year, -%.2f$ discount, ", ((Ford)carArray[id]).getManufacturerDiscount()[i]);
            else
                System.out.print(((Sedan)carArray[id]).getLength()[i] + " cm, ");
            System.out.printf("%.2f$ raw price, ", carArray[id].getRegularPrice()[i]);
            System.out.print("in stock: " + carArray[id].getIsSellOut()[i]);
        }
        do{
            System.out.println("\n");
            menu = num.nextInt();
            if (carArray[id].getIsSellOut()[menu-1])
                System.out.print("\nOut of stock.");
        } while ((menu>10||menu<1) || carArray[id].getIsSellOut()[menu-1]);
        menu--;
        truePrice = carArray[id].getSalePrice(menu);
        System.out.print("\nSo you bought:\n");
        if (id==0) System.out.print("A truck with " + ((Truck)carArray[id]).getWeight()[menu] + " kg, ");
        else if (id==1) System.out.print("A ford with " + ((Ford)carArray[id]).getYear()[menu] + " year, ");
        else System.out.print("A sedan with " + ((Sedan)carArray[id]).getLength()[menu] + " cm, ");
        System.out.print(carArray[id].getSpeed()[menu] + " km/h, " + carArray[id].getColor()[menu]);
        System.out.printf("\nTotal price including all the discounts: %.2f$", truePrice);
        getIncome(truePrice);
    }

    //reads the year and discount values from a file and passes them to the setter
    private void gettingFord(int id) throws FileNotFoundException{
        if (id==1) {
            File yearText = new File("E:\\Pawa\\Lab 6\\Year.txt");
            File discountText = new File("E:\\Pawa\\Lab 6\\Discount.txt");
            Scanner y = new Scanner(yearText);
            Scanner d = new Scanner(discountText);
            int[] year = new int[range];
            double[] discount = new double[range];
            int i = 0;
            while (y.hasNextLine()) {
                year[i] = Integer.parseInt(y.nextLine());
                discount[i] = Integer.parseInt(d.nextLine());
                i++;
            }
            ((Ford) carArray[id]).setYear(year);
            ((Ford) carArray[id]).setManufacturerDiscount(discount);
        }
    }

    //reads the weight values from a file and passes them to the setter
    private void gettingWeight(int id) throws FileNotFoundException{
        if (id==0){
            File weightText = new File("E:\\Pawa\\Lab 6\\Weight.txt");
            Scanner file = new Scanner(weightText);
            int[] weight = new int[range];
            int i = 0;
            while (file.hasNextLine()) {
                weight[i] = Integer.parseInt(file.nextLine());
                i++;
            }
            ((Truck) carArray[id]).setWeight(weight);
        }
    }

    //reads the length values from a file and passes them to the setter
    private void gettingLength(int id) throws FileNotFoundException{
        if (id==2) {
            File lengthText = new File("E:\\Pawa\\Lab 6\\Length.txt");
            Scanner file = new Scanner(lengthText);
            int[] length = new int[range];
            int i = 0;
            while (file.hasNextLine()) {
                length[i] = Integer.parseInt(file.nextLine());
                i++;
            }
            ((Sedan) carArray[id]).setLength(length);
        }
    }

    //sets all car values for the user to select
    private void setCarSetting(int id) throws FileNotFoundException{
        getIsSellOut(id);
        getCarSpeed(id);
        getCarPrice(id);
        getCarColor(id);
        gettingWeight(id);
        gettingFord(id);
        gettingLength(id);
    }
}
