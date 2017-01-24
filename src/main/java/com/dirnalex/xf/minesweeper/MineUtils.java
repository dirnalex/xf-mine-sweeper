package com.dirnalex.xf.minesweeper;

/**
 * Utilities for working with mine field representations, such as string or array representation.
 */
public class MineUtils {
    /**
     * Converts the char array representing the mine field to the string.
     *
     * @param array any array of chars
     * @return compose the chars into string with row separator as a linebreak
     */
    public static String composeMineFieldString(char[][] array) {
        StringBuilder composedSb = new StringBuilder();

        for (int n = 0; n < array.length; n++) {
            for (int m = 0; m < array[n].length; m++) {
                composedSb.append(array[n][m]);
            }
            if (n < array.length - 1) {
                composedSb.append("\n");
            }
        }

        return composedSb.toString();
    }

    /**
     * Converts the string representing the mine field to the char array.
     *
     * @param mineFieldString The string that contains any symbols and line breaks
     * @return char 2-dimensional array with rows representing the lines
     */
    public static char[][] readMineFieldString(String mineFieldString) {
        String[] lines = mineFieldString.split("\\n");
        char[][] mineField = new char[lines.length][];

        for (int lineNo = 0; lineNo < lines.length; lineNo++) {
            mineField[lineNo] = lines[lineNo].toCharArray();
        }

        return mineField;
    }
}
