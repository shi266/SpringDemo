package sanqi.com.test.thread;

public class Number {
    int count = 0;

    public  void getCount(){
        count++;
        System.out.println(count);
    }
    public static void main(String[] args) {
            new one().start();
            new two().start();

    }
}
class one extends Thread{
    @Override
    public void run() {
        Number n = new Number();

            System.out.print("one:");
            n.getCount();

    }
}
class two extends Thread{
    @Override
    public void run() {
        Number n = new Number();


            n.getCount();

    }
}