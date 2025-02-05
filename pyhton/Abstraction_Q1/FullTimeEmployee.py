import Employee

class FullTimeEmployee(Employee.Employee):
    def __init__(self, name, employee_id, salary):
        super().__init__(name, employee_id)
        self._salary = salary

    def get_salary(self):
        return self._salary

    def calculate_pay(self):
        return f"Full Time Employee Pay: GHS {self._salary:.2f}"