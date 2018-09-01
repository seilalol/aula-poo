package pkg01.geradorprova;

import javax.swing.JOptionPane;

public class GeradorProva {

    public static void main(String[] args) {
        Prova p1 = new Prova();
        int prossegue = 0;
        String peso = null;
        String Disciplina = null;
        String Local = null;
        String data = null;
        String nquestoesd = null;
        String perguntad = null, perguntao = null;
        String pesod = null, pesoo = null;
        String criteriosd = null;
        Boolean certo;


            JOptionPane.showMessageDialog(null, "Gerador de provas 0.01****"
                    + "\nPreencha as informacoes solicitadas a seguir:");

            certo = false;
            while (!certo) {
                Disciplina = JOptionPane.showInputDialog("****Disciplina:****");
                if (Disciplina == null || "".equals(Disciplina)) {
                    certo = false;
                    JOptionPane.showMessageDialog(null, "Disciplina em branco.");
                } else {
                    certo = true;
                }
            }

            certo = false;
            while (!certo) {//Disciplina, local, data, peso
                Local = JOptionPane.showInputDialog("****Local:****");
                if (Local == null || "".equals(Local)) {
                    certo = false;
                    JOptionPane.showMessageDialog(null, "Local em branco.");
                } else {
                    certo = true;
                }
            }

            certo = false;
            while (!certo) {
                data = JOptionPane.showInputDialog("****Data:****");
                if (data == null || "".equals(data)) {
                    certo = false;
                    JOptionPane.showMessageDialog(null, "Data em branco.");
                } else {
                    certo = true;
                }
            }
            certo = false;
            while (!certo) {
                peso = JOptionPane.showInputDialog("****Peso(1 a 10):****");
                for (int cont = 1; cont <= 10; cont++) {
                    if ((cont + "").equals(peso)) {
                        certo = true;
                        cont = 11;
                    } else {
                        certo = false;
                    }
                }
                if (!certo) {
                    JOptionPane.showMessageDialog(null, "Numero impossivel");
                }
            }//Disciplina, local, data, peso
            certo = false;
            while (!certo) {//Questoes discursivas
                nquestoesd = JOptionPane.showInputDialog("****Numero de questoes discursivas(1 a 10):****");
                for (int cont = 1; cont <= 10; cont++) {
                    if ((cont + "").equals(nquestoesd)) {
                        certo = true;
                        cont = 11;
                    } else {
                        certo = false;
                    }
                }
                if (!certo) {
                    JOptionPane.showMessageDialog(null, "Numero impossivel");
                }
            }
            int nquestoes;
            nquestoes = Integer.parseInt(nquestoesd);
            Discursiva[] disc = new Discursiva[nquestoes];
            for (int cont = 0; cont < nquestoes; cont++) {
                certo = false;
                while (!certo) {
                    perguntad = JOptionPane.showInputDialog("****Pergunta Discursiva(" + (cont + 1) + "):****");
                    if (perguntad == null || "".equals(perguntad)) {
                        certo = false;
                        JOptionPane.showMessageDialog(null, "Pergunta em branco.");
                    } else {
                        certo = true;
                    }
                }
                certo = false;
                while (!certo) {
                    criteriosd = JOptionPane.showInputDialog("****Criterios da pergunta discursiva(" + (cont + 1) + "):****");
                    if (criteriosd == null || "".equals(criteriosd)) {
                        certo = false;
                        JOptionPane.showMessageDialog(null, "Criterio em branco.");
                    } else {
                        certo = true;
                    }
                }
                certo = false;
                while (!certo) {
                    pesod = JOptionPane.showInputDialog("****Peso da pergunta discursiva(" + (cont + 1) + "):****");
                    for (int cont1 = 1; cont1 <= 10; cont1++) {
                        if ((cont1 + "").equals(pesod)) {
                            certo = true;
                            cont1 = 11;
                        } else {
                            certo = false;
                        }
                    }
                    if (!certo) {
                        JOptionPane.showMessageDialog(null, "Numero impossivel");
                    }
                }
                double pesodi = Double.parseDouble(pesod);
            }//Questoes discursivas

            certo = false;
            while (!certo) {//Questoes objetiva
                nquestoesd = JOptionPane.showInputDialog("****Numero de questoes objetivas(1 a 10):****");
                for (int cont = 1; cont <= 10; cont++) {
                    if ((cont + "").equals(nquestoesd)) {
                        certo = true;
                        cont = 11;
                    } else {
                        certo = false;
                    }
                }
                if (!certo) {
                    JOptionPane.showMessageDialog(null, "Numero impossivel");
                }
            }
            int nquestoeso = Integer.parseInt(nquestoesd);
            Objetiva[] Obj = new Objetiva[nquestoeso];

            for (int cont = 0; cont < nquestoes; cont++) {
                certo = false;
                while (!certo) {
                    perguntao = JOptionPane.showInputDialog("****Pergunta objetiva(" + (cont + 1) + "):****");
                    if (perguntao == null || "".equals(perguntao)) {
                        certo = false;
                        JOptionPane.showMessageDialog(null, "Pergunta em branco.");
                    } else {
                        certo = true;
                    }
                }
                certo = false;
                while (!certo) {
                    pesoo = JOptionPane.showInputDialog("****Peso da pergunta objetiva(" + (cont + 1) + "):****");
                    for (int cont1 = 1; cont1 <= 10; cont1++) {
                        if ((cont1 + "").equals(pesoo)) {
                            certo = true;
                            cont1 = 11;
                        } else {
                            certo = false;
                        }
                    }
                    if (!certo) {
                        JOptionPane.showMessageDialog(null, "Numero impossivel");
                    }
                }
                    double pesoob = Double.parseDouble(pesoo);
                    
                    }//Questoes objetiva
           

    }

}
