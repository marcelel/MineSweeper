import java.util.regex.Pattern;

/**
 * Created by marcel on 16.02.17.
 */
public class MineSweeperImplementation implements MineSweeper {

    private String mineField[] = null;

    private int convert(char c) {
        if (c == '*') {
            return 1;
        }
        else {
            return 0;
        }
    }

    private int calculateNumber(int row, int col) {
        int number = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col -1; j <= col + 1; j++) {
                try {
                    number += convert(mineField[i].charAt(j));
                } catch (IndexOutOfBoundsException e) {
                }
            }
        }
        return number;
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

    public String[] getMineField() {
        return mineField;
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
        if (mineField == null) {
            throw new IllegalStateException();
        }
        String hintField = "";
        for (int i = 0; i < mineField.length; i++) {
            for (int j = 0; j < mineField[i].length(); j++) {
                if (mineField[i].charAt(j) == '*') {
                    hintField += '*';
                    continue;
                }
                hintField += calculateNumber(i, j);
            }
            if (i < mineField.length - 1) {
                hintField += "\n";
            }
        }
        return hintField;
    }
}
