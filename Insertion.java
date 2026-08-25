class Insertion extends Sorter {

    void sort() {
        // Treats the elements before i as sorted.
        // Move A[i] left until it is in the correct position.
        for(int i = 1; i < n; i++){
            int j = i; 
            // Swap ajacent elements while the current element is smaller than its predecessor.
            while(j > 0 && gt(A[j-1], A[j])){
                swap(j-1, j);
                j--;
            }
        } 
    }

    String algorithmName() {
        return "insertion";
    }
}
