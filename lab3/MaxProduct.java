public class MaxProduct
{
    public static void main(String[] args) {
        int arr[]=new int[]{3,5,7,8,1,8,3,4};
        int first=0,second=0,third=0;
        for(int i=0;i<8;i++){
            if(first<=arr[i])
                first=arr[i];
        }
        for(int i=0;i<8;i++){
            if(arr[i]<first && second<=arr[i])
                second=arr[i];
        }
        for(int i=0;i<8;i++){
            if(arr[i]<first && arr[i]<second && third<=arr[i]){
                third = arr[i];
            }
        }
        System.out.print("Array : { ");
        for(int x:arr){
            System.out.print(x+" ");
        }
        System.out.println("}\nProduct of three largest numbers of array are: "+(first*second*third));
    }
}
