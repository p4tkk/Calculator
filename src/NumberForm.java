public class NumberForm {
    public static void printAllSystems(long value){
        System.out.println("HEX: " + Long.toHexString(value).toUpperCase());
        System.out.println("DEC: " + value);
        System.out.println("OCT: " + Long.toOctalString(value));
        System.out.println("BIN: " + Long.toBinaryString(value));
    }
}
