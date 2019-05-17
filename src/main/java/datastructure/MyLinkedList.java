package datastructure;

import org.junit.Test;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    private class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item) {
            this.item = item;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(this.item);
        }
    }

    public void addFirst(E item) {
        Node<E> newNode = new Node<>(item);
        newNode.next = first;
        first = newNode;
        size++;

        if(first.next == null) {
            last = first;
        }
    }

    public void addLast(E item) {
        Node<E> newNode = new Node<>(item);

        if(size == 0) {
            addFirst(item);
        } else {
            last.next = newNode;
            last = newNode;
            size++;
        }
    }

    public void add(int index, E item) {
         if(index == 0) {
             addFirst(item);
         } else {
             Node<E> x = node(index - 1);
             Node<E> y = new Node<>(item);
             Node<E> z = x.next;
             x.next = y;
             y.next = z;
             size++;

             if(z == null) {
                 last = z;
             }
         }
    }

    public E get(int index) {
        return node(index).item;
    }

    public E getFirst() {
        if (first == null)
            throw new NoSuchElementException();

        return first.item;
    }

    public E getLast() {
        if(last == null)
            throw new NoSuchElementException();

        return last.item;
    }

    public E removeFirst() {
        Node<E> temp = first;
        first = first.next;
        size--;
        E item = temp.item;
        temp = null;
        return item;
    }

    public E remove(int index) {
        if(index == 0)
            return removeFirst();

        Node<E> temp = node(index - 1);
        Node<E> toDelete = temp.next;
        temp.next = temp.next.next;
        if(toDelete == last) {
            last = temp;
        }
        size--;
        E item = toDelete.item;
        toDelete = null;
        return item;
    }

    public int size() {
        return size;
    }

    private Node<E> node(int index) {
        Node<E> x = first;

        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        return x;
    }

    @Override
    public String toString() {
        if(first == null) {
            return "[]";
        }

        Node<E> x = first;
        StringBuilder sb = new StringBuilder("[");

        while(x.next != null) {
            sb.append(x.item).append(", ");
            x = x.next;
        }

        return sb.append(x.item).append("]").toString();
    }

    @Test
    public void test() {
        MyLinkedList<Integer> ll = new MyLinkedList<>();

        ll.addFirst(10);
        System.out.println(ll.getFirst());
        ll.addFirst(20);
        System.out.println(ll.getFirst());
        ll.addFirst(30);
        System.out.println(ll.getFirst());

        System.out.println(ll.node(0));
        System.out.println(ll.node(1));
        System.out.println(ll.node(2));

        ll.add(1, 77);

        System.out.println(ll.node(0));
        System.out.println(ll.node(1));
        System.out.println(ll.node(2));
        System.out.println(ll.node(3));

        System.out.println(ll.getLast());

        ll.addLast(99);
        System.out.println(ll.getLast());

        System.out.println(ll);

        ll.removeFirst();
        System.out.println(ll);

        ll.remove(2);
        System.out.println(ll);

        System.out.println(ll.size());

        System.out.println(ll.get(0));

        //TODO indexOf 부터 내일!
    }

}
