def minimumMoney(transactions: List[List[int]]) -> int:
    loss = 0
    for a, b in transactions:
        if a > b:
            loss += a - b
    earn_mx_cost = loss_mx_back = 0
    for a, b in transactions:
        if a < b:
            earn_mx_cost = max(earn_mx_cost, a)
        else:
            loss_mx_back = max(loss_mx_back, b)
    return loss + max(loss_mx_back, earn_mx_cost)