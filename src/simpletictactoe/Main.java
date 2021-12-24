package simpletictactoe;

public class Main {
    public static void main(String[] args) {
        MyClass obj1 = new MyClass(), obj2 = new MyClass();
        obj1.f();
        obj2.f();
        obj1.f();
    }

}

class MyClass{
    static int count;
    void f(){
        count++;
        System.out.print(count + " ");

    }


}