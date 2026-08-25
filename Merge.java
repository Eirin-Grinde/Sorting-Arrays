import java.util.Arrays;

class Merge extends Sorter {

    void sort() {
        A = mergeSort(A);
    }

    // Recursively split A into halves until each part has one element, then merge the sorted halves.
    int[] mergeSort(int[] A){
        // Base case.
        if (A.length <= 1){
            return A;
        } 
        // Splits A in half and recursively sort both halves.
        int i = A.length/2;
        int[] A1 = mergeSort(Arrays.copyOfRange(A, 0, i));
        int[] A2 = mergeSort(Arrays.copyOfRange(A, i, A.length));
        return merge(A1, A2, A); // Merge the sorted halves into A.
    }

    // Merging to sorted arrays.
    int[] merge(int[] A1, int[] A2, int[] A){
        int i = 0;
        int j = 0;
        // Runs through A1 and A2, inserting the elements in ascending order into A.
        while (i < A1.length && j < A2.length){
            if (leq(A1[i], A2[j])){
                A[i+j] = A1[i];
                i ++;
            } else {
                A[i+j] = A2[j]; 
                j ++;
            }
        }
        // Inserting the rest of A1 if A2 is empty.
        while(i < A1.length){
            A[i+j] = A1[i];
            i ++;
        }
        // and the other way around.
        while(j < A2.length){
            A[i+j] = A2[j];
            j ++;
        }
        return A;
    }

    String algorithmName() {
        return "merge";
    }
}
