package com.dirnalex.xf.minesweeper;

/**
 * Interface for validating the mine field strings
 */
public interface MineFieldValidator {
    /**
     * Validates the mine field string
     *
     * @param mineField the string that contains the mine field representation. e.g. "**.\n...\n***"
     * @throws IllegalArgumentException thrown if validation failed
     */
    void validate(String mineField) throws IllegalArgumentException;
}
