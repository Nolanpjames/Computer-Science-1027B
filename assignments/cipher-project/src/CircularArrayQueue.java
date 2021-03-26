public class CircularArrayQueue<T> implements QueueADT<T> {

    private int front;
    private int rear;
    private int count;
    private T[] queue;
    final private int DEFAULT_CAPACITY = 20;

    /**
     * @author Justin Yan
     * Default constuctor
     */
    public CircularArrayQueue(){
        this.front = 1;
        this.rear = this.DEFAULT_CAPACITY;
        this.count = 0;
        this.queue = (T[])new Object[this.DEFAULT_CAPACITY];
    }

    /**
     * Second constructor, sets rear & queue capacity to parameter
     * @param initialCapacity
     */
    public CircularArrayQueue(int initialCapacity){
        this.front = 1;
        this.rear = initialCapacity;
        this.count = 0;
        this.queue = (T[])new Object[initialCapacity];
    }


    /**
     * Adds element to rear of queue
     * Expands capacity if neccessary
     * @param element  the element to be added to the rear of this queue
     */
    @Override
    public void enqueue(T element) {
        if (queue.length <= count){
            expandCapacity();
        }
        boolean already_enqueued = false;

        for(int j = front; (already_enqueued == false) && (j < queue.length + front); j++){
            int i = (j - 1) % queue.length;
            if (queue[i] == null){
                queue[i] = element;
                rear = (front + count) % queue.length;
                count += 1;
                already_enqueued =true;
            }
        }
    }

    /**
     * Removes and returns first element of stack if possible
     * @return firstItem
     */
    @Override
    public T dequeue(){
        T firstItem = first();
        queue[front - 1] = null;
        front = front % queue.length + 1;
        count -= 1;
        rear = (front + count - 1) % queue.length;
        return firstItem;
    }
    /**
     * Returns first element of queue without removing it, if possible
     * @return front element
     */
    @Override
    public T first() {
        if(isEmpty()){
            throw new EmptyCollectionException("Circular Array Queue is empty");
        }
        return queue[front - 1];
    }

    /**
     * Checks if count is less than or greater than 0, indicating an empty queue
     * @return boolean if queue is empty
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Number of items in queue
     * @return count
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     *
     * @return front index value
     */
    public int getFront(){
        return front;
    }
    /**
     *
     * @return rear index value
     */
    public int getRear(){
        return rear;
    }

    /**
     *
     * @return length of queue
     */

    public int getLength(){
        return queue.length;
    }

    /**
     *
     * @return String representation of queue
     */

    public String toString(){
        if(isEmpty()){
            return "The queue is empty";
        }

        String output = "QUEUE: ";

        for(int j = front; j < queue.length + front; j++){
            int i = (j - 1) % queue.length;

            if (queue[i] != null){
                output += queue[i] + ", ";
            }
        }
        return output.substring(0, output.length() - 2) + ".";
    }

    /**
     * Creates new queue 20 slots bigger than original
     */
    private void expandCapacity() {
        T[] newQueue = (T[]) new Object[queue.length + 20];

        for (int j = front; j < queue.length + front; j++) {
            int index = (j - 1) % queue.length;

            if (queue[index] != null) {
                newQueue[j - front] = queue[index];
            }
        }
        queue = newQueue;
        front = 1;
        rear = count;
    }
}
