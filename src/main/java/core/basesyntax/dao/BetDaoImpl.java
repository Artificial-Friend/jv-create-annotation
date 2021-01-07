package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Bet;
import java.util.List;

public class BetDaoImpl implements BetDao {
    @Override
    public List<Bet> getBets() {
        return Storage.bets;
    }

    @Override
    public void addBet(Bet bet) {
        Storage.bets.add(bet);
    }
}
