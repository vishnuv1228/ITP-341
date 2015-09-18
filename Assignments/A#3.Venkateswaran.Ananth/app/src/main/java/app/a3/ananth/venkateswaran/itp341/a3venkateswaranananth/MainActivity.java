package app.a3.ananth.venkateswaran.itp341.a3venkateswaranananth;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends Activity {

    ImageButton btnAmerican;
    ImageButton btnChinese;
    ImageButton btnIndian;
    ImageButton btnItalian;
    ImageButton btnMiddleEast;
    ImageButton btnPortuguese;

    ButtonListener btnListener;

    int counterAm = 1;
    int counterCh = 1;
    int counterIn = 1;
    int counterIt = 1;
    int counterMi = 1;
    int counterPo = 1;

    public static final String COUNTER_AM = " app.a3.ananth.venkateswaran.itp41.a3venkateswaranananth.counterAm";
    public static final String COUNTER_CH = " app.a3.ananth.venkateswaran.itp41.a3venkateswaranananth.counterCh";
    public static final String COUNTER_IN = " app.a3.ananth.venkateswaran.itp41.a3venkateswaranananth.counterIn";
    public static final String COUNTER_IT = " app.a3.ananth.venkateswaran.itp41.a3venkateswaranananth.counterIt";
    public static final String COUNTER_MI = " app.a3.ananth.venkateswaran.itp41.a3venkateswaranananth.counterMi";
    public static final String COUNTER_PO = " app.a3.ananth.venkateswaran.itp41.a3venkateswaranananth.counterPo";


    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_AM, counterAm);
        outState.putInt(COUNTER_CH, counterCh);
        outState.putInt(COUNTER_IN, counterIn);
        outState.putInt(COUNTER_IT, counterIt);
        outState.putInt(COUNTER_MI, counterMi);
        outState.putInt(COUNTER_PO, counterPo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null)
        {
            counterAm = savedInstanceState.getInt(COUNTER_AM, 0);
            counterCh = savedInstanceState.getInt(COUNTER_CH, 0);
            counterIn = savedInstanceState.getInt(COUNTER_IN, 0);
            counterIt = savedInstanceState.getInt(COUNTER_IT, 0);
            counterMi = savedInstanceState.getInt(COUNTER_MI, 0);
            counterPo = savedInstanceState.getInt(COUNTER_PO, 0);
        }

        // find a reference to a button
        btnAmerican = (ImageButton) findViewById(R.id.americanButton);
        btnChinese = (ImageButton) findViewById(R.id.chineseButton);
        btnIndian = (ImageButton) findViewById(R.id.indianButton);
        btnItalian = (ImageButton) findViewById(R.id.italianButton);
        btnMiddleEast = (ImageButton) findViewById(R.id.middle_eastButton);
        btnPortuguese = (ImageButton) findViewById(R.id.portugueseButton);

        // Create a listener
        btnListener = new ButtonListener();

        // Connect listener object with button
        btnAmerican.setOnClickListener(btnListener);
        btnChinese.setOnClickListener(btnListener);
        btnIndian.setOnClickListener(btnListener);
        btnItalian.setOnClickListener(btnListener);
        btnMiddleEast.setOnClickListener(btnListener);
        btnPortuguese.setOnClickListener(btnListener);
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

    public class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view)
        {
            switch(view.getId()) {
                case R.id.americanButton:
                    String msgA = getResources().getString(R.string.liked) + " " + getResources().getString(R.string.american) + " " + counterAm++ + " " + getResources().getString(R.string.times);
                    Toast.makeText(MainActivity.this,msgA, Toast.LENGTH_SHORT).show();
                    btnAmerican.setImageResource(R.drawable.american_clicked);
                    break;
                case R.id.chineseButton:
                    String msgC = getResources().getString(R.string.liked) + " " + getResources().getString(R.string.chinese) + " " + counterCh++ + " " + getResources().getString(R.string.times);
                    Toast.makeText(MainActivity.this,msgC, Toast.LENGTH_SHORT).show();
                    btnChinese.setImageResource(R.drawable.chinese_clicked);
                    break;
                case R.id.indianButton:
                    String msgIn = getResources().getString(R.string.liked) + " " + getResources().getString(R.string.indian) + " " + counterIn++ + " " + getResources().getString(R.string.times);
                    Toast.makeText(MainActivity.this,msgIn, Toast.LENGTH_SHORT).show();
                    btnIndian.setImageResource(R.drawable.indian_clicked);
                    break;
                case R.id.italianButton:
                    String msgIt = getResources().getString(R.string.liked) + " " + getResources().getString(R.string.italian) + " " + counterIt++ + " " + getResources().getString(R.string.times);
                    Toast.makeText(MainActivity.this,msgIt, Toast.LENGTH_SHORT).show();
                    btnItalian.setImageResource(R.drawable.italian_clicked);
                    break;
                case R.id.middle_eastButton:
                    String msgM = getResources().getString(R.string.liked) + " " + getResources().getString(R.string.middle_east) + " " + counterMi++ + " " + getResources().getString(R.string.times);
                    Toast.makeText(MainActivity.this,msgM, Toast.LENGTH_SHORT).show();
                    btnMiddleEast.setImageResource(R.drawable.middle_east_clicked);
                    break;
                case R.id.portugueseButton:
                    String msgP = getResources().getString(R.string.liked) + " " + getResources().getString(R.string.portuguese) + " " + counterPo++ + " " + getResources().getString(R.string.times);
                    Toast.makeText(MainActivity.this,msgP, Toast.LENGTH_SHORT).show();
                    btnPortuguese.setImageResource(R.drawable.portuguese_clicked);
                    break;
            }
        }
    }



}
