public class Metal {
    private String simboloQuimico;
    private double potencialReducao;
    private String nomeMetal;
    
    public Metal(String simboloQuimico, double potencialReducao, String nomeMetal) {
        this.simboloQuimico = simboloQuimico;
        this.potencialReducao = potencialReducao;
        this.nomeMetal = nomeMetal;
    }

    public String getSimboloQuimico() {
        return simboloQuimico;
    }

    public void setSimboloQuimico(String simboloQuimico) {
        this.simboloQuimico = simboloQuimico;
    }
    
    public double getPotencialReducao() {
        return potencialReducao;
    }

    public void setPotencialReducao(double potencialReducao) {
        this.potencialReducao = potencialReducao;
    }

    public String getNomeMetal() {
        return nomeMetal;
    }
    
    public void setNomeMetal(String nomeMetal) {
        this.nomeMetal = nomeMetal;
    }

    
}
