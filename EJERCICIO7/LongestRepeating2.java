//CODIGO REALIZADO SIN PLANTILLA
//compilar: javac LongestRepeating2.java
//test: java GroupAnagrams2 < caso1.txt
//test: java GroupAnagrams2 < caso2.txt

import java.util.Scanner;

public class LongestRepeating2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int k = scanner.nextInt();
        String s = scanner.next().toUpperCase();

        System.out.println("Lo que leyó k: " + k);
        System.out.println("Lo que leyó s: " + s);

        int[] frecuencia = new int[26];
        int inicio = 0;
        int maxLongitud = 0;
        int maxFrecuencia = 0;

        for (int fin = 0; fin < s.length(); fin++) {
            char letraActual = s.charAt(fin);
            
            if (letraActual < 'A' || letraActual > 'Z') {
                continue; // Si encuentra un número, espacio o símbolo lo salta y evita el error
            }

            frecuencia[letraActual - 'A']++;
            
            maxFrecuencia = Math.max(maxFrecuencia, frecuencia[letraActual - 'A']);

            int caracteresParaCambiar = (fin - inicio + 1) - maxFrecuencia;
        
            if (caracteresParaCambiar > k) {
                char letraInicio = s.charAt(inicio);
                if (letraInicio >= 'A' && letraInicio <= 'Z') {
                    frecuencia[letraInicio - 'A']--;
                }
                inicio++;
            }

            maxLongitud = Math.max(maxLongitud, fin - inicio + 1);
        }

        System.out.println(maxLongitud);
        scanner.close();
    } 
}