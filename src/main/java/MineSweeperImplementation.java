import java.util.regex.Pattern;

/**
 * Created by marcel on 16.02.17.
 */
public class MineSweeperImplementation implements MineSweeper {

    private String mineField[] = null;

    public String[] getMineField() {
        return mineField;
    }

    public boolean checkIfMineFieldIsProperlyFormatted (String mineField) {
        if (!Pattern.matches("^([*.]+)|(([*.]+[\n])+[*.]+)$", mineField)) {
            return false;
        }
        String[] parts = mineField.split("\n");
        for (int i = 0; i < parts.length - 1; i++) {
            if (parts[i].length() != parts[i+1].length()) {
                return false;
            }
        }
        return true;
    }

    public void setMineField(String mineField) throws IllegalArgumentException {
        if (!checkIfMineFieldIsProperlyFormatted(mineField)) {
            throw new IllegalArgumentException();
        }
        String[] lines = mineField.split("\n");
        this.mineField = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            this.mineField[i] = lines[i];
        }
    }

    public String getHintField() throws IllegalStateException {
        return null;
    }
}
