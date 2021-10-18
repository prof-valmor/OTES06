
/**
 * Write a description of class Retangulo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Retangulo extends Quadrado{
    private int base;
    
    public Retangulo(int lado, int base, int x, int y) {
        super(lado, x, y);
        this.base = base;
    }
    
    public int calcularArea() {
        return base * lado;
    }
}
