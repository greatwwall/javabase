package com.xujun.base.pattern.factory;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月8日 下午10:07:31 
  */

public class ShapeFactory {

    public Shape getShape(Class<?> clazz) {
        if (clazz.getClass().isInstance(Sequare.class))
            return new Sequare();
        if (clazz.getClass().isInstance(Circle.class))
            return new Sequare();
        if (clazz.getClass().isInstance(Rectangle.class))
            return new Sequare();
        return null;
    }

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape shape1 = factory.getShape(Sequare.class);
        shape1.draw();
        Shape shape2 = factory.getShape(Circle.class);
        shape2.draw();
        Shape shape3 = factory.getShape(Rectangle.class);
        shape3.draw();
    }
}
