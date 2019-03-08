package sod.lab3;

import java.util.Arrays;

public class ArrayPriorityQueue implements PriorityQueue {
    private int length = 0;
    private int[] arr = new int[10];

    public int length() {
        return length;
    }

    public void offer(int n) {
        if (length == arr.length) { //если кончается место, увеличить размер
            arr = Arrays.copyOf(arr, arr.length*2 + 1);
        }

        if ( length == 0 ) {
            arr[length++] = n;
        } else if ( length == 1 ) {
            if ( n > arr[0] ) {
                arr[1] = n;
            } else {
                arr[1] = arr[0];
                arr[0] = n;
            }
            length++;
        } else {
            int index = binarySearch(n);
            int[] right = new int[arr.length-index];
            System.arraycopy(arr, index, right, 0, right.length); //копируем кусок справа от места вставки
            arr[index] = n;
            System.arraycopy(right, 0, arr, index + 1, right.length - 1); //вставляем правый кусок обратно
            length++;
        }
    }

    public Integer poll() {
        if ( length > 0 ) {
            int res = arr[length-1];
            length--;
            arr = Arrays.copyOf(arr, length);
            return res;
        } else {
            return null;
        }
    }

    public Integer peek() {
        if ( length > 0 ) {
            return arr[length -1];
        } else {
            return null;
        }
    }

    private int binarySearch(int searchValue){
        int avgIndex, firstIndex = 0;
        int lastIndex = length - 1;
        if ( searchValue >= arr[lastIndex] ) {
            return lastIndex+1;
        }
        while ( firstIndex < lastIndex ) {
            avgIndex = firstIndex + ((lastIndex - firstIndex)/2);
            if (searchValue <= arr[avgIndex]) {
                lastIndex = avgIndex ;
            }
            else {
                firstIndex = avgIndex + 1;
            }
        }
        return lastIndex;
    }

}