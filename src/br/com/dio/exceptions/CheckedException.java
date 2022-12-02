package br.com.dio.exceptions;

import javax.swing.*;
import java.io.*;

//Imprimir um arquivo no console.
public class CheckedException {//
    public static void main(String[] args) {//throws IOException, deveria ter posto antes, mas pra fazer diferente agora devo tirar, vamos tratar aqui dentro com try catch
        String nomeDoArquivo = "romance-blake-crouch.txt";

        try {//botando o cursor em cimma do imprimir gera o try catch
            imprimirArquivoNoConsole(nomeDoArquivo);//botar o cursor em cima do método e gerar o exception. se botarmos o nome errado da erro do read file
        } catch (FileNotFoundException e) { // tenho que por esse primeiro, pq se eu colocasse o IO Excep é o mais abrangente e n cairia no específico
            JOptionPane.showMessageDialog(null, //para mostrar tela pro usuário
                    "Revise o nome do arquivo que você deseja imprimir! " + e.getCause());
            e.printStackTrace();
        } catch (IOException e){ // preciso gerar os dois pra ser eficiente
            e.printStackTrace();// vai mostrar aonde foi o erro inesperado
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro inesperado! Entre em contato com o suporte! " + e.getCause());// pra n ter que especificar aonde aconteceu o erro
        } finally {
            System.out.println("Chegou no finally!");
        }

        System.out.println("Apesar da exception ou não, o programa continua...");
    }

    public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException { // poderia ter feito o try cath por aqui
        File file = new File(nomeDoArquivo); //inicializou um obj do tipo file

        BufferedReader br = new BufferedReader(new FileReader(file.getName()));//pra criar um buff com td o doc q quero imprimir. Só consigo rodar o file reader se eu tratar essa exception, por isso é uma checked exception, para gerar botar o cursor em cima do método e add
        String line = br.readLine();//lê linha por linha // aqui tbm lança exception. Tanto esse como os abaixo lançam o msm tipo de Exception, clico em cima e troco e dá certo pro reader pq essa nova gerada é mãe daquele

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // para imprimir no console

        do{ //cria laço pra ler cada linha e imprimir no console
            bw.write(line); // aqui tbm
            bw.newLine();// aqui tbm
            line=br.readLine();
        } while(line != null);
        bw.flush();//como ta armazenado num buffer vou pedir pra descarregar através do método flush. aqui tbm lança exception
        br.close();// aqui tbm. se tento rodar sem fazer os exceptions ele indica
    }
}
