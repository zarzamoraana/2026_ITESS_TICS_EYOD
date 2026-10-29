//REALIZADO SIN PLANTILLA
//compilar: javac ValidPalindrome2.java
//test: java ValidPalindrome2 < caso4.txt
//test: java ValidPalindrome2 < caso5.txt
//test: java ValidPalindrome2 < caso6.txt


import java.util.Scanner;

public class ValidPalindrome2 {

    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        int izquierda = 0;
        int derecha = s.length() - 1;

        while (izquierda < derecha) {
            char cIzq = s.charAt(izquierda);
            char cDer = s.charAt(derecha);

            // Si el caracter de la izquierda no es alfanumerico, avanza el puntero
            if (!Character.isLetterOrDigit(cIzq)) {
                izquierda++;
            } 
            // Si el caracter de la derecha no es alfanumerico, retrocede el puntero
            else if (!Character.isLetterOrDigit(cDer)) {
                derecha--;
            } 
            // Si ambos son validos, los comparamos en minusculas
            else {
                if (Character.toLowerCase(cIzq) != Character.toLowerCase(cDer)) {
                    return false; // No coinciden, por lo tanto no es palindromo
                }
                izquierda++;
                derecha--;
            }
        }

        return true; // Si termino el ciclo sin fallos, si es un palindromo
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String texto = scanner.nextLine();
        scanner.close();

        boolean resultado = isPalindrome(texto);
        
        System.out.println("Es un palindromo valido?");
        System.out.println("Resultado: " + resultado);
    }
}
