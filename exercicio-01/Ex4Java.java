
public class Ex4Java{



	public static void main(String args[]){
		float Peso = Float.parseFloat(args[0]);
		float Altura = Float.parseFloat(args[1]);
		
		if(Peso!=0 && Altura != 0){
			System.out.println("Seu IMC é: " + (Peso/(Altura*Altura)));
		}
		else{
			System.out.println("Numero invalido.");
		}
    }
}