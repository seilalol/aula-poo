public class Ex5Java{
	public static void main(String args[]){
		float n1 = Float.parseFloat(args[0]);
		float n2 = Float.parseFloat(args[1]);
		
		if(n1>=0 && n2 > 0){
			System.out.println("Seu salario é: " + ((n1/22)*n2) + " reais.");
		}
		else{
			System.out.println("Numero invalido.");
		}
    }
}