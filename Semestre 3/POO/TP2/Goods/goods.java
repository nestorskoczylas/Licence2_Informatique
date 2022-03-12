public class goods
{
    private double value;
    
    private String name;

    /**
     * Constructeur qui initialise l'attribut name et
     * value à 0.
     * @param n le nom que l'on veut initialiser
     */
    public void initialisationSimple(String n)
    {
        name = n;
        value = 0;
    }

    /**
     * Constructeur qui initialise le nom et
     * la valeur de la marchandsie.
     *
     * @param  a le nom que l'on veut initialiser.
     * @param v la valeur que l'on souhaite initialiser.
     */
    public void initialisationDouble(String a, int v)
    {
        name = a;
        value = v;
    }
    
    /**
     * Méthode pour obtenir la valeur d'une marchandise
     *@return la valeur de l'attribut value
     */
    public double getValue()
    {
        return value;
    }
    
    /**
     * Méthode pour changer la valeur de value.
     * @param x la nouvelle valeur de value.
     */
    public void setValue(double x)
    {
        value = x;
    }
    
    /**
     * Méthode pour obtenir une phrase avec le nom et la valeur de la marchandise.
     */
    public String toString()
    {
        return "the goods "+name+" costs "+value;
    }
    
    /**
     * Méthode qui renvoie la valleur TTC avec une TVA à 20%.
     */
    public double TTC()
    {
        return value*1.2;
    }
}
