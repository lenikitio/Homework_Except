public class NotFoundDateExceptio extends Exception {
    public NotFoundDateExceptio(String message){
        super(message);
    }

    public NotFoundDateExceptio(){
        super("Данные даты ррождения представлены неверно");
    }
}
