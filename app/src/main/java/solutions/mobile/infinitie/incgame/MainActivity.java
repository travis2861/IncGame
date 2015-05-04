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

    CookieCore core = new CookieCore();

    TextView cookieText;
    TextView cpsText;

    TextView clickerCostText;
    TextView clickerAmountText;

    TextView grandmaCostText;
    TextView grandmaAmountText;

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
        clickerAmountText = (TextView) findViewById(R.id.clickerAmountText);

        grandmaCostText = (TextView) findViewById(R.id.grandmaCostText);
        grandmaAmountText = (TextView) findViewById(R.id.grandmaAmountText);
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
                        core.incrementCookie();
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
                        cpsText.setText(String.format("CPS: %.2f", core.getCookiePerSecond()));
                        cookieText.setText(String.format("Cookies: %d",
                                Double.valueOf(core.getInternalCookieCount()).intValue()));

                        clickerAmountText.setText(String.format("Total: %d", core.getClickerAmount()));
                        clickerCostText.setText(String.format("Cost: %d", core.getClickerCost()));

                        grandmaAmountText.setText(String.format("Total: %d", core.getGrandmaAmount()));
                        grandmaCostText.setText(String.format("Cost: %d", core.getGrandmaCost()));
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

    public void cookieButtonPressed(View view) {
        core.setInternalCookieCount(core.getInternalCookieCount() + 1);
    }

    public void buyClicker(View view) {
        core.coreBuyClicker();
    }

    public void buyGrandma(View view) {
        core.coreBuyGrandma();
    }
}
