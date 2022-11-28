import java.util.Arrays;

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
        return indexOf(item) != -1;
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

}
