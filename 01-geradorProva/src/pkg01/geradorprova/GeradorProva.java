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
        String local = null, disciplina = null, data = null, tipoQuestao = null, continuar = "s", temporario;
        int peso = 0;
        Boolean certo;
        Prova prova1 = new Prova();
        ArrayList<Discursiva> discursivas = new ArrayList<Discursiva>();
        ArrayList<Objetiva> objetivas = new ArrayList<Objetiva>();
        //

        //Primeira parte do programa pedindo Disciplina, Local, Data e peso da prova.
        certo = false;
        while (!certo) {
            disciplina = JOptionPane.showInputDialog("Digite o nome da Disciplina: ");
            if ("".equals(disciplina) || disciplina == null) {
                JOptionPane.showMessageDialog(null, "Disciplina em branco");
            } else {
                certo = true;
            }
        }
        certo = false;
        while (!certo) {
            local = JOptionPane.showInputDialog("Digite o local da prova: ");
            if ("".equals(local) || local == null) {
                JOptionPane.showMessageDialog(null, "Local em branco");
            } else {
                certo = true;
            }
        }
        certo = false;
        while (!certo) {
            data = JOptionPane.showInputDialog("Digite a data da prova: ");
            if ("".equals(data) || data == null) {
                JOptionPane.showMessageDialog(null, "Data em branco");
            } else {
                certo = true;
            }
        }
        while (peso <= 0) {
            try {
                temporario = JOptionPane.showInputDialog("Digite o peso da prova: ");
                peso = Integer.parseInt(temporario);
            } catch (Exception e) {
                peso = 0;
            }
            if (peso <= 0) {
                JOptionPane.showMessageDialog(null, "Digite um valor aceitavel(apenas inteiros, sem ser letras).");
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
                tipoQuestao = JOptionPane.showInputDialog("Deseja adicionar questao objetiva(O) ou discursiva(D):");
                if ("O".equals(tipoQuestao) || "D".equals(tipoQuestao) || "o".equals(tipoQuestao) || "d".equals(tipoQuestao)) {
                    certo = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Digite um caracter valido.");
                }

            }
            if ("D".equals(tipoQuestao) || "d".equals(tipoQuestao)) {
                //Segunda parte pedindo suas perguntas, criterios e pesos.

                String pergunta = null, criterios = null;
                double pesoD = 0;

                certo = false;
                while (!certo) {
                    pergunta = JOptionPane.showInputDialog("Digite a pergunta discursiva:");
                    if ("".equals(pergunta) || pergunta == null) {
                        JOptionPane.showMessageDialog(null, "Pergunta em branco");
                    } else {
                        certo = true;
                    }
                }
                certo = false;
                while (!certo) {
                    criterios = JOptionPane.showInputDialog("Digite o criterio de correcao:");
                    if ("".equals(criterios) || criterios == null) {
                        JOptionPane.showMessageDialog(null, "Criterio em branco");
                    } else {
                        certo = true;
                    }
                }
                while (pesoD <= 0) {
                    temporario = JOptionPane.showInputDialog("Digite o peso desta questão:");
                    try {
                        pesoD = Double.parseDouble(temporario);
                    } catch (Exception e) {
                        pesoD = 0;
                    }
                    if (pesoD <= 0) {
                        JOptionPane.showMessageDialog(null, "Digite um valor aceitavel(apenas numeros no formato double, sem ser letras).");
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
            if ("O".equals(tipoQuestao) || "o".equals(tipoQuestao)) {

                Objetiva obj = new Objetiva();

                String pergunta = null;
                String[] opcoes = new String[5];
                double pesoO = 0;
                int opCerta = -1;

                certo = false;
                while (!certo) {
                    pergunta = JOptionPane.showInputDialog("Digite a pergunta objetiva:");
                    if ("".equals(pergunta) || pergunta == null) {
                        JOptionPane.showMessageDialog(null, "Pergunta em branco");
                    } else {
                        certo = true;
                    }
                }
                for (int cont1 = 0; cont1 < 5; cont1++) {
                    certo = false;
                    while (!certo) {
                        opcoes[cont1] = JOptionPane.showInputDialog("Digite a opcao(" + (cont1 + 1) + "/5) da pergunta:");
                        if ("".equals(opcoes[cont1]) || opcoes[cont1] == null) {
                            JOptionPane.showMessageDialog(null, "Opcao em branco");
                        } else {
                            certo = true;
                        }
                    }
                }
                while (opCerta < 1 || opCerta > 5) {
                    temporario = JOptionPane.showInputDialog("Digite qual a alternativa correta da questao:");
                    try {
                        opCerta = Integer.parseInt(temporario);
                    } catch (Exception e) {
                        opCerta = 0;
                    }
                    if (opCerta < 1 || opCerta > 5) {
                        JOptionPane.showMessageDialog(null, "Digite um valor aceitavel(apenas numeros no formato inteiro de 1 ate 5, sem ser letras).");
                    }
                }
                while (pesoO <= 0) {
                    temporario = JOptionPane.showInputDialog("Digite o peso desta questão:");
                    try {
                        pesoO = Double.parseDouble(temporario);
                    } catch (Exception e) {
                        pesoO = 0;
                    }
                    if (pesoO <= 0) {
                        JOptionPane.showMessageDialog(null, "Digite um valor aceitavel(apenas numeros no formato double, sem ser letras).");
                    }
                }

                obj.setPergunta(pergunta);
                obj.setOpcoes(opcoes);
                obj.setRespotaCorreta(opCerta - 1);
                obj.setPeso(pesoO);
                objetivas.add(obj);
                //Fim da terceira parte.

            }
            certo = false;
            while (!certo) {
                continuar = JOptionPane.showInputDialog("Deseja continuar(S/N):");
                if ("S".equals(continuar) || "s".equals(continuar) || "N".equals(continuar) || "n".equals(continuar)) {
                    certo = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Digite um caracter valido.");
                }

            }
        } while ("s".equals(continuar) || "S".equals(continuar));
        certo = false;//Pede o nome do arquivo e garente que o usuario não tente criar um arquivo em branco.
        String arquivo = null;
        while (!certo) {
            arquivo = JOptionPane.showInputDialog("Digite o nome do arquivo(Em branco não é permitido):") + ".txt";
            if (".txt".equals(arquivo) || "null.txt".equals(arquivo)) {
                certo = false;
                JOptionPane.showMessageDialog(null, "Digite um nome valido.");
            } else {
                certo = true;
            }
        }

        prova1.setDir(discursivas);
        prova1.setObj(objetivas);
        Path caminho = Paths.get(arquivo);
        byte[] provaEmBytes = prova1.provaObtemImpressao().getBytes();
        try {
            Files.write(caminho, provaEmBytes);
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(null, "Erro ao salvar.");
        }

        System.out.println("" + prova1.provaObtemImpressao());

    }

}
