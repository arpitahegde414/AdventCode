import re
my_file = open("Day4Input.txt")
data = my_file.read()
data_to_list = data.split("\n")
count = 0
for i in data_to_list:
    l = re.split(r'[,-]+',i)
    range1 = set(range(int(l[0]),int(l[1])+1))
    range2 = set(range(int(l[2]),int(l[3])+1))
    print(l[0],l[1])
    print ("range1: " )
    print ( range1 )
    print(l[2],l[3])
    print ("range2: " )
    print (range2 )
    if range1.issubset(range2) or range2.issubset(range1):
        count += 1
        
print (count)