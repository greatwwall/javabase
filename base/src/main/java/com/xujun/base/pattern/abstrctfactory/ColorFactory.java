package com.xujun.base.pattern.abstrctfactory;

import com.xujun.base.pattern.factory.Shape;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月8日 下午10:07:31 
  */

public class ColorFactory extends AbstractFactory {

    @Override
    Shape getShape(String shape) {
        return null;
    }

    @Override
    Color getColor(String color) {
        if (color.equals("Red"))
            return new Red();
        if (color.equals("Green"))
            return new Green();
        if (color.equals("Blue"))
            return new Blue();
        return null;
    }
}
