package app.a5.ananth.venkateswaran.itp341.a5venkateswaranananth;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
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

        // Inflate the layout for this fragment
        Log.d("H", user);
        fillBlanks(user);
        return rootView;
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
