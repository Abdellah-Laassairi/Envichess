package com.chess.engine.NReines;

public class NReinesBacktracking {
    private static int N = 4;
    public NReinesBacktracking(int N) {
        this.N=N;
    }

    //--------------------------------------------
    //Fonction qui verifier si la position de la reine Qi dans la ligne Li est valid ou non;
    private static boolean positionValid(int[] reines, int i/*Li */, int Qi) {
        //Int[]reines representent les variables Li des reines
        //Verification des contraintes avec les reines précédents
        for (int j = 0; j < Qi; j++) {
            if (reines[j] == i) {
                // i ieme reine est dans la meme ligne
                //Contraintes: i!=j: reines[i]!=reines[j];
                return false;
            }
                //Diagonal
            if (Math.abs(reines[j] - i) == Math.abs(j - Qi)) {
                return false;
            }
            /*if( Math.abs(reines[i] + column) == Math.abs(i + Qi)){
                return false;
            }*/
        }
        return true;
    }

    //--------------------------------------------
    /*Fonction Recursive pour resoudre le probleme */
    static boolean resoudreNQ(int reines[], int queen_i)
    {
        for (int i = 1; i <= N; i++) {
            if (positionValid(reines, i/*column*/, queen_i)) {
                /* Placement de la reine queen_i dans la ligne i*/
                reines[queen_i] = i;

                /* recur to place rest of the queens */
                if (resoudreNQ(reines, queen_i + 1) == true)
                    return true;

                /* S'in n a pas de solution Backtrack */
                reines[queen_i] = -1;
            }
        }

        /* Si tous le reines sont placés return true */
        if (queen_i >= N)
            return true;

        /* Sinon return false*/
        return false;
    }

    //--------------------------------------------
    /* Cette fonction résout le problème des N reines en utilisant
    Retour en arrière. Il utilise principalement résoudreNQ () pour
    résoudre le problème. Il renvoie false si les reines
    ne peut pas être placé, sinon, retourne true et
    imprime le placement des reines sous la forme de 1s.
    Veuillez noter qu'il peut y avoir plus d'un
    solutions, cette fonction imprime l'une des
    solutions réalisables. */
    public static boolean resoudre(int N)
    {
        int reines[]=new int [N];

        for(int i=0; i<N;i++) {
            reines[i] = -1;
        }

        if (resoudreNQ(reines, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        return true;
    }


}