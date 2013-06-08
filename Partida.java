/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdem;

import java.util.Scanner;

/**
 *
 * @author Henrique
 */
public class Partida {
    
    private Jogador[] jogadores;

    public Partida(int quantJogadores) {
        jogadores = new Jogador[quantJogadores];
        for(int i=0; i<quantJogadores; i++){
            jogadores[i] = new Jogador();
        }
    }

    public Jogador[] getJogadores() {
        return jogadores;
    }

    public void setJogadores(Jogador[] jogadores) {
        this.jogadores = jogadores;
    }
    
    
    
    
    
    //exibe o menu inicial do programa
    public static int menuInicial(){
        
        Scanner scanner = new Scanner (System.in);
        System.out.println("Aplicação Pôker Texas Hold em");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Iniciar uma nova partida");
        System.out.println("2 - sair");
        int escolha = scanner.nextInt();
        return escolha;
    }
    
    //pega a quantidade de jogadores na partida, inicializa o objeto partida,
    //chama o método AdicionaJogador() para adicionar cartas aos jogadores
    public static Partida menuInicializaPartida(){
        
        
        Scanner scanner = new Scanner (System.in);
        System.out.println("Quantos jogadores estarão na partida?");
        int quantJogadores = scanner.nextInt();
        
        Partida partida = new Partida(quantJogadores);
        
        for(int i=0; i<quantJogadores; i++){
            System.out.println((i+1)+"º Jogador");
            Partida.AdicionaJogador(partida.getJogadores()[i]);
            
        }
        
        return partida;
        
    }
        
    
    
    
     //Método que adiciona as cartas ao jogadores, retorna um vetor de cartas
    //que será usado para facilitar a descoberta das combinaçoes
    public static void AdicionaJogador(Jogador jogador) {
        
        int[] vetAux = new int[7];
        
        
        for(int i=0; i<7; i++){
            vetAux[i] = 0;
        }
        
        for(int i = 0; i<7; i++){
        
        System.out.println("\nForceça o valor e o naipe da "+(i+1)+"ª carta.\n"
                + "Sendo os valores apenas: 2, 3, 4, 5, 6, 7, 8, 9, T, V, D, R.\n"
                + "Sendo o naipe apenas: e - espadas, o - ouros, p - paus, c - copas.\n"
                + "Exemplo de dado a ser inserido: 8e (representa o oito de espadas)."
                + "Se não houver determinada carta adicione 0.");
        Scanner scanner = new Scanner (System.in);
        String carta = scanner.nextLine();
        jogador.getMao()[i].setValorEnaipe(carta);
        if(carta.equals("0") || carta.equals("00")){
            
            continue;
        }
    }
  }
    
    
    //calcula qual jogador possui a sequência de cartas mais forte
    //e seta o atributo ganhador como true
    public static void calculaResultadoPartida(Partida partida){
        
        int temp = 0;
        
        
        
        for(int i=0; i<partida.getJogadores().length-1; i++){
            if(partida.getJogadores()[i].getComparacao() > partida.getJogadores()[i+1].getComparacao()){
                temp = i;
            
        }
       partida.getJogadores()[temp].setGanhador(true);         
    }
    }
    
    //imprime o resultado da partida
    public static void imprimeResultadoPartida(Partida partida){
        
        for(int i=0; i<partida.getJogadores().length; i++){
            System.out.println();
            Partida.imprimeCartas(partida.getJogadores()[i]);
        }
        
    }
    
    
    //imprime a sequência de cartas de um jogador
    public static void imprimeCartas(Jogador jogador){
        
        String seqCartas = "";
        for(int i=0; i<jogador.getMao().length; i++){
            seqCartas += jogador.getMao()[i].getValorEnaipe() + " ";
            
        }
        
        if(jogador.getCombinacao().equalsIgnoreCase(Combinacoes.getCombinacoes()[0])){
            seqCartas += " " + jogador.getCombinacao() + " (maior carta "+jogador.getComparacao()+")";
        }else{
        seqCartas += " " + jogador.getCombinacao();
        }
        
        if(jogador.isGanhador()){
            System.out.println(seqCartas+" (ganhador)");
        }else{
            System.out.println(seqCartas);
        }
    }
    
}
