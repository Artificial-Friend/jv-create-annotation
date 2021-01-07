package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import core.basesyntax.model.User;

public interface BetDao {
    void addBet(Bet bet);

    void addUser(User user);
}
