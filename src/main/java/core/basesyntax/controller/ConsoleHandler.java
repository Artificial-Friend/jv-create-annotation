package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private final Scanner scanner = new Scanner(System.in);
    private final BetDao betDao = new BetDaoImpl();
    private final UserDao userDao = new UserDaoImpl();

    public void handle() {
        System.out.println("Enter 'value' and 'risk' for your bid");
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                System.out.println("Now enter your name");
                String userName = scanner.nextLine();
                Bet bet = new Bet(value, risk);
                User user = new User(new java.util.Random().nextInt(), userName);
                betDao.addBet(bet);
                userDao.addUser(user);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
                System.out.println("input is incorrect");
            }
        }
    }
}
