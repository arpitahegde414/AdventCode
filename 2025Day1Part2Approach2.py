def read_list(fileName):
    op_list = []
    try:
        with open(fileName, 'r') as file:
            for line in file:
                op_list.append(line.strip())
            #print("Length of op list: ")
            #print(len(op_list))
    except FileNotFoundError:
        print(f"Error: The file '{fileName}' was not found.")
    except ValueError as e:
         print(f"Error converting data to integer: {e}. Check file format.")
         return None
    return op_list

def get_result():
    op_list = read_list("I:/AdventCode/2025Day1Part2.txt")
    #op_list = ["L68", "L30", "R48", "L5", "R60","L55","L1","L99","R14","L82"]
    curr_dial = 50
    result = 0
    for op in op_list:
        direction = op[0]
        value = int(op[1:])
        for _ in range(value):
            if direction=='L':
                curr_dial = (curr_dial-1+100)%100
            else:
                curr_dial=(curr_dial+1)%100
            if curr_dial==0:
                result+=1
    return result
    
print(get_result())