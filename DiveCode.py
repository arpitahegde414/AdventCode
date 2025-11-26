def find_result(fileName):
    positionX = 0
    positionY = 0
    actions = ["forward","up","down"]
    try:
        with open(fileName, 'r') as file:
            for line in file:
                action_points = line.split()
                action = action_points[0]
                points = action_points[1]
                match action:
                    case "forward":
                        positionX+=int(points)
                    case "up":
                        positionY-=int(points)
                    case "down":
                        positionY+=int(points)
                    case _:
                        print(f"Nothing done")
    except FileNotFoundError:
        print(f"Error: The file '{fileName}' was not found.")
    except ValueError as e:
        print(f"Error converting data to integer: {e}. Check file format.")
        return None
    return positionX * positionY

print(find_result("I:/AdventCode/DiveInput.txt"))