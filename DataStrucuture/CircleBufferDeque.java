package DataStrucuture;

// Java implementation of De-queue using circular array

// A structure to represent a Deque
public class CircleBufferDeque  {


    protected double[] buffer;  // circular array
    private int first, last;    // pointers to the front and end
    private int size;
    private int capacity;

    // initialize an empty deque

    public CircleBufferDeque(int capacity) {
        buffer = new double[capacity];  // create an array
        first = 1;                         // pointers initialized
        last = 0;
        size = 0;                           // number of elements
        this.capacity = capacity - 1;   // length of the array minus 1
    }

// Returns the number of nodes
    public int size() {
        return size;
    }
    // Test if empty
    public boolean isEmpty() {
        return size == 0;
    }

// Returns the first element
    public double peekFirst() throws Exception {
        if (isEmpty()){
            throw new Exception("Deque is empty.");
        }
        return buffer[(first-1)%capacity];
    }


    // Returns the last element

    public double peekLast() throws Exception {
        if (isEmpty()){
            throw new Exception("Deque is empty.");
        }

        return buffer[(last+1)%capacity];
    }



    // Adds a new element at the front
    public void addFirst(double value) throws Exception {
        if (size == capacity){
            throw new Exception("Deque is full.");
        }
        buffer[first] = value;
        first = (first+1)%capacity;
        size++;
    }

    // Adds a new node at the tail
    public void addLast(double value) throws Exception {
        if (size == capacity){
            throw new Exception("Deque is full.");
        }
        buffer[last] = value;
        last = (last-1)%capacity;
        size++;
    }

    // Removes the first node
    public double removeFirst() throws Exception {
        if (isEmpty())
            throw new Exception("Deque is empty.");
        first = (first-1)%capacity;
        size--;
        return buffer[first];
    }

    // Removes the last node
    public double removeLast() throws Exception {
        if (isEmpty())
            throw new Exception("Deque is empty.");
        last = (last+1)%capacity;
        size--;
        return buffer[last];
    }
}
