public class PPC {


    public static void main(String[] args) {
    int[] reines=new int[4];
    resoudre_naive(reines);
    resoudre_backtracking(reines);
    resoudre_forwardchecking_noued(reines);
    resoudre_forwardchecking_arc(reines);
}

    //Methode numero 1° : Résolution naïve
    static void resoudre_naive(int [] reines) {
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
								/*System.out.print("Tableau : [");
								for(int r=0;r<4;r++)
									System.out.print(reines[r]+" ");
								System.out.println("]");*/
                        if(r1>=3){
                            System.out.print("Solution : [");
                            for(int r=0;r<4;r++)
                                System.out.print(reines[r]+" ");
                            System.out.println("]");
                        }

                        /*reines[0] : reines[1] reines[2] reines[3]
                         *  reines[1] : reines[2] reines[3]
                         *  reines[2] : reines[3]
                         * */

                    }
                }
            }
        }
    }
    //Methode numero 2° : Backgtracking
    static void resoudre_backtracking(int [] reines){

    }
    //Methode numero 3° : Forward checking  anticipation par nœud
    static void resoudre_forwardchecking_noued(int [] reines){

    }
    //Methode numero 4° : Forward checking , anticipation par arc
    static void resoudre_forwardchecking_arc(int [] reines){

    }

}

