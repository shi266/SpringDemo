package sanqi.com.test.threadPool;

public class ThreadPoolTest {

    public static void main(String[] args) {

        String a = "aa";
        String b = "bb";
        String c = "bb";
        if(!c.equals(a) && !c.equals(b)){
            System.out.println("不执行");
        }else {
            System.out.println("执行");
        }
    }

}
