package www.nugamedical.com;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SingupActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_register;
    private Animation frombottom, fromtop;
    private RelativeLayout rel;
    private View backView;
    EditText editText_setpassword, editText_setpassword2, editText_setid, editText_setName;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signup);

        editText_setName = findViewById(R.id.editText_setName);
        editText_setid = findViewById(R.id.editText_setid);
        btn_register = findViewById(R.id.btn_register);
        rel = findViewById(R.id.rel);
        backView = findViewById(R.id.backView);
        editText_setpassword = findViewById(R.id.editText_setpassword);
        editText_setpassword2 = findViewById(R.id.editText_setpassword2);

        btn_register.setOnClickListener(this);

        fromtop = AnimationUtils.loadAnimation(this,R.anim.fromtop);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);                     // 애니메이션 기능 선택

        rel.setAnimation(frombottom);                                                                    // rel 을 밑에서 위로 올라오는 애니메이션 on
        backView.setAnimation(fromtop);                                                                  // backView를 위에서 아래로 내리는 애니메이션 on

    }

    @Override
    public void onClick(View v) {

        if(editText_setpassword.getText().toString().equals(editText_setpassword2.getText().toString())) {

            if (editText_setid.getText().toString().isEmpty() || editText_setName.getText().toString().isEmpty()){
                Toast.makeText(this, "내용을 전부 입력해주세요.", Toast.LENGTH_SHORT).show();
            }else {

            Toast.makeText(this, "등록되었습니다.", Toast.LENGTH_SHORT).show();
            finish();
            }
        }else {
            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
