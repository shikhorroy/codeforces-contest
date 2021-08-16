package roy.coder.utils.algo.ds.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    private boolean isEnd;
    private final char value;
    private final Map<Character, TrieNode> children;

    public TrieNode(char ch) {
        value = ch;
        isEnd = false;
        children = new HashMap<>();
    }

    public char getValue() {
        return value;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setIsEnd(boolean val) {
        isEnd = val;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }
}

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode((char) 0);
    }

    public void add(String word) {
        TrieNode node = root;
        Map<Character, TrieNode> child;

        for (int i = 0, ln = word.length(); i < ln; ++i) {
            child = node.getChildren();
            char ch = word.charAt(i);

            if (child.containsKey(ch))
                node = child.get(ch);
            else {
                TrieNode tempNode = new TrieNode(ch);
                child.put(ch, tempNode);
                node = tempNode;
            }
        }
        node.setIsEnd(true);
    }

    public boolean search(String key) {
        TrieNode node = root;
        Map<Character, TrieNode> child;

        for (int i = 0, ln = key.length(); i < ln; ++i) {
            child = node.getChildren();
            char ch = key.charAt(i);

            if (child.containsKey(ch)) {
                node = child.get(ch);
            } else return false;
        }
        return node.isEnd();
    }

    public String getMatchedPrefixWord(String string) {
        TrieNode node = root;
        Map<Character, TrieNode> child;
        StringBuilder result = new StringBuilder();

        int prevMatch = 0;
        for (int i = 0, ln = string.length(); i < ln; ++i) {
            child = node.getChildren();
            char ch = string.charAt(i);

            if (child.containsKey(ch)) {
                result.append(ch);
                node = child.get(ch);

                if (node.isEnd())
                    prevMatch = i + 1;
            } else break;
        }

        if (!node.isEnd())
            return result.substring(0, prevMatch);

        return result.toString();
    }
}
