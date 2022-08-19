
import re

from pathlib import Path



def search_with_regex(file_path):
    """
    finds all processes with 4-digit PID using regex

    :param file_path:
    :return: all processes with 4-digit PID
    """
    text_file=str(Path(__file__).parent / file_path)
    processes_list=[]
    with open(text_file, "r") as file:
        for line in file:
            if bool(re.search("[^a-z]\s+([0-9]{4})\s+", line)):
                processes_list.append(line)

          
    return processes_list

