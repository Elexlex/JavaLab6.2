package Carshop;

public abstract class Car {

    //fields
    int[] speed;
    boolean[] isSellOut;
    double[] regularPrice;
    String[] color;

    //constructor
    public Car(int maxNumber){
        color = new String[maxNumber];
        speed = new int[maxNumber];
        regularPrice = new double[maxNumber];
        isSellOut = new boolean[maxNumber];
    }

    //getters/setters
    public int[] getSpeed() {
        return speed;
    }

    public boolean[] getIsSellOut() {
        return isSellOut;
    }

    public double[] getRegularPrice() {
        return regularPrice;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

    public void setRegularPrice(double[] regularPrice) {
        this.regularPrice = regularPrice;
    }

    public void setIsSellOut(boolean[] sellOut) {
        isSellOut = sellOut;
    }

    public void setSpeed(int[] speed) {
        this.speed = speed;
    }

    //an abstract method that calculates the amount including discounts in the next classes
    public abstract double getSalePrice(int number);
}
