package sod.lab3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        ArrayPriorityQueue apq = new ArrayPriorityQueue();
        ListPriorityQueue lpq = new ListPriorityQueue();

        int answer;
        while (true) {
            printMenu();
            answer = in.nextInt();
            switch (answer) {
                case 0: return;
                case 1: {
                    System.out.print("Enter a number: ");
                    int n = in.nextInt();
                    apq.offer(n);
                    lpq.offer(n);
                    System.out.println("Successfully added");
                    break;
                }

                case 2: {
                    System.out.println("Max removed from APQ: "+apq.poll());
                    System.out.println("Max removed from LPQ: "+lpq.poll());
                    break;
                }

                case 3: {
                    System.out.println("Max in APQ: "+apq.peek());
                    System.out.println("Max in LPQ: "+lpq.peek());
                    break;
                }

                case 4: {
                    printInsertionTime(apq, lpq);
                    break;
                }

                case 5: {
                    printRemovalTime(apq, lpq);
                    break;
                }

                case 6: {
                    System.out.println("APQ size: "+apq.length());
                    System.out.println("LPQ size: "+lpq.length());
                    break;
                }

                default: System.out.println("Wrong number, try again!");
            }
        }
    }

    private void printInsertionTime(ArrayPriorityQueue apq, ListPriorityQueue lpq) {
        int[] arr = generateArr(10);
        long start = System.currentTimeMillis();
        for (int item : arr) {
            apq.offer(item);
        }
        System.out.println("Insertion time to PQ based on:");
        System.out.println("Array | List");
        System.out.print((double)(System.currentTimeMillis()-start)/1000 + " | ");

        start = System.currentTimeMillis();
        for (int item : arr) {
            lpq.offer(item);
        }
        System.out.println((double)(System.currentTimeMillis()-start)/1000);
    }

    private void printRemovalTime(ArrayPriorityQueue apq, ListPriorityQueue lpq) {
        int size = apq.length();
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            System.out.print(apq.poll()+" ");
        }
        System.out.println();
        double time = (double)(System.currentTimeMillis()-start)/1000;

        size = lpq.length();
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            System.out.print(lpq.poll()+" ");
        }
        System.out.println();
        System.out.println("Removal time of PQ based on:");
        System.out.println("Array | List");
        System.out.println(time+" | "+(double)(System.currentTimeMillis()-start)/1000);
    }

    private void printMenu() {
        System.out.println("1) Add element\n"+
                "2) Remove max element\n"+
                "3) Print max element\n"+
                "4) Add 1000 random numbers\n"+
                "5) Remove all\n"+
                "6) Print size\n"+
                "0) Exit"
        );
    }

    private int[] generateArr(int size) {
        return new Random().ints(size, 1, 100).toArray();
    }

}