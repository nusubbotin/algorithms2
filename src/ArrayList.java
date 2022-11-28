import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ArrayList implements IntList{

    private final Integer[] stor;
    private int size;

    public ArrayList() {
        stor = new Integer[10];
    }

    public ArrayList(int initSize) {
        stor = new Integer[initSize];
    }

    @Override
    public Integer add(Integer item) {
        validateSize();
        validateValue(item);
        stor[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateIndex(index);
        validateValue(item);

        if (index == size) {
           stor[size++] = item;
            return item;
        }

        System.arraycopy(stor, index, stor, index + 1, size - index);
        stor[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateValue(item);
        stor[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateValue(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);

        Integer item = stor[index];

        if (index != size){
            System.arraycopy(stor, index + 1, stor, index, size - index);
        }

        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] storCopy = toArray();
        sortInsertion(storCopy);
        return containsBinary(storCopy, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (stor[i].equals(item)){
                return 1;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size-1; i >= 0; i--) {
            if (stor[i].equals(item)){
                return 1;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return stor[index];
    }

    @Override
    public boolean equals(IntList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(stor, size);
    }

    private void validateValue(Integer value){
        if (value == null) {
            throw new NullValueException();
        }
    }

    private void validateSize(){
        if (size >= stor.length){
            throw new ArrayLengthExceptiom();
        }
    }

    private void validateIndex(int index){
        if (index < 0 || index > size){
            throw new ArrayIndexException();
        }
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static boolean containsDefault(Integer[] arr, int element) {
        for (int i : arr) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsBinary(Integer[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }


    public static Integer[] getRandomArray(int size){
        List<Integer> intList =  (List<Integer>) new Random().ints(size, 1, 1_000_000)
                .boxed()
                .collect(Collectors.toList())
                ;

        return (Integer[]) intList.toArray();
    }



}
