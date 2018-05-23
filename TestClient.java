//*******************************************
// Test Client Program for Intcoll4, Intcoll2 and Intcoll3
//       Aniruddha Maiti
//*******************************************

import java.util.*;

public class TestClient {

    public static final int SENTINEL = 0;

    public static void main(String[] args) {
        int value;
        Scanner keyboard = new Scanner(System.in);

        Intcoll4 P1 = new Intcoll4(), N1 = new Intcoll4(), L1 = new Intcoll4();

        value = keyboard.nextInt();
        while (value != SENTINEL) {
            if (value > 0) {

                P1.insert(value);
                L1.insert(value);

            } else {

                N1.insert(-value);
                L1.omit(-value);
            }

            value = keyboard.nextInt();
        }

        // Test Intcoll4
        System.out.println("\n\nResults for Intcoll4\n*****************************\n");

        System.out.println("\nThe values in collection P1 are: ");
        P1.print();
        System.out.println("Size of P1 : " + P1.get_howmany());

        System.out.println("\nThe values in collection N1 are:");
        N1.print();
        System.out.println("Size of N1 : " + N1.get_howmany());

        System.out.println("\nThe values in collection L1 are:");
        L1.print();
        System.out.println("Size of L1 : " + L1.get_howmany());

        if (P1.equals(N1)) {
            System.out.println("\nP1 and N1 are equal.");
        } else {
            System.out.println("\nP1 and N1 are NOT equal.");
        }

        Intcoll4 A1 = new Intcoll4();
        A1.copy(L1);

        
        if (A1.equals(L1)) {
            System.out.println("\nA1 and L1 are equal.");
        } else {
            System.out.println("\nA1 and L1 are NOT equal.");
        }
        
        A1.omit(5);
        A1.omit(400);
        A1.omit(-5);
        A1.omit(-400);
        A1.omit(0);

        System.out.println("\n 5 Belongs to A1 " + A1.belongs(5));
        System.out.println("\n 15 Belongs to A1 " + A1.belongs(15));
        System.out.println("\n 150 Belongs to A1 " + A1.belongs(150));
        System.out.println("\n 27 Belongs to A1 " + A1.belongs(27));

        A1.insert(15);
        A1.insert(-27);
        A1.insert(30);
        A1.insert(0);

        System.out.println("\n 5 Belongs to A1 " + A1.belongs(5));
        System.out.println("\n 15 Belongs to A1 " + A1.belongs(15));
        System.out.println("\n 150 Belongs to A1 " + A1.belongs(150));
        System.out.println("\n 27 Belongs to A1 " + A1.belongs(27));

        System.out.println("\nThe values in the copy of L1 are:\n");
        A1.print();

        System.out.println("Size of A1  " + A1.get_howmany());

        System.out.println("\n*****************************\n");

    }

}
