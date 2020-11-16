
/**
 * Write a description of class FiguraGeometrica here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.Graphics;

public abstract class FiguraGeometrica {
    protected int x;
    protected int y;
    
    public FiguraGeometrica(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public abstract int calcularArea();
    
    public abstract void desenhar(Graphics g);
    
    public abstract void move(int novoX, int novoY);
}
