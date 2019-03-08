package sod.lab3;

public class ListPriorityQueue implements PriorityQueue {
    private int length = 0;
    private Element head = null;
    private Element tail = null;

    public int length() {
        return length;
    }

    public void offer(int n) {
        Element newElement = new Element(n);
        if (head!=null) {
            if ( n>tail.data && n<head.data ) { //в середину
                Element left = tail, right;
                while ( left.next != null ) {
                    right = left.next;
                    if ( right.data >= n ) {
                        newElement.previous = left;
                        newElement.next = right;
                        left.next = newElement;
                        right.previous = newElement;
                        break;
                    }
                    left=right;
                }
            } else if ( n <= tail.data ) { //в конец
                newElement.next = tail;
                tail.previous = newElement;
                tail = newElement;
            } else if ( n >= head.data ){ //в начало
                newElement.previous = head;
                head.next = newElement;
                head = newElement;
            }
        } else { //единственный элемент
            head = newElement;
            tail = newElement;
        }
        length++;
    }

    public Integer poll() {
        Element res = head;
        if (head!=null) {
            length--;
            head = head.previous;
            return res.data;
        } else {
            return null;
        }
    }

    public Integer peek() {
        if ( head != null ) {
            return head.data;
        } else {
            return null;
        }
    }

    private class Element {
        private int data;
        private Element next = null;
        private Element previous = null;
        Element(int data){
            this.data = data;
        }
    }

}