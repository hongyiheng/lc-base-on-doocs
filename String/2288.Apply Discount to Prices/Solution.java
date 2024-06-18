class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] ws = sentence.split(" ");
        for (int i = 0; i < ws.length; i++) {
            String w = ws[i];
            if (w.charAt(0) != '$' || w.length() < 2) {
                continue;
            }
            boolean digit = true;
            for (int j = 1; j < w.length() && digit; j++) {
                if (!Character.isDigit(w.charAt(j))) {
                    digit = false;
                }
            }
            if (!digit) {
                continue;
            }
            Long v = Long.parseLong(w.substring(1));
            if (v != -1) {
                ws[i] = "$" + String.format("%.2f", 1.0 * v * (100 - discount) / 100);
            }
        }
        return String.join(" ", ws);
    }
}