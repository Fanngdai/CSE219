package Recitation6;

import Recitation6.Rectangle;
import Recitation6.Circle;
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
public class ShapeFactory {
    
    public Shapes getShape(ShapeType st){
        if(st.equals(RECTANGLE)){
            return new Rectangle();
        }
        else if(st.equals(SQUARE)){
            return new Square();
            
        }
        else
            return new Circle();
    }
}
