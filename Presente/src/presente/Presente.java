/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presente;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vicky
 * 
 *      
 *      Realizar un programa que sobre un número constante que van a ser el tamaño del array,
        pida esa cantidad de números introducidos por teclado, los meta en un array y use un
        método, con la cabecera que tenemos justo debajo, para revisar dicho array eliminando
        los duplicados y devolviendo un nuevo vector para finalmente imprimir el array
        resultante.
        Método a crear:
        public static int[] borrarDuplicados(int[] listaNum)
 * 
 * 
 * 
 */
public class Presente {
    
    //  Realizar un programa que sobre un número constante (que van a ser el tamaño del array,)
    static final int TAMANO = 5;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // los meta en un array
        int[] numeros = new int[TAMANO];
        // pida esa cantidad de números introducidos por teclado,
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("INTRODUCE " + TAMANO + " NÚMEROS");
        
        for (int i = 0; i < TAMANO; i++) {
            numeros[i] = entrada.nextInt();       
        }
        
        int [] resultado = borrarDuplicados(numeros);
        for (int i = 0; i < resultado.length; i++) {
            System.out.println(resultado[i]);
            
        }
        
    }
    
    /**
     * y use un
        método, con la cabecera que tenemos justo debajo, para revisar dicho array eliminando
        los duplicados y devolviendo un nuevo vector para finalmente imprimir el array
        resultante.
        Método a crear:
        public static int[] borrarDuplicados(int[] listaNum)
     */
     public static int[] borrarDuplicados(int[] listaNum){
         
         ArrayList<Integer> list = new ArrayList<>();
         
         for(int i : listaNum) {
             if(!list.contains(i)){
                 list.add(i);
             }
         }
         
         int[] elArrayQueVoyADevolver = new int[list.size()];
         for(int i= 0; i< list.size(); i++){
             elArrayQueVoyADevolver[i] = list.get(i);
         }
         
         return elArrayQueVoyADevolver;
         
     }
}
