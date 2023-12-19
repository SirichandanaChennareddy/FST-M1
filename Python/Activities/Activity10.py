# Given a tuple of numbers, iterate through it and print only those numbers which are divisible by 5
intList = []
# number of elements as input
intnumofElements = int(input("Enter the umber of elements : "))
sum = 0
# iterating till the range
for i in range(0, intnumofElements):
    intElements = int(input())
    # adding the element
    intList.append(intElements)

# Given tuple
num_tuple = tuple(intList)
print("Given list is ", num_tuple)

# Print elements that are divisible by 5
print("Elements that are divisible by 5:")
for num in num_tuple:
    if (num % 5 == 0):
        print(num)