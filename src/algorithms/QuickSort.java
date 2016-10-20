package algorithms;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] input = inputGenerator(50, 0, 200000);

        sort(0, input.length, input);

        System.out.println(isSortedCheck(input));
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println("");
    }

    public static void sort(int startIndex, int endIndex, int[] inputArray) {
        if (endIndex - startIndex == 0)
            return;

        int temp;
        int pivotIndex = startIndex;

        for (int i = startIndex; i < endIndex; i++) {
            if (inputArray[i] < inputArray[pivotIndex]) {
                temp = inputArray[i];
                inputArray[i] = inputArray[pivotIndex + 1];
                inputArray[pivotIndex + 1] = inputArray[pivotIndex];
                inputArray[pivotIndex] = temp;
                pivotIndex++;
            }
        }     
        
        if (startIndex < pivotIndex)
            sort(startIndex, pivotIndex + 1, inputArray);
        if (pivotIndex + 1 < endIndex)
            sort(pivotIndex + 1, endIndex, inputArray);
    }

    public static int[] inputGenerator(int size, int minRange, int maxRange) {
        int[] inputArray = new int[size];

        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            inputArray[i] = rand.nextInt(maxRange - minRange) + minRange;

        }

        return inputArray;
    }

    public static boolean isSortedCheck(int[] inputArray) {
        for (int i = 0; i < inputArray.length - 1; i++) {
            if (inputArray[i] > inputArray[i + 1])
                return false;
        }

        return true;
    }
}
