import java.util.regex.*;
public class UserData {
    private String login;
    private String password;
    private String name;
    private String surname;
    private String fatherName;
    private String birthDate;
    private String group;
    private String secretQuestion;
    private String email;
    private String phoneNumber;
    //Нужно сделать регулярки для каждого метода Set
    public void setLogin(String login){
        this.login = login;
    }
    public String getLogin(){
        return login;}
    public void setPassword(String password){//Нужно зациклить ввод пароля, пока он не надежен вводится новый
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*_).{8,20}$";
        Pattern CheckThePassword = Pattern.compile(passwordPattern);
        Matcher m = CheckThePassword.matcher(password);
        if(m.matches() == true) {

            this.password = password;
        }
        else{
            System.out.println("Введите пароль надежнее!");
        }
    }
    public String getPassword(){
        return password;
    }public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }public void setSurname(String surname){
        this.surname = surname;
    }
    public String getSurname(){
        return surname;
    }public void setFatherName(String fatherName){
        this.fatherName = fatherName;
    }
    public String getFatherName(){
        return fatherName;
    }public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }
    public String getBirthDate(){
        return birthDate;
    }public void setGroup(String group){
        this.group = group;
    }
    public String getGroup(){
        return group;
    }public void setSecretQuestion(String secretQuestion){
        this.secretQuestion = secretQuestion;
    }
    public String getSecretQuestion(){
        return secretQuestion;
    }public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;}
    public void setPhoneNuber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
}