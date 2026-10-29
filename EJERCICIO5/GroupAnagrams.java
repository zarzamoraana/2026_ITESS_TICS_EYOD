//CODIGO REALIZADO CON PLANTILLA
//compilar: javac GroupAnagrams.java
//test: java GroupAnagrams < caso1.txt
//test: java GroupAnagrams < caso2.txt

//IMPORTS QUE SON PARTE DE LA PLANTILLA
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//IMPORT NECESARIOS PARA EL CODIGO
 

public class GroupAnagrams {
    int n;
    String[] palabras;
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
                    s = new StringTokenizer(b.readLine());
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
                if (s.hasMoreTokens()) {
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
        palabras = new String[n];
        for (int i = 0; i < n; i++) {
            palabras[i] = reader.next();
        }
    }

    public void resuelve() {
        Map<String, List<String>> mapa = new HashMap<>();

        for (String palabra : palabras) {
            char[] caracteres = palabra.toCharArray();
            Arrays.sort(caracteres);
            String clave = new String(caracteres);

            mapa.computeIfAbsent(clave, k -> new ArrayList<>()).add(palabra);
        }

        List<List<String>> resultadoFiltrado = new ArrayList<>();
        for (List<String> grupo : mapa.values()){
            if (grupo.size() > 1 ){
                resultadoFiltrado.add(grupo);
            }
        }
        System.out.println("Grupos de anagramas encontrados :3 :");
        System.out.println(resultadoFiltrado);

    }

    public static void main(String[] args) {
        GroupAnagrams id = new GroupAnagrams();
        id.leerDatos();
        id.resuelve();
    }   
}

