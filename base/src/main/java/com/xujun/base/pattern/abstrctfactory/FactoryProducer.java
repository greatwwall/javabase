package com.xujun.base.pattern.abstrctfactory;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月8日 下午10:26:48 
  */

public class FactoryProducer {

    public static AbstractFactory getFactory(String str) {
        if (str.equals("Shape"))
            return new ShapeFactory();
        if (str.equals("Color"))
            return new ColorFactory();
        return null;
    }
}
