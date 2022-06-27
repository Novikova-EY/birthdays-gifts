package ru.novikova.birthdaysGifts;

import ru.novikova.birthdaysGifts.entities.User;

import java.util.HashMap;
import java.util.Map;

public class IdentityMapUsers {
    private Map<Long, User> usersMap = new HashMap();

    public void addUser(User user) {
        this.usersMap.put(user.getId(), user);
    }

    public User getUser(Long id) {
        return this.usersMap.get(id);
    }
}
