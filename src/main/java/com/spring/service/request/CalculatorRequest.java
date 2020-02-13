package com.spring.service.request;

import java.io.Serializable;

public class CalculatorRequest implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 8421413074837257635L;

  private double x;
  private double y;
  
  public double getX() {
    return x;
  }
  public void setX(double x) {
    this.x = x;
  }
  public double getY() {
    return y;
  }
  public void setY(double y) {
    this.y = y;
  }
  
}
