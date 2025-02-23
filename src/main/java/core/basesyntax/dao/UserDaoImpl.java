package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.User;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getUsers() {
        return Storage.users;
    }

    @Override
    public void addUser(User user) {
        Storage.users.add(user);
    }
}
