//CODIGO REALIZADO SIN PLANTILLA
//compilar: javac ContainsDuplicate2.java
//test: java ContainsDuplicate2 < caso1.txt
//test: java ContainsDuplicate2 < caso2.txt


import java.util.Scanner;
import java.util.HashSet;

public class ContainsDuplicate2 {

        public static void main (String [] args){
        Scanner scanner = new Scanner (System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        HashSet<Integer> conjunto = new HashSet<>();
        boolean duplicado = false;

        for (int i = 0; i < n; i++) {
            if (!conjunto.add(nums[i])) {
                duplicado = true;
                break;
            }
        }

        System.out.println(duplicado);

        scanner.close();
        }

}

