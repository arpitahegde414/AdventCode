def file_to_int_list(fileName):
	int_list = []
	try:
		with open(fileName, 'r') as file:
			for line in file:
				int_list.append(int(line.strip()))
	except FileNotFoundError:
		print(f"Error: The file '{fileName}' was not found.")
	except ValueError as e:
		 print(f"Error converting data to integer: {e}. Check file format.")
		 return None
	return int_list

def sonarSweep():
    int_list = file_to_int_list("I:/AdventCode/SonarSweepInput.txt")
    count = sum (b>a for a,b in zip(int_list, int_list[1:]))
    print(count)

sonarSweep()