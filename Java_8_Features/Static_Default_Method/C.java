package Java_8_Features.Static_Default_Method;

interface A {
    default void show() {
        System.out.println("A interface Default Method Calling");
    }
}

interface B {
    default void show() {
        System.out.println("B interface Default Method Calling");
    }
}

public class C implements A, B {
    public void show() {
        A.super.show();
    }

    public static void main(String[] args) {
        C c=new C();
        c.show();
        Util.help();
    }
}

interface Util {
    static void help() {
        System.out.println("Static Method Calling");
    }
}




