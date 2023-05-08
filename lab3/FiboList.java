import java.util.ArrayList;
import java.util.Scanner;

public class FiboList {
    static ArrayList<Integer> list=new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = 50; //Enter Nth Position to which Fibonacci array will be printed
        int n1 = 1, n2 = 1, fb = 0;
        list.add(n1);
        list.add(n2);
        for (int i = 2; i < N; i++) {
            fb = n1 + n2;
            list.add(fb);
            n1 = n2;
            n2 = fb;
        }
        System.out.print("Enter number whom to find is fibonacci or not: ");
        int num=in.nextInt();
        int index=findFibo(num);
        if(index>-1) {
            System.out.println(num+" is Fibonacci and is found at Position: "+(index+1));
        }else System.out.println(num+" is not fibonacci..");
    }
    public static int findFibo(int value){
        int l=0,u=list.size()-1,mid=-1;
        while(l<=u){
            mid=(l+u)/2;
            if(list.get(mid)>value)
                u=mid-1;
            else if(list.get(mid)<value)
                l=mid+1;
            else
                return mid;
        }
        return -1;
    }
}
