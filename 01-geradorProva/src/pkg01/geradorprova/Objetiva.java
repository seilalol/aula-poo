package pkg01.geradorprova;

public final class Objetiva extends Questao {

    //Atributos:
    private String[] opcoes;
    private int respotaCorreta;

    //Metodos
    public String retornaQuestao() {
        String questao = "";
        questao += "*PerguntaObjetiva:" + this.getPergunta() + "\r\n";
        String op[] = this.getOpcoes();
        for (int opc = 0; opc < 5; opc++) {
            String s = "";

            if (opc == 0) {
                s = "a";
            }
            if (opc == 1) {
                s = "b";
            }
            if (opc == 2) {
                s = "c";
            }
            if (opc == 3) {
                s = "d";
            }
            if (opc == 4) {
                s = "e";
            }
            questao += "*" + s + ") " + op[opc] + "\r\n";
        }
        //questao += "*Correta:" + (this.getRespotaCorreta() + 1) + "\r\n"; Não se printa a questão correta numa prova creio eu
        questao += "*Peso:" + this.getPeso() + "\r\n";

        return questao;
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
