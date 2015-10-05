package app.a5.ananth.venkateswaran.itp341.a5venkateswaranananth;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
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
    public void onClick(View v) {
        Button b = (Button) v;
        String userOption = b.getText().toString();

        // Check if screen is large
        if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE) {
            fillBlanks(userOption);
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
        name.setText(player[0]);
        emailField.setText(player[1]);
        phoneField.setText(player[2]);
        addressField.setText(player[3]);
    }

}
