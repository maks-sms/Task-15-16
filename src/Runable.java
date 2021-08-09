public class Runable implements Runnable {

    private final int[] array;
    private final int from;
    private final int to;
    private int mid;

    public Runable(int[] array, int from, int to) {
        this.array = array;
        this.from = from;
        this.to = to;
    }

    public int getMid() {
        return mid;
    }

    @Override
    public void run() {
        int toFrom = to - from;
        int sumArr = 0;

        for (int i = from; i < to; i++) {
            sumArr += array[i];
        }
        mid = sumArr / toFrom;


    }
}