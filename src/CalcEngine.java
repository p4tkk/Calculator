public class CalcEngine implements ICalculator{

    /** выполнение обычной операции с двумя числами */
    @Override
    public long calculate(long a, long b, String operator) {
        long res = 0;
        switch (operator) {
            case "+": res = a + b; break;
            case "-": res = a - b; break;
            case "*": res = a * b; break;
            case "/":
                if (b != 0) {
                    res = a / b;
                } else {
                    System.out.println("Ошибка: деление на ноль!");
                    res = 0;
                }
                break;
            case "%":
                if (b != 0) {
                    res = a % b;
                } else {
                    System.out.println("Ошибка: деление на ноль (остаток)!");
                    res = 0;
                }
                break;
            default:
                System.out.println("Ошибка: неизвестная операция.");
        }
        return res;
    }

    /** выполнение унарной операции, в моей программе это опреция смены знака "+/-" */
    @Override
    public long calculateUnary(long a, String operator) {
        long res = 0;
        switch (operator) {
            case "+/-": // смена знака числа
                res = -a;
                break;
            default:
                System.out.println("Ошибка: неизвестная унарная операция.");
        }
        return res;
    }
}