from ast import Lambda


def head_above_avg(args):
    """
    unpacks head (first element) and tail (rest of numbers) and answers if head is above average of tail sequence

    :param args:
    :return: true if head above average
    """
    head, *tail=args
    tail_avg=sum(tail)/len(tail)
    return True if head > tail_avg else False


def unpack_name_and_year(record):
    """
    unpacks values from record - e.g. record = ('ACME', 50, 123.45, (12, 18, 2012)) - and throws not needed values away

    :param record:
    :return: tuple containing name and year
    """ 
    name,*_,(*_,year)=record
    return (name,year)

