import sys
import os

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from Encapsulation_Q1.CommissionEmployee import CommissionEmployee

class BasePlusCommissionEmployee(CommissionEmployee):
    def __init__(self, first_name, last_name, ssn, gross_sales, commission_rate, base_salary):
        super().__init__(first_name, last_name, ssn, gross_sales, commission_rate)
        self.set_base_salary(base_salary)

    def set_base_salary(self, base_salary):
        try:
            self.base_salary = base_salary
            if base_salary < 0:
                raise ValueError
        except ValueError:
            print("Base salary must be greater than 0")

    def get_base_salary(self):
        return self.base_salary

    def earnings(self):
        return self.base_salary + super().earnings()