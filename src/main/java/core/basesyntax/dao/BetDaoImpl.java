package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;

public class BetDaoImpl implements BetDao {
    @Override
    public void addBet(Bet bet) {
        Storage.bets.add(bet);
    }

    @Override
    public void addUser(User user) {
        Storage.users.add(user);
    }
}
