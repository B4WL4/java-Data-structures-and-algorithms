import java.util.ArrayList;

public class IntersectionList {
    public static void main(String[] args) {
        int arr1[]=new int[]{1,2,3,4,5,6};
        int arr2[]=new int[]{0,2,6};
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        for(int i=0;i<6;i++){
            list1.add(arr1[i]);
        }
        for(int i=0;i<3;i++){
            list2.add(arr2[i]);
        }
        findIntersect(list1,list2);
    }
    public static void findIntersect(ArrayList<Integer> l1,ArrayList<Integer> l2){
        System.out.print("The intersection set of two arrayList is: { ");
        for(int x:l1){
            for(int y:l2){
                if(x==y)
                    System.out.print(x+" ");
            }
        }
        System.out.print("}");
    }
}
