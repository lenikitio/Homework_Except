public class FIOFormatException extends Exception{
    public FIOFormatException(String message){
        super(message);
    }

    public FIOFormatException(){
        super("Данные ФИО введены неверно");
    }
}
