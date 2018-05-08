package ca.cmpt213.as4.shapes;


/**
 * this class takes care of the rectangle object which extends from shapeImp
 * */
public class Rectangle extends ShapeImpl {


    public static final int BORDER_OFFSET = 2;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y, width, height);


    }


    @Override
    boolean isBoarder(int X, int Y) {
        boolean topAndBottomBorder = (X >= getLocationX()
                && X <= getLocationX()+ getWidth()-1 )
                && ( Y == getLocationY() || Y == getLocationY()+getHeight()-1);

        boolean leftAndRightBorder = (Y >= getLocationY()
                && Y <=getLocationY() + getHeight()-1)
                && ( X == getLocationX() || X == getLocationX()+getWidth()-1);

        if(topAndBottomBorder || leftAndRightBorder){
            return true;
        }
        return false;
    }

    @Override
    boolean isInside(int X, int Y)
    {
        if(isBoarder(X,Y)){
            return false;
        }

        boolean checkHorizontal = X >= getLocationX()+1 && X<=getLocationX()+ getWidth()-BORDER_OFFSET;
        boolean checkVertical   = Y >= getLocationY()+1 && Y<=getLocationY()+ getHeight()- BORDER_OFFSET;
        if(checkHorizontal  && checkVertical){
            return true;
        }
        return false;
    }
}
