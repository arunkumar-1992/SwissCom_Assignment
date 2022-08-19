from ast import Slice


def strip_ends(arr):
    """

    :param arr:
    :return: Sliced list containing all elements except the first and last element
    """
    list=slice(arr[0],len(arr)-1)
    return arr[list]

def strip_chars(string):
    """

    :param string:
    :return: new string containing every second character from given string
    """
    
    return string[::2]