from abc import ABC, abstractmethod

class Employee(ABC):
    def __init__(self, name, employee_id):
        self._name = name
        self._employee_id = employee_id

    def get_name(self):
        return self._name

    def get_employee_id(self):
        return self._employee_id

    @abstractmethod
    def calculate_pay(self):
        pass