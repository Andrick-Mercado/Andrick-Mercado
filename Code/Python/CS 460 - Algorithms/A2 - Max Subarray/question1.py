import matplotlib.pyplot as plt
import numpy as np
import copy
import time

def brute_force_find_max(array):
    max_profit = 0
    max_left = 0
    max_right = 0

    for i in range(len(array)):
        profit = 0
        for j in range(i,  len(array)-1):
            profit = profit + array[j]
            if profit>max_profit:
                max_left = i
                max_right = j
                max_profit = profit

    return max_left, max_right, max_profit


def find_max_crossing_subarray(array, low, mid, high):
    left_sum = -1500
    sum_subarray = 0
    max_left = 0
    max_right = 0
    for i in range(mid, low-1,-1):
        sum_subarray = sum_subarray + array[i]
        if sum_subarray > left_sum:
            left_sum = sum_subarray
            max_left = i
    right_sum = -1500
    sum_subarray = 0
    for i in range(mid+1, high+1):
        sum_subarray = sum_subarray + array[i]
        if sum_subarray > right_sum:
            right_sum = sum_subarray
            max_right = i
    return max_left, max_right, (left_sum + right_sum)



def find_maximum_subarray(array, low, high):
    if low == high:
        return low, high, 0
    else:
        mid = (low+high)//2
    left_low, left_high, left_sum = find_maximum_subarray(array, low, mid)
    right_low, right_high, right_sum = find_maximum_subarray(array, mid+1, high)
    cross_low, cross_high, cross_sum = find_max_crossing_subarray(array, low, mid, high)
    if left_sum >= right_sum and left_sum >= cross_sum:
        return left_low, left_high, left_sum
    elif right_sum >= left_sum and right_sum >= cross_sum:
        return right_low, right_high, right_sum
    else:
        return cross_low, cross_high, cross_sum


def display_plots( size, brute_time, recursive_time):
    incrementer = brute_time / size
    array_of_time_brute = [incrementer * x for x in range(size)]
    n = np.arange(0, size)
    plt.plot(n, array_of_time_brute,label='$O(n^2)$')


    incrementer = recursive_time / size
    array_of_time_recursive = [incrementer * x for x in range(size)]
    n = np.arange(0, size)
    plt.plot(n, array_of_time_recursive, label='$O(nlgn)$')

    temp = np.argwhere(np.diff(np.sign(np.array(array_of_time_brute) - np.array(array_of_time_recursive)))).flatten()
    print("the intercept is at times: ", temp, " seconds.")

    plt.xlabel('n')
    plt.ylabel('seconds')
    plt.title('Brute Force vs Recursive')
    plt.grid('on')
    plt.legend()
    plt.show()


def main():
    size_of_array = -1

    #makes sure input is positive int
    while size_of_array < 1:
        size_of_array = int(input("Enter the size of the array to be filled: "))
        if size_of_array < 1:
            print("please enter a positive number!")

    # display info to screen
    print("your number was: ", size_of_array)
    random_array_of_ints = np.random.randint(-999, 1001, size_of_array)
    copy_of_array = copy.deepcopy(random_array_of_ints)
    #print("Array: ", random_array_of_ints)

        # here we print sorted array
    #max subarray brute force
    start_brute = time.time()
    max_left, max_right, max_profit = brute_force_find_max(random_array_of_ints)
    end_brute = time.time()
    print("BRUTE FORCE: max left index: ", max_left, "max right index", max_right, "max profit value: ",max_profit)

    random_array_of_ints = copy_of_array

    #max subarray recursive
    start_recursive = time.time()
    max_left, max_right, max_profit = find_maximum_subarray(random_array_of_ints, 0, size_of_array-1)
    end_recursive = time.time()
    print("RECURSIVE: max left index: ", max_left, "max right index", max_right, "max profit value: ", max_profit)

    display_plots(size_of_array, (end_brute-start_brute), (end_recursive-start_recursive))

if __name__ == "__main__":
    main()
