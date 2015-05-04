package solutions.mobile.infinitie.incgame;

import android.view.View;

/**
 * Created by tigew on 5/4/15.
 */
public class CookieCore {

    private double internalCookieCount;
    private double clickerCost = 1;
    private int clickerCount = 0;
    private double clickerCps = 0;

    public CookieCore() {
    }

    public void incrementCookie() {

        internalCookieCount += cookiePerSecond;
    }

    public void coreBuyClicker() {
        if (internalCookieCount >= clickerCost) {
            clickerCount += 1;
            internalCookieCount -= clickerCost;
            clickerCost += (clickerCost * 0.03);
            clickerCps += .3;
            calculateCPS();
        }
    }

    private void calculateCPS() {
        cookiePerSecond = clickerCps;
    }

    public double getInternalCookieCount() {
        return internalCookieCount;
    }

    public void setInternalCookieCount(double internalCookieCount) {
        this.internalCookieCount = internalCookieCount;
    }

    public double getClickerCost() {
        return clickerCost;
    }

    public void setClickerCost(double clickerCost) {
        this.clickerCost = clickerCost;
    }

    public int getClickerCount() {
        return clickerCount;
    }

    public void setClickerCount(int clickerCount) {
        this.clickerCount = clickerCount;
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
