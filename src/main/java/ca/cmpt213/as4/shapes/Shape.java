package ca.cmpt213.as4.shapes;
import ca.cmpt213.as4.UI.Canvas;
import java.awt.*;

public interface Shape {
//    int X = 0;
//    int Y = 0;
//    char Board_Char = 0;
//    Color color = Color.yellow ;


    public int getLocationX();

    public int getLocationY();

    public void setBorderChar(char lable);

    public char getBoardChar();

    public void setColor(Color color);

    public Color getColor();

    public void draw(Canvas canvas) throws NoSuchMethodException;



}
