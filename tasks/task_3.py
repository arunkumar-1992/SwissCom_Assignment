from ast import Slice


def strip_ends(arr):
    """

    :param arr:
    :return: Sliced list containing all elements except the first and last element
    """
    #arr[slice(arr[0],len(arr)-1)]
   
    return [item for item in arr if (item is not  arr[0]) and  (item is not arr[len(arr)-1]) ]

def strip_chars(string):
    """

    :param string:
    :return: new string containing every second character from given string
    """
    
    return string[::2]