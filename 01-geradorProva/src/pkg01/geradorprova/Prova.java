package pkg01.geradorprova;

public class Prova {

    //Atributos:
    private String nomeDisciplina;
    private int peso;
    private String local;
    private String data;
    private Objetiva[] obj; 
    private Discursiva[] dir; 

    //Construtores:
    public Prova() {}

    //Metodos:
    public String obtemDetalhes() {

        String detalhes = "******************\n";
        detalhes += "*Disciplina: " + this.getNomeDisciplina() + "\n";
        detalhes += "*Data: " + this.getData() + "\n";
        detalhes += "*Local: " + this.getLocal() + "\n";
        detalhes += "*Peso: " + this.getPeso() + "\n";
        int cont = 0;
        while(cont<this.dir.length){
            detalhes += "*PerguntaDisc:(" + (cont+1) +"):" + this.dir[cont].getPergunta() + "\n";
            detalhes += "*Criterio(" + (cont+1) +"):" + this.dir[cont].getCriteriosCorrecao() + "\n";
            detalhes += "*Peso(" + (cont+1) +"):" + this.dir[cont].getPeso() + "\n";
            cont++;
        }
        cont = 0;
         while(cont<this.obj.length){
            detalhes += "*PerguntaObj(" + (cont+1) +"):" + this.obj[cont].getPergunta() + "\n";
            String op[] = this.obj[cont].getOpcoes();
            for(int opc=0;opc<5;opc++){
               detalhes+= "*Opcao (" + (opc+1) + ") da questao(" + (cont+1) + ");" + op[opc] + "\n";
           }            
            detalhes += "*Correta(" + (cont+1) +")" + (this.obj[cont].getRespotaCorreta()+1) + "\n";
            detalhes += "*Peso(" + (cont+1) +"):" + this.obj[cont].getPeso() + "\n";
            cont++;
        }

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

    public Objetiva[] getObj() {
        return obj;
    }

    public void setObj(Objetiva[] obj) {
        this.obj = obj;
    }

    public Discursiva[] getDir() {
        return dir;
    }

    public void setDir(Discursiva[] Dir) {
        this.dir = Dir;
    }
    
    
}
