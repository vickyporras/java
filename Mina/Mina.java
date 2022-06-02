public class Mina{

  public int filas ;
  public int columnas;
  public int  matrix[][]  =new int[filas][columnas];

  public void crearMatriz(){

  }

  public void mostarMatriz(int[][] matrix){
       for(int i=0 ; i<filas; i++){
         for(int j=0; j<columnas; j++){
               System.out.print(matrix[i][j]);
          }
           System.out.println(" ");
       }
     }
}
