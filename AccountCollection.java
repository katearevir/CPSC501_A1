import java.util.List;
import java.util.ArrayList;

public class AccountCollection {
    private List<ChequingAccount> cAccs = new ArrayList<ChequingAccount>();
    private List<SavingsAccount> sAccs = new ArrayList<SavingsAccount>();

    public void addChequingAccount(ChequingAccount cAcc){
        cAccs.add(cAcc);
    }

    public void addSavingsAccount(SavingsAccount sAcc){
        sAccs.add(sAcc);
    }

    public ChequingAccount getChequingAccount(Customer c){
        for(int i = 0; i < cAccs.size(); i++)
        {
            if (cAccs.get(i).getAccountHolder().equals(c))
            {
                return cAccs.get(i);
            }
        }
        return null;
    }

    public SavingsAccount getSavingsAccount(Customer c){
        for(int i = 0; i < sAccs.size(); i++)
        {
            if(sAccs.get(i).getAccountHolder() == c)
            {
                return sAccs.get(i);
            }
        }

        return null;
    }
}
