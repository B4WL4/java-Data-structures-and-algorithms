import java.util.Scanner;

public class BinarySearch{
    static int arr[];
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        arr=new int[]{10,20,30,40,50,60,70,80,90,100};
        System.out.print("Enter value to search: ");
        int value=input.nextInt();
        int index=search(value);
        if(index>-1) {
            System.out.println("value is found at index: "+index);
        }else System.out.println("value is not found in array..");
    }

    //binary search
    public static int search(int value){
        int l=0,u=arr.length-1,mid=-1;
        while(l<=u){
            mid=(l+u)/2;
            if(arr[mid]>value)
                u=mid-1;
            else if(arr[mid]<value)
                l=mid+1;
            else
                return mid;
        }
        return -1;
    }
}
