package Exceptions;

import javax.swing.*;
import java.io.*;

public class CheckedExceptions {

    public static void main(String[] args) {
        String nomeDoArquivo = "Tex.txt";

        try {
            imprimirArquivoNoConsole(nomeDoArquivo);
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null,
                    "O Arquivo não existe! " + e.getCause());
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!");
        } finally {
            System.out.println("Chegou no finally...");
        }

        System.out.println("Apesar da exception ou não, o programa continua ...");
    }

    public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException {
        File arquivo =new File(nomeDoArquivo);

        BufferedReader reader = new BufferedReader(new FileReader(arquivo.getName()));
        String line = reader.readLine();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        do{
            writer.write(line);
            writer.newLine();
            line = reader.readLine();
        }while(line != null);
        writer.flush();
        reader.close();

    }




}
