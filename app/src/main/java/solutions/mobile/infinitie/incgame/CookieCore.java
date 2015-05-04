package solutions.mobile.infinitie.incgame;

public class CookieCore {

    private double internalCookieCount;
    private int clickerCost = 15;
    private int clickerAmount = 0;
    private double clickerCps = 0;

    public CookieCore() {
    }

    public void incrementCookie() {

        internalCookieCount += cookiePerSecond;
    }

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

    private void calculateCPS() {
        cookiePerSecond = clickerCps;
    }

    private int updateCost(int itemBaseCost, int itemAmount) {
        return (int) (itemBaseCost * (Math.pow(1.15, itemAmount)));

    }

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

    double cookiePerSecond;
}