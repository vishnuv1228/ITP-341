package app.a5.ananth.venkateswaran.itp341.a5venkateswaranananth;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    EditText name;
    EditText emailField;
    EditText phoneField;
    EditText addressField;
    EditText notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        // When you rotate, it adds more fragment so use following if statement
        if (savedInstanceState == null) {
            MainActivityFragment masterFragment = new MainActivityFragment();
            fragmentTransaction.add(R.id.masterFragmentRegular, masterFragment, "Master Handset");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }


        Intent intent = getIntent();
        String userOption = intent.getStringExtra("message");
        Log.d("H", "User Option: " + userOption);
        if (userOption != null) {
            Bundle bundle = new Bundle();
            bundle.putString("option", userOption);
            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setArguments(bundle);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.masterFragmentRegular, detailFragment);
            transaction.addToBackStack(null);
            transaction.commit();

        }
        // Initialize variables
        name = (EditText) findViewById(R.id.nameSelection);
        emailField = (EditText) findViewById(R.id.emailInput);
        phoneField = (EditText) findViewById(R.id.phoneInput);
        addressField = (EditText) findViewById(R.id.addressInput);
        notes = (EditText) findViewById(R.id.notesInput);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }


}
