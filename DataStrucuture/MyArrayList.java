package DataStrucuture;
import java.util.Arrays;

public class MyArrayList {
    private Object[] data;
    private int count = 0;
    private int FIXED_SIZE = 10;

    public MyArrayList() {
        data = new Object[this.FIXED_SIZE];
    }

    /**
     * Get the specific object
     *
     * @param index
     * @return the data
     */
    public Object get(int index) {
        if (index < count) {
            return data[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Add new object to the array list
     *
     * @param obj
     */
    public void add(Object obj) {
        if (data.length - count <= data.length / 2) {
            this.reSizeArray();
        }

        data[count++] = obj;
    }

    /**
     * Remove the object from list
     *
     * @param index
     * @return
     */
    public Object remove(int index) {
        if (index < count) {
            Object obj = data[index];
            int temp = index;
            data[index] = null;

            while (temp < count) {
                data[temp] = data[temp + 1];
                data[temp + 1] = null;
                temp++;
            }

            count--;
            return obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Resizing the array
     */
    public void reSizeArray() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        MyArrayList solution = new MyArrayList();
        solution.add(new Integer(2));
        solution.add(new Integer(5));
        solution.add(new Integer(1));
        solution.add(new Integer(23));
        solution.add(new Integer(14));
        for (int i = 0; i < solution.size(); i++) {
            System.out.print(solution.get(i) + " ");
        }
        solution.add(new Integer(29));
        System.out.println("Element at position 5:" + solution.get(5));
        System.out.println("Total List size: " + solution.size());
        System.out.println("Removing element at position 2: " + solution.remove(2));
        for (int i = 0; i < solution.size(); i++) {
            System.out.print(solution.get(i) + " ");
        }
    }

}
