import re
my_file = open("Day5InputPart1.txt")
data = my_file.read()
data_to_list = data.split("\n")
count = 0
stack = [['L','C','G','M','Q'],['G','H','F','T','C','L','D','R'],['R','W','T','M','N','F','J','V'],['P','Q','V','D','F'
,'J'],['T','B','L','S','M','F','N'],['P','D','C','H','V','N','R'],['T','C','H'],['P','H','N','Z','V','J','S','G'],
['G','H','F','Z']]
for a in range(len(stack)):
    stack[a].reverse()
for i in data_to_list:
    l = re.split(r'[move from to]+',i)
    #number of pops and append
    for j in range(int(l[1])):
        stack[int(l[3])-1].append(stack[int(l[2])-1].pop())
        
print(stack)

#VCTFTJQCG