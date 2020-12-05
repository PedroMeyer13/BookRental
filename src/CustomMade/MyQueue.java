package CustomMade;

import Interface.ArrayQueue;

import java.util.ArrayList;

public class MyQueue implements ArrayQueue {
    // declare variables to be able to store data and create a queue
    private ArrayList<String> data;
    private int size;
    private int front;
    private int rear;

    public MyQueue() {
        // declare the values for the starting values
        this.data = new ArrayList<>();
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    @Override // adding a new element on the array list
    public boolean Enqueue(String newElement) {
        // checking if the queue was empty, if so we add increase the value for front, it only happens if the queue is empty
        if(front == -1) {
            front++;
        }
        //increase the value for rear
        rear++;
        //add to the Array List
        data.add(rear, newElement);
        // increase the size of the queue
        size++;
        return true;
    }

    @Override// remove one item from the queue
    public String Dequeue() {
        // if the queue is empty return null
        if(size == 0) {
            return null;
        }
        // get the item on the front to return to the user
        String toReturn = data.get(front);
        //set the old front to null
        data.set(front, null);
        // add front value to to refer to the next item on the queue
        front++;
        // reduce the size of the queue
        size--;
        return toReturn;
    }

    @Override// get the first Item of the queue
    public String First() {
        // if the queue is empty return null
        if(size == 0) {
            return null;
        }
        // if there are items get the one in front position and returns the item
        return data.get(front);
    }

    @Override// get the last Item of the queue
    public String Last() {
        // if the queue is empty return null
        if(size == 0) {
            return null;
        }
        // if there are items get the one in front position and returns the item
        return data.get(rear);
    }

    @Override// get the size of the queue
    public int size() {
        // return the size
        return size;
    }

    @Override// check if the queue is empty
    public boolean isEmpty() {
        // if it is return ture, otherwise false.
        if(size == 0) {
            return true;
        }
        return false;
    }

    @Override// return the queue in a string format
    public String toString() {

        String toReturn = "[ ";

        for(int i = front; i <= rear; i++) {
            toReturn += data.get(i) + " ";
        }

        toReturn += "]";

        return toReturn;
    }

}
