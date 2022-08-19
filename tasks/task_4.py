""" Write a decorator who logs the name of the called function . """



def decorative(func):
    def inner_method(task):
        Logger.log(func.__name__)
        func(task)
    return inner_method


@decorative
def a_method(task):
    Logger.log("do something with {}".format(task))


class Logger:

    logs = []

    @staticmethod
    def log(statement):
        Logger.logs.append(statement)