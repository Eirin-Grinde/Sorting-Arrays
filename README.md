# Sorting-Arrays
Implementation and comparison of different sorting algorithms in Java.

This project was originally developed as part of the IN2010 course at the University of Oslo. The project has since been updated to make the program more usable as a standalone project.

## Sorting algorithms
The project contains implementations of:
- Insertion Sort
- Merge Sort
- Quick Sort
- Radix Sort
- Stooge Sort

The first four was part of the original assignment. Stooge was added as an extra algorithm to experiment with a worse theoretical performance.

## How to use
Compile the Java files and run `Main`.
The program will ask for:

1. The filename containing the array/integers to sort.
2. Which sorting algorithm you want to use.

The program checks that the input file exists and lets the user choose between the five algorithms.
The selected algorithm is then passed to the sorting framework, which produces the sorted output and experimental results.

## Input files
The input files should contain integers with one integer on each line. 
Example: 
`
42
17
8
23
4
`

The original input files used were provided through the IN2010 sorting [resources](https://github.uio.no/IN2010/sortering-ressursside). Example input files can be found there.

## Course framework
The project was based on a framework provided as a part of IN2010, and can be found on the page mentioned above.
The following files were provided:
- Sorter.java
- SortRunner.java
- Main.java

The sorting algorithms were implemented as part of the assignment. The project has since been adjusted, including changes to `Main.java` so that the user can select the input file and the sorting algorithm interactively.

`SortRunner.java` is still used for running the sorting algorithm and producing the output files, but has been adjusted to accommodate for the CLI. 

## Analysis
The project also contains Python code used to plot the experimental results to analyse the sorting algs.
The analysis looks at measurments such as:
- Runtime
- Number of comparisons
- Number of swaps
- The effect of different input sizes
- The effect of input order

## References
[IN2010 sorting resources](https://github.uio.no/IN2010/sortering-ressursside)
