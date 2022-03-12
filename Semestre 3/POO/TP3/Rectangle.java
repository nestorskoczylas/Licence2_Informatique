public class Rectangle{
    private double lo;
    private double la;
    public Rectangle(double lo, double la){
        this.lo=lo;
        this.la=la;
    }
    public double aire(){
        return this.lo*this.la;
    }

    public double perimetre(){
        return 2*(this.lo+this.la);
    }

    public boolean estCarre(){
        if(this.lo==this.la){
            return true;
        }
        else {
            return false;
        } 
    }
    public boolean equals(Object o){
        if(o instanceof Rectangle){
            Rectangle other = (Rectangle)o;
            return this.lo==other.lo && this.la==other.la;
        }
        else{
            return false;
        }
    }
    public String toString(){
        return "Le rectangle a une longueur de "+this.lo+" et une largeur de "+this.la;
    }
    public static void main(String[] args){
        Rectangle r1 = new Rectangle( 1, 1);
        Rectangle r2 = new Rectangle(2,2);
        r1.aire();
        r2.perimetre();
        r1.estCarre();
        r2.estCarre();
        r1.equals(r2);
        System.out.println("r2 péri"+r2.perimetre());
    }
}