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

package com.spring.service.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.spring.service.enums.CalculatorEnum;
import com.spring.service.request.CalculatorRequest;
import com.spring.service.response.CalculatorResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/calculadora")
@Api(tags = { "Calculadora" }, description = "Calcula com enum.")
public class CalculatorResource extends RequestMappingHandlerMapping {

  /**
   * Método : CalculadoraEnum
   * 
   * @author diego
   * @version 1.0.0 - 12/02/2020
   * @return ResponseEntity<?>
   * @throws Exception 
   */

  @ApiOperation(value = "Realiza operações matemáticas", response = String.class, notes = "Esse endpoint aguarda operadores matemáticos")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Retorna um ResponseModel com uma mensagem de sucesso", response = String.class),
      @ApiResponse(code = 500, message = "Caso tenhamos algum erro vamos retornar um ResponseModel com a Exception", response = String.class) })

  @PostMapping
  public ResponseEntity<List<CalculatorResponse>> insert(@RequestBody CalculatorRequest objetoEntrada) throws Exception {
    
    /**
     * Exemplo throw Exception geral caso Body venha vazio.
     */
    if ( objetoEntrada == null ) {
      throw new Exception("Entrada vazia: " + this);
    }
    
    List<CalculatorResponse> listObjectResponse = new ArrayList<CalculatorResponse>();

    /**
     * Exemplo If ternário tratamento nullPointer
     */
    double x = objetoEntrada != null ? objetoEntrada.getX() : 0;
    double y = objetoEntrada != null ? objetoEntrada.getY() : 0;
    
    /**
     * Leitura do CalculatorEnum
     */
    for(CalculatorEnum calculator: CalculatorEnum.values()) {
      CalculatorResponse objectResponse = new CalculatorResponse();
      objectResponse.setRequest(objetoEntrada);
      objectResponse.setOperator(calculator.name());
      objectResponse.setResult(calculator.apply(x, y));
      System.out.printf("%f %s %f = %f%n", x, calculator, y, calculator.apply(x, y));
      listObjectResponse.add(objectResponse);
    }
    
    /**
     * Exemplo response body do resultado dentro do objeto response
     */
    return ResponseEntity.ok().body(listObjectResponse);
  }
}
