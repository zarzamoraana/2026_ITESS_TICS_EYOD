//CODIGO REALIZADO CON PLANTILLA
//compilar: javac LongestRepeating.java
//test: java GroupAnagrams < caso1.txt
//test: java GroupAnagrams < caso2.txt

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestRepeating {
    
    String s;
    int k;
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
        s = reader.next().toUpperCase();
        k = reader.nextInt();
    }

    public void resuelve() {
        if (s == null) return;

        int[] frecuencia = new int[26];
        int inicio = 0;
        int maxLongitud = 0;
        int maxFrecuencia = 0;

        for (int fin = 0; fin < s.length(); fin++) {
            char letraActual = s.charAt(fin);
            frecuencia[letraActual - 'A']++;
            
           
            maxFrecuencia = Math.max(maxFrecuencia, frecuencia[letraActual - 'A']);

            int caracteresParaCambiar = (fin - inicio + 1) - maxFrecuencia;
        
            if (caracteresParaCambiar > k) {
                frecuencia[s.charAt(inicio) - 'A']--;
                inicio++;
            }

           
            maxLongitud = Math.max(maxLongitud, fin - inicio + 1);
        }

        System.out.println(maxLongitud);
    }

    public static void main(String[] args) {
        LongestRepeating id = new LongestRepeating();
        id.leerDatos();
        id.resuelve();
    }   
}