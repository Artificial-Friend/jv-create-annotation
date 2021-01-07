package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.List;

public class BetDaoImpl implements BetDao {
    @Override
    public void addBet(Bet bet) {
        Storage.bets.add(bet);
    }

    @Override
    public void addUser(User user) {
        Storage.users.add(user);
    }

    @Override
    public List<Bet> getBets() {
        return Storage.bets;
    }

    @Override
    public List<User> getUsers() {
        return Storage.users;
    }
}
