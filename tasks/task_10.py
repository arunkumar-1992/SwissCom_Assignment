import time


def countdown(description, n):
    while n > 0:
        print((description + " -> {}\n").format(n))
        n -= 1
        time.sleep(1)


def spawn_threads(count):
    """
    Spawns given number of threads, each thread starting a countdown
    :param count threads
    """
    
    countdown("starting a countdown ",count)


spawn_threads(4)