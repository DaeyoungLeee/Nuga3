package www.nugamedical.com;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DustSettingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner_lowest_dust,spinner_highest_dust;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dustsetting);

        spinner_lowest_dust = findViewById(R.id.spinner_lowest_dust);
        spinner_highest_dust = findViewById(R.id.spinner_highest_dust);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dustnumbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_lowest_dust.setAdapter(adapter);
        spinner_lowest_dust.setOnItemSelectedListener(this);

        spinner_highest_dust.setAdapter(adapter);
        spinner_highest_dust.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
