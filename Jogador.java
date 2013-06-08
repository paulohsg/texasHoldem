/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdem;

/**
 *
 * @author Henrique
 */
public class Jogador {
    
    private Carta[] mao = new Carta[7];
    private int comparacao;
    private String combinacao;
    private boolean ganhador;

    

    public Jogador() {
        this.mao[0] = new Carta("");
        this.mao[1] = new Carta("");
        this.mao[2] = new Carta("");
        this.mao[3] = new Carta("");
        this.mao[4] = new Carta("");
        this.mao[5] = new Carta("");
        this.mao[6] = new Carta("");
        this.comparacao = 0;
        this.combinacao = "";
        this.ganhador = false;
        
    }

    public Carta[] getMao() {
        return mao;
    }

    public void setMao(Carta[] mao) {
        this.mao = mao;
    }

    public String getCombinacao() {
        return combinacao;
    }

    public void setCombinacao(String combinacao) {
        this.combinacao = combinacao;
    }

    public int getComparacao() {
        return comparacao;
    }

    public void setComparacao(int comparacao) {
        this.comparacao = comparacao;
    }

    public boolean isGanhador() {
        return ganhador;
    }

    public void setGanhador(boolean ganhador) {
        this.ganhador = ganhador;
    }
    
    

 

   
}
