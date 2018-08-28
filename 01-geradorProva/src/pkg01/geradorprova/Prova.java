package pkg01.geradorprova;

public class Prova {

    //Atributos:
    private String nomeDiscplina;
    private int peso;
    private String local;
    private String data;

    //Construtores:
    public Prova(String nomeDisciplina) {
        this.setNomeDiscplina(nomeDisciplina);
        this.setPeso(10);
    }

    //Metodos:
    public String obtemDetalhes() {

        String detalhes = "";
        detalhes += "Disciplina: " + this.getNomeDiscplina() + "\n";
        detalhes += "Data: " + this.getData() + "\n";
        detalhes += "Local: " + this.getLocal() + "\n";
        detalhes += "Peso: " + this.getPeso() + "\n";

        return detalhes;
    }

    //Getters e Setters:
    public String getNomeDiscplina() {
        return nomeDiscplina;
    }

    public void setNomeDiscplina(String nomeDiscplina) {
        this.nomeDiscplina = nomeDiscplina;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
