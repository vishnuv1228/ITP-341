package app.a5.ananth.venkateswaran.itp341.a5venkateswaranananth;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    Button player1Button;
    Button player2Button;
    Button player3Button;

    EditText name;
    EditText emailField;
    EditText phoneField;
    EditText addressField;
    EditText notes;
    String savedName;
    String email;
    String phone;
    String address;
    String notessaved;
    String [] temp;
    static final String STATE_NAME = "name";
    static final String STATE_EMAIL = "email";
    static final String STATE_PHONE = "phone";
    static final String STATE_ADDRESS = "address";
    static final String STATE_NOTES = "notes";

    public MainActivityFragment() {
    }
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_master, container, false);
        player1Button = (Button) view.findViewById(R.id.firstButton);
        player1Button.setOnClickListener(this);
        player2Button = (Button) view.findViewById(R.id.secondButton);
        player2Button.setOnClickListener(this);
        player3Button = (Button) view.findViewById(R.id.thirdButton);
        player3Button.setOnClickListener(this);


        // Initialize variables
        name = (EditText) view.findViewById(R.id.nameSelection);
        emailField = (EditText) view.findViewById(R.id.emailInput);
        phoneField = (EditText) view.findViewById(R.id.phoneInput);
        addressField = (EditText) view.findViewById(R.id.addressInput);
        notes = (EditText) view.findViewById(R.id.notesInput);
        return view;

    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (savedInstanceState != null) {
            Log.d("H", "savedName");
            savedName = savedInstanceState.getString(STATE_NAME);
            email = savedInstanceState.getString(STATE_EMAIL);
            phone = savedInstanceState.getString(STATE_PHONE);
            address = savedInstanceState.getString(STATE_ADDRESS);
            notessaved = savedInstanceState.getString(STATE_NOTES);
        }
        else
        {
            savedName = "";
            email = "";
            phone = "";
            address = "";
            notessaved = "";
        }
    }
    public void setEditable(boolean editable) {

        if (!editable) {
            editString(name, false);
            editString(emailField, false);
            editString(phoneField, false);
            editString(addressField, false);
            editString(notes, false);
        }
        else
        {
            Log.d("h", "In setEditable true");
            editString(name, true);
            editString(emailField, true);
            editString(phoneField, true);
            editString(addressField, true);
            editString(notes, true);

        }

    }
    public void editString(EditText value, Boolean bool)
    {
        value.setFocusable(bool);
        value.setFocusableInTouchMode(bool);
        value.setClickable(bool);

    }
    public void onClick(View v) {
        Button b = (Button) v;
        String userOption = b.getText().toString();

        // Check if screen is large
        if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
            fillBlanks(userOption);
            setEditable(false);
        }
        else
        {
            Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
            intent.putExtra("message", userOption);
            getActivity().startActivity(intent);
        }

    }
    private void fillBlanks(String user) {
        if (user.equals(getResources().getString(R.string.player1))) {
            String [] christie = getResources().getStringArray(R.array.p1_data);
            fillSpecificField(christie);
        }
        else if (user.equals(getResources().getString(R.string.player2))) {
            String [] sergei = getResources().getStringArray(R.array.p2_data);
            fillSpecificField(sergei);
        }
        else if (user.equals(getResources().getString(R.string.player3))) {
            String[] jin = getResources().getStringArray(R.array.p3_data);
            fillSpecificField(jin);
        }
    }
    private void fillSpecificField(String[] player) {
        temp = player;
        if(savedName.equals("") || email.equals("") || phone.equals("") || address.equals("") || notessaved.equals("")) {
            name.setText(temp[0]);
            emailField.setText(temp[1]);
            phoneField.setText(temp[2]);
            addressField.setText(temp[3]);
        }
        else
        {
            name.setText(savedName);
            emailField.setText(email);
            phoneField.setText(phone);
            addressField.setText(address);
            notes.setText(notessaved);
        }
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        super.onCreateOptionsMenu(menu, inflater);
        Log.d("H", "In mainActivityFragment onCreateOptionsMenu");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.editFields) {
            setEditable(true);
            return true;
        }
        else if (id == R.id.saveFields) {
            savedName = name.getText().toString();
            email = emailField.getText().toString();
            phone = phoneField.getText().toString();
            address = addressField.getText().toString();
            notessaved = notes.getText().toString();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
