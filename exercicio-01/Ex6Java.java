
public class Ex6Java{
	public static void main(String args[]){
	int i = 0;
        float[] numero= new float[10];
        float soma=0;
        float maior=0,menor=0;
        while(i<10){
        String numeroString = JOptionPane.showInputDialog("("+(i+1)+"/10)"+"-Informe um numero: ");
        numero[i] = Float.parseFloat(numeroString);
        soma=soma+numero[i];
        if(numero[i]>maior){
            maior=numero[i];
        }if(numero[i]<menor){
            menor=numero[i];
        }
        i++;
        }
        JOptionPane.showMessageDialog(null, "Soma de todos os numeros = " + soma);
        JOptionPane.showMessageDialog(null, "Media = " + soma/10);
        JOptionPane.showMessageDialog(null, "Maior = " + maior);
        JOptionPane.showMessageDialog(null, "Menor = " + menor);
    }
}