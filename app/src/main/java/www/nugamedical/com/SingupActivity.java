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
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SingupActivity extends AppCompatActivity implements View.OnClickListener {

    private  Button btn_register;
    private Animation frombottom, fromtop;
    private RelativeLayout rel;
    private View backView;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signup);

        btn_register = findViewById(R.id.btn_register);
        rel = findViewById(R.id.rel);
        backView = findViewById(R.id.backView);

        btn_register.setOnClickListener(this);

        fromtop = AnimationUtils.loadAnimation(this,R.anim.fromtop);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);                     // 애니메이션 기능 선택

        rel.setAnimation(frombottom);                                                                    // rel 을 밑에서 위로 올라오는 애니메이션 on
        backView.setAnimation(fromtop);                                                                  // backView를 위에서 아래로 내리는 애니메이션 on


    }

    @Override
    public void onClick(View v) {

        Toast.makeText(this, "등록되었습니다.", Toast.LENGTH_SHORT).show();
        finish();
    }
}
