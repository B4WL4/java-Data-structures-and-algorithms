import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearchList{
    static ArrayList<Integer> list=new ArrayList<>();
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        for(int i=10;i<=100;i+=10){
            list.add(i);
        }
        System.out.print("Enter value to search: ");
        int value=input.nextInt();
        int index=search(value);
        if(index>-1) {
            System.out.println("value is found at index: "+index);
        }else System.out.println("value is not found in array..");
    }

    //binary search
    public static int search(int value){
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
