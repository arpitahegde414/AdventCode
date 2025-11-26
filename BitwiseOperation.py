def find_result(fileName):
    gamma = ""
    epsilon = ""
    bit_list = []
    try:
        with open(fileName, 'r') as file:
            for line in file:
                bit_list.append(line.strip())     
    except FileNotFoundError:
        print(f"Error: The file '{fileName}' was not found.")
    except ValueError as e:
         print(f"Error converting data to integer: {e}. Check file format.")
         return None
    
    for i in range(len(bit_list[0])):
        bits = [bit[i] for bit in bit_list]
        ones_count = bits.count("1")
        zeroes_count = bits.count("0")
        gamma += "1" if ones_count> zeroes_count else "0"
        epsilon += "0" if ones_count>zeroes_count else "1"
    
    return int(gamma, 2) * int(epsilon, 2)

print(find_result("I:/AdventCode/BitwiseInput.txt"))