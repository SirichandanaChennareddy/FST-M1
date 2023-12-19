# creating an empty list
numList = []

# number of elements as input
num = int(input("Enter the number of elements : "))

# iterating till the range
for i in range(0, num):
    value = int(input())
    # adding the element
    numList.append(value)

# Get first element in list
firstElement = numList[0]
# Get last element in list
lastElement = numList[-1]

# Check if first and last element are equal
if firstElement == lastElement:
    print('The first and Last element in the list are same')
else:
    print('The first and Last element in the list are Different')

print('The elements in the List are:', numList)
