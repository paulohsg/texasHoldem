/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdem;

import java.util.Arrays;

/**
 *
 * @author Henrique
 */
public class Carta {
    
    private String valorEnaipe;

    public Carta(String valorEnaipe) {
        this.valorEnaipe = valorEnaipe;
    }

    public String getValorEnaipe() {
        return valorEnaipe;
    }

    public void setValorEnaipe(String valorEnaipe) {
        this.valorEnaipe = valorEnaipe;
    }

    //pega o valor das cartas e coloca em um vetor int ordenado.
    public static int[] cartasParaInteiro(Carta[] cartas){
        
        int[] vetAux = new int[cartas.length];
        
        for(int i=0; i<cartas.length; i++){
        if(cartas[i].getValorEnaipe().charAt(0) == 't' || cartas[i].getValorEnaipe().charAt(0) == 'T'){
            vetAux[i] = Integer.parseInt("10");
        }else if(cartas[i].getValorEnaipe().charAt(0) == 'v' || cartas[i].getValorEnaipe().charAt(0) == 'V'){
            vetAux[i] = Integer.parseInt("11");
        }else if(cartas[i].getValorEnaipe().charAt(0) == 'd' || cartas[i].getValorEnaipe().charAt(0) == 'D'){
            vetAux[i] = Integer.parseInt("12");
        }else if(cartas[i].getValorEnaipe().charAt(0) == 'r' || cartas[i].getValorEnaipe().charAt(0) == 'R'){
            vetAux[i] = Integer.parseInt("13");
        }else if(cartas[i].getValorEnaipe().charAt(0) == 'a' || cartas[i].getValorEnaipe().charAt(0) == 'A'){
            vetAux[i] = Integer.parseInt("14");
        }else{
            vetAux[i] = Character.getNumericValue(cartas[i].getValorEnaipe().charAt(0));
        }
      }
        
        Arrays.sort(vetAux);
        return vetAux;
        
    }
    
    
     
    
    public static String cartasParaString(Carta[] cartas){
        
        String resultado = "";
        for(int i=0; i<cartas.length; i++){
            resultado = cartas[i] + " ";
            
        }
        
        return resultado;
    }
    
    
    
}
