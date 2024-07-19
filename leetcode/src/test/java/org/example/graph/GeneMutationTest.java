package org.example.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeneMutationTest {
    @Test
    public void testSingleMutationInBank() {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        GeneMutation geneMutation = new GeneMutation();
        assertEquals(1, geneMutation.minMutation(start, end, bank));
    }

    @Test
    public void testMultipleMutationsInBank() {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        GeneMutation geneMutation = new GeneMutation();
        assertEquals(2, geneMutation.minMutation(start, end, bank));
    }

    @Test
    public void testNoMutationInBank() {
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        GeneMutation geneMutation = new GeneMutation();
        assertEquals(3, geneMutation.minMutation(start, end, bank));
    }
}
