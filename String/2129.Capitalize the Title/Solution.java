class Solution {
    public String capitalizeTitle(String title) {
        String[] ws = title.split(" ");
        for (int i = 0; i < ws.length; i++) {
            if (ws[i].length() <= 2) {
                ws[i] = ws[i].toLowerCase();
            } else {
                ws[i] = ws[i].substring(0, 1).toUpperCase() + ws[i].substring(1).toLowerCase();
            }
        }
        return String.join(" ", ws);
    }
}