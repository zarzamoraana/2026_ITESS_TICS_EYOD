 //REALIZADO CON PLANTILLA
//compilar: javac ValidPalindrome.java
//test: java ValidPalindrome < caso1.txt
//test: java ValidPalindrome < caso2.txt
//test: java ValidPalindrome < caso3.txt
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class ValidPalindrome {
    // FastReader class for efficient input
    String texto;
    FastReader reader = new FastReader();

    static class FastReader {
        // BufferedReader to read input
        BufferedReader b;
        // StringTokenizer to tokenize input
        StringTokenizer s; 

        // Constructor to initialize BufferedReader
        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        // Method to read the next token as a string
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

        // Method to read the next token as an integer
        int nextInt() { 
                return Integer.parseInt(next()); 
        }

        // Method to read Char
        char nextChar() {
            return next().charAt(0);
        }

        // Method to read the next token as a long
        long nextLong() { 
            return Long.parseLong(next()); 
        }

        // Method to read the next token as a double
        double nextDouble() { 
            return Double.parseDouble(next()); 
        }

        // Method to read the next line as a string
        String nextLine() {
            String str = "";
            try {
                if (s !=null && s.hasMoreTokens()){
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
    //Captura la linea de la palabra 
    public void leerDatos() {
        texto = reader.nextLine();
    }

    //Si la linea de texto esta vacia el programa no devuelve nada
    public void resuelve() {
        if (texto == null) {
            System.out.println(true);
            return;
        }
     int izquierda = 0;
     int derecha = texto.length() - 1;
     boolean esPalindromo = true;

     //Tecnica de los dos punteros
     while (izquierda < derecha){
        char cIzq = texto.charAt(izquierda);
        char cDer = texto.charAt(derecha);

        //Si el caracter de la izquierda no es letra o numero, el puntero avanza
        if (!Character.isLetterOrDigit(cIzq)){
            izquierda++;
        }
        //Si el caracter de la derecha no es letra o numero, el puntero retrocede
        else if (!Character.isLetterOrDigit(cDer)){
            derecha--;
     }
     //Si ambos son validos se comparan convertidos en minusculas
     else{
        if (Character.toLowerCase(cIzq) != Character.toLowerCase (cDer)){
            esPalindromo = false;
            break;
        }
        izquierda++;
        derecha--;
     }
    }
    //Imprime true o falso dependiendo de si la palabra es un palindromo o no
    System.out.println(esPalindromo); 
    }   
    public static void main (String [] args){
        ValidPalindrome id = new ValidPalindrome();
        id.leerDatos();
        id.resuelve();
    }
}