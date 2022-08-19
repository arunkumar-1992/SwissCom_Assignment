import unittest
import os
import datetime

from tasks.task_1 import create_tree, print_tree
from tasks.task_2 import head_above_avg, unpack_name_and_year
from tasks.task_3 import strip_ends, strip_chars
from tasks.task_4 import a_method, Logger

from tasks.task_10 import spawn_threads
from tasks.task_12 import search_with_regex

from tasks.task_16 import bubble_sort



ROOT = "ROOT"

FILE_PATH = "proc_dump.txt"


class VerifyTasks(unittest.TestCase):

    def test_task_1(self):
        print_tree(8)
        tree = create_tree(5)
        self.assertEqual("    *    ", tree[0])
        self.assertEqual("   ***   ", tree[1])
        self.assertEqual("  *****  ", tree[2])
        self.assertEqual(" ******* ", tree[3])
        self.assertEqual("*********", tree[4])

    def test_task_2(self):
        self.assertTrue(head_above_avg((10, 9, 8, 9, 5, 11)))
        self.assertFalse(head_above_avg((8, 9, 8, 9, 5, 11)))
        self.assertFalse(head_above_avg([10, 9, 8, 12, 10, 11]))

        self.assertEqual(('ACME', 2012), unpack_name_and_year(('ACME', 50, 123.45, (12, 18, 2012))))

    def test_task_3(self):
        arr = strip_ends([1, 3, 5, 7, 9])
        self.assertEqual([3, 5 ,7], arr)

        self.assertEqual("Dsitki ikihrTs", strip_chars("Das ist kein wirklicher Test"))

    def test_task_4(self):
        a_method("a task")
        self.assertEqual(len(Logger.logs), 2)
        self.assertTrue("a_method" in Logger.logs[0])
        self.assertEqual("do something with a task", Logger.logs[1])

    def test_task_10(self):
        spawn_threads(4)

    def test_task_12(self):
        matches = search_with_regex(FILE_PATH)

        self.assertEqual(27, len(matches))
        self.assertEqual(
            'pi        1745  1726  0 19:16 ?        00:00:00 /usr/lib/chromium-browser/chromium-browser --type=zygote --ppapi-flash-path=/usr/lib\n',
            matches[1])

    def test_task_16(self):
        arr = [64, 34, 25, 12, 22, 11, 90]
        arr_before_str = str(arr)
        arr_sorted = sorted(arr)
        arr_sorted_str = str(arr_sorted)
        bubble_sort(arr)
        arr_bubble_sorted_str = str(arr)

        self.assertNotEqual(arr_before_str, arr_bubble_sorted_str)
        self.assertEqual(arr_sorted_str, arr_bubble_sorted_str)


if __name__ == '__main__':
    unittest.main()
