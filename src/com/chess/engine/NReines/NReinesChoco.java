package com.chess.engine.NReines;

import org.chocosolver.solver.*;
import org.chocosolver.solver.variables.*;

public class NReinesChoco {

    public static void main(String[] args) {
        /* TODO Auto-generated method stub */
        /*Variables: Reines[4]
         * Domaines : {1,2,3,4}
         * Contraintes: i!=j: reines[i]!=reines[j];
         * 				reines[i]+i!=reines[j]+j
         * 				|reines[i]-i|!=|reines[j]-j|
         * 	(reines[i]-i!=reines[j]-j) || (i-reines[i]!=reines[j]-j) || (reines[i]-i!=j-reines[j]) || (i-reines[i]!=j-reines[j])
         */
        //1)Declaration du model
        int n=4;
        Model m=new Model(n+" reines");
        //2)Variables
        //IntVar[] reines=m.intVarArray(4,new int[] {1,2,3,4});
        IntVar[] reines=new IntVar[n];
        for(int i=0;i<n;i++)
            reines[i]=m.intVar("reine "+(i+1),1,n);
        //3)D�clarer les Contraintes et les poster
        for(int i=0;i<n-1;i++)
            for(int j=i+1;j<n;j++) {
                m.arithm(reines[i],"!=",reines[j]).post();
                m.arithm(reines[i],"!=",reines[j],"+",j-i).post();
                m.arithm(reines[i],"!=",reines[j],"+",i-j).post();
                m.arithm(reines[j],"+",reines[i],"!=",j+i).post();
            }
        //4) R�soudre le probl�me
        //M�thode 1
		/*Solution s=m.getSolver().findSolution();
		if(s!=null)
			System.out.println(s.toString());
		else
			System.out.println("Pas de solution trouvee");*/
        //M�thode 2
        Solver sl=m.getSolver();
        while(sl.solve()) {
            sl.showSolutions();
        }


    }


}
