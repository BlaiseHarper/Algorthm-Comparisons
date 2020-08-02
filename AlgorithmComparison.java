/*
 * This is a program I made for my calculus II class. I was trying to prove 
 * how a bubble sorting algorithm (with O(n^2) time complexity) is slower at
 * sorting than a 
 *
 * 
 * @author Blaise Harper, Calculus II, S02118492
 */

package algorithmcomparison;
import java.util.Random;
import java.time.Instant;
import java.util.Date;



public class AlgorithmComparison 
{
    //Main Method
    public static void main(String[] args) throws InterruptedException
    {
        //Declaring maxiumum and minimum random values
        int min = 1; 
        int max = 100000;    
        
        //Creating two arrays that hold 100,000 integers each.
        int[] a1 = new int[100000];
        int[] a2 = new int[100000];
        
        //Writing an array of 100,000 random integers between 1 and 10,000,000
        for (int i = 0; i<100000; i++)
            {
                a1[i] = randomGenerator(min, max);
            }
        for (int i = 0; i<100000; i++)
            {
                a2[i] = randomGenerator(min, max);
            }
        
        //Writing an array of 100 random integers between 1 and 100
        int[] a3 = new int[100];
        for (int i=0; i<100; i++)
            {
                a3[i] = a1[i];
            }
        int[] a4 = new int[100];
        for (int i=0; i<100; i++)
            {
                a4[i] = a2[i];
            }
        
        //Print Name and Date:
        Date date = new Date();
        Instant instant1 = date.toInstant();
        System.out.println("Created by Blaise Harper");
        System.out.println("Program ran on "+ instant1);        
        System.out.println();
        
        //Bubble sort first 100 integers
        System.out.println("Starting Execution of Bubble Sort (100 random integers)");
        //Start of Execution time
        long startTime1 = System.nanoTime();
        bubbleSort(a3);
        long endTime1 = System.nanoTime();
	long timeElapsed = endTime1 - startTime1;
	System.out.println("Execution time in nanoseconds: " + timeElapsed);
	System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
        System.out.println();
        
        //Shell sort first 100 integers
        System.out.println("Starting Execution of Shell Sort (100 random integers)");
        //Start of Execution time
        long startTime2 = System.nanoTime();
        shellSort(a4);
        long endTime2 = System.nanoTime();
	timeElapsed = endTime2 - startTime2;
	System.out.println("Execution time in nanoseconds: " + timeElapsed);
	System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
        System.out.println();
        
        //Bubble sort first 100 integers
        System.out.println("Starting Execution of Bubble Sort (100,000 random integers)");
        //Start of Execution time
        long startTime3 = System.nanoTime();
        bubbleSort(a1);
        long endTime3 = System.nanoTime();
	timeElapsed = endTime3 - startTime3;
	System.out.println("Execution time in nanoseconds: " + timeElapsed);
	System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
        System.out.println();
        
        //Shell sort first 100 integers
        System.out.println("Starting Execution of Shell Sort (100,000 random integers)");
        //Start of Execution time
        long startTime4 = System.nanoTime();
        shellSort(a2);
        long endTime4 = System.nanoTime();
	timeElapsed = endTime4 - startTime4;
	System.out.println("Execution time in nanoseconds: " + timeElapsed);
	System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
        System.out.println();
    }
    
    //Random Integer Generator Method   
    public static int randomGenerator(int min, int max) 
        {
            return new Random().nextInt(max - min + 1) + min;
        }

    //Imported Bubble Sort Algorithm
    public static void bubbleSort(int[] list) 
        {
            boolean needNextPass = true;
   
            for (int k = 1; k < list.length && needNextPass; k++) 
                {
                    // Array may be sorted and next pass not needed
                    needNextPass = false;
                    for (int i = 0; i < list.length - k; i++) 
                        {
                            if (list[i] > list[i + 1]) 
                                {
                                    // Swap list[i] with list[i + 1]
                                    int temp = list[i];
                                    list[i] = list[i + 1];
                                    list[i + 1] = temp;
          
                                    needNextPass = true; // Next pass still needed
                                }                       
                        }
                }
        }

    //Imported Shell Sort Algorithm
    public static void shellSort(int[] list)
        {
            int n = list.length;
    
            // Start with a big gap, then reduce the gap
            for (int gap = n/2; gap > 0; gap /= 2)
                {
                    // Do a gapped insertion sort for this gap size. 
                    // The first gap elements a[0..gap-1] are already 
                    // in gapped order keep adding one more element 
                    // until the entire array is gap sorted
                    for (int i = gap; i < n; i += 1) 
                        { 
                            // add a[i] to the elements that have been gap 
                            // sorted save a[i] in temp and make a hole at 
                            // position i 
                            int temp = list[i]; 
  
                             // shift earlier gap-sorted elements up until 
                            // the correct location for a[i] is found 
                            int j; 
                            for (j = i; j >= gap && list[j - gap] > temp; j -= gap) 
                                list[j] = list[j - gap]; 
  
                                // put temp (the original a[i]) in its correct location 
                                list[j] = temp; 
                        }            
                }
        }
}