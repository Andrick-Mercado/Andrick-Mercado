import sys
import matplotlib.pyplot as plt
import numpy as np
import copy
import time


def insertion_sort(array):
    for i in range(len(array)):
        key = array[i]
        j = i - 1
        while j >= 0 and array[j] > key:
            array[j + 1] = array[j]
            j = j - 1
        array[j + 1] = key
    return array


def merge_sort(array, start, end):
    if start < end:
        middle = start + (end - start) // 2
        merge_sort(array, start, middle)
        merge_sort(array, middle + 1, end)
        merge(array, start, middle, end)


def merge(array, start, middle, end):
    first_sub_array = middle - start + 1
    second_sub_array = end - middle

    left_array = [0] * (first_sub_array)
    right_array = [0] * (second_sub_array)

    for i in range(len(left_array)):
        left_array[i] = array[start + i]
    for i in range(len(right_array)):
        right_array[i] = array[middle + i + 1]

    pos_left_array = 0
    pos_right_array = 0
    pos_merge_array = start

    while pos_left_array < first_sub_array and pos_right_array < second_sub_array:
        if left_array[pos_left_array] <= right_array[pos_right_array]:
            array[pos_merge_array] = left_array[pos_left_array]
            pos_left_array += 1
        else:
            array[pos_merge_array] = right_array[pos_right_array]
            pos_right_array += 1
        pos_merge_array += 1

    while pos_left_array < first_sub_array:
        array[pos_merge_array] = left_array[pos_left_array]
        pos_left_array += 1
        pos_merge_array += 1

    while pos_right_array < second_sub_array:
        array[pos_merge_array] = right_array[pos_right_array]
        pos_right_array += 1
        pos_merge_array += 1


def display_plots(size_of_array):
    n = np.arange(1.1, size_of_array ** 2)  # , 0.1)
    y1 = [size_of_array * (nn * np.log(nn)) for nn in n]
    y2 = [(nn ** 2) for nn in n]
    temp = np.argwhere(np.diff(np.sign(np.array(y1) - np.array(y2)))).flatten()
    #print("intercept: ", temp) #uncoment this to see x-intercept value
    if temp.size != 0:
        if temp[0] != 0:
            tmp = temp[0]
        else:
            tmp = temp[1]
        fig, axs = plt.subplots(2, 2)

        x = np.arange(1.1, size_of_array, 0.1)
        y = [_ ** 2 for _ in x]
        axs[0, 0].plot(x, y, label='Insertion')
        y = [size_of_array * (_ * np.log(_)) for _ in x]
        axs[0, 0].plot(x, y, label='Merge')
        axs[0, 0].set_xlabel('n')
        axs[0, 0].set_ylabel('$T$')
        axs[0, 0].grid(alpha=0.618)
        axs[0, 0].set_title('Insertion and Merge Sort for n')
        axs[0, 0].legend(loc="upper left")

        x = n = np.arange(1.1, tmp + 5, 0.1)
        y = [_ ** 2 for _ in x]
        axs[0, 1].plot(x, y, label='Insertion')
        y = [size_of_array * (_ * np.log(_)) for _ in x]
        axs[0, 1].plot(x, y, label='Merge')
        axs[0, 1].set_xlabel('n')
        axs[0, 1].set_ylabel('$T$')
        axs[0, 1].grid(alpha=0.618)
        axs[0, 1].set_title('Insertion Sort < Merge Sort')
        axs[0, 1].legend(loc="upper left")

        if tmp < 10:
            tmp2 = 2
        else:
            tmp2 = 10
        x = np.arange(tmp - tmp2, tmp + tmp2, 0.1)
        y = [_ ** 2 for _ in x]
        axs[1, 0].plot(x, y, label='Insertion')
        y = [size_of_array * (_ * np.log(_)) for _ in x]
        axs[1, 0].plot(x, y, label='Merge')
        axs[1, 0].set_xlabel('n')
        axs[1, 0].set_ylabel('$T$')
        axs[1, 0].grid(alpha=0.618)
        axs[1, 0].set_title('Insertion Sort = Merge Sort')
        axs[1, 0].legend(loc="upper left")

        x = np.arange(1.1, tmp * 2, 0.1)
        y = [_ ** 2 for _ in x]
        axs[1, 1].plot(x, y, label='Insertion')
        y = [size_of_array * (_ * np.log(_)) for _ in x]
        axs[1, 1].plot(x, y, label='Merge')
        axs[1, 1].set_xlabel('n')
        axs[1, 1].set_ylabel('$T$')
        axs[1, 1].grid(alpha=0.618)
        axs[1, 1].set_title('Insertion Sort > Merge Sort')
        axs[1, 1].legend(loc="upper left")

        fig.tight_layout()
        plt.show()
    else:
        print("error no valid intercept will display generic graph")
        n = np.arange(1.1, 2000)
        y1 = [size_of_array * (nn * np.log(nn)) for nn in n]
        y2 = [(nn ** 2) for nn in n]
        plt.plot(n, y1, label="Merge")
        plt.plot(n, y2, label='Insertion')
        plt.legend(loc="upper left")
        plt.title("No Intercept")
        plt.xlabel("n")
        plt.ylabel("$T$")
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
    random_array_of_ints = np.random.randint(1, 1001, size_of_array)
    copy_of_array = copy.deepcopy(random_array_of_ints)
    print("Array: ", random_array_of_ints)

    # here we print sorted array
    start = time.time()
    insertion_sort(random_array_of_ints)
    end = time.time()
    print("Sorting using Insertion Sort: ", random_array_of_ints)
    print("Elapsed time: ", (end - start), "seconds")

    random_array_of_ints = copy_of_array

    start = time.time()
    merge_sort(random_array_of_ints, 0, size_of_array - 1)
    end = time.time()

    print("Sorting using Merge Sort: ", random_array_of_ints)
    print("Elapsed time: ", (end - start), "seconds")

    #will plot for graphs
    display_plots(size_of_array)

if __name__ == "__main__":
    main()
