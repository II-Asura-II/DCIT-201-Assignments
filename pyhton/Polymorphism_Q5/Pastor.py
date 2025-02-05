import ChurchMember

class Pastor(ChurchMember.ChurchMember):
    def __init__(self, name, member_id, tithe):
        super().__init__(name, member_id)
        self.tithe = tithe

    def get_contribution(self):
        return self.tithe

    def give_offering(self, amount, message):
        return f"Offering given GHS {amount:.2f}. Note: {message}"