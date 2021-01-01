package com.chess.engine.NReines;

import java.util.*;

public class NReinesForwardcheking {
    
    static final int N=4;

    public class Variable {
        public Map<Integer, Integer> Domain = new HashMap<Integer, Integer>();
        public int Valeur;
        public Variable(int valeur) {
            for (int i = 1; i <= 4; i++) {
                Domain.put(i,i);
                this.Valeur=Valeur;
            }
        }
    }

    public static void main(String args[])
    {
        NReinesForwardcheking Queen = new NReinesForwardcheking();
        Queen.solveNQ();
    }

    private static void RemoveDomain(Variable[] reines, int i, int Qi) {

        for (int j = 0; j < 4; j++) {
            if(j+Qi==N){
                break;
            }
                reines[j+Qi].Domain.remove(i);
                reines[j+Qi].Domain.remove(Math.abs(j+i));
                reines[j+Qi].Domain.remove(Math.abs(j-i));
        }
    }

    private static void RestoreDomain(Variable[] reines, int i, int Qi) {

        for (int j = 0; j < 4; j++) {
            if(j+Qi==N){
                break;
            }
            reines[j+Qi].Domain.put(i, i);
            reines[j+Qi].Domain.put(Math.abs(j+i), Math.abs(j+i));
            reines[j+Qi].Domain.put(Math.abs(j-i),Math.abs(j-i));
        }
    }


    static boolean solveNQUtil(Variable reines[], int Li, int queen_i) throws ArrayIndexOutOfBoundsException
    {
        if (queen_i >= N-1) {
            return true;
        }
                for(int i=1;i<=N;i++){
                    NReinesForwardcheking.RemoveDomain(reines, Li, queen_i);
                    if (reines[queen_i + 1].Domain.containsKey(i)) {
                            reines[queen_i + 1].Valeur = i;
                            if (solveNQUtil(reines, i,queen_i + 1) == true)
                                return true;
                        }
                    if(reines[queen_i+1].Domain.isEmpty()) {
                        NReinesForwardcheking.RestoreDomain(reines, i,queen_i);
                        reines[queen_i].Valeur++;
                        if (solveNQUtil(reines, i+1,queen_i) == true)
                                return true;
                    }
            }

        return false;
    }


    public  boolean solveNQ(){
        Variable Q1=new Variable(-1);
        Variable Q2=new Variable(-1);
        Variable Q3=new Variable(-1);
        Variable Q4=new Variable(-1);

        Variable[] reines= { Q1, Q2, Q3, Q4 };

        if (solveNQUtil(reines, 1,0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(reines);
        return true;
    }

    static void printSolution(Variable[] reines)
    {
        for (int i = 0; i < N; i++) {
            System.out.print(" " + reines[i].Domain + " ");
        }
        System.out.print("Solution est : [");
        for (int i = 0; i < N; i++) {
            System.out.print(" " + reines[i].Valeur + " ");
        }
        System.out.println("]");

    }
    }

