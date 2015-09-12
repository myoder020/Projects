/**
 * Created by Yoder on 5/28/2015.
 */

import exceptions.EmptyCollectionException;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedListStackImpl<T> implements StackADT<T>{
    /** indicates number of elements stored */
    private int count;
    /** pointer to top of stack */
    private LinearNode<T> top;

    public LinkedListStackImpl() {
        count = 0;
        top = null;
    }

    @Override
    public void push(T element) {
        LinearNode<T> curr = new LinearNode<>(element);

        curr.setNext(top);
        top = curr;
        count++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if(isEmpty())
            throw new EmptyCollectionException("Stack");

        T result = top.getElement();
        top = top.getNext();
        count--;

        return result;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }


}
