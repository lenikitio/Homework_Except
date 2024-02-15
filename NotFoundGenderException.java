public class NotFoundGenderException extends Exception{
    public NotFoundGenderException(String message){
        super(message);
    }

    public NotFoundGenderException(){
        super("Данные о поле введены неверно");
    }
}
