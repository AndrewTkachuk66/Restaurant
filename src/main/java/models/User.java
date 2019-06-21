package models;

/**
 class of entity for all users
 used  authorization and identification
 */

public class User  {
    private int id;
    private String name;
    private String login;
    private String password;
    private String email;
    private String status;
    public User (){}

    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getLogin () {
        return login;
    }

    public void setLogin ( String login ) {
        this.login = login;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus ( String status ) {
        this.status = status;
    }

    @Override
    public String toString () {
        return  name + " " + "" + login + " " + password ;
    }
}

