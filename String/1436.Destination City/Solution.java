class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> us = new HashSet<>();
        for (List<String> p : paths) {
            us.add(p.get(0));
        }
        for (List<String> p : paths) {
            if (!us.contains(p.get(1))) {
                return p.get(1);
            }
        }
        return "";
    }
}