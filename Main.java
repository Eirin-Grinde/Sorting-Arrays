import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner; 

class Main {
    public static void main(String[] args) throws Exception {
        // Getting the filename 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Filename?");
        String filename = scanner.nextLine();
        File file = new File(filename);

        // Making sure the file works
        while(!(file.exists() && file.isFile())){
            System.out.println("File does not exist or could not be found, try again (if in folder try folder/filename):");
            filename = scanner.nextLine();
            file = new File(filename);
        } 

        // Reading the file
        BufferedReader in = new BufferedReader(new FileReader(file));
        int[] A = in.lines().mapToInt(i -> Integer.parseInt(i)).toArray();
        in.close();

        // User input for which sorting alg to use
        System.out.println("Which sorting algorithm do you want to use?");
        System.out.println("1. Insertion sort");
        System.out.println("2. Merge sort");
        System.out.println("3. Quick sort");
        System.out.println("4. Radix sort");
        System.out.println("5. Stooge sort");
        System.out.println("Enter number:");
        int algorithm = scanner.nextInt();
        
        // Making sure the input is valid
        while(!(algorithm == 1 || algorithm == 2 || algorithm == 3 || algorithm == 4 || algorithm == 5)){
            System.out.println("Please enter a number between 1 and 5:");
            algorithm = scanner.nextInt();
        }

        scanner.close();    

        // Sending to SortRunner with chosen alg
        if(algorithm == 1){
            Sorter alg = new Insertion();
            SortRunner.runAlgsPart1(A, filename, alg); 
            SortRunner.runAlgsPart2(A, filename, alg);
        } else if(algorithm == 2){
            Sorter alg = new Merge();
            SortRunner.runAlgsPart1(A, filename, alg); 
            SortRunner.runAlgsPart2(A, filename, alg);
        } else if(algorithm == 3){
            Sorter alg = new Quick();
            SortRunner.runAlgsPart1(A, filename, alg); 
            SortRunner.runAlgsPart2(A, filename, alg);
        } else if(algorithm == 4){
            Sorter alg = new Radix();
            SortRunner.runAlgsPart1(A, filename, alg); 
            SortRunner.runAlgsPart2(A, filename, alg);
        } else if(algorithm == 5){
            Sorter alg = new stooge();
            SortRunner.runAlgsPart1(A, filename, alg); 
            SortRunner.runAlgsPart2(A, filename, alg);
        }    
    }
}
