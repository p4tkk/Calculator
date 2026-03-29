import java.sql.SQLOutput;
import java.util.Scanner;
public class ProgClass {
    private final Scanner scanner = new Scanner(System.in);
    private final CalcEngine eng = new CalcEngine();

    public void start(){
        System.out.println("Калькулятор в режиме программиста");
        System.out.println("Доступны: +, -, *, /, AND, OR, XOR, NOT, NAND, NOR");
        System.out.println("Введите 'q' для выхода");

        while (true){
            try{
                System.out.print("Введите первое число: ");
                long n1 = Long.parseLong(scanner.next());

                System.out.print("Операция: ");
                String opInput = scanner.next().toUpperCase();
                if(opInput.equals("q")) break;

                long res;

                if (opInput.equals("NOT")) {
                    res = eng.calculateUnary(n1, opInput);
                } else {
                    // Для всех остальных (бинарных) операций просим второе число
                    System.out.print("Введите второе число: ");
                    long n2 = Long.parseLong(scanner.next());
                    res = eng.calculate(n1, n2, opInput);
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
}
