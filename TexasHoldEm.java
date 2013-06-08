/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdem;

/**
 *
 * @author Henrique
 */
public class TexasHoldEm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Partida.menuInicial();
        Partida partida = Partida.menuInicializaPartida();
        Partida.calculaResultadoPartida(partida);
        Partida.imprimeResultadoPartida(partida);
       
        
   
}


}
