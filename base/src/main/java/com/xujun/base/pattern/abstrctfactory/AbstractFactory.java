package com.xujun.base.pattern.abstrctfactory;

import com.xujun.base.pattern.factory.Shape;

/**
  * @todo 
  * @author xujun
  * @version 1.0
  * @date 2018年4月8日 下午10:19:35 
  */

public abstract class AbstractFactory {

    abstract Shape getShape(String string);

    abstract Color getColor(String color);
}
