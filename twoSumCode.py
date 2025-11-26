def find_sum(fileName):
    int_list = []
    sum = 2020
    preMap = {}
    try:
        with open(fileName, 'r') as file:
            for line in file:
                integer = int(line.strip())
                if integer in preMap:
                    #found the sum, return the result
                    return integer * preMap[integer]
                else:
                    preMap[2020 - integer] = integer                
    except FileNotFoundError:
        print(f"Error: The file '{fileName}' was not found.")
    except ValueError as e:
        print(f"Error converting data to integer: {e}. Check file format.")
        return None
    print(f"Didnt get two sum")
    return 0


print(find_sum("I:/AdventCode/TwoSumInput.txt"))