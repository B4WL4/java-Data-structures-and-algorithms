public class Intersection {
    public static void main(String[] args) {
        int arr1[]=new int[]{1,2,3,4,5,6};
        int arr2[]=new int[]{0,2,6};
        findIntersect(arr1,arr2);
    }
    public static void findIntersect(int[] a1,int[] a2){
        System.out.print("The intersection set of two arrays is: { ");
        for(int x:a1){
            for(int y:a2){
                if(x==y)
                    System.out.print(x+" ");
            }
        }
        System.out.print("}");
    }
}
