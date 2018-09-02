package pkg01.geradorprova;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GeradorProva {

    public static void main(String[] args) {
        //Variaveis
        Scanner scan = new Scanner(System.in);
        String local = null, disciplina = null, data = null;
        int peso = 0;
        Boolean certo;
        Prova prova1 = new Prova();
        //

        //Primeira parte do programa pedindo Disciplina, Local, Data e peso da prova.
        certo = false;
        while (!certo) {
            System.out.println("Digite o nome da Disciplina: ");
            disciplina = scan.nextLine();
            if ("".equals(disciplina)) {
                System.out.println("Disciplina em branco");
            } else {
                certo = true;
            }
        }
        certo = false;
        while (!certo) {
            System.out.println("Digite o local da prova: ");
            local = scan.nextLine();
            if ("".equals(local)) {
                System.out.println("Local em branco");
            } else {
                certo = true;
            }
        }
        certo = false;
        while (!certo) {
            System.out.println("Digite a data da prova: ");
            data = scan.nextLine();
            if ("".equals(data)) {
                System.out.println("Data em branco");
            } else {
                certo = true;
            }
        }
        while (peso <= 0) {
            try {
                System.out.println("Digite o peso da prova: ");
                peso = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Digite um valor aceitavel(apenas inteiros, sem ser letras).");
                scan.nextLine();
            }
        }

        prova1.setData(data);
        prova1.setLocal(local);
        prova1.setNomeDisciplina(disciplina);
        prova1.setPeso(peso);
        //Fim da primeira parte.

        //Segunda parte pedindo quantidade de questões discursivas, suas perguntas, criterios e pesos.
        int qtdDis = 0;

        while (qtdDis <= 0) {
            System.out.println("Digite a quantidade de questoes discursivas: ");
            try {
                qtdDis = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Digite um valor aceitavel(apenas inteiros, sem ser letras).");
                scan.nextLine();
            }
        }
        Discursiva QuestoesDis[] = new Discursiva[qtdDis];//Cria um vetor de questoes discursivas

        for (int cont = 0; cont < qtdDis; cont++) {
            QuestoesDis[cont] = new Discursiva(); //Constroi o vetor
            String pergunta = null, criterios = null;
            double pesoD = 0;

            certo = false;
            while (!certo) {
                System.out.println("Digite a pergunta discursiva(" + (cont + 1) + "):");
                pergunta = scan.nextLine();
                if ("".equals(pergunta)) {
                    System.out.println("Pergunta em branco");
                } else {
                    certo = true;
                }
            }
            certo = false;
            while (!certo) {
                System.out.println("Digite o criterio de correcao(" + (cont + 1) + "):");
                criterios = scan.nextLine();
                if ("".equals(criterios)) {
                    System.out.println("Criterio em branco");
                } else {
                    certo = true;
                }
            }
            while (pesoD <= 0) {
                System.out.println("Digite o peso desta questão(" + (cont + 1) + "):");
                try {
                    pesoD = scan.nextDouble();
                    scan.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Digite um valor aceitavel(apenas numeros no formato double, sem ser letras).");
                    scan.nextLine();
                }
            }

            QuestoesDis[cont].setCriteriosCorrecao(criterios);
            QuestoesDis[cont].setPergunta(pergunta);
            QuestoesDis[cont].setPeso(pesoD);

        }//Fim da segunda parte.

        prova1.setDir(QuestoesDis);

        //Terceira parte pedindo quantidade de questões objetivas, suas perguntas, opcoes, opcao correta e pesos.
        int qtdObj = 0;

        while (qtdObj <= 0) {
            System.out.println("Digite a quantidade de questoes objetivas: ");
            try {
                qtdObj = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Digite um valor aceitavel(apenas inteiros, sem ser letras).");
                scan.nextLine();
            }
        }
        Objetiva QuestoesObj[] = new Objetiva[qtdObj];//Cria um vetor de questoes discursivas

        for (int cont = 0; cont < qtdDis; cont++) {
            QuestoesObj[cont] = new Objetiva(); //Constroi o vetor
            String pergunta = null;
            String[] opcoes = new String[5];
            double pesoO = 0;
            int opCerta = 0;

            certo = false;
            while (!certo) {
                System.out.println("Digite a pergunta objetiva(" + (cont + 1) + "):");
                pergunta = scan.nextLine();
                if ("".equals(pergunta)) {
                    System.out.println("Pergunta em branco");
                } else {
                    certo = true;
                }
            }
            for (int cont1 = 0; cont1 < 5; cont1++) {
                certo = false;
                while (!certo) {
                    System.out.println("Digite a opcao(" + (cont1 + 1) + "/5) da pergunta(" + (cont + 1) + "):");
                    opcoes[cont1] = scan.nextLine();
                    if ("".equals(opcoes[cont1])) {
                        System.out.println("Opcao em branco");
                    } else {
                        certo = true;
                    }
                }
            }
            while (opCerta <= 0 || opCerta > 5) {
                System.out.println("Digite qual a alternativa correta da questao(" + (cont + 1) + "):");
                try {
                    opCerta = scan.nextInt() - 1;
                    scan.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Digite um valor aceitavel(apenas numeros no formato inteiro de 1 ate 5, sem ser letras).");
                    scan.nextLine();
                }
            }
            while (pesoO <= 0) {
                System.out.println("Digite o peso desta questão(" + (cont + 1) + "):");
                try {
                    pesoO = scan.nextDouble();
                    scan.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Digite um valor aceitavel(apenas numeros no formato double, sem ser letras).");
                    scan.nextLine();
                }
            }

            for (int op = 0; op < 5; op++) {
                System.out.println("Teste" + opcoes[op]);
            }

            QuestoesObj[cont].setPergunta(pergunta);
            QuestoesObj[cont].setOpcoes(opcoes);
            QuestoesObj[cont].setRespotaCorreta(opCerta);
            QuestoesObj[cont].setPeso(pesoO);

        }//Fim da terceira parte.

        prova1.setObj(QuestoesObj);

        System.out.println("" + prova1.obtemDetalhes());

    }

}
