package www.nugamedical.com;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstFragment extends Fragment /*implements View.OnClickListener*/{


    /*
    private  ImageView btn_lightening, btn_thermometer, btn_humidity, btn_dust, btn_fire, btn_emergency, btn_cctv;
    private  TextView btn_environment, btn_electronics;
    */
    public static FirstFragment newInstance(){

        FirstFragment f = new FirstFragment();
        return f;
    }

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.frag1, container, false);

        /*
        //이미지 버튼 클릭 세팅
        btn_lightening = view.findViewById(R.id.btn_lightening);
        btn_dust       = view.findViewById(R.id.btn_dust);
        btn_emergency  = view.findViewById(R.id.btn_emergency);
        btn_fire       = view.findViewById(R.id.btn_fire);
        btn_humidity   = view.findViewById(R.id.btn_humidity);
        btn_thermometer= view.findViewById(R.id.btn_thermometer);
        btn_cctv       = view.findViewById(R.id.btn_cctv);
        btn_environment= view.findViewById(R.id.btn_environment);
        btn_electronics= view.findViewById(R.id.btn_electronics);

        //

        //

        btn_lightening.setOnClickListener(this);
        btn_dust.setOnClickListener(this);
        btn_emergency.setOnClickListener(this);
        btn_fire.setOnClickListener(this);
        btn_humidity.setOnClickListener(this);
        btn_thermometer.setOnClickListener(this);
        btn_cctv.setOnClickListener(this);
        btn_electronics.setOnClickListener(this);
        btn_environment.setOnClickListener(this);
       */

        return view;
    }
    /*
    //이미지 버튼이 눌렸을 경우
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_lightening:
                showFragment(SecondFragment.newInstance());

                break;
            case R.id.btn_dust:
                showFragment(SecondFragment.newInstance());

                break;
            case R.id.btn_emergency:
                showFragment(SecondFragment.newInstance());

                break;
            case R.id.btn_fire:
                showFragment(SecondFragment.newInstance());

                break;
            case R.id.btn_humidity:
                showFragment(SecondFragment.newInstance());

                break;
            case R.id.btn_thermometer:
                showFragment(SecondFragment.newInstance());

                break;
            case R.id.btn_cctv:
                showFragment(ThirdFragment.newInstance());

                break;
            case R.id.btn_environment:
                showFragment(SecondFragment.newInstance());

                break;
            case R.id.btn_electronics:
                showFragment(FourthFragment.newInstance());

                break;

        }
    }

    public void showFragment(Fragment f){
        getFragmentManager().beginTransaction().replace(R.id.contents, f).commit();
    }*/


}