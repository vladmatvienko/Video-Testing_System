import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
 * Класс предназначен для регистрации пользователей
 * @author bli34
 * @version 1.0.0
 */
public class SignUp {
    /**
     * @param args параметр, благодаря которому выполняется метод main
     * main() метод, в котором все данные, введенные при регистрации, загружаются в базу данных
     * @throws SQLException в случае, когда main не срабтывает
     * @throws ClassNotFoundException в случае, когда main не срабтывает
     * @author bli34
     * @version 1.0.0
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Пользователь вводит имя, фамилию и тд, нужно сделать мб это через новый класс, включить сюда регулярки
        //Нужно это привязать как-то к графическому интерфейсу
        Scanner sc = new Scanner(System.in);
        UserData user = new UserData();
        user.setLogin(sc.nextLine());
        user.setPassword(sc.nextLine());
        user.setName(sc.nextLine());
        user.setSurname(sc.nextLine());
        //Отчество нужно сделать опциональным
        user.setFatherName(sc.nextLine());
        user.setBirthDate(sc.nextLine());
        user.setGroup(sc.nextLine());
        //Нужно сделать несколько секретных вопросов и прикрутить к интерфейсу
        //Правильнее назвать это ответом на вопрос
        user.setSecretQuestion(sc.nextLine());
        user.setEmail(sc.nextLine());
        user.setPhoneNuber(sc.nextLine());
        String username = "root";
        String password = "1234";
        String connectionURL = "jdbc:mysql://localhost:3306/users of application";
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Подключаюсь к БД, она только у меня на компе, хз как сделать ее общедоступной, мб разместить где-то в облаке, нужно придумать или отставить
        try(Connection connection = DriverManager.getConnection(connectionURL, username,password)){
            System.out.println("We are connected");

            Statement statement = connection.createStatement();
            {//вставляю инфу в БД, еще не до конца разобрался
                statement.executeUpdate("INSERT INTO users(name, surname)\n" +
                        "    VALUES ('"+user.getName()+"', '"+user.getSurname()+"');");

            }

        }
    }
}