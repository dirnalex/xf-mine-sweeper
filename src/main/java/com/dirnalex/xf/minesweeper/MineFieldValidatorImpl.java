package com.dirnalex.xf.minesweeper;


/**
 * Implementation for validating the mine field strings.
 */
public class MineFieldValidatorImpl implements MineFieldValidator {
    /**
     * Validates the mine field string amond such factors as:
     * null equality,
     * allowed symbols,
     * equality of each line
     *
     * @param mineField the string that contains the mine field representation. e.g. "**.\n...\n***"
     * @throws IllegalArgumentException thrown if validation failed
     */
    public void validate(String mineField) throws IllegalArgumentException {
        validateNotNull(mineField);
        validateAcceptedSymbols(mineField);
        validateLinesEquality(mineField);
    }

    private void validateNotNull(String mineField) {
        if (mineField == null) {
            throw new IllegalArgumentException("String with the mine field representation " +
                    "is null.");
        }
    }

    private void validateAcceptedSymbols(String mineField) throws IllegalArgumentException {
        //allowed symbols are no mine symbol, mine symbol and line break symbol
        if (!mineField.matches("[" + MineSweeperImpl.NO_MINE_CHAR + MineSweeperImpl.MINE_CHAR + "\\n]*")) {
            throw new IllegalArgumentException("String with the mine field representation " +
                    "contains symbols other than '" + MineSweeperImpl.NO_MINE_CHAR + "', '" +
                    MineSweeperImpl.MINE_CHAR + "' or linebreak ('\\n').");
        }
    }

    private void validateLinesEquality(String mineField) throws IllegalArgumentException {
        String[] lines = mineField.split("\\n");
        //here we go from the second line to the last and compare each line's length with the previous one's
        for (int lineNo = 1; lineNo < lines.length; lineNo++) {
            if (lines[lineNo].length() != lines[lineNo - 1].length()) {
                throw new IllegalArgumentException("String with the mine field representation " +
                        "contains lines with different lengths.");
            }
        }
    }
}
