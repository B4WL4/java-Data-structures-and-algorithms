import java.util.ArrayList;

public class MaxProductList
{
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        int arr[]=new int[]{3,5,7,8,1,8,3,4};
        for(int i=0;i<8;i++){
            list.add(arr[i]);
        }
        int first=0,second=0,third=0;
        for(int i=0;i<8;i++){
            if(first<=list.get(i))
                first=list.get(i);
        }
        for(int i=0;i<8;i++){
            if(list.get(i)<first && second<=list.get(i))
                second=list.get(i);
        }
        for(int i=0;i<8;i++){
            if(list.get(i)<first && list.get(i)<second && third<=list.get(i)){
                third = list.get(i);
            }
        }
        System.out.println("ArrayList : "+list);
        System.out.println("Product of three largest numbers of array are: "+(first*second*third));
    }
}
