package utils;

public class Calculator {
    private double value1;
    private double value2;
    private String operation = "";
    private String errorMessage = "<br>";

    public void setValor1(String value) {
        try{
            this.value1 = Double.parseDouble(value);
        }//try//try
        catch(NumberFormatException e){
            this.errorMessage += "O valor 1 parece não ser um número válido para esta operação!<br>";
        }//catch
    }//func

    public void setValor2(String value) {
        try{
            this.value2 = Double.parseDouble(value);
        }//try//try
        catch(NumberFormatException e){
            this.errorMessage += "O valor 2 parece não ser um número válido para esta operação!<br>";
        }//catch
    }//func

    public void setOperacao(String operacao) {
        this.operation = operacao;
    }//func

    public String getErrorMessage() {
        return errorMessage;
    }//func
    
    //Se ocorreu mensagem de erro, logo retorna true (existe um erro)
    public boolean hasError(){
        return !errorMessage.equals("");
    }//func
    
    public double calculateOperation(){
        double operationResult = 0.0;
        //
        switch(operation){
            case "adicao":
                operationResult = (value1 + value2);
                break;
            case "subtracao":
                operationResult = (value1 - value2);
                break;
            case "multiplicacao":
                operationResult = (value1 * value2);
                break;
        }//switch
        return operationResult;
    }//func
}//class