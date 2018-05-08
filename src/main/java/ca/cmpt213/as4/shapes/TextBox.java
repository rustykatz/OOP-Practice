package ca.cmpt213.as4.shapes;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import ca.cmpt213.as4.UI.Canvas;


/**
 * this class makes sure that the writing is fitable and also makes sures to
 * center the texts
 * */
public class TextBox extends Rectangle   {


    private int X;
    private int Y;
    private int width;
    private int height;
    private String msg;
    private char lable;

    public TextBox(int X, int Y, int width, int height, String msg) {
        super(X,Y,width, height);

        this.X = X;
        this.Y = Y;
        this.width = width;
        this.height = height;
        this.msg = msg;
    }

    @Override
    public void setBorderChar(char lable) {
        super.setBorderChar(lable);
    }

    @Override
    public void setColor(Color color) {
        super.setColor(color);
    }

    public String getMessage(){
            return msg;
    }

    public void setMessage(String msg){

        this.msg = msg;
    }

    public ArrayList<String> breakDownWord(ArrayList<String> allWordWithNoSpace ,
                                           int wordCounter ,
                                           ArrayList<String> lstOfSentences){
        String fullsentence = "";
        while(allWordWithNoSpace.get(wordCounter).length() >= getWidth()-2){
            fullsentence = allWordWithNoSpace.get(wordCounter).substring(0,getWidth()-2);
            lstOfSentences.add(fullsentence);
            String temp = allWordWithNoSpace.get(wordCounter).replace(fullsentence,"");
            allWordWithNoSpace.set(wordCounter,temp);
            fullsentence="";

        }
        return lstOfSentences;
    }


    public ArrayList<String> divideIntoSentence( String msg){

        String msgWithTrimEnds = getMessage().trim();
        ArrayList<String> allWordWithNoSpace = new ArrayList<>(Arrays.asList(msgWithTrimEnds.split(" ")));
        ArrayList<String> lstOfSentences = new ArrayList<>();

        int wordCounter = 0;

        for (int listCounter = 0; listCounter < allWordWithNoSpace.size(); listCounter++) {
            int tempWidth = getWidth()-1;
            String fullsentence = "";

            for (int chosenWord = wordCounter; chosenWord < allWordWithNoSpace.size(); chosenWord++) {

                if (allWordWithNoSpace.get(chosenWord).length()-1 < tempWidth-1) {
                    fullsentence += allWordWithNoSpace.get(chosenWord);
                    tempWidth -= allWordWithNoSpace.get(chosenWord).length();
                    wordCounter ++;

                }
                else if (allWordWithNoSpace.get(chosenWord).length() >= getWidth()-2) {
                    lstOfSentences.add(fullsentence);
                    lstOfSentences = breakDownWord(allWordWithNoSpace,wordCounter,lstOfSentences);

                    fullsentence = allWordWithNoSpace.get(wordCounter);
                    tempWidth -= allWordWithNoSpace.get(chosenWord).length();
                    wordCounter ++;
                }

                else{
                    break;
                }
                fullsentence = fullsentence + " ";
                tempWidth--;

            }
            lstOfSentences.add(fullsentence);
        }
        return lstOfSentences;
    }


    public void draw(Canvas canvas) {
        super.draw(canvas);

        ArrayList<String> lstOfSentences = new ArrayList<>();
        lstOfSentences = (ArrayList<String>) divideIntoSentence(getMessage()).clone();

        for (int i = 0; i < lstOfSentences.size(); i++) {
            System.out.println(lstOfSentences.get(i));
        }
        int charAt =0;
        int StringAt =0;

        for(int heightVal = Y+1; heightVal <  Y+1 + getHeight()-1 ;heightVal++){
            int tempStringSize = lstOfSentences.get(StringAt).length();
            int offset = (int) Math.ceil(((getWidth()-2) - (tempStringSize-1)) /2);

            for (int widthVal = X+1; widthVal < X+1 + getWidth()-1 ; widthVal++) {

                if(!isBoarder(widthVal,heightVal) && isInside(widthVal,heightVal)){


                    if(charAt < tempStringSize ){

                        canvas.setCellText(widthVal+offset,
                                            heightVal,
                                            lstOfSentences.get(StringAt).charAt(charAt));
                        charAt++;


                    }else if (StringAt == lstOfSentences.size()-1){
                        return;
                    }
                }
            }
            StringAt++;
            charAt = 0;
        }
    }
}
