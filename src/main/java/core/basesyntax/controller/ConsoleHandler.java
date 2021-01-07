package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.model.Bet;
import java.util.Scanner;

public class ConsoleHandler {
    Scanner scanner = new Scanner(System.in);
    BetDao dao = new BetDaoImpl();

    public void handle() {
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                Bet bet = new Bet(value, risk);
                dao.addBet(bet);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
                System.out.println("input is incorrect");
            }
        }
    }
}
