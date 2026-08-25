import java.util.ArrayList;

public class Radix extends Sorter{

    void sort(){
        A = radixSort(A);
    }

    // LSD radix Sort. Sorts the array by using bucket sort d times.
    int[] radixSort(int[] A){
        int d = maxDigits(A); // Find the largest number to determine how many loops are needed.
        for(int i = 0; i < d; i++){
            A = bucketSort(A, i); 
        }
        return A;
    }

    // Helper function for finding the number of digits in the largest number in A.
    // Use the fact that: floor(log10(Tall)) + 1 gives number of digits i a number.
    int maxDigits(int[] A){
        int md = 0;
        for (int i: A){
            if (i > md) md = i;
        }
        return (md == 0) ? 1 : (int) Math.log10(md) + 1;
    }

    // Bucket sort for whole numbers.
    int[] bucketSort(int[] A, int currentPlace){
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] B = new ArrayList[10];
        int place = currentPlace;
        
        // Represented by an array with N lists.
        int N = 10; // Number of possible digits/categories
        for(int i = 0; i < N; i++){
            B[i] = new ArrayList<>();
        }

        // Placing the elements in the list representing their category.
        int div = (int)Math.pow(10, place);
        for(int i = 0; i <= n-1; i++){
            int k = (A[i]/div) % 10; // divide by 10^(place) and take modulo 10 to get correct category.
            B[k].add(A[i]); 
        }

        // Insert all elements back in A.
        int j = 0;
        for(int k = 0; k <= N-1; k++){
            for(int x: B[k]){
                A[j] = x;
                j ++;
            }
        }
        return A;
    }
    
    String algorithmName() {
        return "radix";
    }
}
