public class Quick extends Sorter{

    void sort() {
        A = quickSort(A, 0, A.length-1);
    }

    // Sorting Array by picking a pivot element and partitioning the array so 
    // that smaller elements are to the left and higher to the right. 
    int[] quickSort(int[] A, int low, int high){
        // Base case for the recursion.
        if(low >= high){
            return A;
        }

        int p = partition(A, low, high);
        quickSort(A, low, p-1);
        quickSort(A, p+1, high);
        return A;
    }

    // Chooses the median of the first, middle and last element as the pivot.
    // Can help reduce the likelyhood of very uneven partitions.
    int choosePivot(int[] A, int low, int high){
        int mid = (low + high)/2;

        if(A[low] > A[mid] && A[low] < A[high]){
            return low;
        } else if (A[high] < A[mid] && A[high] > A[low]){
            return high;
        } else return mid;
    }

    // Handels the partitioning and swaps of the array
    int partition(int[]A, int low, int high){
        int p = choosePivot(A, low, high);
        swap(p, high); // Moves the pivot to the end temporarily 

        int pivot = A[high];
        int left = low;
        int right = high - 1; 

        // Move elements that are smaller than the pivot to the left and larger to the right. 
        while (left <= right){
            while ((left <= right) && leq(A[left], pivot)){
                left ++;
            }
            while ((right >= left) && geq(A[right], pivot)){
                right --;
            }
            if(lt(left, right)){
                swap(left, right);
            }
        }

        // Places pivot in the "right" space.
        swap(left, high); 
        // Returns the new index for pivot.
        return left;
    }

    String algorithmName() {
        return "quick";
    }
}
