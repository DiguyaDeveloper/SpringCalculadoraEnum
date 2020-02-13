package com.spring.service.response;

import java.io.Serializable;

import com.spring.service.request.CalculatorRequest;

public class CalculatorResponse implements Serializable {

  private static final long serialVersionUID = -7689385404551308643L;
  
  private CalculatorRequest request;
  private double result;
  private String operator;
  
  public CalculatorRequest getRequest() {
    return request;
  }
  public void setRequest(CalculatorRequest request) {
    this.request = request;
  }
  public double getResult() {
    return result;
  }
  public void setResult(double result) {
    this.result = result;
  }
  public String getOperator() {
    return operator;
  }
  public void setOperator(String operator) {
    this.operator = operator;
  }
  
}
