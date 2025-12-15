import javax.swing.JOptionPane;

public class Main {

    public static Metal[] carregarMetais() {
        return new Metal[] {
            new Metal("Li", -3.04, "Lítio", 1),
            new Metal("K", -2.93, "Potássio", 1),
            new Metal("Cr", -0.74, "Cromo", 3),
            new Metal("Ba", -2.90, "Bário", 2),
            new Metal("Ca", -2.87, "Cálcio", 2),
            new Metal("Na", -2.71, "Sódio", 1),
            new Metal("Mg", -2.37, "Magnésio", 2),
            new Metal("Zn", -0.76, "Zinco", 2),
            new Metal("Fe", -0.44, "Ferro", 2),
            new Metal("Cu", 0.34, "Cobre", 2),
            new Metal("Ni", -0.23, "Níquel", 2),
            new Metal("Pb", -0.13, "Chumbo", 2),
            new Metal("Co", -0.28, "Cobalto", 2),
            new Metal("Ag", 0.80, "Prata", 1)
        };
    }

    public static int calcularMMC(int a, int b) {
        int maior = Math.max(a, b);
        int menor = Math.min(a, b);
        for (int i = maior; ; i += maior) {
            if (i % menor == 0) return i;
        }
    }

    public static void main(String[] args) {

        Metal[] metais = carregarMetais();

        while (true) {

            String menu = "Escolha um metal:\n\n";
            for (int i = 0; i < metais.length; i++) {
                menu += (i + 1) + " - "
                     + metais[i].getSimbolo()
                     + " (" + metais[i].getNomeMetal() + ")\n";
            }

            int i1 = Integer.parseInt(
                JOptionPane.showInputDialog(menu)
            ) - 1;

            int i2 = Integer.parseInt(
                JOptionPane.showInputDialog("Escolha outro metal:\n\n" + menu)
            ) - 1;

            Metal a = metais[i1];
            Metal b = metais[i2];

            if (a == b) {
                JOptionPane.showMessageDialog(
                    null,
                    "Não é possível formar uma pilha com o mesmo metal."
                );
                continue;
            }

            Metal oxidacao;
            Metal reducao;

            if (a.getPotencialPadraoReducao() < b.getPotencialPadraoReducao()) {
                oxidacao = a;
                reducao = b;
            } else {
                oxidacao = b;
                reducao = a;
            }

            int eOx = oxidacao.getEletrons();
            int eRed = reducao.getEletrons();
            int totalEletrons = calcularMMC(eOx, eRed);

            int coefOx = totalEletrons / eOx;
            int coefRed = totalEletrons / eRed;

            String resultado = "";

            resultado += "Metais selecionados:\n";
            resultado += "- " + a.getNomeMetal()
                      + " | E° = " + a.getPotencialPadraoReducao() + " V\n";
            resultado += "- " + b.getNomeMetal()
                      + " | E° = " + b.getPotencialPadraoReducao() + " V\n\n";

            resultado += "Resultado:\n";
            resultado += "Oxidação: " + oxidacao.getNomeMetal() + "\n";
            resultado += "Redução: " + reducao.getNomeMetal() + "\n\n";

            resultado += oxidacao.getSimbolo() + "(s) → "
                      + coefOx + " " + oxidacao.getSimbolo()
                      + oxidacao.getCargaComAsterisco() + "(aq) + "
                      + totalEletrons + " e-\n";

            resultado += coefRed + " " + reducao.getSimbolo()
                      + reducao.getCargaComAsterisco() + "(aq) + "
                      + totalEletrons + " e- → "
                      + reducao.getSimbolo() + "(s)\n\n";

            resultado += "Reação global:\n\n";

            resultado += coefOx + " " + oxidacao.getSimbolo() + "(s) + "
                      + coefRed + " " + reducao.getSimbolo()
                      + reducao.getCargaComAsterisco() + "(aq) → "
                      + coefOx + " " + oxidacao.getSimbolo()
                      + oxidacao.getCargaComAsterisco() + "(aq) + "
                      + coefRed + " " + reducao.getSimbolo() + "(s)\n\n";

            double tensao = Math.abs(
                reducao.getPotencialPadraoReducao()
              - oxidacao.getPotencialPadraoReducao()
            );

            resultado += "Tensão da pilha: "
                      + String.format("%.2f", tensao) + " V";

            JOptionPane.showMessageDialog(null, resultado);

            int continuar = JOptionPane.showConfirmDialog(
                null,
                "Deseja testar outra combinação?",
                "Continuar",
                JOptionPane.YES_NO_OPTION
            );

            if (continuar != JOptionPane.YES_OPTION) {
                break;
            }
        }
    }
}
