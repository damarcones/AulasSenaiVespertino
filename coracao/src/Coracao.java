public class Coracao {
    public static void main(String[] args) {
        int H=7,W=7;
        for(int i=2;i<=(H+1)/2;i++){
 
       for(int j=0;j<W/2-i;j++){
         System.out.print(" ");
        }
     for(int k=1;k<(i+1)*2+1;k++){
     System.out.print("*");
     }
 
     if(i==2){
     System.out.print(" ");
     }
 
     for(int j=0;j<W/2-i+1;j++){
     System.out.print(" ");
     }
 
     for(int k=1;k<(i+1)*2+1;k++){
     if(i==(H+1)/2&&k>i+3)
     System.out.print("");
     else
     System.out.print("*");
     }
     System.out.println();
 
     }
     int HH=17,WW=17;
     for(int i=1;i<=HH/2;i++){
 
     for(int j=1;j<=i;j++){
     System.out.print(" ");
     }
     int z=WW-2*i;
     for(int k=1;k<=z;k++){
     System.out.print("*");
     }
     System.out.println();
  }
 }
 }

