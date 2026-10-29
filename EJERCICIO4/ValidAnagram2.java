//CODIGO REALIZADO SIN PLANTILLA
//compilar: javac ValidAnagram2.java
//test: java ValidAnagram2 < caso1.txt
//test: java ValidAnagram2 < caso2.txt
//test: java ValidAnagram2 < caso3.txt

import java.util.Scanner;
import java.util.Arrays;

public class ValidAnagram2 {
    public static void main (String [] args){
        Scanner scanner = new Scanner (System.in);

        //Verifica que haya primera linea y la guarda en palabra1
        if (!scanner.hasNextLine()){
            System.out.println(false);
            scanner.close();
            return;
        }
        String palabra1 = scanner.nextLine();

        
        //Verifica que haya segunda linea y la guarda en palabra2
        if(!scanner.hasNextLine()){
            System.out.println(false);
            scanner.close();
            return;
        }
        String palabra2 = scanner.nextLine();


        //Misma logica que del codigo con plantilla
        String limpia1 = palabra1.replaceAll("\\s+", "").toLowerCase();
        String limpia2 = palabra2.replaceAll("\\s+", "").toLowerCase();

        // Si no miden lo mismo, no son anagramas
        if (limpia1.length() != limpia2.length()) {
            System.out.println(false);
            scanner.close();
            return;
        }

        // Convertimos a arreglos, ordenamos y comparamos
        char[] arr1 = limpia1.toCharArray();
        char[] arr2 = limpia2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean esAnagrama = Arrays.equals(arr1, arr2);

        // Imprimimos el resultado
        System.out.println(esAnagrama);

        scanner.close();
    }
        }

    

