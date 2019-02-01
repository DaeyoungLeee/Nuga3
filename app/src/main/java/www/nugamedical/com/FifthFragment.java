package www.nugamedical.com;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class FifthFragment extends Fragment implements View.OnClickListener {

    private CardView btn_airconditonaer, btn_purifier, btn_ventilator;

    private View view;


    public static FifthFragment newInstance(){
        FifthFragment f = new FifthFragment();
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.frag5, container, false);

        btn_airconditonaer = view.findViewById(R.id.btn_airconditonaer);
        btn_purifier       = view.findViewById(R.id.btn_purifier);
        btn_ventilator     = view.findViewById(R.id.btn_ventilator);

        btn_airconditonaer.setOnClickListener(this);
        btn_purifier.setOnClickListener(this);
        btn_ventilator.setOnClickListener(this);




        return view;
    }




    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_airconditonaer:
                Intent intent_set_air = new Intent(getActivity(), AirconditionerSettingActivity.class);
                startActivity(intent_set_air);
                Log.d("showFragment: clicked", "에어컨클릭");
                break;
            case R.id.btn_purifier:
               Intent intent_set_dust = new Intent(getContext(), DustSettingActivity.class);
               startActivity(intent_set_dust);
                Log.d("showFragment: clicked", "공기청정클릭");
                break;
            case R.id.btn_ventilator:
                Intent intent_set_ventil = new Intent(getContext(), VentilationSetting.class);
                startActivity(intent_set_ventil);
                Log.d("showFragment: clicked", "환풍기클릭");
                break;

        }

    }

}
