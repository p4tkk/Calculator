public class CalcEngine {

    public long calculate(long a, long b, String operator){
        long res = 0;
        switch (operator.toUpperCase()){
            case "+": res = a + b; break;
            case "-": res = a - b; break;
            case "*": res = a * b; break;
            case "/":
                if (b != 0) {
                    res = a / b;
                }else{
                    System.out.println("Ошибка!: деление на ноль недопустимо!");
                    res = 0;
                } break;
            case "AND": res = a & b; break;
            case "OR":  res = a | b; break;
            case "XOR": res = a ^ b; break;
            case "NAND": res = ~(a & b); break;
            case "NOR":  res = ~(a | b); break;
            default:
                System.out.println("Ошибка: неизвестная бинарная операция.");
        }
        return res;
    }

    public long calculateUnary(long a, String operator){
        long res = 0;
        switch (operator){
            case "NOT": // это побитовое отрицание (0 на 1, 1 на 0)
                res = ~a;
                break;
            default:
                System.out.println("Ошибка: неизвестная унарная операция.");
        }
        return res;
    }
}
