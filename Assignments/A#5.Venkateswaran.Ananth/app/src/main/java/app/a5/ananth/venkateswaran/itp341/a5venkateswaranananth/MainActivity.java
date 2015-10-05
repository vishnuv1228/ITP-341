package app.a5.ananth.venkateswaran.itp341.a5venkateswaranananth;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

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
