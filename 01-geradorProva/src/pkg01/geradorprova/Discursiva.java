package pkg01.geradorprova;

public final class Discursiva extends Questao {

    //Atributos:
    private String criteriosCorrecao;

    //Metodos
    public String retornaQuestao() {
        String questao = "";

        questao += "*PerguntaDiscursiva:" + this.getPergunta() + "\r\n";
        questao += "*_______________________________________" + "\r\n";
        questao += "*_______________________________________" + "\r\n";
        questao += "*_______________________________________" + "\r\n";
        questao += "*Criterio:" + this.getCriteriosCorrecao() + "\r\n";
        questao += "*Peso:" + this.getPeso() + "\r\n";

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
