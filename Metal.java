public class Metal {
    String nomeMetal;
    String simbolo;
    int numOxidacao;
    String estado;

    public Metal(String nomeMetal, String simbolo, int numOxidacao, String estado) {
        this.nomeMetal = nomeMetal;
        this.simbolo = simbolo;
        this.numOxidacao = numOxidacao;
        this.estado = estado;
    }

    public String getNomeMetal() {
        return nomeMetal;
    }

    public void setNomeMetal(String nomeMetal) {
        this.nomeMetal = nomeMetal;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public int getNumOxidacao() {
        return numOxidacao;
    }

    public void setNumOxidacao(int numOxidacao) {
        this.numOxidacao = numOxidacao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}