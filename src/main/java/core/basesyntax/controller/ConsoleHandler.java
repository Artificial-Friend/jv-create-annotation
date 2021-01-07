package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.model.Bet;

import java.util.Scanner;

public class ConsoleHandler {
    Scanner scanner = new Scanner(System.in);
    BetDao dao = new BetDaoImpl();

    public void handle() {
        String command = scanner.nextLine();
        int value;
        double risk;
        String[] betData;
        Bet bet;
        while (true) {
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            try {
                betData = command.split(" ");
                value = Integer.parseInt(betData[0]);
                risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
                dao.addBet(bet);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
                System.out.println("input is incorrect");
            }
        }
    }
}
