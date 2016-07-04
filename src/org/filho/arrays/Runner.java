package org.filho.arrays;

import java.math.BigDecimal;
import java.util.Scanner;

public class Runner {

  public static void main(String[] args) {
    // Utiliza o scanner para ler o input do usuário
    Scanner scanner = new Scanner(System.in);
    System.out.print("Informe um valor que seja múltiplo de 10 e que esteja entre 100 e 1000: ");
    
    String numeroStr = scanner.next();
    
    // Se não são todos dígitos
    if(!numeroStr.matches("^\\d+$")) {
      System.err.println("Número não contém somente dígitos.");
      System.exit(1);
    }
    
    BigDecimal numero = new BigDecimal(numeroStr);
    // Se não é múltiplo de 10
    if(numero.divide(BigDecimal.TEN).scale() != 0 || 
        (numero.compareTo(new BigDecimal(100L)) <= 0 || numero.compareTo(new BigDecimal(1000L)) >= 0) ) {
      System.err.println("Número não é múltiplo de 10 ou não está entre 100 e 1000");
      System.exit(1);
    }
    
    BigDecimal[] array = new BigDecimal[10];
    
    BigDecimal pc30 = new BigDecimal(".3");
    BigDecimal pc10 = new BigDecimal(".1");
    
    for (int i = 0; i < array.length; i++) {
      // Começamos com o índice 1, pois é assim que está no exemplo
      int idx = i+1;
      BigDecimal indice = new BigDecimal(idx);
      
      // O índice vezes 30 (ou 10) vezes o nr informado
      array[i] = indice.multiply(idx % 3 == 0 ? pc30 : pc10).multiply(numero);
    }
    
    System.out.print("Deseja saber a soma das posições ímpares ou pares do array? [i, p]: ");
    String opcao = scanner.next();
    
    if(!opcao.equals("i") && !opcao.equals("p")) {
      System.err.println("Não entendi a sua opção. Tchau.");
      System.exit(1);
    }
    
    BigDecimal soma = BigDecimal.ZERO;
    
    // ímpares
    for (int i = 0; i < array.length; i++) {
      int idx = i+1;
      
      if(opcao.equals("i") && idx % 2 != 0 || opcao.equals("p") && idx % 2 == 0)
        soma = soma.add(array[i]);
    }
    
    System.out.println("A soma é: " + soma.toPlainString());
    
    scanner.close();
  }

}
