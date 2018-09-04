package pkg01.geradorprova;

public final class Discursiva extends Questao {

    //Atributos:
    private String criteriosCorrecao;

    //Metodos
    public String retornaQuestao() {
        String questao = "";

        questao += "*PerguntaDisc:" + this.getPergunta() + "\n";
        questao += "*_______________________________________" + "\n";
        questao += "*_______________________________________" + "\n";
        questao += "*_______________________________________" + "\n";
        questao += "*Criterio:" + this.getCriteriosCorrecao() + "\n";
        questao += "*Peso:" + this.getPeso() + "\n";

        return questao;
    }

    //Getters e Setters:
    public String getCriteriosCorrecao() {
        return criteriosCorrecao;
    }

    public void setCriteriosCorrecao(String criteriosCorrecao) {
        this.criteriosCorrecao = criteriosCorrecao;
    }

}
