package org.example.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GeneMutation {
    public Object minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String gene : bank) {
            bankSet.add(gene);
        }

        if (!bankSet.contains(end)) {
            return -1;
        }

        char[] mutations = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int mutationsCount = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();
                if (currentGene.equals(end)) {
                    return mutationsCount;
                }
                char[] geneArray = currentGene.toCharArray();
                for (int j = 0; j < geneArray.length; j++) {
                    char originalChar = geneArray[j];
                    for (char mutation : mutations) {
                        if (mutation != originalChar) {
                            geneArray[j] = mutation;
                            String mutatedGene = new String(geneArray);
                            if (bankSet.contains(mutatedGene) && !visited.contains(mutatedGene)) {
                                queue.offer(mutatedGene);
                                visited.add(mutatedGene);
                            }
                        }
                    }
                    geneArray[j] = originalChar;
                }
            }
            mutationsCount++;
        }

        return -1;
    }
}
