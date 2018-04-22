package com.xujun.base.pattern.abstrctfactory;

import com.xujun.base.pattern.factory.Shape;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月8日 下午10:28:33 
  */

public class AbstractFactoryTest {

    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("Shape");
        Shape shape = shapeFactory.getShape("Rectangle");
        shape.draw();
        shape = shapeFactory.getShape("Circle");
        shape.draw();
        shape = shapeFactory.getShape("Sequare");
        shape.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("Color");
        Color color = colorFactory.getColor("Red");
        color.fill();
        color = colorFactory.getColor("Green");
        color.fill();
        color = colorFactory.getColor("Blue");
        color.fill();
    }
}
