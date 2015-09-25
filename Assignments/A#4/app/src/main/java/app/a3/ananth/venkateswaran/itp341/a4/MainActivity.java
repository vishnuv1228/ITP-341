package app.a3.ananth.venkateswaran.itp341.a4;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import java.text.NumberFormat;

public class MainActivity extends Activity {

    // TAG
    private static final String TAG = MainActivity.class.getSimpleName();


    // variables for widgets
    EditText billAmount;
    SeekBar seekBarTipPercent;
    TextView seekBarText;
    TextView tipAmountLabel;
    TextView totalAmountLabel;
    Spinner spinnerOptions;
    TextView perPerson1;
    TextView perPersonAmount1;

    // instance variables
    double bill = 0;
    int percent = 0;
    double tip = 0;
    double total = 0;
    int perPerson = 0;

    public static final String BILL = " app.a3.ananth.venkateswaran.itp41.a3venkateswaranananth.bill";
    public static final String PERCENT = " app.a3.ananth.venkateswaran.itp41.a3venkateswaranananth.percent";
    public static final String TIP = " app.a3.ananth.venkateswaran.itp41.a3venkateswaranananth.tip";
    public static final String TOTAL = " app.a3.ananth.venkateswaran.itp41.a3venkateswaranananth.total";
    public static final String PERPERSON = " app.a3.ananth.venkateswaran.itp41.a3venkateswaranananth.perPerson";


    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(BILL, bill);
        outState.putInt(PERCENT, percent);
        outState.putDouble(TIP, tip);
        outState.putDouble(TOTAL, total);
        outState.putInt(PERPERSON, perPerson);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Save on rotation
        if (savedInstanceState != null)
        {
            bill = savedInstanceState.getInt(BILL, 0);
            percent = savedInstanceState.getInt(PERCENT, 0);
            tip = savedInstanceState.getInt(TIP, 0);
            total = savedInstanceState.getInt(TOTAL, 0);
            perPerson = savedInstanceState.getInt(PERPERSON, 0);
        }


        // get reference to widgets

        billAmount = (EditText) findViewById(R.id.editBill);
        seekBarTipPercent = (SeekBar) findViewById(R.id.percentBar);
        seekBarText = (TextView) findViewById(R.id.seekBarText);
        tipAmountLabel = (TextView) findViewById(R.id.tipAmount);
        totalAmountLabel = (TextView) findViewById(R.id.totalAmount);
        spinnerOptions = (Spinner) findViewById(R.id.spinnerOps);
        perPerson1 = (TextView) findViewById(R.id.perPersonLabel);
        perPersonAmount1 = (TextView) findViewById(R.id.perPersonAmount);

        // Bill Amount action listener for editText
        billAmount.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView tv, int i, KeyEvent keyEvent) {
                Log.d(TAG, "inside onEditorAction");
                // set bill int variable to value user inputs
                String input = tv.getText().toString();
                bill = Double.parseDouble(input);34.44
                createAmounts();
                return false;
            }
        });

        // SeekBar action listener
        seekBarTipPercent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d(TAG, "in onProgressChanged SeekBar");
                percent = progress;
                seekBarText.setText(Integer.toString(percent) + getString(R.string.percent1));
                createAmounts();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Spinner listener
        spinnerOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String h = parent.getItemAtPosition(position).toString();
                if (h.matches(".*\\d+.*"))
                {
                    String temp = h.replaceAll("\\D+","");
                    perPerson = Integer.parseInt(temp);
                }
                else
                {
                    perPerson = -1;
                }
                createAmounts();
                Log.d(TAG, "In onItemSelected Spinner and Selection is " + perPerson);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void createAmounts() {
        Log.d(TAG, "Inside createAmounts");

        if (bill != 0) {
            if (percent != 0 && perPerson == -1) {
                // Tip
                makeTipandTotal();

                perPerson1.setText("");
                perPersonAmount1.setText("");
            }
            else
            {
                // divide by number of people
                makeTipandTotal();

                // Set text visible
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                perPerson1.setText(getString(R.string.perPersonLabel));
                double personAmount = total/(double)perPerson;
                perPersonAmount1.setText(formatter.format(personAmount));

            }
        }
    }
    public void makeTipandTotal()
    {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        double newPercent = (double) percent / 100;
        tip = newPercent * bill;
        tipAmountLabel.setText(formatter.format(tip));
        // Total
        total = bill + tip;
        totalAmountLabel.setText(formatter.format(total));
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
}
