package org.example.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DungeonGameTest {

    @Test
    public void testDungeonGame() {
        int[][] dungeon1 = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        assertEquals(7, DungeonGame.calculateMinimumHP(dungeon1));

        int[][] dungeon2 = {{0}};
        assertEquals(1, DungeonGame.calculateMinimumHP(dungeon2));
    }
}