package com.chess.engine.NReines;

import java.util.HashMap;
import java.util.Map;

public class NReinesLookahead {
    private static int N=4;
    public NReinesLookahead(int N){
        this.N=N;
    }
    //---------------------------------------------------------------
    //Inner Class Variable avec attributs Domain et Valeur;
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

    //---------------------------------------------------------------
    private static void RemoveDomain(Variable[] reines, int i, int Qi) {

        for (int j = 0; j < N; j++) {
            if(j+Qi==N){
                break;
            }
            reines[j+Qi].Domain.remove(i);
            reines[j+Qi].Domain.remove(Math.abs(j+i));
            reines[j+Qi].Domain.remove(Math.abs(j-i));
        }
    }

    //---------------------------------------------------------------
    private static boolean DomaineEmpty(Variable[]reines){
        for(int i=0;i<N;i++)
        {
            if(reines[i].Domain.isEmpty()){
                return true;
            }
        }
        return false;
    }

    //---------------------------------------------------------------

    private static void RestoreDomain(Variable[] reines, int i, int Qi) {
        for (int j = 0; j < N; j++) {
            if(j+Qi==N){
                break;
            }
                reines[j + Qi].Domain.put(i, i);
                reines[j + Qi].Domain.put(Math.abs(j + i), Math.abs(j + i));
                reines[j + Qi].Domain.put(Math.abs(j - i), Math.abs(j - i));
        }
    }

    //Verification sur tous les variables avant affectation
    static boolean resoudreNQ(Variable reines[], int Li, int queen_i) throws ArrayIndexOutOfBoundsException {
        if (queen_i >= N-1) {
            return true;
        }
        for(int i=1;i<=N;i++){
            RemoveDomain(reines, Li, queen_i);
            if (reines[queen_i + 1].Domain.containsKey(i)) {

                if (resoudreNQ(reines, i,queen_i + 1) == true) {
                    reines[queen_i + 1].Valeur = i;
                    return true;
                }
            }
            if(reines[queen_i+1].Domain.isEmpty()) {
                RestoreDomain(reines, i,queen_i);
                reines[queen_i].Valeur++;
                if (resoudreNQ(reines, i+1,queen_i) == true)
                    return true;
            }
        }

        return false;
    }


    public boolean resoudre(){
        Variable[] reines = new Variable[N];
        for(int i=0;i<N;i++){
            reines[i]=new Variable(1);
        }
        if (resoudreNQ(reines,1,0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(reines);
        return true;
    }

    static void printSolution(Variable[] reines)
    {

        System.out.print("Solution est : [");
        for (int i = 0; i < N; i++) {
            System.out.print(" " + reines[i].Valeur + " ");
        }
        System.out.println("]");

    }
}
