intList = []
# number of elements as input
intnumofElements = int(input("Enter number of the elements : "))
sum = 0
# iterating till the range
for i in range(0, intnumofElements):
    intElements = int(input())
    # adding the element
    intList.append(intElements)
print('Elements in the Lists are:',intList)
for number in intList:
    sum += int(number)
print('The sum of Elements in the List are :', sum)