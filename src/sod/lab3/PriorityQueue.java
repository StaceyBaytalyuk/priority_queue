package sod.lab3;

public interface PriorityQueue {
    void offer(int n);
    Integer poll();
    Integer peek();
    int length();
}