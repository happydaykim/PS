import sys
input = sys.stdin.readline

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

N, M = map(int, input().split())

truth_input = list(map(int, input().split()))
num_truth = truth_input[0]
truth_people = truth_input[1:]

# Union Find 배열
parent = list(range(N+1))

parties = []
for _ in range(M):
    party_info = list(map(int, input().split()))
    party_len = party_info[0]
    party_people = party_info[1:]
    parties.append(party_people)

if num_truth > 1:
    for i in range(num_truth - 1):
        union(truth_people[i], truth_people[i+1])

# Party 내 사람들을 Union
for party in parties:
    if len(party) > 1:
        for i in range(len(party) - 1):
            union(party[i], party[i+1])

cnt = 0
if num_truth == 0:
    print(M)
else:
    # truth 사람들은 다 Union 했기 때문에 truth_people[0] 만 확인
    truth_root = find(truth_people[0])
    for party in parties:
        possible = True
        for person in party:
            if find(person) == truth_root:
                possible = False
                break
        if possible:
            cnt += 1
    print(cnt)