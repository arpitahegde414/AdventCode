def find_result(fileName):
    total = 0
    currentString = ""
    try:
        with open(fileName, 'r') as file:
            for line in file:
                #if the line is not empty, then keep on appending
                if(line.strip()):
                    currentString+=line.strip()
             
                #if line is empty, means group ended, so count unique letters in the string, append to total and clear the string
                else:
                    print(currentString)
                    total+= len(set(currentString))
                    currentString = ""
            total+= len(set(currentString))
    except FileNotFoundError:
        print(f"Error: The file '{fileName}' was not found.")
    except ValueError as e:
        print(f"Error converting data to integer: {e}. Check file format.")
        return None
    return total

print(find_result("I:/AdventCode/GroupYes.txt"))