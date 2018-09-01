package pkg01.geradorprova;

public class Prova {

    //Atributos:
    private String nomeDisciplina;
    private int peso;
    private String local;
    private String data;
    private Objetiva[] obj; 
    private Discursiva[] Dir; 

    public Objetiva[] getObj() {
        return obj;
    }

    public void setObj(Objetiva[] obj) {
        this.obj = obj;
    }

    public Discursiva[] getDir() {
        return Dir;
    }

    public void setDir(Discursiva[] Dir) {
        this.Dir = Dir;
    }

    //Construtores:
    public Prova() {}

    //Metodos:
    public String obtemDetalhes() {

        String detalhes = "";
        detalhes += "Disciplina: " + this.getNomeDisciplina() + "\n";
        detalhes += "Data: " + this.getData() + "\n";
        detalhes += "Local: " + this.getLocal() + "\n";
        detalhes += "Peso: " + this.getPeso() + "\n";

        return detalhes;
    }

    //Getters e Setters:
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDiscplina) {
        this.nomeDisciplina = nomeDiscplina;
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
