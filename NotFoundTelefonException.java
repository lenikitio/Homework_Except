public class NotFoundTelefonException extends Exception{
    public NotFoundTelefonException(String message){
        super(message);
    }

    public NotFoundTelefonException(){
        super("Данные телефона введены неверно");
    }
}
