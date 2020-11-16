
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {
        Quadrado q = new Quadrado(2, 10, 10);
        Retangulo r = new Retangulo(4, 5, 10, 15);
       
        ArrayList<FiguraGeometrica> lista = new ArrayList<FiguraGeometrica>();
        ArrayList<String> strings = new ArrayList<String>();
        //
        lista.add(q);
        lista.add(new Quadrado(10, 0, 0));
        lista.add(new Retangulo(15, 10, 0, 0));
        lista.add(r);
        
        for(FiguraGeometrica f: lista) {
            System.out.println("--> Area da figura " + f + ": "  + f.calcularArea());
        }
        
    }
}
