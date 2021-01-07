package core.basesyntax.dao;

import core.basesyntax.model.User;
import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void addUser(User user);
}
