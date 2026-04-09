public class ModeManager {
    private int curMode = 10; // DEC

    /** устанавливает систему счисления */
    public void setMode(String mode){
        switch (mode.toUpperCase()){
            case "BIN": curMode = 2; break;
            case "OCT": curMode = 8; break;
            case "DEC": curMode = 10; break;
            case "HEX": curMode = 16; break;
            default:
                System.out.println("Неизвестный режим! Оставлен текущий");
        }
    }

    /** возвращает текстовое название текущего режима */
    public String getMode(){
        switch (curMode){
            case 2: return "BIN";
            case 8: return "OCT";
            case 10: return "DEC";
            case 16: return "HEX";
            default: return "DEC";
        }
    }

    /** преобразует введенную строку в число типа long, согласно текущему режиму */
    public long parse(String input){
        return Long.parseLong(input, curMode);
    }

    /** возвращает строку-подсказку с допустимыми цифрами в текущей системе счисления */
    public String getAvailableChars() {
        switch (curMode) {
            case 2:  return "0, 1";
            case 8:  return "0 - 7";
            case 10: return "0 - 9";
            case 16: return "0 - 9, A - F";
            default: return "Неизвестно";
        }
    }
}
