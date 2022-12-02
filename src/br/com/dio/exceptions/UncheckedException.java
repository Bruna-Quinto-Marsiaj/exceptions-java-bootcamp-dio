package br.com.dio.exceptions;

import javax.swing.*;

//Fazer a divisão de 2 valores inteiros
public class UncheckedException {
    public static void main(String[] args) {

        boolean continueLooping = true; //iniciando a variável...
        do {// fazer laço pra que quando dê a exception o código retorne pra pedir os números e o usuário faça o input correto
            String a = JOptionPane.showInputDialog("Numerador: ");//pra usar esse método show ele retorna uma string, porém quandoo eu for fazer a conta eu vou mudar o tipo e colocar int no caso
            String b = JOptionPane.showInputDialog("Denominador: ");

            try{ //botamos o try onde pode ocorrer a exception
                int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));//parseInt pra transf a string em int
                System.out.println("Resultado: " + resultado); // chegando até aqui n precisa fazer o loop, dando certo o resultado, daí vai direto p o finally
                continueLooping = false;
            } catch (NumberFormatException e) {// quando boto o mouse abaixo do sysout ele pergunta se quero botar o catch, clico e faz automático
                e.printStackTrace(); // o "e" é um objeto e herda os métodos desse tipo de exception
                JOptionPane.showMessageDialog(null, "Entrada inválida, informe um número inteiro! " + e.getMessage());// nem sempre é bom esse tipo de msg pq palavras em inglês ou conceitos n sabidos podem assustar o usuário
            } catch (ArithmeticException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Impossível dividir um número por 0.");
            }
            finally { //é opcional. Dando exception ou n executa o finally // daria pra ter feito o tratamento de excessão pra quando é um divisão que n gera um inteiro
                System.out.println("Chegou no finally!");
            }
        } while(continueLooping);//flag


        System.out.println("O código continua...");
    }

    public static int dividir(int a, int b) {
        return a / b;
    }
}
