class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> ac = new HashSet<>(), vc = new HashSet<>();
        for (List<String> p : paths) {
            ac.add(p.get(0));
            ac.add(p.get(1));
            vc.add(p.get(0));
        }
        for (String s : ac) {
            if (!vc.contains(s)) {
                return s;
            }
        }
        return null;
    }
}