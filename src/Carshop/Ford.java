package Carshop;

public class Ford extends Car{

    //fields
    private int[] year;
    private double[] manufacturerDiscount;

    //constructor
    public Ford(int maxNumber){
        super(maxNumber);
        year = new int[maxNumber];
        manufacturerDiscount = new double[maxNumber];
    }

    //getters/setters
    public double[] getManufacturerDiscount() {
        return manufacturerDiscount;
    }

    public int[] getYear() {
        return year;
    }

    public void setManufacturerDiscount(double[] manufacturerDiscount) {
        this.manufacturerDiscount = manufacturerDiscount;
    }

    public void setYear(int[] year) {
        this.year = year;
    }

    //a method to calculate the amount including discounts
    @Override
    public double getSalePrice(int number) {
        return regularPrice[number]-manufacturerDiscount[number];
    }
}