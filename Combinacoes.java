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
public class Combinacoes {
    
    private static final String[] combinacoes = {"sem combinação","par", "dois pares", "trinca", "straight", 
        "flush", "full house", "quadra", "straight flush", "royal straight flush"};
   
    private static final int SEM_COMBINACAO = 0;
    private static final int PAR = 15;
    private static final int DOIS_PARES = 16;
    private static final int TRINCA = 17;
    private static final int STRAIGHT = 18; //sequencia de cartas com naipes diferentes
    private static final int FLUSH = 19; //cinco cartas do mesmo naipe
    private static final int FULL_HOUSE = 20; //uma trinca e um par
    private static final int QUADRA = 21;
    private static final int STRAIGHT_FLUSH = 22;//sequência de cartas do mesmo naipe
    private static final int ROYAL_STRAIGHT_FLUSH = 23; //sequência dez, valete, dama, rei e A do mesmo naipe

    public Combinacoes() {
    }
    
    

    public static String[] getCombinacoes() {
        return combinacoes;
    }

    public static int getDOIS_PARES() {
        return DOIS_PARES;
    }

    public static int getFLUSH() {
        return FLUSH;
    }

    public static int getFULL_HOUSE() {
        return FULL_HOUSE;
    }

    public static int getPAR() {
        return PAR;
    }

    public static int getQUADRA() {
        return QUADRA;
    }

    public static int getROYAL_STRAIGHT_FLUSH() {
        return ROYAL_STRAIGHT_FLUSH;
    }

    public static int getSEM_COMBINACAO() {
        return SEM_COMBINACAO;
    }

    public static int getSTRAIGHT() {
        return STRAIGHT;
    }

    public static int getSTRAIGHT_FLUSH() {
        return STRAIGHT_FLUSH;
    }

    public static int getTRINCA() {
        return TRINCA;
    }


    
    
    
    //verifica se um vetor de cartas forma uma sequência
    public static boolean verificaSequencia(Carta[] cartas){
        int[] aux = Carta.cartasParaInteiro(cartas);
        int cont = 0;
        
        for(int i=0; i<cartas.length-1; i++){
           if(aux[i] > (aux[i+1] - 2)){
               cont++;
               }
            
        }
        if(cont == 5)
            return true;
        else
            return false;
    }
    
    //verifica se ha a combinação straight flush (sequência de cartas do msm naipe) em um vetor de cartas
    public static boolean verificaStraightFlush(Jogador jogador) {
        
        int[] aux = Carta.cartasParaInteiro(jogador.getMao());
        
        
        
        if(aux[2] != 10 && aux[3] !=11 && aux[4] !=12 && aux[5] !=13 && aux[6] !=14 ){
            if(Combinacoes.verificaSequencia(jogador.getMao()) == true && Combinacoes.verificaNaipesIguais(jogador.getMao()) == true){
                jogador.setComparacao(Combinacoes.getSTRAIGHT_FLUSH());
                jogador.setCombinacao(Combinacoes.getCombinacoes()[8]);
                return true;
        }else{
            return false;
        }
        }else
            return false;
    }
    
    //verifica se há a combinação royal straight flush (sequência 10, valete, dama, rei e A do mesmo naipe) em um vetor de cartas
    public static boolean verificaRoyalStraightFlush(Jogador jogador){
        
        
        int[] aux = Carta.cartasParaInteiro(jogador.getMao());
        int[] royal = {aux[0], aux[1], 10, 11, 12, 13, 14};
        if(Arrays.equals(royal, aux) && Combinacoes.verificaNaipesIguais(jogador.getMao())){
            jogador.setComparacao(Combinacoes.getROYAL_STRAIGHT_FLUSH());
            jogador.setCombinacao(Combinacoes.getCombinacoes()[9]);
            return true;
        }else{
        return false;
        }
        
    }
    
    //verifica se há a combinação straight (sequência de cartas de naipes diferentes) em um vetor de cartas
    public static boolean verificaStraight(Jogador jogador){
        
        if(Combinacoes.verificaSequencia(jogador.getMao()) == true && Combinacoes.verificaNaipesIguais(jogador.getMao()) == false){
            jogador.setComparacao(Combinacoes.getSTRAIGHT());
            jogador.setCombinacao(Combinacoes.getCombinacoes()[4]);
            return true;
        }else{
            return false;
        }
    }
    
    //verifica se um vetor de cartas possui todos os naipes iguais
    public static boolean verificaNaipesIguais(Carta[] cartas){
        
        int cont = 0;
        char[] naipes = new char[cartas.length];
        
        
        for(int i=0; i<cartas.length-1; i++){
            if(cartas[i].getValorEnaipe().charAt(1) == cartas[i+1].getValorEnaipe().charAt(1)){
                cont++;
            
            }
            
}
        
        if(cont == 4 || cont > 4)
            return true;
        else
            return false;
    }
    
    //verifica se há um par de cartas iguais no vetor de cartas
    public static int verificaUmPar(Jogador jogador){
        
        int[] aux = Carta.cartasParaInteiro(jogador.getMao());
        int temp = 0;
        
        for(int i=0; i<jogador.getMao().length-1; i++){
            if(aux[i] == aux[i+1]){
                temp = aux[i];
                i++;
            }
        }
        if(temp != 0){
            jogador.setComparacao(Combinacoes.getPAR());
            jogador.setCombinacao(Combinacoes.getCombinacoes()[1]);
        }
        
        return temp;
    }
    
    //verifica se há dois pares de cartas iguais no vetor de cartas
    public static int[] verificaDoisPares(Jogador jogador){
        
        int[] aux = Carta.cartasParaInteiro(jogador.getMao());
        int[] resultado = {0,0};
        
        for(int i=0; i<jogador.getMao().length-1; i++){
            if(aux[i] == aux[i+1]){
                if(resultado[0] == 0){
                    resultado[0] = aux[i];
                    i++;
                }else{
                    resultado[1] = aux[i];
                }
            }
        }
        
        if(resultado[0] != 0 && resultado[1] != 0){
            jogador.setComparacao(Combinacoes.getDOIS_PARES());
            jogador.setCombinacao(Combinacoes.getCombinacoes()[2]);
        }
        
        return resultado;
    }
    
    //verifica se há uma trinca de pares iguais no vetor de cartas
    public static int verificaTrinca(Jogador jogador){
        
        int[] aux = Carta.cartasParaInteiro(jogador.getMao());
        int temp = 0;
        
        for(int i=0; i<jogador.getMao().length-1; i++){
            if(aux[i] == aux[i+1] && aux[i+1] == aux[i+2]){
                temp = aux[i];
                i++;
            }
        }
        
        if(temp != 0){
            jogador.setComparacao(Combinacoes.getTRINCA());
            jogador.setCombinacao(Combinacoes.getCombinacoes()[3]);
        }
        
        return temp;
        
    }
    
    //verifica se possui 5 cartas do mesmo naipe
    public static boolean verificaFlush(Jogador jogador){
        if(Combinacoes.verificaNaipesIguais(jogador.getMao())){
            jogador.setComparacao(Combinacoes.getFLUSH());
            jogador.setCombinacao(Combinacoes.getCombinacoes()[5]);
            return true;
        }else{
            return false;
        }
    }
   
    
    //verifica se tem uma trinca e um par
    public static boolean verificaFullHouse(Jogador jogador){
        
        if(Combinacoes.verificaUmPar(jogador) != 0 && Combinacoes.verificaTrinca(jogador) != 0){
            jogador.setComparacao(Combinacoes.getFULL_HOUSE());
            jogador.setCombinacao(Combinacoes.getCombinacoes()[6]);
            return true;
            
        } else{
            return false;
        }
    }
    
    //verifica se tem uma quadra de cartas do mesmo valor
    public static int verificaQuadra(Jogador jogador){
        
        int[] aux = Carta.cartasParaInteiro(jogador.getMao());
        int temp = 0;
        
        for(int i=0; i<jogador.getMao().length-2; i++){
            if(aux[i] == aux[i+1] && aux[i+1] == aux[i+2] && aux[i+2] == aux[i+3])
            temp = aux[i];
            i++;
        }
        
        if(temp != 0){
            jogador.setComparacao(Combinacoes.getFLUSH());
            jogador.setCombinacao(Combinacoes.getCombinacoes()[7]);
        }
        return temp;
    }
    
    
    //acha o maior valor em um vetor de cartas
    public static String achaMaiorCarta(Carta[] carta){
        
        int[] aux = Carta.cartasParaInteiro(carta);
        int temp = 0;
        String tempS = "";
        
        for(int i=0; i<aux.length-1; i++){
            if(aux[i] > aux[i+1])
                temp = aux[i];
        }
        
        if(temp == 10)
            return "10";
        if(temp == 11)
            return "v";
        if(temp == 12)
            return "d";
        if(temp == 13)
            return "r";
        if(temp == 14)
            return "a";
        else
            tempS = Integer.toString(temp);
            return tempS;
        
    }
    
    
    public static boolean temCombinacao(Jogador jogador){
        
        if(jogador.getComparacao() < Combinacoes.getPAR())
            return false;
        else
            return true;
        
    }
    
    
  
    
    
    public static void resultadoComparacao(Jogador jogador){
        
        Combinacoes.verificaUmPar(jogador);
        Combinacoes.verificaDoisPares(jogador);
        Combinacoes.verificaTrinca(jogador);
        Combinacoes.verificaStraight(jogador);
        Combinacoes.verificaStraight(jogador);
        Combinacoes.verificaFlush(jogador);
        Combinacoes.verificaFullHouse(jogador);
        Combinacoes.verificaQuadra(jogador);
        Combinacoes.verificaQuadra(jogador);
        Combinacoes.verificaStraightFlush(jogador);
        Combinacoes.verificaRoyalStraightFlush(jogador);
        
    }
    
}
