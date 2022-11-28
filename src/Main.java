import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task2() {

    }

    private static void task1() {
        IntList stringList = new ArrayList();
        long start;

        Integer[] arr = ArrayList.getRandomArray(100_000);

        start = System.currentTimeMillis();
        System.out.println("sortBubble:");
        Integer[] arrCopy = Arrays.copyOf(arr, arr.length);
        ArrayList.sortBubble(arrCopy);
        long time1 = System.currentTimeMillis() - start;
        System.out.println("Time sortBubble = " + time1);

        System.out.println(arrCopy);

        start = System.currentTimeMillis();
        System.out.println("sortBubble:");
        Integer[] arrCopy2 = Arrays.copyOf(arr, arr.length);
        ArrayList.sortSelection(arrCopy2);
        long time2 = System.currentTimeMillis() - start;
        System.out.println("Time sortSelection = " + time2);

        System.out.println(arrCopy2);

        start = System.currentTimeMillis();
        System.out.println("sortInsertion:");
        Integer[] arrCopy3 = Arrays.copyOf(arr, arr.length);
        ArrayList.sortInsertion(arrCopy3);
        long time3 = System.currentTimeMillis() - start;
        System.out.println("Time sortInsertion = " + time3);

        System.out.println(arrCopy3);

        Long minTime = Math.min(time1, Math.min(time2, time3));

        if (time1 == minTime){
            System.out.print("sortBubble");
        } else if (time2 == minTime) {
            System.out.print("sortSelection");
        } else if (time3 == minTime) {
            System.out.print("sortInsertion");
        }

        System.out.println(" fastest!");
    }
}