n = int(input())

array = []
for _ in range(n):
    colors = list(map(str, input()))
    array.append(colors)

maxCount = 0 #최대 사탕 개수를 초기화

# 배열의 행 마다 같은 색의 사탕이 몇개 있는지 계산
def width():
    global  maxCount
    
    for k in range(n):
        countRow = 1 #초기 개수를 1로 초기화
        for l in range(n - 1):
            if array[k][l] == array[k][l + 1]: #만약 같은 열의 사탕의 색이 같다면
                countRow += 1 #사탕 개수 1 증가
                maxCount = max(maxCount,countRow) #증가시킨 값과 최대 사탕개수를 비교하여 큰값을 대입
            else: #만약 같은 열의 사탕 개수가 다르다면
                countRow = 1 #개수를 1로 초기화


# 배열의 열마다 같은 색의 사탕이 몇개 있는지 계산
def height():
    for k in range(n):
        global maxCount
        
        countColumn = 1 #초기 개수를 1로 초기화
        for l in range(n - 1):
            if array[l][k] == array[l + 1][k]: #만약 같은 행의 사탕의 색이 같다면
                countColumn += 1 #사탕 개수를 1개씩 증가시켜주고
                maxCount = max(maxCount,countColumn) #증가시킨 값과 최대 사탕개수를 비교하여 큰값을 대입
            else: #만약 같은 행의 색이 다르다면
                countColumn = 1 #개수를 1로 초기화


for i in range(n):
    for j in range(n - 1):
        # 만약 입력 받은 배열의 행의 원소가 다르다면
        if array[i][j] != array[i][j + 1]:
            array[i][j], array[i][j + 1] = array[i][j + 1], array[i][j]
            width()
            height()
            array[i][j + 1], array[i][j] = array[i][j], array[i][j + 1]
        # 만약 입력 받은 배열의 열의 원소가 다르다면
        if array[j][i] != array[j + 1][i]:
            array[j][i], array[j + 1][i] = array[j + 1][i], array[j][i]
            width()
            height()
            array[j + 1][i], array[j][i] = array[j][i], array[j + 1][i]

print(maxCount) #색이 같은 사탕개수 최대값을 출력

##
##
## 효율성 제일 좋은 풀이
import sys
from collections import deque

N = int(sys.stdin.readline().strip())

mapp = [[0 for col in range(N)] for row in range(N)]
visit = [[False for col in range(N)] for row in range(N)]
result = 0
# 동남
dr = [0, 1]
dc = [1, 0]

for r in range(N):
    line = sys.stdin.readline().strip()
    for c in range(N):
        mapp[r][c] = line[c]

# 최대개수 행 검사
def find_row(row):
    global result
    cnt = 0
    a = ' '
    for c in range(N):
        if(a==mapp[row][c]):
            cnt += 1
        else:
            if(cnt > result):
                result = cnt
            cnt = 1
            a = mapp[row][c]
        if(cnt > result):
            result = cnt
# 최대개수 열 검사
def find_col(col):
    global result
    cnt = 0
    a = ' '
    for r in range(N):
        if(a==mapp[r][col]):
            cnt += 1
        else:
            if(cnt > result):
                result = cnt
            cnt = 1
            a = mapp[r][col]
        if(cnt > result):
            result = cnt
# 초기상태 최대개수 갱신
for r in range(N):
    find_row(r)
for c in range(N):
    find_col(c)

q = deque()
q.appendleft((0,0))

while(len(q) != 0):
    cnt = 0
    cur = q.pop()
    if(visit[cur[0]][cur[1]]):
        continue
    visit[cur[0]][cur[1]] = True
    for i in range(2):
        nr = cur[0] + dr[i]
        nc = cur[1] + dc[i]
        # 범위 안이고 방문하지 않으면 위치 바꿔보기
        if(nr>=0 and nr<N and nc>=0 and nc<N and not visit[nr][nc]):
            q.appendleft((nr, nc))
            if(mapp[cur[0]][cur[1]] == mapp[nr][nc]):
                continue
            origin_1 = mapp[cur[0]][cur[1]]
            origin_2 = mapp[nr][nc]
            mapp[nr][nc] = origin_1
            mapp[cur[0]][cur[1]] = origin_2

            # 좌우교환일때 최대개수 갱신
            if(i == 0):
                find_row(cur[0])
                find_col(cur[1])
                find_col(nc)
            # 상하교환일때 최대개수 갱신
            else:
                find_row(cur[0])
                find_row(nr)
                find_col(cur[1])

            if(result < cnt):
                result = cnt
            # 바꾼위치 원래대로
            mapp[nr][nc] = origin_2
            mapp[cur[0]][cur[1]] = origin_1

print(result)