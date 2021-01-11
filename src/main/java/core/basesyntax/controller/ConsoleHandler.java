package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.UserDao;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    @Inject
    private BetDao betDao;
    @Inject
    private UserDao userDao;
    private final Scanner scanner = new Scanner(System.in);

    public void handle() {
        System.out.println("Enter 'value' and 'risk' for your bid");
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                System.out.println(betDao.getBets());
                System.out.println(userDao.getUsers());
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
