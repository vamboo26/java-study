package datastructure;

import org.junit.Test;

import java.util.Stack;

public class MyQueueByStack<E> {

    private Stack<E> in = new Stack<>();
    private Stack<E> out = new Stack<>();

    public void enQueue(E item) {
        in.add(item);
    }

    public E deQueue() {
        if(out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        return out.pop();
    }

    @Test
    public void test() {
        MyQueueByStack<Integer> qs = new MyQueueByStack<>();
        qs.enQueue(1);
        qs.enQueue(2);
        qs.enQueue(3);

        System.out.println(qs.deQueue());
        System.out.println(qs.deQueue());
        System.out.println(qs.deQueue());
        System.out.println(qs.deQueue());
    }

}
