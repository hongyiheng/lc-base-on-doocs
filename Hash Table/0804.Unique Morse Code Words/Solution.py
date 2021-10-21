class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        mp = [
            ".-","-...","-.-.","-..",".","..-.",
            "--.","....","..",".---","-.-",".-..",
            "--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-",
            "-.--","--.."
        ]
        ans = set()
        for word in words:
            t = []
            for c in word:
                t.append(mp[ord(c) - ord('a')])
            ans.add(''.join(t))
        return len(ans)