package www.nugamedical.com;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FirstFragment extends Fragment /*implements View.OnClickListener*/{


    private SwipeRefreshLayout swipe_frag1;
    private TextView weather_state, nowTemperature, nowHumidity, nowCity;
    private ImageView weather_icon;
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

        swipe_frag1 = view.findViewById(R.id.swipe_frag1);

        weather_state = view.findViewById(R.id.weather_state);
        nowTemperature = view.findViewById(R.id.nowTemperature);
        nowHumidity = view.findViewById(R.id.nowHumidity);
        nowCity = view.findViewById(R.id.nowCity);
        weather_icon = view.findViewById(R.id.weather_icon);
        //날씨 업데이트
        findWeather();

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

        //새로고침
        swipe_frag1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                showFragment(FirstFragment.newInstance());

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipe_frag1.setRefreshing(false);
                    }
                },3000);
            }
        });

        return view;
    }

    // 날씨 관련 코딩//
    public void findWeather(){
        String Url = "https://api.openweathermap.org/data/2.5/weather?q=wonju&appid=27b1b8b908d5ad361af19ff8eee92989";      //open weather api 받아오기

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, Url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject main_object = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                    String temp = String.valueOf(main_object.getDouble("temp"));
                    String humidity = String.valueOf(main_object.getDouble("humidity"));
                    String descroption = object.getString("description");
                    String city = response.getString("name");


                    nowHumidity.setText(humidity);
                    nowCity.setText(city);
                    weather_state.setText(descroption);

                    //description(날씨)에 따라 그림 변화
                    if(descroption.equals("haze") || descroption.equals("smoke") || descroption.equals("mist") || descroption.equals("fog") || descroption.equals("sand, dust whirl") || descroption.equals("sand") || descroption.equals("dust") || descroption.equals("volcanic ash") || descroption.equals("squalls") || descroption.equals("tornado")){
                        weather_icon.setImageResource(R.drawable.misticon);
                    }else if(descroption.equals("clear sky")){
                        weather_icon.setImageResource(R.drawable.sunny);
                    }else if(descroption.equals("light snow") || descroption.equals("snow") || descroption.equals("sleet") || descroption.equals("shower sleet") || descroption.equals("light rain and snow") || descroption.equals("rain and snow") || descroption.equals("light shower snow") || descroption.equals("shower snow") || descroption.equals("heavy shower snow")){
                        weather_icon.setImageResource(R.drawable.snow);
                    }else if(descroption.equals("scattered clouds") || descroption.equals("few clouds") || descroption.equals("broken clouds")){
                        weather_icon.setImageResource(R.drawable.cloudy);
                    }else if (descroption.equals("thunderstorm") || descroption.equals("thunderstorm with light rain") || descroption.equals("thunderstorm with rain") || descroption.equals("thunderstorm with heavy rain") || descroption.equals("light thunderstorm") || descroption.equals("heavy thunderstorm") || descroption.equals("ragged thunderstorm") || descroption.equals("thunderstorm with drizzle") || descroption.equals("thunderstorm with light drizzle") || descroption.equals("thunderstorm with heavy drizzle")){
                        weather_icon.setImageResource(R.drawable.thunderrain);
                    }

                    //일자
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat adf = new SimpleDateFormat("EEEE-DD-MM");
                    String formatted_data = adf.format(calendar.getTime());


                    double temp_int = Double.parseDouble(temp);
                    double centi = temp_int - 273.15;
                    centi = Math.round(centi);
                    int i = (int)centi;
                    nowTemperature.setText(String.valueOf(i));

                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(jor);
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

    public void showFragment(Fragment f){
        getFragmentManager().beginTransaction().replace(R.id.frame_main, f).commit();
    }


}