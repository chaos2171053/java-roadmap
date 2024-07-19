package org.example.TrieTree;


//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
//
//请你实现 Trie 类：
//
//        Trie() 初始化前缀树对象。
//        void insert(String word) 向前缀树中插入字符串 word 。
//        boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
//        boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
//
//
//        示例：
//
//        输入
//        ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//        [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//        输出
//        [null, null, true, false, true, null, true]
public class Trie {
    private class TrieNode{
        private TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode(){
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public boolean search(String word) {
        if (word.isEmpty()) {
            return root.isEndOfWord;
        }
        TrieNode node = this.searchPrefix(word);
        return node!=null && node.isEndOfWord;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for(char c:word.toCharArray()){
            int index = c - 'a';
            if(node.children[index]==null){
                return  null;
            }
            node = node.children[index];
        }
        return node;
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char c:word.toCharArray()){
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;

    }

    public boolean startsWith(String word) {
        if (word.isEmpty()) {
            return root.isEndOfWord;
        }
        TrieNode node = this.searchPrefix(word);
        return node!=null;
    }
}
