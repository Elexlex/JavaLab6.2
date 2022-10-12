package Carshop;

public class Sedan extends Car{

    //field
    private int[] length;

    //constructor
    public Sedan(int maxNumber){
        super(maxNumber);
        length = new int[maxNumber];
    }

    //a method to calculate the amount including discounts
    @Override
    public double getSalePrice(int number) {
        if (length[number]>20)
            return regularPrice[number]*(1-0.05);
        else
            return regularPrice[number];
    }

    //getter/setter
    public int[] getLength() {
        return length;
    }

    public void setLength(int[] length) {
        this.length = length;
    }
}
