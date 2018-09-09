package pkg01.geradorprova;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GeradorProva {

    public static void main(String[] args) {
        //Variaveis
        Scanner scan = new Scanner(System.in);
        String local = null, disciplina = null, data = null;
        int peso = 0;
        Boolean certo;
        Prova prova1 = new Prova();
        int continuar = 0;
        ArrayList<Discursiva> discursivas = new ArrayList<Discursiva>();
        ArrayList<Objetiva> objetivas = new ArrayList<Objetiva>();
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
        do {
            certo = false;
            while (!certo) {
                try {
                    System.out.println("Desesja adicionar questao objetiva(1) ou discursiva(2): \nSair(3)");
                    continuar = scan.nextInt();
                    scan.nextLine();
                } catch (Exception e) {
                }
                if (continuar == 1 || continuar == 2 || continuar == 3) {
                    certo = true;
                } else {
                    System.out.println("Digite um numero valido.");
                }

            }
            if (continuar == 2) {
                //Segunda parte pedindo suas perguntas, criterios e pesos.

                String pergunta = null, criterios = null;
                double pesoD = 0;

                certo = false;
                while (!certo) {
                    System.out.println("Digite a pergunta discursiva:");
                    pergunta = scan.nextLine();
                    if ("".equals(pergunta)) {
                        System.out.println("Pergunta em branco");
                    } else {
                        certo = true;
                    }
                }
                certo = false;
                while (!certo) {
                    System.out.println("Digite o criterio de correcao:");
                    criterios = scan.nextLine();
                    if ("".equals(criterios)) {
                        System.out.println("Criterio em branco");
                    } else {
                        certo = true;
                    }
                }
                while (pesoD <= 0) {
                    System.out.println("Digite o peso desta questão:");
                    try {
                        pesoD = scan.nextDouble();
                        scan.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Digite um valor aceitavel(apenas numeros no formato double, sem ser letras).");
                        scan.nextLine();
                    }
                }

                Discursiva dis = new Discursiva();
                dis.setCriteriosCorrecao(criterios);
                dis.setPergunta(pergunta);
                dis.setPeso(pesoD);
                discursivas.add(dis);

                //Fim da segunda parte.
            }
            //Terceira parte suas perguntas, opcoes, opcao correta e pesos.
            if (continuar == 1) {

                Objetiva obj = new Objetiva();

                String pergunta = null;
                String[] opcoes = new String[5];
                double pesoO = 0;
                int opCerta = -1;

                certo = false;
                while (!certo) {
                    System.out.println("Digite a pergunta objetiva:");
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
                        System.out.println("Digite a opcao(" + (cont1 + 1) + "/5) da pergunta:");
                        opcoes[cont1] = scan.nextLine();
                        if ("".equals(opcoes[cont1])) {
                            System.out.println("Opcao em branco");
                        } else {
                            certo = true;
                        }
                    }
                }
                while (opCerta < 0 || opCerta > 5) {
                    System.out.println("Digite qual a alternativa correta da questao:");
                    try {
                        opCerta = scan.nextInt() - 1;
                        scan.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Digite um valor aceitavel(apenas numeros no formato inteiro de 1 ate 5, sem ser letras).");
                        scan.nextLine();
                    }
                }
                while (pesoO <= 0) {
                    System.out.println("Digite o peso desta questão:");
                    try {
                        pesoO = scan.nextDouble();
                        scan.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Digite um valor aceitavel(apenas numeros no formato double, sem ser letras).");
                        scan.nextLine();
                    }
                }

                obj.setPergunta(pergunta);
                obj.setOpcoes(opcoes);
                obj.setRespotaCorreta(opCerta);
                obj.setPeso(pesoO);
                objetivas.add(obj);
                //Fim da terceira parte.
            }
        } while (continuar == 1 || continuar == 2);

        prova1.setDir(discursivas);
        prova1.setObj(objetivas);
        Path caminho = Paths.get("Provas.txt");
        byte[] provaEmBytes = prova1.provaObtemImpressao().getBytes();
        try {
            Files.write(caminho,provaEmBytes);
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(null, "Erro ao salvar.");
        }
        
        System.out.println("" + prova1.provaObtemImpressao());

    }

}
