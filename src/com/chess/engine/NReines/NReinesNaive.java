package com.chess.engine.NReines;

public class NReinesNaive {
    private static int N=4;
    public NReinesNaive(int N){
        this.N=N;
    }

    //---------------------------------------------------------------
    //Fonction pour verifier si les contraintes sont vérifier ou non
    private static boolean contraintRespect(int[] reines) {

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if(i==j){
                    continue;
                }
                if (reines[j] == reines[i]) {
                    return false;
                }
                //Probleme is here
                if (Math.abs(reines[i] - i) == Math.abs(reines[j] - j) || reines[i] + i == reines[j] + j) {
                    return false;
                }
            }
        }
        return true;

    }
    //---------------------------------------------------------------
    //Fonction recursive pour resoudre le probleme des N Reines en utilisant l'algorithm Naive.
    //Cette fonction fait la permutation d'array int Array et verifier si la solution est correct ou non avec la methode contraintRespect
    public static void resoudreNQ(int[] intArray, int start, int[] reines) {
        for(int i = start; i < intArray.length; i++){
            int temp = intArray[start];
            intArray[start] = intArray[i];
            intArray[i] = temp;
            resoudreNQ(intArray, start + 1, reines);
            intArray[i] = intArray[start];
            intArray[start] = temp;
        }
        if (start == intArray.length - 1) {
            for(int i=0;i<N;i++) {
                reines[i]=intArray[i];
            }
            if(contraintRespect(reines)){
                System.out.println(java.util.Arrays.toString(intArray));
            }
        }
    }

    //---------------------------------------------------------------
    //Fonction resoultuon probleme 4*4 reines en utilisant la methode naive
    static void resoudre_naive_4X4(int [] reines) {
        //Affectation totale
        for(int i1=1;i1<=4;i1++) {
            reines[0]=i1;
            for(int i2=1;i2<=4;i2++) {
                reines[1]=i2;

                for(int i3=1;i3<=4;i3++) {
                    reines[2]=i3;
                    for(int i4=1;i4<=4;i4++) {
                        reines[3]=i4;
                        //Affectation totale
                        //consistante?
                        int test=0,nbre_comp=0;
                        int r1;
                        for(r1=0;r1<3;r1++) {
                            test=0;
                            nbre_comp=0;
                            for(int r2=r1+1;r2<4;r2++) {
                                nbre_comp++;
                                if(reines[r1]!=reines[r2])
                                    if(reines[r1]+r1!=reines[r2]+r2)
                                        if(reines[r1]-r1!=reines[r2]-r2)

                                            if(reines[r1]-r1!=r2-reines[r2])
                                                if(r1-reines[r1]!=r2-reines[r2])
                                                    test++;
                            }
                            if(test!=nbre_comp)
                                break;
                        }
                        if(r1>=3){
                            Main.printSolution(reines, 4);
                        }
                    }
                }
            }
        }
    }
}
