import java.util.Scanner;

public class postToInfix {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter The PostFix expression you want to convert: ");
        String postfix=in.next();
        System.out.println("Infix expression of the given PostFix expression is: "+toInfix(postfix));
    }
    static String toInfix(String postFix){
        String inFix="";
        Stack_Array<String> temp=new Stack_Array<>(postFix.length());
        for(int i=0;i<postFix.length();i++){
            char symbol=postFix.charAt(i);
            if(Character.isLetter(symbol) || Character.isDigit(symbol)){
                temp.push(String.valueOf(symbol));
            }else{
                String s2=temp.pop();
                String s1=temp.pop();
                inFix="("+s1+symbol+s2+")";
                temp.push(inFix);
            }
        }
        return inFix;
    }
}
