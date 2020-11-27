package Interface;

public interface ArrayQueue {

    /**
     * Adds an new element at the back of the queue
     * Takes a newElement as a parameter
     * and returns false is capacity full
     */
    public boolean Enqueue(String newElement);

    /**
     * Removes an element from the front of the queue
     * and return null if queue is empty
     */
    public String Dequeue();

    /**
     * First element of the queue without removing it
     * and return null if empty
     */
    public String First();

    /**
     * Last element of the queue without removing it
     * and return null if empty
     */
    public String Last();

    /**
     * return the Number of elements in the queue
     */
    public int size();

    /**
     * return True if there is no elements in the queue
     */
    public boolean isEmpty();

}
