package ca.cmpt213.as4.shapes;

import java.awt.*;
//import java.awt.Shape;

public class Triangle extends ShapeImpl  {


    public Triangle(int topRight, int topLeft, int bottomRight) {
        super(topRight, topLeft,bottomRight,bottomRight);

    }

    @Override
    public void setBorderChar(char lable) {
        super.setBorderChar(lable);
    }

    @Override
    protected boolean isBoarder(int X, int Y) {

        boolean checkBase = (X >= getLocationX() && X <= (getLocationX()+ getWidth() -1))&& (Y== (getLocationY()+getHeight()-1));
        boolean checkLeftWall = (Y >= getLocationY() && Y<= (getLocationY()+ getHeight() -1))&& (X== (getLocationX()));
        boolean checkDiagnol = (X - getLocationX() == Y - getLocationY());

        if(checkBase || checkLeftWall || checkDiagnol ){
            return true;
        }
        return false;
    }

    @Override
    protected boolean isInside(int X, int Y) {



        boolean checkBase = (X >= getLocationX()
                && X <= (getLocationX()+ getWidth() -2))
                && ( Y!= (getLocationY()+getHeight()-1));

        boolean checkHight = (Y >= getLocationY()
                && Y<= (getLocationY()+ getHeight() -2))
                && (X!= (getLocationX()));

        boolean checkDiagnol = (X - getLocationX() != Y - getLocationY());
        boolean checkLastPlace = (X < (getLocationX() + Y- getLocationY()));

        if(checkBase && checkHight && checkDiagnol && checkLastPlace){
            return true;
        }
        return false;

    }

    @Override
    public void setColor(Color color) {
        super.setColor(color);
    }
}
