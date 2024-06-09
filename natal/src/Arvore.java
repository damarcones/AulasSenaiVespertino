public class Arvore {
     public static void main(String[] args)
     {
            int i,j,posi,t,i2;
             posi=6;
             t=1;
            for (i=1;i<=6;i++)
            {
                for (j=1;j<=10;j++)
                if (j==posi)
                {
                 for (i2=1;i2<=t;i2++)
                     System.out.print('*');
    
                 t=t+2;
                 posi--;
    
                 }
                 else
                 {
                  System.out.print(' ');
    
                  }
                  System.out.println();
            }
        }
    }