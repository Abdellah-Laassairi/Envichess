package com.chess.engine.NReines;

import java.sql.SQLOutput;

public class PPC {
    public static final int N=4;


    public static void main(String[] args) {
    int[] reines=new int[N];

    resoudre_naive(reines);
    resoudre_backtracking(reines);
    //resoudre_forwardchecking(reines);
    //resoudre_lookahead(reines);
}

    //Fonction pour afficher la solution
    static void printSolution(int reines[])
    {
        System.out.print("Solution est : [");
        for (int i = 0; i < N; i++) {
            System.out.print(" " + reines[i] + " ");
        }
        System.out.println("]");
    }

    //Methode numero 1° : Résolution naïve
    static void resoudre_naive(int [] reines) {
        System.out.println("\nResolution avec methode Naive:");
        int[] array={1,2,3,4};

        NReinesNaive.permute(array, 0, reines);
    }


    //Methode numero 2° : Backtracking
    static void resoudre_backtracking(int [] reines){
        System.out.println("\nResolution avec methode backtracking :");
        NReinesBacktracking Queen = new NReinesBacktracking();
        Queen.solveNQ();
        if (NReinesBacktracking.solveNQUtil(reines, 0) == false) {
            System.out.print("Solution n'exsite Pas");
        }
        printSolution(reines);
    }


    //Methode numero 3° : Forward checking  anticipation par nœud
    static void resoudre_forwardchecking(int [] reines){

    }


    //Methode numero 4° : Forward checking , anticipation par arc
    static void resoudre_lookahead(int [] reines){

    }


}

