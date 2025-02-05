import ChurchMember
import Pastor

def main():
    church_member = ChurchMember.ChurchMember("John Doe", "M001")
    print("Church Member")
    print("Contribution:", church_member.get_contribution())
    print(church_member.give_offering(100))
    
    pastor = Pastor.Pastor("Rev. Smith", "P001", 500)
    print("\nPastor")
    print("Contribution:", pastor.get_contribution())
    print(pastor.give_offering(200, "For the church renovation"))

main()