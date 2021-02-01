package com.chess.engine.NReines;

import java.util.*;

public class NReinesForwardcheking {
    static int N=4;
    public NReinesForwardcheking(int N) {
        this.N=N;
    }
    //Class du Variable
    public class Variable {
        private Map<Integer, Integer> Domain = new HashMap<Integer, Integer>();
        private int Valeur;
        public Variable(int valeur) {
            for (int i = 1; i <= 4; i++) {
                Domain.put(i,i);
                this.Valeur=Valeur;
            }
        }
    }
    
    //Fonction qui supprime les elements du domain de tous les variables si on place la reine Qi dans la ligne i
    //--------------------------------------------
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
    //Fonction qui ajoute les elements du domain supprimé aprés le retour en arriere
    //--------------------------------------------
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

    //Fonction recursive qui utilise les deux fonction removeDomaine et Restore domaine pour l'implementation d'algorithm Forwardchecking
    //--------------------------------------------
    static boolean resoudreNQ(Variable reines[], int Li, int queen_i) throws ArrayIndexOutOfBoundsException
    {
        if (queen_i >= N-1) {
            return true;
        }
                for(int i=1;i<=N;i++){
                    NReinesForwardcheking.RemoveDomain(reines, Li, queen_i);
                    if (reines[queen_i + 1].Domain.containsKey(i)) {
                            reines[queen_i + 1].Valeur = i;
                            if (resoudreNQ(reines, i,queen_i + 1) == true)
                                return true;
                        }
                    if(reines[queen_i+1].Domain.isEmpty()) {
                        NReinesForwardcheking.RestoreDomain(reines, i,queen_i);
                        reines[queen_i].Valeur++;
                        if (resoudreNQ(reines, i+1,queen_i) == true)
                                return true;
                    }
            }

        return false;
    }

    //--------------------------------------------
    public  boolean resoudre(){
        Variable[] reines= new Variable[N];
        for(int i=0;i<N;i++){
            reines[i]=new Variable(-1);
        }
        if (resoudreNQ(reines, 1,0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }
        printSolution(reines);
        return true;
    }
    //--------------------------------------------
    static void printSolution(Variable[] reines)
    {
        System.out.print("Solution est : [");
        for (int i = 0; i < N; i++) {
            System.out.print(" " + reines[i].Valeur + " ");
        }
        System.out.println("]");

    }
    }

