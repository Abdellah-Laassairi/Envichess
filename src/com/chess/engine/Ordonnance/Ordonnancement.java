package com.chess.engine.Ordonnance;

import org.chocosolver.solver.*;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.variables.IntVar;

public class Ordonnancement {

    //private static final String IntVar = null;

    public static void main(String[] args) {

        //créer le modèle
        Model model = new Model("modélisation_csp");

        //déclarationdesvariables
        IntVar m=model.intVar("m",0, 26);  //new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26}
        IntVar ch=model.intVar("ch", 0, 26);  //variable ''ch'' : jour de début de la tâche charpenterie
        IntVar t=model.intVar("t", 0, 26);
        IntVar pl=model.intVar("pl", 0, 26);
        IntVar sol=model.intVar("sol", 0, 26);
        IntVar fe=model.intVar("fe", 0, 26);
        IntVar fa=model.intVar("fa", 0, 26);
        IntVar j=model.intVar("j", 0, 26);
        IntVar pe=model.intVar("pe", 0, 26);
        IntVar am=model.intVar("am", 0, 26);



        //déclarer les contraintes
        Constraint c100=model.arithm(ch, ">=",m,"+",7 ) ;
        Constraint c200=model.arithm(t, ">=",ch,"+",3 ) ;
        Constraint c300=model.arithm(pl, ">=",m,"+",7 ) ;
        Constraint c400=model.arithm(sol, ">=",m,"+",7 ) ;
        Constraint c500=model.arithm(fe, ">=",t,"+",1 ) ;
        Constraint c600=model.arithm(fa,">=",t,"+",1);
        Constraint c601=model.arithm(fa,">=",pl,"+",8);
        Constraint c700=model.arithm(j,">=",t,"+",1);
        Constraint c701=model.arithm(j,">=",pl,"+",8);
        Constraint c800=model.arithm(pe, ">=",sol,"+",3 ) ;
        Constraint c900=model.arithm(am, ">=",fe,"+",1 ) ;
        Constraint c901=model.arithm(am, ">=",fa,"+",2 ) ;
        Constraint c902=model.arithm(am, ">=",j,"+",1 ) ;
        Constraint c903=model.arithm(am, ">=",pe,"+",2 ) ;

        //nouvelles contraintes de temps
        Constraint c0=model.arithm(m, ">=",0 ) ;
        Constraint c1=model.arithm(ch, ">=",7 ) ;
        Constraint c2=model.arithm(t, ">=",12 ) ;
        Constraint c3=model.arithm(pl, ">=",12 ) ;
        Constraint c4=model.arithm(sol, ">=",11 ) ;
        Constraint c5=model.arithm(fe, ">=",11 ) ;
        Constraint c6=model.arithm(fa,">=",17);
        Constraint c7=model.arithm(j,">=",17);
        Constraint c8=model.arithm(pe, ">=",8 ) ;
        Constraint c9=model.arithm(am, ">=",12 ) ;
        Constraint c10=model.arithm(m, "<=", 14);
        Constraint c11=model.arithm(ch, "<=", 11);
        Constraint c12=model.arithm(t, "<=", 14);
        Constraint c13=model.arithm(pl, "<=", 19);
        Constraint c14=model.arithm(sol, "<=", 17);
        Constraint c15=model.arithm(fe, "<=", 19);
        Constraint c16=model.arithm(fa, "<=", 22);
        Constraint c17=model.arithm(j, "<=", 23);
        Constraint c18=model.arithm(pe, "<=", 18);
        Constraint c19=model.arithm(am, "<=", 23);

        //poster les contraintes
        model.post(c0);
        model.post(c1);
        model.post(c2);
        model.post(c3);
        model.post(c4);
        model.post(c5);
        model.post(c6);
        model.post(c7);
        model.post(c8);
        model.post(c9);
        model.post(c10);
        model.post(c11);
        model.post(c12);
        model.post(c13);
        model.post(c14);
        model.post(c15);
        model.post(c16);
        model.post(c17);
        model.post(c18);
        model.post(c19);

        model.post(c100);
        model.post(c200);
        model.post(c300);
        model.post(c400);
        model.post(c500);
        model.post(c600);
        model.post(c700);
        model.post(c800);
        model.post(c900);
        model.post(c601);
        model.post(c701);
        model.post(c901);
        model.post(c902);
        model.post(c903);

        //appeler le solveur
        Solver s=model.getSolver();
        Solution solution=s.findSolution();

        if (solution==null) {
            System.out.println("pas de solution");
        }
        else {
            System.out.println(solution.toString());
        }

    }

}