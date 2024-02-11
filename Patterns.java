/*        1)Number of rows and columns
          2)Basic boiler plate code
          for(int i=1;i<= ;i++){
             for(int j=1;j<= ;j++){
                 System.out.println("*");
                }   
            }
          3)Each row nummber of stars
          4)Relate stars with ---> i,j
          5)Write Code
         */

// import java.util.*;
public class Patterns {
    public static void main(String[] args){
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        for(int i=1;i<=5;i++){
            for(int j=4;j>=i;j--){
                System.out.print(j+" ");
            }
            System.out.println();
        }


            
    }
}
