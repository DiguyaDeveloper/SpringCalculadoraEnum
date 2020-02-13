/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
  :: EMPRESA    : DiguyaDeveloper                                              ::
  :: SISTEMA    : Enum                                                         ::
  :: MÓDULO     :                                                              ::
  :: OBSERVAÇÃO :                                                              ::
  ::---------------------------------------------------------------------------::
  :: PROGRAMADOR:                                                              ::
  :: DATA       :                                                VERSÃO:       ::
  :: ALTERAÇÃO  :                                                              ::
  ::---------------------------------------------------------------------------::
  :: PROGRAMADOR: Diego Ceccon de Souza                                        ::
  :: DATA       : 12/02/2020                                     VERSÃO:    1  ::
  :: ALTERAÇÃO  : Primeira versão                                              ::
  :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/

package com.spring.service.enums;

public enum CalculatorEnum {

  PLUS {
    public double apply(double x, double y) {
      return x + y;
    }
  },
  MINUS {
    public double apply(double x, double y) {
      return x - y;
    }
  },
  TIMES {
    public double apply(double x, double y) {
      return x * y;
    }
  },
  DIVIDE {
    public double apply(double x, double y) {
      return x / y;
    }
  };

  public abstract double apply(double x, double y);

}
