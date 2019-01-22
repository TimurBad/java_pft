package ru.stqa.pft.addressbook;

public class GroupData {
    private final String login;
    private final String password;

    public GroupData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
