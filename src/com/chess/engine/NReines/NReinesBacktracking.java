package com.chess.engine.NReines;

public class NReinesBacktracking {
    static final int N = 4;

    private static boolean positionValid(int[] reines/* Li[]*/, int i, int Qi) {
        //Int[]reines representent les variables Li des reines
        //
        //Verification des contraintes avec les reines prédents
        for (int j = 0; j < Qi; j++) {
            if (reines[j] == i) {
                // i ieme reine est dans la meme ligne
                //Contraintes: i!=j: reines[i]!=reines[j];
                return false;
            }
                //the ith Queen is in diagonal
            if (Math.abs(reines[j] - i) == Math.abs(j - Qi)) {
                return false;
            }
            /*if( Math.abs(reines[i] + column) == Math.abs(i + Qi)){
                return false;
            }*/
        }
        return true;
    }


    /*Fonction Recursive pour resoudre le probleme */
    static boolean solveNQUtil(int reines[], int queen_i)
    {

        /* Consider this column and try placing
           this queen in all rows one by one */
        for (int i = 1; i <= N; i++) {
            if (positionValid(reines, i/*column*/, queen_i)) {
                /* Placement de la reine queen_i dans la ligne i*/
                reines[queen_i] = i;

                /* recur to place rest of the queens */
                if (solveNQUtil(reines, queen_i + 1) == true)
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

    /* Cette fonction résout le problème des N reines en utilisant
    Retour en arrière. Il utilise principalement résoudreNQUtil () pour
    résoudre le problème. Il renvoie false si les reines
    ne peut pas être placé, sinon, retourne true et
    imprime le placement des reines sous la forme de 1s.
    Veuillez noter qu'il peut y avoir plus d'un
    solutions, cette fonction imprime l'une des
    solutions réalisables. */
    public static boolean solveNQ()
    {
        int reines[]= { -1, -1, -1, -1};

        if (solveNQUtil(reines, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        return true;
    }


}