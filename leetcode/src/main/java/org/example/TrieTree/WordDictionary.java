package org.example.TrieTree;

public class WordDictionary {


    private class  TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        public  TrieNode(){
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public WordDictionary(){
        root = new TrieNode();
    }


    public void addWord(String word) {
        TrieNode node = root;
        for (char c:word.toCharArray()){
            int index = c-'a';
            if(node.children[index]==null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchWord(root, word, 0);
    }

    private boolean searchWord(TrieNode node, String word, int index) {
        if(node==null){
            return false;
        }
        if (index == word.length()) {
            return node.isEndOfWord;
        }
        char c = word.charAt(index);

        if(c == '.') {
            for (int i = 0; i < 26; i++) {
                if (searchWord(node.children[i], word, index + 1)) {
                    return true;
                }
            }
            return false;
        }else {
            int idx = c - 'a';
            return searchWord(node.children[idx], word, index + 1);
        }

    }

}
