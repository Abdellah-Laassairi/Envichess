package com.chess.engine.NReines;

import org.chocosolver.solver.*;
import org.chocosolver.solver.variables.*;

public class NReinesChoco {

    public static void resoudreNQ(int n) {
        //1)Declaration du model
        Model m=new Model(n+" eines");
        //2)Variables
        //IntVar[] reines=m.intVarArray(4,new int[] {1,2,3,4});
        IntVar[] reines=new IntVar[n];
        for(int i=0;i<n;i++)
            reines[i]=m.intVar("reine "+(i+1),1,n);
        //3)Declaration des Contraintes et les poster
        for(int i=0;i<n-1;i++)
            for(int j=i+1;j<n;j++) {
                m.arithm(reines[i],"!=",reines[j]).post();
                m.arithm(reines[i],"!=",reines[j],"+",j-i).post();
                m.arithm(reines[i],"!=",reines[j],"+",i-j).post();
                m.arithm(reines[j],"+",reines[i],"!=",j+i).post();
            }
        //4) R�soudre le probl�me
        Solver sl=m.getSolver();
        while(sl.solve()) {
            sl.showSolutions();
        }


    }


}
