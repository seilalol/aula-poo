package pkg01.geradorprova;

public final class Objetiva extends Questao {

    //Atributos:
    private String[] opcoes;
    private int respotaCorreta;

    //Construtores:
    public Objetiva() {
        this.opcoes = new String[5];
    }

    //Getters e Setters:
    public String[] getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(String[] opcoes) {
        this.opcoes = opcoes;
    }

    public int getRespotaCorreta() {
        return respotaCorreta;
    }

    public void setRespotaCorreta(int respotaCorreta) {
        this.respotaCorreta = respotaCorreta;
    }

}
