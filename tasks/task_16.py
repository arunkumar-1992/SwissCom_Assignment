def bubble_sort(arr):
    """
    Sorts the given array using bubble sort algorithm
    """
    total = len( arr )

    for i in range( total - 1 ) :
        flag = 0

        for j in range(total- 1) :
            
            if arr[j] > arr[j + 1] : 
                tmp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = tmp
                flag = 1

        if flag == 0:
            break

    return arr

