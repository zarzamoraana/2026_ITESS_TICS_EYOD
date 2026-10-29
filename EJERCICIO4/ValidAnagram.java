//CODIGO REALIZADO CON PLANTILLA
//compilar: javac ValidAnagram.java
//test: java ValidAnagram < caso1.txt
//test: java ValidAnagram < caso2.txt
//test: java ValidAnagram < caso3.txt

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays; //nos ayudara a ordenar las palabras 

public class ValidAnagram {
    
    String palabra1; //Para resolver si es un anagrama o no se deben de comparar 2 palabras no cadenas de texto como en el de palindrome
    String palabra2; 
    FastReader reader = new FastReader();

    static class FastReader {
        BufferedReader b;
        StringTokenizer s; 

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    String line = b.readLine();
                    if (line == null) return null;
                    s = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace(); 
                }
            }
            return s.nextToken();
        }

        int nextInt() { 
            return Integer.parseInt(next()); 
        }

        char nextChar() {
            return next().charAt(0);
        }

        long nextLong() { 
            return Long.parseLong(next()); 
        }

        double nextDouble() { 
            return Double.parseDouble(next()); 
        }

        String nextLine() {
            String str = "";
            try {
                if (s != null && s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace(); 
            }
            return str;
        }
    }
    public void leerDatos() {
     palabra1 = reader.nextLine();
     palabra2 = reader.nextLine();
    }
        
    public void resuelve() {
        if (palabra1 == null || palabra2 == null) { //no regresa nada si no se "ingresan" las palabras
            System.out.println(false);
            return;
        }
        //Sirve para remover los espacios en blanco de las palabras
        String limpia1 = palabra1.replaceAll("\\s+", "").toLowerCase();
        String limpia2 = palabra2.replaceAll("\\s+", "").toLowerCase();

        if (limpia1.length() != limpia2.length()) {
            System.out.println(false);
            return;
        }

        char[] arr1 = limpia1.toCharArray();
        char[] arr2 = limpia2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean esAnagrama = Arrays.equals(arr1, arr2);
        System.out.println(esAnagrama); 
    }

    public static void main(String[] args) {
        ValidAnagram id = new ValidAnagram();
        id.leerDatos();
        id.resuelve();
    }   
}
