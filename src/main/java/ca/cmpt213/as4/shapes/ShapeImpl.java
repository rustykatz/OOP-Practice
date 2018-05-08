package ca.cmpt213.as4.shapes;
import ca.cmpt213.as4.UI.Canvas;
import ca.cmpt213.as4.UI.CanvasIcon;
import ca.cmpt213.as4.UI.PicturePanel;
import java.awt.*;


/**
 * this class implements the shape needed with the help of child classes
 * */

public abstract class ShapeImpl implements Shape {

    private int X;
    private int Y;
    private int width;
    private int height;

    private char lable = '*';
    private Color color = Color.yellow ;


    public ShapeImpl(int X, int Y, int width, int height) {
        this.X = X;
        this.Y = Y;
        this.width = width;
        this.height = height;
    }




    @Override
    public int getLocationX() {
        return X;
    }

    @Override
    public int getLocationY() {
        return Y;
    }

    @Override
    public void setBorderChar(char lable) {
        this.lable = lable;
    }

    @Override
    public char getBoardChar() {
        return lable;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void draw(Canvas canvas)  {


        for(int chosenX_Value = X; chosenX_Value <=  X + getWidth()-1 ;chosenX_Value++){
            for (int chosenY_Value = Y; chosenY_Value <= Y + getHeight()-1 ; chosenY_Value++) {
                if(isBoarder(chosenX_Value,chosenY_Value)   ){

                    canvas.setCellColor(chosenX_Value,chosenY_Value,getColor());
                    canvas.setCellText(chosenX_Value,chosenY_Value,getBoardChar());

                }
                if( isInside(chosenX_Value,chosenY_Value) ){
                    canvas.setCellColor(chosenX_Value,chosenY_Value,getColor());

                    canvas.setCellText(chosenX_Value,chosenY_Value,' ');

                }

            }
        }




    }
    protected int getWidth(){
        return width;
    }

    protected int getHeight() {
        return height;
    }

    abstract boolean isBoarder(int X, int Y);

    abstract boolean isInside(int X, int Y);

}
