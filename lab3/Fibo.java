import java.util.Scanner;

public class Fibo {
    static long arr[];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = 50; //Enter Nth Position to which Fibonacci array will be printed
        arr = new long[N];
        int n1 = 1, n2 = 1, fb = 0;
        arr[0] = n1;
        arr[1] = n2;
        for (int i = 2; i < N; i++) {
            fb = n1 + n2;
            arr[i] = fb;
            n1 = n2;
            n2 = fb;
        }
//        System.out.print("array of first " + N + " Fibonacci numbers is : { ");
//        for (long x : arr) {
//            System.out.print(x + " ");
//        }
//        System.out.print(" }");
        System.out.print("Enter number whom to find is fibonacci or not: ");
        int num=in.nextInt();
        int index=findFibo(arr,num);
        if(index>-1) {
            System.out.println(num+" is Fibonacci and is found at Position: "+(index+1));
        }else System.out.println(num+" is not fibonacci..");
    }
    public static int findFibo(long[] arr, int num) {
        int l = 0, u = arr.length - 1, mid = -1;
        while (!(l > u)) {
            mid = (l + u) / 2;
            if (arr[mid] > num)
                u = mid - 1;
            else if (arr[mid] < num)
                l = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
