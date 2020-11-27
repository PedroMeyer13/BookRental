package CustomMade;

import Interface.ArrayQueue;

import java.util.ArrayList;

public class MyQueue implements ArrayQueue {

    private ArrayList<String> data;
    private int size;
    private int front;
    private int rear;

    public MyQueue() {

        this.data = new ArrayList<>();
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    @Override
    public boolean Enqueue(String newElement) {

//        if(rear >= data.size() - 1) {
//            System.out.println(data.size());
//            return false;
//        }

        if(front == -1) {
            front++;
        }
        rear++;
        data.add(rear, newElement);
        size++;
        return true;
    }

    @Override
    public String Dequeue() {

        if(size == 0) {
            return null;
        }
        String toReturn = data.get(front);
        data.set(front, null);
        front++;
        size--;
        return toReturn;
    }

    @Override
    public String First() {

        if(size == 0) {
            return null;
        }
        return data.get(front);
    }

    @Override
    public String Last() {
        if(size == 0) {
            return null;
        }
        return data.get(rear);
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {

        if(size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {

        String toReturn = "[ ";

        for(int i = front; i <= rear; i++) {
            toReturn += data.get(i) + " ";
        }

        toReturn += "]";

        return toReturn;
    }

}
