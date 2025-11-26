def find_result(fileName):
    valid_passwords = 0
    try:
        with open(fileName, 'r') as file:
            for line in file:
                line = line.replace(":","")
                line_items = line.split(" ")
                occurence = line_items[0]
                character = line_items[1]
                password = line_items[2]
                minO, maxO = map(int, occurence.split("-"))
                if minO <= password.count(character) <= maxO:
                    valid_passwords+=1
    except FileNotFoundError:
        print(f"Error: The file '{fileName}' was not found.")
    except ValueError as e:
         print(f"Error converting data to integer: {e}. Check file format.")
         return None
    return valid_passwords
print(find_result("I:/AdventCode/passwordPolicyInput.txt"))