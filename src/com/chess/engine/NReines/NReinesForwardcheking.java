package com.chess.engine.NReines;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NReinesForwardcheking {
    static final int N=4;
    public static class Variable {
        Set<Integer> Domain = new HashSet<Integer>();
        int Valeur;
        public Variable(int valeur) {
            for (int i = 1; i <= 4; i++) {
                Domain.add(i);
                this.Valeur=Valeur;
            }
        }
    }

    public static void main(String args[])
    {
        NReinesForwardcheking Queen = new NReinesForwardcheking();
        NReinesForwardcheking.solveNQ();
    }

    private static void RemoveDomain(Variable[] reines, int column, int Qi) {
        //check for all previously placed queens
        for (int i = 0; i < Qi; i++) {
            if (reines[i].Valeur == column) {
                // the ith Queen(previous) is in same column
                //Contraintes: i!=j: reines[i]!=reines[j];
                reines[i].Domain.remove(column);
            }
            //the ith Queen is in diagonal
            if (Math.abs(reines[i].Valeur - column) == Math.abs(i - Qi)) {
                reines[i].Domain.remove(column);
            }
            if( Math.abs(reines[i].Valeur + column) == Math.abs(i + Qi)){
                reines[i].Domain.remove(column);
            }
        }
    }

    static boolean solveNQUtil(Variable reines[], int queen_i ) {
        if (queen_i >= N)
            return true;

        for (int i = 0; i < N; i++) {
            RemoveDomain(reines, i, queen_i);
            Iterator<Integer> it = reines[i].Domain.iterator();
            if (reines[i].Domain.isEmpty()) {
                reines[queen_i].Valeur = -1;

            }

            if (it.hasNext()) {
                int next = it.next();
                reines[queen_i].Valeur = next;
            }


            /* recur to place rest of the queens */
            if (solveNQUtil(reines, queen_i + 1) == true)
                return true;

        }

        /* If the queen can not be placed in any row in
           this colum col, then return false */
            return false;

    }

    public static boolean solveNQ(){
        Variable Q1=new Variable(-1);
        Variable Q2=new Variable(-1);
        Variable Q3=new Variable(-1);
        Variable Q4=new Variable(-1);

        Variable[] reines= { Q1, Q2, Q3, Q4 };

        if (solveNQUtil(reines, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(reines);
        return true;
    }

    static void printSolution(Variable[] reines)
    {
        for (int i = 0; i < N; i++) {
            System.out.print(" " + reines[i].Valeur + " ");
        }
    }
    }

