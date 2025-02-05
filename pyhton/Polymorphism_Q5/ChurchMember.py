class ChurchMember():
    def __init__(self, name, member_id):
        self.name = name
        self.member_id = member_id

    def get_contribution(self):
        return 0.0
    
    def give_offering(self, amount):
        return f"Offering given GHS {amount:.2f}"