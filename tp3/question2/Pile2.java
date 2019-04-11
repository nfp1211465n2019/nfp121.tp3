 package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    
    private Stack<Object> stk;

    private int capacite;
    private int taille;
    
    public Pile2(int taille) {
        if (taille < 0) this.taille = TAILLE_PAR_DEFAUT;
      else this.taille = taille;
      
      this.capacite = 0;
      this.stk = new Stack<>();
    }

    public Pile2() {
        this.taille = TAILLE_PAR_DEFAUT;
        this.capacite = 0;
        this.stk = new Stack<>();
    }

    @Override
    public void empiler(Object o) throws PilePleineException {
        if (estPleine()) throw new PilePleineException(); 
        else {
            stk.push(o);
            this.capacite++;
        }
    }

    @Override
    public Object depiler() throws PileVideException {
        if (estVide()) throw new PileVideException();
        this.capacite--;
        return stk.pop(); 
    }

    @Override
    public Object sommet() throws PileVideException {
        return this.stk.peek();
    }

    @Override
    public boolean estVide() {
        return this.stk.empty(); //Ou bien: return this.capacite == 0; 
    }

    @Override
    public boolean estPleine() {
        return this.capacite == this.taille; 
    }

    @Override
    public String toString() {
        Stack<Object> temp = new Stack<>();
        StringBuffer sb = new StringBuffer("["); 
        int count = 0;
        while (!this.estVide()) { 
            if (count > 0) sb.append(", "); 
            Object obj = this.stk.pop();
            temp.push(obj);
            sb.append(obj.toString()); 
        } 
        sb.append("]"); 
        this.stk = temp;
        return sb.toString(); 
    }

    @Override
    public boolean equals(Object o) {
        if(this.toString().equals(((Pile2)o).toString())) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

     public int taille() {
        return this.taille;
    }

    public int capacite() {
        return this.capacite;
    }

} // Pile2.java
