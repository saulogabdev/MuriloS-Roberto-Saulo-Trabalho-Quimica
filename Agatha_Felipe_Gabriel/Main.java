import java.util.Scanner;

public class Main {
    public static Scanner tecladoScanner = new Scanner(System.in);

    public static Metal[] informacoesMetais(){
        Metal[] metais = new Metal[14];

        metais[0] = new Metal("Li", -3.04, "Litio");
        metais[1] = new Metal("K", -2.93, "Potássio");
        metais[2] = new Metal("Cr", -0.74, "Cromo");
        metais[3] = new Metal("Ba", -2.90, "Bário");
        metais[4] = new Metal("Ca", -2.87, "Cálcio");
        metais[5] = new Metal("Na", -2.71, "Sódio");
        metais[6] = new Metal("Mg", -2.37, "Magnésio");
        metais[7] = new Metal("Zn", -0.76, "Zinco");
        metais[8] = new Metal("Fe", -0.44, "Ferro");
        metais[9] = new Metal("Cu", 0.34, "Cobre");
        metais[10] = new Metal("Ni", -0.23, "Níquel");
        metais[11] = new Metal("Pb", -0.13, "Chumbo");
        metais[12] = new Metal("Co", -0.28, "Cobalto");
        metais[13] = new Metal("Ag", 0.80, "Prata");

        return metais;
    }

    public static void listarMetais(Metal[] metais){
        for (int i = 0; i < metais.length; i++) {
            System.out.printf("%d - %s (%s) \n", i + 1, metais[i].getSimboloQuimico(), metais[i].getNomeMetal());
        }
    }

    public static void resposta(Metal metal1, Metal metal2){
        double potencialPilha;

        System.out.printf("Você escolheu os metais: %s (E: %.2f V) e %s (E: %.2f V)\n", metal1.getSimboloQuimico(), metal1.getPotencialReducao(), metal2.getSimboloQuimico(), metal2.getPotencialReducao());

        if (metal1.getPotencialReducao() < metal2.getPotencialReducao()) {
            System.out.printf("%s (%s) oxida: %s(s) → %s⁺(aq) + e⁻\n\n", metal1.getSimboloQuimico(), metal1.getNomeMetal(), metal1.getSimboloQuimico(), metal1.getSimboloQuimico());
            System.out.printf("%s (%s) reduz: %s⁺(aq) + e⁻ → %s(s)\n\n", metal2.getSimboloQuimico(), metal2.getNomeMetal(), metal2.getSimboloQuimico(), metal2.getSimboloQuimico());
            System.out.printf("Reação Global: %s(s) + %s⁺(aq) → %s⁺(aq) + %s(s)\n\n", metal1.getSimboloQuimico(), metal2.getSimboloQuimico(), metal1.getSimboloQuimico(), metal2.getSimboloQuimico());
            potencialPilha = -(metal1.getPotencialReducao()) + metal2.getPotencialReducao();
            System.out.printf("E da Pilha: %.2f V\n\n", potencialPilha);
        } else if (metal1.getPotencialReducao() > metal2.getPotencialReducao()) {
            System.out.printf("%s (%s) oxida: %s(s) → %s⁺(aq) + e⁻\n\n", metal2.getSimboloQuimico(), metal2.getNomeMetal(), metal2.getSimboloQuimico(), metal2.getSimboloQuimico());
            System.out.printf("%s (%s) reduz: %s⁺(aq) + e⁻ → %s(s)\n\n", metal1.getSimboloQuimico(), metal1.getNomeMetal(), metal1.getSimboloQuimico(), metal1.getSimboloQuimico());
            System.out.printf("Reação Global: %s(s) + %s⁺(aq) → %s⁺(aq) + %s(s)\n\n", metal2.getSimboloQuimico(), metal1.getSimboloQuimico(), metal2.getSimboloQuimico(), metal1.getSimboloQuimico());
            potencialPilha = -(metal2.getPotencialReducao()) + metal1.getPotencialReducao();
            System.out.printf("E° da Pilha: %.2f V\n\n", potencialPilha);
        } else {
            System.out.printf("Não ocorre oxirredução entre essas espécies.\n\n");
        }
    }

    public static void limparTerminal() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
        System.out.println("\033\143");

    }
    
    public static void main(String[] args) {
        Metal[] metais = informacoesMetais();

        while (true) {
            limparTerminal();
            System.out.printf("Escolha um dos seguintes metais: \n");
            listarMetais(metais);
            System.out.println();
            int escolha1 = tecladoScanner.nextInt() - 1;
            limparTerminal();
            System.out.printf("Agora escolha outro metal: \n");
            listarMetais(metais);
            System.out.println();
            int escolha2 = tecladoScanner.nextInt() - 1;
            limparTerminal();

            Metal metal1 = metais[escolha1];
            Metal metal2 = metais[escolha2];

            resposta(metal1, metal2);

            System.out.println("Deseja fazer outra comparação? (s/n)");
            String continuar = tecladoScanner.next().toLowerCase();
            if (!continuar.equals("s")) {
                
                try {
                    Thread.sleep(3000);
                    limparTerminal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
