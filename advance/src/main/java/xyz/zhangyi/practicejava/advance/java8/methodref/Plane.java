package xyz.zhangyi.practicejava.advance.java8.methodref;

public class Plane {
    private String make;
    private String model;
    private int year;

    public Plane(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;//Automatic unboxing
    }

    protected void what(){
        System.out.println("This Plane is a " + year + " " + make + " " + model + ".");
    }
}
