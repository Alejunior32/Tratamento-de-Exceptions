package Exceptions;

import javax.swing.*;

public class UnchekedExceptions {

    public static void main(String[] args) {
        boolean contiueLooping = true;

        do{
            String a = JOptionPane.showInputDialog("Numerador: ");
            String b = JOptionPane.showInputDialog("Denominador: ");

            try{
                int resultado = dividir(Integer.parseInt(a),Integer.parseInt(b));
                System.out.println("Resultado: "+resultado);
                contiueLooping = false;
            }catch (NumberFormatException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Entrada Inválida, Informe um número inteiro :" +e.getMessage());
            }catch (ArithmeticException e){
                JOptionPane.showMessageDialog(null, "Impossível dividir um número por 0");
            } finally {
                System.out.println("Chegou no finally!");
            }

        }while (contiueLooping);

        System.out.println("O código chegou ao fim ...");
    }

    public static int dividir(int a, int b){

        return a/b;}

}
