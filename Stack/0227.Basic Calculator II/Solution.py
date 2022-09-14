class Solution:
    def calculate(self, s: str) -> int:
        def cal_num(a, b, cal):
            if cal == "*":
                return a * b
            elif cal == "/":
                return a // b
            elif cal == "+":
                return a + b
            return a - b

        num, cal = deque(), deque()
        idx, n = 0, len(s)
        while idx < n:
            if s[idx] == " ":
                idx += 1
                continue
            elif "0" <= s[idx] <= "9":
                cur = 0
                while idx < n and "0" <= s[idx] <= "9":
                    cur = cur * 10 + int(s[idx])
                    idx += 1
                num.append(cur)
                if cal and (cal[-1] == "*" or cal[-1] == "/"):
                    b, a = num.pop(), num.pop()
                    num.append(cal_num(a, b, cal.pop()))
                continue
            cal.append(s[idx])
            idx += 1
        while cal:
            num.appendleft(cal_num(num.popleft(), num.popleft(), cal.popleft()))
        return num[0]