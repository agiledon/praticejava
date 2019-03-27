package xyz.zhangyi.practicejava.advance.java8.methodref;

public class Automobile<X, Y, Z> {
    private X make;
    private Y model;
    private Z year;

    public Automobile(X make, Y model, Z year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    protected void what(){
        System.out.println("This Automobile is a " + year + " " + make + " " + model + ".");
    }
}
