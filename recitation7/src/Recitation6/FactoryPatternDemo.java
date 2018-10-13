package Recitation6;

import static Recitation6.ShapeType.CIRCLE;
import static Recitation6.ShapeType.RECTANGLE;
import static Recitation6.ShapeType.SQUARE;
import java.awt.Shape;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author fannydai
 */
public class FactoryPatternDemo {
    public static void main(String[] args){
        ShapeFactory shapeFactory = new ShapeFactory();
        Shapes rectangle = shapeFactory.getShape(RECTANGLE);
        Shapes square = shapeFactory.getShape(SQUARE);
        Shapes circle = shapeFactory.getShape(CIRCLE);
        
        rectangle.draw();
        square.draw();
        circle.draw();
    }
}
