package com.dirnalex.xf.minesweeper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for mine object initialization
 */
public class TestMineFieldSet {
    private MineSweeperImpl mineSweeper;

    @Before
    public void init() {
        mineSweeper = new MineSweeperImpl();
    }

    @Test
    public void testNormalBehavior() {
        char[][] mineField = {
                {'.', '*', '.'},
                {'*', '*', '*'},
                {'*', '.', '.'},
                {'*', '.', '*'}
        };
        String stringMineField = MineUtils.composeMineFieldString(mineField);

        mineSweeper.setMineField(stringMineField);

        char[][] actualMineField = mineSweeper.getMineField();
        Assert.assertArrayEquals(mineField, actualMineField);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testImproperSymbolsInput() {
        String stringMineField = "!@#$%^&()_+1234567890-=";

        mineSweeper.setMineField(stringMineField);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnequalLineLength() {
        char[][] testData = {
                {'.', '*'},
                {'*', '*', '*'},
                {'*', '.', '.', '*'},
                {'*', '.', '*'}
        };
        String stringData = MineUtils.composeMineFieldString(testData);

        mineSweeper.setMineField(stringData);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        mineSweeper.setMineField((String) null);
    }
}
