import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class hm {
    public static void main(String[] args) {

        System.out.println("Введите данные в формате: Фамилия Имя Отчество дата_рождения номер_телефона пол");
        Scanner sc = new Scanner(System.in);
        // String data = sc.nextLine();
        String data = "30.07.1998 952133 m Толстогузов Евгений Сергеевич";
        getFileContact(data);
    }

    public static void getFileContact(String data) {
        String[] parseData = data.split(" ");
        if (checkCount(parseData) < 0) {
            return;
        } else {
            try {

                String date = findDate(parseData);
                int telefon = findTelefon(parseData);

                char sex = findGender(parseData);
                String[] fio = findFio(parseData, date);
                String filename = fio[0] + ".txt";

                File file = new File(filename);
                boolean exist = file.exists();
                FileWriter writer = new FileWriter(filename, exist);
                if (exist == true) {
                    writer.write("\n");
                }
                writer.write(fio[0] + fio[1] + fio[2] + date + telefon + sex);
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String[] findFio(String[] parseData, String date) throws FIOFormatException {
        String[] fio = new String[3];
        for (int i = 0; i < parseData.length; i++) {
            if (!parseData[i].matches("\\d*") && parseData[i].length() > 1 && parseData[i] != date) {
                fio[0] = parseData[i];
                fio[1] = parseData[i + 1];
                fio[2] = parseData[i + 2];
                return fio;
            }
        }
        throw new FIOFormatException();
    }

    private static int findTelefon(String[] parseData) throws NotFoundTelefonException {
        int telefon;
        for (String data : parseData) {
            if (data.matches("\\d*")) {
                telefon = Integer.parseInt(data);
                return telefon;
            }
        }
        throw new NotFoundTelefonException();
    }

    private static String findDate(String[] parseData) throws NotFoundDateExceptio {
        String date;
        for (String data : parseData) {
            if (data.length() == 10) {
                date = data;
                return date;
            }
        }
        throw new NotFoundDateExceptio();
    }

    private static char findGender(String[] parseData) throws NotFoundGenderException {
        char sex;
        for (String data : parseData) {
            if (data.length() == 1) {
                sex = data.charAt(0);
                checkGender(sex);
                return sex;
            }
        }
        throw new NotFoundGenderException();
    }

    private static void checkGender(char sex) throws NotFoundGenderException {
        if (sex != 'f' && sex != 'm') {
            throw new NotFoundGenderException();
        }
    }

    public static int checkCount(String[] data) {
        int size = data.length;
        if (size > 6) {
            System.out.println("Вы переборщили, ввели слишком много данных");
            return -1;
        } else if (size < 6) {
            System.out.println("Вы что-то пропустили, данных не хватает");
            return -2;
        }
        return data.length;
    }

}
