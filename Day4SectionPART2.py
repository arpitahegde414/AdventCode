import re
my_file = open("Day4Input.txt")
data = my_file.read()
data_to_list = data.split("\n")
count = 0
for i in data_to_list:
    l = re.split(r'[,-]+',i)
    range1 = set(range(int(l[0]),int(l[1])+1))
    range2 = set(range(int(l[2]),int(l[3])+1))
    common = list(range1.intersection(range2))
    if len(common)>0:
        count+=1
print (count)