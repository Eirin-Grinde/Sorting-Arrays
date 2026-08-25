public class stooge extends Sorter {

    void sort(){
        A = stoogeSort(A, 0, A.length -1);
    }

    int[] stoogeSort(int[] A, int i, int j){
        if(i >= j) return A;
        // Compare the first and last elements. If necessary, swap them. 
        if(gt(A[i], A[j])){
            swap(i, j);
        }

        // If there are more than two elements, recursively sort:
        // The first 2/3
        // The last 2/3 
        // The first 2/3 again
        if((j - i + 1) > 2){
            int t = (j - i + 1)/3;
            stoogeSort(A, i, j - t);
            stoogeSort(A, i + t, j);
            stoogeSort(A, i, j - t);
        }
        return A;
    }
    String algorithmName() {
        return "stooge";
    }
}
