public class matrixIntersection {
    public static void main(String[] args) {
        int matix1[][]=new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int matrix2[][]=new int[][]{
                {2,4},
                {6,7}
        } ;
        findIntersect(matix1,matrix2);
    }
    public static void findIntersect(int[][] m1,int[][] m2){
        int common[]=new int[10];
        int k=0;
       for(int x[]:m1){
           for(int x1:x){
               for(int y[]:m2){
                   for(int y1:y){
                       if(x1==y1){
                           common[k]=x1; //storing common elements of two matrices
                           k++;
                       }
                   }
               }
           }
       }
        System.out.print("The intersection set of two matrices is: {");
       for (int i=0;i<k;i++){
           System.out.print(common[i]+" ");
       }
        System.out.print("}");
    }
}


//  if(x==y) {
//          for (int i=0;i<10;i++){
//        if(intersect[i]!=x){
//        intersect[i]=x;
//        k++;
//        break;
//        }
//        }
//        }
//        System.out.print("The intersection set of two arrays is: { ");
//        for (int i=0;i<k;i++){
//        System.out.print(intersect[i]+" ");
//        }
//        System.out.print("}");