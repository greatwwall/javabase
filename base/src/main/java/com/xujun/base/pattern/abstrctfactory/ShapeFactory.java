package com.xujun.base.pattern.abstrctfactory;

import com.xujun.base.pattern.factory.Circle;
import com.xujun.base.pattern.factory.Rectangle;
import com.xujun.base.pattern.factory.Sequare;
import com.xujun.base.pattern.factory.Shape;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月8日 下午10:07:31 
  */

public class ShapeFactory extends AbstractFactory {

    @Override
    Shape getShape(String shape) {
        if (shape.equals("Sequare"))
            return new Sequare();
        if (shape.equals("Circle"))
            return new Circle();
        if (shape.equals("Rectangle"))
            return new Rectangle();
        return null;
    }

    @Override
    Color getColor(String color) {
        return null;
    }
}
