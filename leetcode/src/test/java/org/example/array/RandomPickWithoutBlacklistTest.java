package org.example.array;

import org.junit.Test;
import java.util.*;


public class RandomPickWithoutBlacklistTest {
    @Test
    public void testRandomPickWithoutBlacklist() {
        RandomPickWithoutBlacklist solution = new RandomPickWithoutBlacklist(7, new int[]{2, 3, 5});
        List<Integer> picks = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            picks.add(solution.pick());
        }
        System.out.println(picks); // 输出随机选择的整数列表
    }
    @Test
    public void debugMethod(){
        RandomPickWithoutBlacklist solution = new RandomPickWithoutBlacklist(5, new int[]{1,0});
    }
}

