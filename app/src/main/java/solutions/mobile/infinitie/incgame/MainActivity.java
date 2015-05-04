package solutions.mobile.infinitie.incgame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends ActionBarActivity {


    TextView cookieText;
    TextView clickerCostText;
    TextView clickerAmountText;
    TextView cpsText;

    double internalCookieCount;
    double clickerCost = 1;
    int clickerCount = 0;
    double clickerCps = 0;
    double cookiePerSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupGame();
        gameLoop();
    }

    private void setupGame() {
        cookieText = (TextView) findViewById(R.id.cookieCount);
        cpsText = (TextView) findViewById(R.id.cpsText);

        clickerCostText = (TextView) findViewById(R.id.clickerCostText);
        clickerCostText.setText(String.format("Cost: %.2f", clickerCost));

        clickerAmountText = (TextView) findViewById(R.id.clickerAmountText);
        clickerAmountText.setText(String.format("Total: %d", clickerCount));
    }


    private void gameLoop() {
        Timer t = new Timer();

        // Cookie tick task
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        incrementCookie();
                    }
                });
            }
        }, 0, 1000);

        // UI update task
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        cpsText.setText(String.format("CPS: %.2f", cookiePerSecond));
                        cookieText.setText(String.format("Cookies: %.2f", internalCookieCount));

                        clickerAmountText.setText(String.format("Total: %d", clickerCount));
                        clickerCostText.setText(String.format("Cost: %.2f", clickerCost));
                    }
                });
            }
        }, 0, 100);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void incrementCookie() {

        internalCookieCount += cookiePerSecond;
    }

    public void cookieButtonPressed(View view) {
        internalCookieCount += 1;
    }

    public void buyClicker(View view) {
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
}
