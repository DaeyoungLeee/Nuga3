package www.nugamedical.com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class VentilationSetting extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private  Spinner spinner_co2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ventilatorsetting);

        spinner_co2= findViewById(R.id.spinner_co2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.co2numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_co2.setAdapter(adapter);
        spinner_co2.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
