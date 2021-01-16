
from abc import ABCMeta, abstractmethod

# 3.x
class Super(metaclass=ABCMeta):
    @abstractmethod
    def method(self):
# 2.x
class Super:
    __metaclass__ = ABCMeta
    @abstractmethod
    def method(self):

        