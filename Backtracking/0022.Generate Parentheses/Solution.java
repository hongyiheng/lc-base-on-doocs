class Solution {
    String[] choose = new String[]{"(", ")"};

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        backTrack(n, n, new StringBuilder(), res);
        return res;
    }

    private void backTrack(int lefts, int rights, StringBuilder tempStr, List<String> res) {
        if (lefts == 0 && rights == 0) {
            res.add(new String(tempStr));
            return;
        }
        if (lefts > rights) {
            return;
        }
        for (String cur : choose) {
            tempStr.append(cur);
            if (cur.equals("(") && lefts > 0) {
                backTrack(lefts - 1, rights, tempStr, res);
            } else if (cur.equals(")") && rights > 0) {
                backTrack(lefts, rights - 1, tempStr, res);
            }
            tempStr.deleteCharAt(tempStr.length() - 1);
        }
    }
}