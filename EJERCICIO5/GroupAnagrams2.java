//CODIGO REALIZADO SIN PLANTILLA (FUERZA BUTA)
//compilar: javac GroupAnagrams2.java
//test: java GroupAnagrams2 < caso3.txt

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams2{
    public static void main (String [] args){
        Scanner scanner = new Scanner (System.in);

        //Primer paso: pedirle al usuario que ingrese la cantidad de palabras :p
       System.out.print("Cuantas palabras quieres ingresar?:");
       int n = scanner.nextInt();

       //Paso 2: Definirlas en un arreglo
       String [] palabras = new String[n];
       //Paso 3: Pedirle al usuario que ingrese las palabras (separadas por espacio)
       System.out.println("Ingresa las"  + n +  "palabras separadas:");
       for (int i = 0; i < n; i++){
        palabras[i] = scanner.next();
       }
       scanner.close();

       //Logica del HashMap para agrupar anagramas
       Map<String, List<String>> mapa = new HashMap<>();

        for (String palabra : palabras) {
            char[] caracteres = palabra.toCharArray();
            Arrays.sort(caracteres);
            String clave = new String(caracteres);

            mapa.computeIfAbsent(clave, k -> new ArrayList<>()).add(palabra);
        }

        //Filtrar únicamente los grupos con anagramas reales (tamaño > 1)
        List<List<String>> resultadoFiltrado = new ArrayList<>();
        for (List<String> grupo : mapa.values()) {
            if (grupo.size() > 1) {
                resultadoFiltrado.add(grupo);
            }
        }

        System.out.println("Grupos de anagramas encontrados:");
        System.out.println(resultadoFiltrado);
    }
}