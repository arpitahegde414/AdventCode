rules = {}
def result(fileName):
    try:
        with open(fileName, 'r') as file:
            for line in file:
                keyBag, valueBags = line.split(" bags contain ", maxsplit=1)
                if "no other bags" in valueBags:
                    rules[keyBag] = []
                else:
                    #valueBagsList = [ vB.replace(" bags, ","").replace(" bags.","").replace(" bag, ","").replace(" bag.","") for vB in valueBags.split(", ")]
                    #rules[keyBag] = valueBagsList
                    valueBagsList = []
                    for vB in valueBags.split(", "):
                        vB = vB.strip()
                        parts = vB.split(" ", 1)
                        color = parts[1].replace(" bags","").replace(".","").replace(" bag","")
                        valueBagsList.append(color)
                    rules[keyBag] = valueBagsList
                #.replace(" bags, ", "").replace(" bags.","").replace(" bag, ").replace
    except FileNotFoundError:
        print(f"Error: The file '{fileName}' was not found.")
    except ValueError as e:
         print(f"Error converting data to integer: {e}. Check file format.")
         return None
    return sum(can_contain_golden_bag(bag) for bag in rules if bag != "shiny gold")


def can_contain_golden_bag(bag):
    return "shiny gold" in rules[bag] or any(can_contain_golden_bag(b) for b in rules[bag])

    
print(result("I:/AdventCode/bagsMap.txt"))