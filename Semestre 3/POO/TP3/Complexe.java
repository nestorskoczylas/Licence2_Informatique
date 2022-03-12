public class Complexe {
    private double re;
    private double im;
    public Complexe(double re, double im){
        this.re = re;
        this.im = im;
    }

    
    public Complexe conjugate(){
        double x = this.re;
        double y = -this.im;
        return new Complexe(x,y);
    }

    public Complexe add(Complexe o){
        double x = this.re+o.re;
        double y = this.im+o.im;
        return new Complexe(x,y);
    }

    public Complexe mult(Complexe o){
        double x = this.re*o.re-this.im*o.im;
        double y = this.re*o.im+o.re*this.im;
        return new Complexe(x,y);
    }
    
    public String toString(){
        return this.re+"+i"+this.im;
    }
    public static void main (String [] arg){
        Complexe c1 = new Complexe(8,5);
        Complexe c2 = new Complexe(6,13);
        System.out.println("ça fait "+c2.mult(c1));  
    }

    
}