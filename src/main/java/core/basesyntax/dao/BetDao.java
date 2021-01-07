package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.List;

public interface BetDao {
    void addBet(Bet bet);

    void addUser(User user);

    List<Bet> getBets();

    List<User> getUsers();

}
