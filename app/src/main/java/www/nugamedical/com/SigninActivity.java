package www.nugamedical.com;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText_enterid, editText_enter_password;
    private Button btn_login;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signin);

        btn_login = findViewById(R.id.btn_login);
        editText_enterid = findViewById(R.id.editText_enterid);
        editText_enter_password = findViewById(R.id.editText_enter_password);

        btn_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.btn_login:

                Intent intent_signin = new Intent(SigninActivity.this, MainActivity.class);
                startActivity(intent_signin);
                finish();

                break;

        }

    }
}
