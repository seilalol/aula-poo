package pkg01.geradorprova;

import java.util.ArrayList;

public class Prova {

    //Atributos:
    private String nomeDisciplina;
    private int peso;
    private String local;
    private String data;
    private ArrayList<Objetiva> obj;
    private ArrayList<Discursiva> dir;

    //Construtores:
    public Prova() {
    }

    //Metodos:
    public String obtemDetalhes() {

        String detalhes = "******************\n";
        detalhes += "*Disciplina: " + this.getNomeDisciplina() + "\n";
        detalhes += "*Data: " + this.getData() + "\n";
        detalhes += "*Local: " + this.getLocal() + "\n";
        detalhes += "*Peso: " + this.getPeso() + "\n";
        detalhes += "******************\n";

        return detalhes;
    }

    public String provaObtemImpressao() {
        String detalhes = this.obtemDetalhes();
        detalhes += "******************\n";

        int cont = 0;
        if (this.dir.size() == 0) {
            detalhes += "Sem questões discursivas.\n";
        }
        while (cont < this.dir.size()) {
            detalhes += "*"+(cont+1)+")" + this.dir.get(cont).retornaQuestao();
            cont++;
        }
        detalhes += "******************\n";
        cont = 0;
        if (this.obj.size() == 0) {
            detalhes += "Sem questões objetivas.\n";
        }
        while (cont < this.obj.size()) {
            detalhes += "*"+(cont+1)+")" + this.obj.get(cont).retornaQuestao();
            cont++;
        }

        detalhes += "******************\n";

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

    public ArrayList<Objetiva> getObj() {
        return obj;
    }

    public ArrayList<Discursiva> getDir() {
        return dir;
    }

    public void setObj(ArrayList<Objetiva> obj) {
        this.obj = obj;
    }

    public void setDir(ArrayList<Discursiva> dir) {
        this.dir = dir;
    }
}
