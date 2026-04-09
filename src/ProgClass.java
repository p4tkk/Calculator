import java.util.Scanner;
public class ProgClass implements IApp{
    private Scanner scanner = new Scanner(System.in);
    private ICalculator eng = new CalcEngine();
    private ModeManager mode = new ModeManager();

    /** запуск основной программы */
    @Override
    public void start(){
        System.out.println("Калькулятор в режиме программиста");

        while (true){
            try{
                System.out.println("Режим: " + mode.getMode());
                System.out.println("Доступные цифры: " + mode.getAvailableChars());
                System.out.println("Введите первое число,");
                System.out.println("команду для выбора сисетмы счисления (HEX, DEC, BIN, OCT)");
                System.out.print("или 'q' для выхода: ");
                String input = scanner.next();

                // проверка на выход из программы
                if (input.equalsIgnoreCase("q")) break;

                // проверка на изменение режима
                if (isModeCommand(input)){
                    mode.setMode(input);
                    System.out.println("Система счисления изменена на " + mode.getMode());
                    continue;
                }

                // парсим первое число
                long n1 = mode.parse(input);

                String op;
                while (true) {
                    System.out.print("Операция (+, -, *, /, %, +/-): ");
                    op = scanner.next();

                    // проверяем, входит ли введенная строка в список разрешенных
                    if (op.equals("+") || op.equals("-") || op.equals("*") ||
                            op.equals("/") || op.equals("%") || op.equals("+/-")) {
                        break;
                    } else {
                        System.out.println("Ошибка: '" + op + "' не является допустимой операцией. Попробуйте еще раз.");
                    }
                }

                long res;
                if (op.equals("+/-")) {
                    res = eng.calculateUnary(n1, op);
                } else {
                    long n2 = 0;

                    while (true) {
                        System.out.print("Введите второе число (" + mode.getMode() + "): ");
                        String input2 = scanner.next();

                        try {
                            n2 = mode.parse(input2);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Ошибка! '" + input2 + "' не подходит для системы " + mode.getMode());
                            System.out.println("Попробуйте ввести второе число еще раз.");
                        }
                    }
                    res = eng.calculate(n1, n2, op);
                }

                System.out.println("Результат:");
                NumberForm.printAllSystems(res);
            } catch(NumberFormatException e){
                System.out.println("Ошибка! Введено не число!");
            } catch (Exception e){
                System.out.println("Ошибка!" + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    /** доп. метод для проверки, является ли введенная строка командой смены режима */
    private boolean isModeCommand(String cmd) {
        String c = cmd.toUpperCase();
        return c.equals("HEX") || c.equals("DEC") || c.equals("BIN") || c.equals("OCT");
    }
}
