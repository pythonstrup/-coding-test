N = int(input())
dp = [0] * (N+1)
for i in range(1, N+1):
    dp[i] = i
    for j in range(1, int(i**0.5)+1):
        dp[i] = min(dp[i], dp[i-j**2]+1)
print(dp[N])

##
##
## 다른 풀이
n = int(input())
 
dp = [i for i in range (n+1)]
 
for i in range(1, n+1):
    for j in range(1, i):
        if (j * j) > i:
            break
        if dp[i] > dp[i - j * j] + 1:
            dp[i] = dp[i - j * j] + 1
 
print(dp[n])      