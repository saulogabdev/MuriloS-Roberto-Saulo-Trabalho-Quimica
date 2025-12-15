public class Metal {

    private String simbolo;
    private double potencialPadraoReducao;
    private String nomeMetal;
    private int eletrons;
    private int carga;

    public Metal(String simbolo, double potencialPadraoReducao, String nomeMetal, int carga) {
        this.simbolo = simbolo;
        this.potencialPadraoReducao = potencialPadraoReducao;
        this.nomeMetal = nomeMetal;
        this.carga = carga;
        this.eletrons = carga;
    }

    public String getCargaComAsterisco() {
        if (carga == 1) {
            return "*";
        }
        return "*" + carga;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getEletrons() {
        return eletrons;
    }

    public void setEletrons(int eletrons) {
        this.eletrons = eletrons;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public double getPotencialPadraoReducao() {
        return potencialPadraoReducao;
    }

    public void setPotencialPadraoReducao(double potencialPadraoReducao) {
        this.potencialPadraoReducao = potencialPadraoReducao;
    }

    public String getNomeMetal() {
        return nomeMetal;
    }

    public void setNomeMetal(String nomeMetal) {
        this.nomeMetal = nomeMetal;
    }
}
