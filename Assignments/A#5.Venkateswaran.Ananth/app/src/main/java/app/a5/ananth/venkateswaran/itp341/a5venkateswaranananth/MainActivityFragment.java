package app.a5.ananth.venkateswaran.itp341.a5venkateswaranananth;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    Button player1Button;
    Button player2Button;
    Button player3Button;

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
        return view;

    }
    public void onClick(View v) {
        Button b = (Button) v;
        String userOption = b.getText().toString();
        Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
        intent.putExtra("message", userOption);
        getActivity().startActivity(intent);
    }


}
