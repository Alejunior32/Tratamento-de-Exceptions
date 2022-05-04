package Exceptions;

import javax.swing.*;
import java.io.*;

public class ExceptionPersonalizada {
    public static void main(String[] args) {
        String nomeDoArquivo = JOptionPane.showInputDialog("Nome do arquivo: ");

        imprimirArquivoNoConsole(nomeDoArquivo);
        System.out.println("Com exception ou não, o programa continua... ");

    }
    public static void imprimirArquivoNoConsole(String nomeDoArquivo){

        try {
            BufferedReader reader = lerArquivos(nomeDoArquivo);
            String line = reader.readLine();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

            do{
                writer.write(line);
                writer.newLine();
                line = reader.readLine();
            }while(line != null);
            writer.flush();
            reader.close();
        }catch (LeituraDoArquivoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro não esperado, por favor,fale com o suporte"+e.getMessage());
            e.printStackTrace();
        }
    }
    public static BufferedReader lerArquivos(String nomeArquivo) throws LeituraDoArquivoException {
        File arquivo =new File(nomeArquivo);
        try {
            return new BufferedReader(new FileReader(nomeArquivo));
        } catch (FileNotFoundException e) {
            throw new LeituraDoArquivoException(arquivo.getName(),arquivo.getPath());
        }
    }

}
class LeituraDoArquivoException extends Exception{

    private String nomeDoArquivo;
    private String diretorio;

    public LeituraDoArquivoException(String diretorio, String nomeDoArquivo) {
        super("O arquivo "+nomeDoArquivo+ " não foi encontrado no diretorio" +diretorio);
        this.diretorio = diretorio;
        this.nomeDoArquivo= nomeDoArquivo;
    }

    public LeituraDoArquivoException() {
    }

    @Override
    public String toString() {
        return "LeituraDoArquivoException{" +
                "nomeDoArquivo='" + nomeDoArquivo + '\'' +
                ", diretorio='" + diretorio + '\'' +
                '}';
    }

}
