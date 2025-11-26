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
i = 0
while i + 2 < len(data_to_list):
    x,y,z = data_to_list[i], data_to_list[i+1], data_to_list[i+2] 
    common = list(set(x) & set(y) & set(z))
    print ( common)
    score += score_board[common[0]]
    i += 3
print(score)
