// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами,
// их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

import java.io.*;
import java.util.*;

public class PhoneBooks {
    private static HashMap<String, String> contacts = new HashMap<>();

    private static void addPB(String name, String phone) {
        contacts.put(name, phone);
    }

    private static void delPB(String phone) {
        contacts.remove(phone);
    }

    public static String FindSurname(String number) {
        String result = contacts.get(number);
        if (result == null)
            return "Человек с таким номером не найдей";
        return result;
    }

    public static String[] FindNumberPhone(String surname) {
        List<String> result = new ArrayList<String>();
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            if (surname.equalsIgnoreCase((String) entry.getValue())) {
                result.add((String) entry.getKey());
            }
        }
        if (result.size() == 0)
            result.add("Человек с такой фамилией не найден");
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) throws IOException {
        String act;
        PhoneBooks myPhoneBook = new PhoneBooks();
        myPhoneBook.addPB("Podrez", "4543534556");
        myPhoneBook.addPB("Evgen", "5653333444");
        myPhoneBook.addPB("Olga", "4545634565");
        myPhoneBook.addPB("Dariya", "4565465678");

        System.out.println(
                "Выбор действия: (Add)добавить данные, (Del)удалить данные, (Num) найти номера по фамилии, (Sur)найти фамилию ");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        act = bf.readLine();
        while (!act.equals("")) {
            if (act.equals("Add")) {
                System.out.print("Введите фамилию: ");
                String name = bf.readLine();
                System.out.print("Введите телефон: ");
                String phone = bf.readLine();
                addPB(name, phone);
            } else {
                if (act.equals("Del")) {
                    System.out.print("Введите телефон: ");
                    String phone = bf.readLine();
                    delPB(phone);
                } else {
                    if (act.equals("Num")) {
                        System.out.print("Введите фамилию: ");
                        String surname = bf.readLine();
                        String[] numbers = FindNumberPhone(surname);
                        for (String number : numbers) {
                            System.out.println(number);
                        }
                    } else {
                        if (act.equals("Sur")) {
                            System.out.print("Введите номер: ");
                            String number = bf.readLine();
                            System.out.println(FindSurname(number));
                        }
                    }
                }
            }
            break;
        }
        System.out.println("Нажмитие ENTER для выхода");
        act = bf.readLine();
    }
}