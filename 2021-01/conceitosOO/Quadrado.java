
/**
 * Write a description of class Quadrado here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.Graphics;

public class Quadrado extends FiguraGeometrica {
   
    protected int lado;
    
    public Quadrado(int lado, int x, int y) {
        super(x,y);
        this.lado = lado;
    }
    
    public int calcularArea() {
        return lado * lado;
    }
    
    public void desenhar(Graphics g) {
    }
    
    public void move(int novoX, int novoY){
    }
}
