package app.a5.ananth.venkateswaran.itp341.a5venkateswaranananth;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class DetailFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    EditText name;
    EditText emailField;
    EditText phoneField;
    EditText addressField;
    EditText notes;
    String [] temp;
    String savedName;
    String email;
    String phone;
    String address;
    String notessaved;
    static final String STATE_NAME = "name";
    static final String STATE_EMAIL = "email";
    static final String STATE_PHONE = "phone";
    static final String STATE_ADDRESS = "address";
    static final String STATE_NOTES = "notes";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        String user = bundle.getString("option");

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        // Initialize variables
        name = (EditText) rootView.findViewById(R.id.nameSelection);
        emailField = (EditText) rootView.findViewById(R.id.emailInput);
        phoneField = (EditText) rootView.findViewById(R.id.phoneInput);
        addressField = (EditText) rootView.findViewById(R.id.addressInput);
        notes = (EditText) rootView.findViewById(R.id.notesInput);
        setHasOptionsMenu(true);

        setEditable(false);

        // Inflate the layout for this fragment
        Log.d("H", user);
        fillBlanks(user);
        return rootView;
    }
    @Override
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
        Log.d("H", "In detailFragment onCreateOptionsMenu");
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.editFields) {
            Log.d("H", "In detailFragment menu option");
            setEditable(true);
            return true;
        }
        if (id == R.id.saveFields) {
            savedName = name.getText().toString();
            email = emailField.getText().toString();
            phone = phoneField.getText().toString();
            address = addressField.getText().toString();
            notessaved = notes.getText().toString();
            Log.d("H", savedName);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.d("h", "onSaveInstanceState");
        savedInstanceState.putString(STATE_NAME, savedName);
        savedInstanceState.putString(STATE_EMAIL, email);
        savedInstanceState.putString(STATE_PHONE, phone);
        savedInstanceState.putString(STATE_ADDRESS, address);
        savedInstanceState.putString(STATE_NOTES, notessaved);

    }
}
