import java.util.Random;
import java.util.logging.Logger;

public class Main {

    static Logger logg = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {

        int[] array = addArray(10000000);
        Runable r1 = new Runable(array, 0, 2500000);
        Runable r2 = new Runable(array, 2500000, 5000000);
        Runable r3 = new Runable(array, 5000000, 7500000);
        Runable r4 = new Runable(array, 7500000, 10000000);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);

        long start = System.currentTimeMillis();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        long end = System.currentTimeMillis();

        int mid = (r1.getMid() + r2.getMid() + r3.getMid() + r4.getMid()) / 4;


        logg.info("Cреднее значение: " + mid);

        logg.info(String.valueOf(end - start));
    }

    public static int[] addArray(int size) {
        int[] arr = new int[size];

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(8000);
        }

        return arr;
    }


}