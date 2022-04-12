package sanqi.com.test.thread;

public class NumTest {
   private static int num = 0;
    public  static void numUP(){
        num++;
        System.out.println(num);
    }


    public static void main(String[] args) {
    new Thread(new A()).start();
    new Thread(new B()).start();
    new Thread(new C()).start();

    }

}
class A implements Runnable{
   A(){
       System.out.print("线程A执行");
   }
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.print("线程A:");
            NumTest.numUP();
        }

    }
}
class B implements Runnable{
    B(){
        System.out.print("线程B执行");
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("线程B:");
            NumTest.numUP();
        }

    }
}
class C implements Runnable{
    C(){
        System.out.print("线程C执行");
    }
    @Override
    public void run() {
        for (int i = 0; i < 150; i++) {
            System.out.print("线程C:");
            NumTest.numUP();
        }

    }
}