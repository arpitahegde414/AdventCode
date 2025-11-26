from string import ascii_lowercase
from string import ascii_uppercase

s=1
score_board = {}
for c in ascii_lowercase:
	score_board[c] = s
	s+=1
for c in ascii_uppercase:
	score_board[c] = s
	s+=1
my_file = open("Day3Input.txt")
data = my_file.read()
data_to_list = data.split("\n")
score = 0
for i in data_to_list:
    x,y = i[:len(i)//2], i[len(i)//2:]
    common = list(set(x) & set(y))
    score += score_board[common[0]]
print(score)
	