class Solution {
    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i), right = s.substring(i);
            if ("".equals(left) || "".equals(right)) {
                continue;
            }
            List<String> ls = new ArrayList<>(), rs = new ArrayList<>();
            if (left.length() == 1) {
                ls.add(left);
            } else {
                int n = left.length();
                boolean num = left.charAt(n - 1) != '0';
                if (left.charAt(0) == '0') {
                    if (num) {
                        ls.add("0." + left.substring(1));
                    }
                } else {
                    ls.add(left);
                    for (int j = n - 2; j > -1; j--) {
                        if (!num) {
                            if (left.charAt(j) != '0') {
                                num = true;
                            }
                            continue;
                        }
                        ls.add(left.substring(0, j + 1) + "." + left.substring(j + 1));
                    }
                }
            }
            if (right.length() == 1) {
                rs.add(right);
            } else {
                int n = right.length();
                boolean num = right.charAt(n - 1) != '0';
                if (right.charAt(0) == '0') {
                    if (num) {
                        rs.add("0." + right.substring(1));
                    }
                } else {
                    rs.add(right);
                    for (int j = n - 2; j > -1; j--) {
                        if (!num) {
                            if (right.charAt(j) != '0') {
                                num = true;
                            }
                            continue;
                        }
                        rs.add(right.substring(0, j + 1) + "." + right.substring(j + 1));
                    }
                }
            }
            for (String l : ls) {
                if (l.contains(".") && l.charAt(l.length() - 1) == '0') {
                    continue;
                }
                for (String r : rs) {
                    if (r.contains(".") && r.charAt(r.length() - 1) == '0') {
                        continue;
                    }
                    ans.add("(" + l + ", " + r + ")");
                }
            }
        }
        return ans.stream().distinct().collect(Collectors.toList());
    }
}
