package Carshop;

public class Truck extends Car{

    //field
    private int[] weight;

    //constructor
    public Truck(int maxNumber){
        super(maxNumber);
        weight = new int[maxNumber];
    }

    //getter/setter
    public int[] getWeight() {
        return weight;
    }

    public void setWeight(int[] weight) {
        this.weight = weight;
    }

    //a method to calculate the amount including discounts
    @Override
    public double getSalePrice(int number) {
        if (weight[number]>2000)
            return regularPrice[number]*(1-0.1);
        else
            return regularPrice[number];
    }
}
