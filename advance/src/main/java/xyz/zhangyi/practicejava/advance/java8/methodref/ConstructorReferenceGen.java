package xyz.zhangyi.practicejava.advance.java8.methodref;

public class ConstructorReferenceGen {
    static <Ob, X, Y, Z> Ob factory(FuncInt<Ob, X, Y, Z> obj, X p1, Y p2, Z p3){
        return obj.func(p1, p2, p3);
    }

    public static void main(String[] args){
        System.out.println();

        //Example #1
        FuncInt<Automobile<String, String, Integer>, String, String, Integer> auto_cons = Automobile::new;
        Automobile<String, String, Integer> honda = factory(auto_cons, "Honda", "Accord", 2006);
        honda.what();

        //Example #2
        FuncInt<Plane, String, String, Integer> plane_cons = Plane::new;
        Plane cessna = factory(plane_cons, "Cessna", "Skyhawk", 172);
        cessna.what();
        System.out.println();
    }
}
