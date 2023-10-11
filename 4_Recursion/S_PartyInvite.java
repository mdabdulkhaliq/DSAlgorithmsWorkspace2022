/*
    Find the number of ways in which you can invite n people to your party, either in single or pairs
    Logic:
        There are two ways to invite
            Single - Once we invite a member in single, call recursively to decide on n-1 people left
            Pair - To pair a member with other you have (n-1) choices and call recursively for other n-2 left
        Base condition
            If n <=1 there is only 1 way to invite
*/
public class S_PartyInvite {
    public static void main(String[] args) {
        int n = 4;
        int ways = inviteForParty(n);
        System.out.println(ways);
    }
    
    public static int inviteForParty(int n){

        if(n <= 1){
            return 1;
        }

        int singleInvite = inviteForParty(n-1);

        int pairInvite = (n-1) * inviteForParty(n-2);

        return singleInvite + pairInvite;
    }
}