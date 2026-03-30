public class ModeManager {
    private int curMode = 10; // DEC

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

    public String getMode(){
        switch (curMode){
            case 2: return "BIN";
            case 8: return "OCT";
            case 10: return "DEC";
            case 16: return "HEX";
            default: return "DEC";
        }
    }

    public long parse(String input){
        return Long.parseLong(input, curMode);
    }

    public int getCurrentMode(){
        return curMode;
    }
}
