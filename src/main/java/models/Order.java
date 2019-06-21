package models;

import java.util.Date;
import java.util.List;

/**
class of entity for orders that
 contains a unique identifier: id, User, userID
 */

public class Order {
    private int id;
    private int userID;
    private User user;

    public Order(){
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getId () {
        return id;
    }

    public void setId (int id ) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
