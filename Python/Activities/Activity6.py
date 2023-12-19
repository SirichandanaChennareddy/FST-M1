# Generating Right Angle Triangle Pattern Using Stars
row = int(input('Enter number of rows required: '))

for i in range(row):
    print(str(i) * i)

for i in range(row):
    for j in range(i+1):
        print('*',end=' ')
    print()

# Hollow Right Angle Triangle Pattern Using Stars
#row = int(input('Enter number of rows required: '))

for i in range(row):
    for j in range(i+1):
        if j==0 or j==i or i==row-1:
            print('*',end=" ")
        else:
            print(" ", end=" ")
    print()

# Generating Pyramid Pattern Using Stars

#row = int(input('Enter number of rows required: '))

for i in range(row):
    for j in range(row-i):
        print(' ', end='') # printing space required and staying in same line

    for j in range(2*i+1):
        print('*',end='') # printing * and staying in same line
    print() # printing new line


# Generating Hollow Pyramid Pattern Using Stars

#row = int(input('Enter number of rows required: '))

for i in range(row):
    for j in range(row-i):
        print(' ', end='') # printing space required and staying in same line

    for j in range(2*i+1):
        if j==0 or j==2*i or i==row-1:
            print('*',end='')
        else:
            print(' ', end='')
    print() # printing new line

# Generating Inverse Pyramid Pattern Using Stars

#row = int(input('Enter number of rows required: '))

for i in range(row,0,-1):
    for j in range(row-i):
        print(' ', end='') # printing space and staying in same line

    for j in range(2*i-1):
        print('*',end='') # printing * and staying in same line
print()
# Reading number of rows
#row = int(input('Enter how many lines? '))

# Generating pattern
for i in range(1,row+1):
    # for space
    for j in range(1, row+1-i):
        print(' ', end='')

    # for decreasing pattern
    for j in range(i,0,-1):
        print(j, end='')

    # for increasing pattern
    for j in range(2,i+1):
        print(j, end='')

    # Moving to next line
    print()