class Node:
	def __init__(self, size, name):
		self.name = name
		self.endNode = true
		self.size = size
	def __init__(self,name):
		self.name = name
		self.endNode = false
		self.size = 0
my_file = open("Day7Input.txt")
data = my_file.read()
data_to_list = data.split("\n")
root = Node("\")
