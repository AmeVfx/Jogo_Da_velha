import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = {"0","1","2","3","4","5","6","7","8"};
        int[][] combinacoes =
                {{0,1,2}, {3,4,5}, {6,7,8},
                  {0,3,6},{1,4,7},{2,5,8}
                   ,{0,4,8},{2,4,6}};
        MostrarTabu(array);
        Boolean jogador = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < combinacoes.length; j++) {
                if (ChecarVitoriaX(combinacoes[j], array)){
                    return;
                }
                if (ChecarVitoriaY(combinacoes[j], array)){
                    return;
                }
            }
            int posicao;
            try
            {
                posicao = scanner.nextInt();
                if (posicao < 0) {
                    i--;
                    System.out.println("Digite numeros que nao sejam negativos!");
                    continue;
                }
                if (posicao > 8) {
                    i--;
                    System.out.println("DIGITE apenas numero existentes nas casas do TABULEIRO!");
                    continue;
                }
            }catch (Exception E){
                System.out.println("Digite apenas numeros!");
                scanner.next();
                i--;
                continue;
            }

            if (array[posicao].equals("X") || array[posicao].equals("Y") ){
                i--;
                System.out.println("Casa Já ocupada tente NOVAMENTE!");
                continue;
            }
            if (jogador == true) {
                jogador = false;
                array[posicao] = "X";
                MostrarTabu(array);
            } else {
                jogador = true;
                array[posicao] = "Y";
                MostrarTabu(array);
            }
        }
        System.out.println("Empate");
    }
    public static boolean ChecarVitoriaX(int[] combinacao, String[] tabu){
        for (int i = 0; i < combinacao.length; i++) {
            if (tabu[combinacao[i]].equals("X") &&
                    tabu[combinacao[i+1]].equals("X")
                    && tabu[combinacao[i+2]].equals("X")) {
                System.out.println("Jogador X ganhou!");
                return true;
            }
            break;
        }
        return false;
    }
    public static boolean ChecarVitoriaY(int[] combinacao, String[] tabu){
        for (int i = 0; i < combinacao.length; i++) {
            if (tabu[combinacao[i]].equals("Y") &&
                    tabu[combinacao[i+1]].equals("Y")
                    && tabu[combinacao[i+2]].equals("Y")) {
                System.out.println("Jogador Y ganhou!");
                return true;
            }
            break;
        }
        return false;
    }
    public static void MostrarTabu (String[] array){
        System.out.printf("""
                | %S | %S | %S |  
                | %S | %S | %S |  
                | %S | %S | %S |  """
                ,array[0],array[1],array[2]
                ,array[3],array[4],array[5]
                ,array[6],array[7],array[8] );
    }
}