package utils;

public class Calculadora {
    private double valor1;
    private double valor2;
    private String operacao = "";
    private String errorMessage = "";

    public void setValor1(String value) {
        try{
            System.out.println("Value 1= "+ value);
            this.valor1 = Double.parseDouble(value);
        }//try
        catch(NumberFormatException e){
            this.errorMessage += "<br>O valor 1 parece não ser um número válido para esta operação!";
        }//catch
    }//func

    public void setValor2(String value) {
        try{
            this.valor2 = Double.parseDouble(value);
        }//try
        catch(NumberFormatException e){
            this.errorMessage += "<br>O valor 2 parece não ser um número válido para esta operação!";
        }//catch
    }//func

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }//func

    public String getErrorMessage() {
        return errorMessage;
    }//func
    
    //Se ocorreu mensagem de erro, logo retorna true (existe um erro
    public boolean hasError(){
        return !errorMessage.equals("");
    }//func
    
    public double calcular(){
        double resultado = 0.0;
        System.out.println("VALOR DA OPERAÇÃO: " + operacao);
        switch(operacao){
            case "adicao":
                resultado = (valor1 + valor2);
                break;
            case "subtracao":
                resultado = (valor1 - valor2);
                break;
            case "multiplicacao":
                resultado = (valor1 * valor2);
                break;
        }//switch
        return resultado;
    }//func
}//class