package solutions.mobile.infinitie.incgame;

// TODO (TRAVIS): Possibly modularize even further into buy, upgrade, achieve class
public class CookieCore {

    // Cookie Goodness, praise cookie
    private double internalCookieCount;
    private double cookiePerSecond;

    // Clicker related garb
    private int clickerCost = 15;
    private int clickerAmount = 0;
    private double clickerCps = 0;


    // Grandma knows best
    private int grandmaCost = 100;
    private int grandmaAmount = 0;
    private double grandmaCps = 0;

    // Hold your butts, we are going in
    public CookieCore() {
    }

    // cookie total updater
    public void incrementCookie() {
        internalCookieCount += cookiePerSecond;
    }

    // Clicker buy magic
    public void coreBuyClicker() {
        int clickerBaseCost = 15;
        if (internalCookieCount >= clickerCost) {
            clickerAmount += 1;
            internalCookieCount -= clickerCost;
            clickerCost = updateCost(clickerBaseCost, clickerAmount);
            clickerCps += .1;
            calculateCPS();
        }
    }

    public void coreBuyGrandma() {
        int grandmaBaseCost = 100;
        if (internalCookieCount >= grandmaCost) {
            grandmaAmount += 1;
            internalCookieCount -= grandmaCost;
            grandmaCost = updateCost(grandmaBaseCost, grandmaAmount);
            grandmaCps += .5;
            calculateCPS();
        }
    }

    // Will probably end up changed but for now we do it this way
    private void calculateCPS() {
        cookiePerSecond = clickerCps + grandmaCps;
    }

    // item cost jesus function
    private int updateCost(int itemBaseCost, int itemAmount) {
        return (int) (itemBaseCost * (Math.pow(1.15, itemAmount)));

    }

    // Getters and Setters, fuck you
    public double getInternalCookieCount() {
        return internalCookieCount;
    }

    public void setInternalCookieCount(double internalCookieCount) {
        this.internalCookieCount = internalCookieCount;
    }

    public int getClickerCost() {
        return clickerCost;
    }

    public void setClickerCost(int clickerCost) {
        this.clickerCost = clickerCost;
    }

    public int getClickerAmount() {
        return clickerAmount;
    }

    public void setClickerAmount(int clickerAmount) {
        this.clickerAmount = clickerAmount;
    }

    public double getClickerCps() {
        return clickerCps;
    }

    public void setClickerCps(double clickerCps) {
        this.clickerCps = clickerCps;
    }

    public double getCookiePerSecond() {
        return cookiePerSecond;
    }

    public void setCookiePerSecond(double cookiePerSecond) {
        this.cookiePerSecond = cookiePerSecond;
    }

    public int getGrandmaCost() {
        return grandmaCost;
    }

    public void setGrandmaCost(int grandmaCost) {
        this.grandmaCost = grandmaCost;
    }

    public int getGrandmaAmount() {
        return grandmaAmount;
    }

    public void setGrandmaAmount(int grandmaAmount) {
        this.grandmaAmount = grandmaAmount;
    }

    public double getGrandmaCps() {
        return grandmaCps;
    }

    public void setGrandmaCps(double grandmaCps) {
        this.grandmaCps = grandmaCps;
    }
}
