class Solution {
    class Node {
        private Node[] children;
        private boolean end;

        public Node() {
            children = new Node[27];
            end = false;
        }
    }

    Node root = new Node();

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        List<String> ans = new ArrayList<>();
        for (String s :folder) {
            boolean son = findAndSave(s);
            if (!son) {
                ans.add(s);
            }
        }
        return ans;
    }

    public boolean findAndSave(String s) {
        boolean son = false;
        Node r = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = '/' == s.charAt(i) ? 26 : s.charAt(i) - 'a';
            if (r.children[idx] == null) {
                r.children[idx] = new Node();
            }
            if (r.children[idx].end && s.charAt(i + 1) == '/') {
                son = true;
            }
            r = r.children[idx];
        }
        r.end = true;
        return son;
    }
}
