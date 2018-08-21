
public class Ex7Java{
	public static void main(String args[]){
		int i = 0;
        float[] numero= new float[3];
        float soma=0;
        String nome = null;
        while(i<3){
        if(i==0){
            nome =JOptionPane.showInputDialog("Qual seu nome?");
        }
        String numeroString = JOptionPane.showInputDialog("(M"+(i+1)+"/M3)"+"-Informe a nota: ");
        numero[i] = Float.parseFloat(numeroString);
        soma=soma+numero[i];
        i++;
        }
        String Situacao = null;
        if((soma/3)>=5.75){
            Situacao = "Aprovado.";
        }else{
            Situacao = "Reprovado.";
        }
        JOptionPane.showMessageDialog(null, "Nome do aluno: " + nome + "\nMédia: " + (soma/3) + "\nSituacao: " + Situacao);
    }
}