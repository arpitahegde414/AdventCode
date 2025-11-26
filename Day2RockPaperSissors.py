my_file = open("Day2Input.txt")
data = my_file.read()
data_to_list = data.split("\n")
score = 0
for i in data_to_list:
    x = i.split()
    #draw
    if (x[0] == "A" and x[1] == "X"):
        score =score+4
    elif (x[0]=="B" and x[1]=="Y"):
        score=score+5
    elif(x[0] =="C" and x[1]=="Z"):
        score=score+6
    #won
    elif x[0] =="A" and x[1] =="Y":
        score =score+8
    elif x[0] =="B" and x[1] =="Z":
        score =score+9
    elif x[0] =="C" and x[1] =="X":
        score =score+7
    #loose
    elif x[0] =="A" and x[1] =="Z":
        score =score+3
    elif x[0] =="B" and x[1] =="X":
        score =score+1
    elif x[0] =="C" and x[1] =="Y":
        score =score+2
        
print(score)