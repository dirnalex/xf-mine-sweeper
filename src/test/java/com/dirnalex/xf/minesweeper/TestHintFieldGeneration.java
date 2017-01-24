package com.dirnalex.xf.minesweeper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for hint field generation.
 */
public class TestHintFieldGeneration {
    private MineSweeperImpl mineSweeper;

    @Before
    public void init() {
        mineSweeper = new MineSweeperImpl();
    }

    @Test
    public void testNoMines() {
        char[][] mineField = {
                {'.', '.', '.'},
                {'.', '.', '.'},
                {'.', '.', '.'},
                {'.', '.', '.'}
        };
        mineSweeper.setMineField(mineField);

        String hintField = mineSweeper.getHintField();

        Assert.assertEquals("000\n000\n000\n000", hintField);
    }

    @Test
    public void testAllMines() {
        char[][] mineField = {
                {'*', '*', '*'},
                {'*', '*', '*'},
                {'*', '*', '*'},
                {'*', '*', '*'}
        };
        mineSweeper.setMineField(mineField);

        String hintField = mineSweeper.getHintField();

        Assert.assertEquals("***\n***\n***\n***", hintField);
    }

    @Test
    public void testOneMine() {
        char[][] mineField = {
                {'.', '.', '.'},
                {'.', '*', '.'},
                {'.', '.', '.'},
                {'.', '.', '.'}
        };
        mineSweeper.setMineField(mineField);

        String hintField = mineSweeper.getHintField();

        Assert.assertEquals("111\n1*1\n111\n000", hintField);
    }

    @Test
    public void testMineHintForSeveralMines() {
        char[][] mineField = {
                {'.', '.', '.'},
                {'.', '*', '.'},
                {'.', '.', '.'},
                {'.', '*', '.'}
        };
        mineSweeper.setMineField(mineField);

        String hintField = mineSweeper.getHintField();

        Assert.assertEquals("111\n1*1\n222\n1*1", hintField);
    }

    @Test
    public void testMineHintSurroundedWithMines() {
        char[][] mineField = {
                {'.', '.', '.'},
                {'*', '*', '*'},
                {'*', '.', '*'},
                {'*', '*', '*'}
        };
        mineSweeper.setMineField(mineField);

        String hintField = mineSweeper.getHintField();

        Assert.assertEquals("232\n***\n*8*\n***", hintField);
    }
}
