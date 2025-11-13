import java.util.Scanner;

public class OxidacaoReducao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Metal zn = new Metal("Zinco", "Zn", 0, "s");
        Metal cu = new Metal("Cobre", "Cu", 0, "s");
        Metal zn2 = new Metal("Zinco", "Zn2+", 2, "aq");
        Metal cu2 = new Metal("Cobre", "Cu2+", 2, "aq");

        Metal[] opcoes = {zn, cu, zn2, cu2};

        System.out.println("Escolha duas espécies:");
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println((i + 1) + " - " + opcoes[i].getSimbolo());
        }

        System.out.print("Escolha a primeira: ");
        int escolha1 = sc.nextInt();
        System.out.print("Escolha a segunda: ");
        int escolha2 = sc.nextInt();

        Metal m1 = opcoes[escolha1 - 1];
        Metal m2 = opcoes[escolha2 - 1];

        System.out.println("\nVocê escolheu: " + m1.getSimbolo() + "(" + m1.getEstado() + ") e " +
                           m2.getSimbolo() + "(" + m2.getEstado() + ")");

        if (m1.getNumOxidacao() == 0 && m2.getNumOxidacao() == 2 && !m1.getNomeMetal().equals(m2.getNomeMetal())) {
            System.out.println(m1.getSimbolo() + "(" + m1.getEstado() + ") oxida e " +
                               m2.getSimbolo() + "(" + m2.getEstado() + ") reduz.");
        } else if (m1.getNumOxidacao() == 2 && m2.getNumOxidacao() == 0 && !m1.getNomeMetal().equals(m2.getNomeMetal())) {
            System.out.println(m2.getSimbolo() + "(" + m2.getEstado() + ") oxida e " +
                               m1.getSimbolo() + "(" + m1.getEstado() + ") reduz.");
        } else {
            System.out.println("Não ocorre reação de oxirredução entre essas espécies.");
        }

        sc.close();
    }
}