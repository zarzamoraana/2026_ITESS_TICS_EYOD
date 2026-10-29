//CODIGO REALIZADO CON PLANTILLA
//compilar: javac ContainsDuplicate.java
//test: java ContainsDuplicate < caso1.txt
//test: java ContainsDuplicate < caso2.txt

/*
*    ITESS 2026
*    Agosto-Diciembre
*    Estructura y organizacion de datos
*    Tema 2. Estructuras lineales
*    01/10/26
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class ContainsDuplicate {
    
    int n;
    int[] nums;
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
        n = reader.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = reader.nextInt();
        }
    }

    public void resuelve() {
        HashSet<Integer> conjunto = new HashSet<>();
        boolean duplicado = false;

        for (int i = 0; i < n; i++) {
            if (!conjunto.add(nums[i])) {
                duplicado = true;
                break;
            }
        }

        System.out.println(duplicado);
    }

    public static void main(String[] args) {
         ContainsDuplicate id = new ContainsDuplicate();
        id.leerDatos();
        id.resuelve();
    }   
}