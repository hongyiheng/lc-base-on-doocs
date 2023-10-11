class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> pos = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> neg = new HashSet<>(Arrays.asList(negative_feedback));
        List<int[]> q = new ArrayList<>();
        int n = student_id.length;
        for (int i = 0; i < n; i++) {
            int degree = 0;
            for (String s : report[i].split(" ")) {
                if (pos.contains(s)) {
                    degree += 3;
                } else if (neg.contains(s)) {
                    degree--;
                }
            }
            q.add(new int[]{degree, student_id[i]});
        }
        q.sort((a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        return q.stream().map(e -> e[1]).limit(k).collect(Collectors.toList());
    }
}