my_file = open("Day2Input.txt")
data = my_file.read()
data_to_list = data.split("\n")
score = 0
for i in data_to_list:
    x = i.split()
    #loose
    if x[1] == "X":
		#opponent has choosen rock, we have to choose sissors to loose
        if x[0] == "A":
            score+=3
        elif x[0] == "B":
			#opponent has choosen paper, we have to choose rock to loose
            score+=1
        elif x[0] == "C":
			#opponent has choosen sissors, we have to choose paper to loose
            score+=2
	#draw
    elif x[1] == "Y":
        if x[0] == "A":
			#opponent has choosen rock, we have to choose rock to draw
            score+=4
        elif x[0] == "B":
			#opponent has choosen paper, we have to choose paper to draw
            score+=5
        elif x[0] == "C":
			#opponent has choosen sissors, we have to choose sisors to draw
            score+=6
	#win
    elif x[1] == "Z":
        if x[0] == "A":
			#opponent has choosen rock, we have to choose paper to win
            score+=8
        elif x[0] == "B":
			#opponent has choosen paper, we have to choose sissors to win
            score+=9
        elif x[0] == "C":
			#opponent has choosen sissors, we have to choose rock to win
            score+=7
    
print(score)