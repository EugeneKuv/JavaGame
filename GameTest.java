package ru.kuvaldin;

public class GameTest {

    public void testGameEgualResult() {
        String scenario = "Тест на ничью";
        System.out.println(scenario);

        Player vasa = new Player("Вася");
        Player igor = new Player("Игорь");
        Dice dice = new DiceTest();

        Game game = new Game(dice, new GameWinnerPrinter() {
            @Override
            public void printWinner(Player winner) {
                if (winner == null) {
                    System.out.println("Тест пройден" + '\n');
                }
                else {
                    System.out.println("Тест не пройден" + '\n');
                }
            }
        });

        game.playGame(vasa, igor);
    }

    public void testGameRangeOfValues() {
        String scenario = "Тест на значения от 1 до 6";
        System.out.println(scenario);
        Dice dice = new DiceImpl();

        boolean check = true;
        for (int i = 0; i < 100; i++) {
            int value = dice.roll();
            if (value < 1 || value > 6) {
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("Тест пройден" + '\n');
        }
        else {
            System.out.println("Тест не пройден" + '\n');
        }
    }

    public void testDiceNegativeValue() {
        String scenario = "Тест на отрицательные значения кубика";
        System.out.println(scenario);
        Dice dice = new DiceImpl();

        boolean check = true;
        for (int i = 0; i < 100; i++) {
            int value = dice.roll();
            if (value < 0) {
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("Тест пройден" + '\n');
        }
        else {
            System.out.println("Тест не пройден" + '\n');
        }
    }

    public void testPlayerConstructor() {
        String scenario = "Тест на конструктор игрока";
        System.out.println(scenario);

        String name = "Игорь";
        Player player = new Player(name);

        if (player.getName().equals(name)) {
            System.out.println("Тест пройден" + '\n');
        }
        else {
            System.out.println("Тест не пройден" + '\n');
        }
    }
}