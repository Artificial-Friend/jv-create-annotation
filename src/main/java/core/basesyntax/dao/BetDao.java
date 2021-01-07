package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import java.util.List;

public interface BetDao {
    List<Bet> getBets();

    void addBet(Bet bet);
}
