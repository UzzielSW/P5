//TDArray.java

class TDArray{
   public static void main(String BDP[])   {
      int val[][];
      val =new int[3][3];//creation of multidimensional integer array
      for(int i=0;i<3;i++)
           for(int j=0;j<3;j++) {  
              val[i][j]=1;       
              System.out.print(val[i][j]);   
       		}
   }
}
