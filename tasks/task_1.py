def create_tree(height):
    """
    Create a list of strings which can be printed as a tree as shown below

       *
      ***
     *****
    *******
   *********
  ***********
 *************
***************

    :param height of the tree
    :return: list of strings to be printed
    """
    j = 0
    list=[]

    for i in range(1, height+1):
        pattern=""
        
        for left_space in range(1, (height-i)+1):
            pattern=" "+pattern
       
        while j!=((2*i)-1):
            pattern=pattern+"*"+""
            j += 1
        
        for right_space in range(1, (height-i)+1):
            pattern=pattern+" "
        j = 0
        list.append(pattern)
    return list


def print_tree(height):
    for line in create_tree(height):
        print("".join(line))