class Solution {
    class Node {
        boolean end;
        Node[] children;

        Node() {
            this.end = false;
            this.children = new Node[26];
        }
    }

    Node root = new Node();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word : words) {
            if (!word.isEmpty()) {
                if (dfs(word, 0)) {
                    ans.add(word);
                } else {
                    insert(word);
                }
            }
        }
        return ans;
    }

    private void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Node();
            }
            node = node.children[c - 'a'];
        }
        node.end = true;
    }

    private boolean dfs(String word, int i) {
        if (i == word.length()) {
            return true;
        }
        Node node = root;
        while (i < word.length()) {
            if (node.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            node = node.children[word.charAt(i) - 'a'];
            if (node.end && dfs(word, i + 1)) {
                return true;
            }
            i++;
        }
        return false;
    }
}