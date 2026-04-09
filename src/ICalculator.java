public interface ICalculator {
    /** выполнение обычной операции с двумя числами */
    long calculate(long a, long b, String operator);
    /** выполнение унарной операции, в моей программе это опреция смены знака "+/-" */
    long calculateUnary(long a, String operator);
}
