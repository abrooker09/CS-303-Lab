import java.util.*;


public class Lab1{

/*linear search*/

    public static void LinearSearch(int[] data, int n){

       int found = 0;
       for (int i = 0; i<data.length; i++){
           if (n == data[i]){
              found = 1;
              System.out.println(n + " found at index " + i);
              break;
           }
       }
       if (found == 0)
          System.out.println(n + " Not found\n");
    }


/*binary search*/

    public static int BinarySearch(int[] data, int l, int r, int n){
         if (r >= l){
             int mid = l + (r-l)/2;
             if (data[mid] == n)
                return mid;
             if (data[mid] < n)
                return BinarySearch(data,mid+1,r,n); /*making it recursive*/
             if (data[mid] > n)
                return BinarySearch(data,l,mid-1,n);
         }
         return -1;
    }

    public static void main(String[] args){
    	

        Random rand = new Random(); /*randomizing the selected array*/
        int[] data = new int[10];
        int n;

        for (int i = 0; i<10; i++){
           data[i] = rand.nextInt(1048576);/*allowing all random integers between 0-2^20*/
        }
        System.out.println("Selected array:"); /*selecting integers for linear search*/
        for (int i = 0; i<10; i++)
            System.out.print(data[i] + " ");/*displays the selected integers*/ 
        System.out.println();
        n = data[5];
        System.out.println("Linear Search Result:");
        LinearSearch(data,n);
        System.out.println("\n");/*adding a space between searches for appearance*/
      
        /*Driver Program*/
        Arrays.sort(data); /*sorting input array*/
        System.out.println("Selected array:"); /*selecting integers for binary search*/
        for (int i = 0; i<10; i++)
            System.out.print(data[i] + " ");
        System.out.println(); /*displays the selected random integers*/
        System.out.println("Binary Search Result:");
        int res = BinarySearch(data,0,9,n);
        if (res == -1)
            System.out.println( n + " Not found");
        else
            System.out.println(n + " found at index " + res);

    }
}