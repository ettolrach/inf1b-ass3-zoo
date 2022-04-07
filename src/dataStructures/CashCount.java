package dataStructures;

import java.util.ArrayList;

public class CashCount implements ICashCount {
    private int twentyPounds;
    private int tenPounds;
    private int fivePounds;
    private int twoPounds;
    private int onePound;
    private int fiftyPence;
    private int twentyPence;
    private int tenPence;

    public CashCount() {
        this.twentyPounds = 0;
        this.tenPounds = 0;
        this.fivePounds = 0;
        this.twoPounds = 0;
        this.onePound = 0;
        this.fiftyPence = 0;
        this.twentyPence = 0;
        this.tenPence = 0;
    }

    public void setNrNotes_20pounds(int noteCount) {
        this.twentyPounds = noteCount;
    }
    public void setNrNotes_10pounds(int noteCount) {
        this.tenPounds = noteCount;
    }
    public void setNrNotes_5pounds(int noteCount) {
        this.fivePounds = noteCount;
    }
    public void setNrCoins_2pounds(int coinCount) {
        this.twoPounds = coinCount;
    }
    public void setNrCoins_1pound(int coinCount) {
        this.onePound = coinCount;
    }
    public void setNrCoins_50p(int coinCount) {
        this.fiftyPence = coinCount;
    }
    public void setNrCoins_20p(int coinCount) {
        this.twentyPence = coinCount;
    }
    public void setNrCoins_10p(int coinCount) {
        this.tenPence = coinCount;
    }
    public int getNrNotes_20pounds() {
        return twentyPounds;
    }
    public int getNrNotes_10pounds() {
        return tenPounds;
    }
    public int getNrNotes_5pounds() {
        return fivePounds;
    }
    public int getNrCoins_2pounds() {
        return twoPounds;
    }
    public int getNrCoins_1pound() {
        return onePound;
    }
    public int getNrCoins_50p() {
        return fiftyPence;
    }
    public int getNrCoins_20p() {
        return twentyPence;
    }
    public int getNrCoins_10p() {
        return tenPence;
    }

    public void depositChange(ICashCount newChange) {
        this.twentyPounds += newChange.getNrNotes_20pounds();
        this.tenPounds += newChange.getNrNotes_10pounds();
        this.fivePounds += newChange.getNrNotes_5pounds();
        this.twoPounds += newChange.getNrCoins_2pounds();
        this.onePound += newChange.getNrCoins_1pound();
        this.fiftyPence += newChange.getNrCoins_50p();
        this.twentyPence += newChange.getNrCoins_20p();
        this.tenPence += newChange.getNrCoins_10p();
    }
    private int iteratorGetter(int i) {
        switch (i) {
            case 0:
                return this.twentyPounds;
            case 1:
                return this.tenPounds;
            case 2:
                return this.fivePounds;
            case 3:
                return this.twoPounds;
            case 4:
                return this.onePound;
            case 5:
                return this.fiftyPence;
            case 6:
                return this.twentyPence;
            case 7:
                return this.tenPence;
            default:
                return 0;
        }
    }
    private void iteratorChanger(int i, int amount) {
        switch (i) {
            case 0:
                this.twentyPounds += amount;
                break;
            case 1:
                this.tenPounds += amount;
                break;
            case 2:
                this.fivePounds += amount;
                break;
            case 3:
                this.twoPounds += amount;
                break;
            case 4:
                this.onePound += amount;
                break;
            case 5:
                this.fiftyPence += amount;
                break;
            case 6:
                this.twentyPence += amount;
                break;
            case 7:
                this.tenPence += amount;
                break;
        }
    }
    public boolean withdrawChange(int toWithdraw) {
        boolean toReturn = false;
        int tempAmount;
        int[] coinsToChange = new int[8];
        int[] denominations = {2000, 1000, 500, 200, 100, 50, 20, 10};
        for (int i = 0; i < 8; i++) {
            tempAmount = toWithdraw / denominations[i];
            if (this.iteratorGetter(i) < tempAmount) {
                continue;
            }
            coinsToChange[i] = tempAmount;
            toWithdraw -= tempAmount * denominations[i];
        }
        if (toWithdraw == 0) {
            for (int i = 0; i < 8; i++) {
                this.iteratorChanger(i, coinsToChange[i]);
            }
            return true;
        }
        else {
            return false;
        }
    }

    public static CashCount safeCashConversion(ICashCount toConvert) {
        CashCount toReturn = new CashCount();
        toReturn.setNrNotes_20pounds(toConvert.getNrNotes_20pounds());
        toReturn.setNrNotes_10pounds(toConvert.getNrNotes_10pounds());
        toReturn.setNrNotes_5pounds(toConvert.getNrNotes_5pounds());
        toReturn.setNrCoins_2pounds(toConvert.getNrCoins_2pounds());
        toReturn.setNrCoins_2pounds(toConvert.getNrCoins_1pound());
        toReturn.setNrCoins_50p(toConvert.getNrCoins_50p());
        toReturn.setNrCoins_20p(toConvert.getNrCoins_20p());
        toReturn.setNrCoins_10p(toConvert.getNrCoins_10p());
        return toReturn;
    }

    public static int changeToCash(ICashCount change) {
        return 2000 * change.getNrNotes_20pounds()
                + 1000 * change.getNrNotes_10pounds()
                + 500 * change.getNrNotes_5pounds()
                + 200 * change.getNrCoins_2pounds()
                + 100 * change.getNrCoins_1pound()
                + 50 * change.getNrCoins_50p()
                + 20 * change.getNrCoins_20p()
                + 10 * change.getNrCoins_10p();
    }
    public static ICashCount cashToChange(int cash) {
        ICashCount cashCountToReturn = new CashCount();
        int tempAmount;
        int[] denominations = {2000, 1000, 500, 200, 100, 50, 20, 10};
        ArrayList<Integer> noOfCoins = new ArrayList<>();
        for (int denomination : denominations) {
            tempAmount = cash / denomination;
            noOfCoins.add(tempAmount);
            cash -= tempAmount * denomination;
        }
        cashCountToReturn.setNrNotes_20pounds(noOfCoins.get(0));
        cashCountToReturn.setNrNotes_10pounds(noOfCoins.get(1));
        cashCountToReturn.setNrNotes_5pounds(noOfCoins.get(2));
        cashCountToReturn.setNrCoins_2pounds(noOfCoins.get(3));
        cashCountToReturn.setNrCoins_1pound(noOfCoins.get(4));
        cashCountToReturn.setNrCoins_50p(noOfCoins.get(5));
        cashCountToReturn.setNrCoins_20p(noOfCoins.get(6));
        cashCountToReturn.setNrCoins_10p(noOfCoins.get(7));
        return cashCountToReturn;
    }
}
