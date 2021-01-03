package com.chess.engine.NReines;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------"
                +"\nBonjour! Voila la resolution du probleme partie du projet d'élement programmation par contrainte!\n" +
                "Dans cette partie on va aborder le probleme des N*N Reines, le CSP est comme suite : \n"+
                "Variables: Reines[4]\n" +
                "Domaines : {1,2,3,4}\n" +
                "Contraintes: " +
                "\n\ti!=j: reines[i]!=reines[j];\n" +
                "\treines[i]+i!=reines[j]+j\n" +
                "\t|reines[i]-i|!=|reines[j]-j|\n");
        System.out.println("Veuillez entrer le nombres de reines pour le problesm N*N : \n");
        Scanner input = new Scanner(System.in);
        final int N=input.nextInt();
        int[] reines=new int[N];

    resoudre_naive(reines, N);
    resoudre_backtracking(reines, N);
    resoudre_forwardchecking(N);
    resoudre_lookahead(N);
    resoudre_choco(N);
}

    //Dans chaque methode on cree l'object correspondant et on fait appele a la fonction resolution
    //--------------------------------------------
    //Methode numero 1° : Résolution naïve
    static void resoudre_naive(int [] reines, int N) {
        System.out.println("\nResolution avec methode Naive:");
        NReinesNaive queen =new NReinesNaive(N);
        int[] array=new int[N];
        for(int i=0;i<N;i++){
            array[i]=i+1;
        }

        queen.resoudreNQ(array, 0, reines);
    }

    //--------------------------------------------
    //Methode numero 2° : Backtracking
    static void resoudre_backtracking(int [] reines, int N){
        System.out.println("\nResolution avec methode backtracking :");
        NReinesBacktracking Queen = new NReinesBacktracking(N);

        Queen.resoudre(N);
        if (NReinesBacktracking.resoudreNQ(reines, 0) == false) {
            System.out.print("Solution n'exsite Pas");
        }
        printSolution(reines, N);
    }

    //--------------------------------------------
    //Methode numero 3° : Forward checking  anticipation par nœud
    static void resoudre_forwardchecking(int N){
        System.out.println("\nResolution avec methode forward checking :");
        NReinesForwardcheking queen = new NReinesForwardcheking(N);
        queen.resoudre();
    }


    //Methode numero 4° : Look ahead
    static void resoudre_lookahead(int N){
        System.out.println("\nResolution avec methode Look ahead:");
        NReinesLookahead queen =new NReinesLookahead(N);
        queen.resoudre();

    }


    //--------------------------------------------
    //Methode numero 5° : Chooco
    static void resoudre_choco(int N){
        System.out.println("\nResolution avec Choco :");
        NReinesChoco.resoudreNQ(N);
    }

    //--------------------------------------------
    //Fonction pour afficher la solution
    static void printSolution(int reines[], int N)
    {
        System.out.print("Solution est : [");
        for (int i = 0; i < N; i++) {
            System.out.print(" " + reines[i] + " ");
        }
        System.out.println("]");
    }

}

