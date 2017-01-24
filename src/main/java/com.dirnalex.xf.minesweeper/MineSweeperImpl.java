package com.dirnalex.xf.minesweeper;

/**
 * Realization of MineSweeper interface.
 * Stores the mine fields and allows to generate the hint field.
 */
public class MineSweeperImpl implements MineSweeper {
    public static final char MINE_CHAR = '*';
    public static final char NO_MINE_CHAR = '.';

    private char[][] mineField = null;

    @Override
    public void setMineField(String mineField) throws IllegalArgumentException {
        MineFieldValidator validator = new MineFieldValidatorImpl();
        validator.validate(mineField);

        this.mineField = MineUtils.readMineFieldString(mineField);
    }

    @Override
    public String getHintField() throws IllegalStateException {
        if (mineField == null) {
            throw new IllegalStateException("Mine field is not initialized yet.");
        }

        char[][] hintField = new char[mineField.length][];

        for (int n = 0; n < mineField.length; n++) {
            hintField[n] = new char[mineField[n].length];
            for (int m = 0; m < mineField[n].length; m++) {
                hintField[n][m] = getHints(mineField, n, m);
            }
        }

        return MineUtils.composeMineFieldString(hintField);
    }

    private char getHints(char[][] array, int n, int m) throws IllegalStateException {
        switch (array[n][m]) {
            case MINE_CHAR:
                return MINE_CHAR;
            case NO_MINE_CHAR:
                int hints = 0;
                //iterate through the 3x3 square with center in n,m and ignore cells outside the array and the center.
                //for the rest cells find out the amount of mines
                for (int nn = n - 1; nn <= n + 1; nn++) {
                    if (nn >= 0 && nn < array.length) {
                        for (int mm = m - 1; mm <= m + 1; mm++) {
                            if (mm >= 0 && mm < array[nn].length
                                    && !(nn == n & mm == m)
                                    && array[nn][mm] == MINE_CHAR) {
                                hints++;
                            }
                        }
                    }
                }
                //converting integer to char. Error situation should be impossible within normal behaviour.
                char[] hintsChars = String.valueOf(hints).toCharArray();
                if (hintsChars.length != 1) {
                    throw new Error("For some unknown reason amount of hints was not convertible to char. " +
                            "The most possible reason is that there were more than nine hints counted.");
                }
                return hintsChars[0];
            default:
                throw new IllegalStateException("Mine array contains forbidden symbols.");
        }
    }

    public char[][] getMineField() {
        return mineField;
    }

    public void setMineField(char[][] mineField) {
        this.mineField = mineField;
    }
}
