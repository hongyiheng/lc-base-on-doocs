class Solution {
    Map<String, String[]> mp = new HashMap<String, String[]>() {{
        put("1", new String[]{});
        put("2", new String[]{"a", "b", "c"});
        put("3", new String[]{"d", "e", "f"});
        put("4", new String[]{"g", "h", "i"});
        put("5", new String[]{"j", "k", "l"});
        put("6", new String[]{"m", "n", "o"});
        put("7", new String[]{"p", "q", "r", "s"});
        put("8", new String[]{"t", "u", "v"});
        put("9", new String[]{"w", "x", "y", "z"});
    }};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        int len = digits.length();
        if (len == 0) {
            return res;
        }
        dfs(res, 0, path, digits, len);
        return res;
    }

    public void dfs(List<String> res, int depth, StringBuilder path, String digits, int len) {
        if (depth == len) {
            res.add(path.toString());
            return;
        }
        String key = digits.substring(depth, depth + 1);
        for (String item : mp.get(key)) {
            path.append(item);
            dfs(res, depth + 1, path, digits, len);
            path.deleteCharAt(path.length() - 1);
        }
    }
}