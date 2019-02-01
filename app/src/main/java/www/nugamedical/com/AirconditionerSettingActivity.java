package www.nugamedical.com;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AirconditionerSettingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner_lowest_thermo,spinner_highest_thermo, spinner_lowest_humidity, spinner_highest_humidity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_airconditionersetting);

        spinner_highest_thermo = findViewById(R.id.spinner_highest_thermo);
        spinner_lowest_thermo = findViewById(R.id.spinner_lowest_thermo);
        spinner_lowest_humidity = findViewById(R.id.spinner_lowest_humidity);
        spinner_highest_humidity = findViewById(R.id.spinner_highest_humidity);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.humiditynumbers, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_lowest_thermo.setAdapter(adapter1);
        spinner_lowest_thermo.setOnItemSelectedListener(this);
        spinner_highest_thermo.setAdapter(adapter1);
        spinner_highest_thermo.setOnItemSelectedListener(this);
        spinner_lowest_humidity.setAdapter(adapter2);
        spinner_lowest_humidity.setOnItemSelectedListener(this);
        spinner_highest_humidity.setAdapter(adapter2);
        spinner_highest_humidity.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
