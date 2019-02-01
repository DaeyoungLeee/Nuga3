package www.nugamedical.com;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private  Button btn_signin, btn_signup;
    private ImageView mark;
    private TextView nugaTitle, nugaSubtitle;
    private Animation fromright, fromleft, fromtop;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        fromtop = AnimationUtils.loadAnimation(this,R.anim.fromtop);
        fromleft = AnimationUtils.loadAnimation(this, R.anim.fromleft);
        fromright = AnimationUtils.loadAnimation(this, R.anim.fromright);

        nugaTitle = findViewById(R.id.nugaTitle);
        nugaSubtitle = findViewById(R.id.nugaSubtitle);
        mark = findViewById(R.id.mark);
        btn_signin = findViewById(R.id.btn_signin);
        btn_signup = findViewById(R.id.btn_signup);

        btn_signin.setOnClickListener(this);
        btn_signup.setOnClickListener(this);

        mark.setAnimation(fromtop);
        nugaTitle.setAnimation(fromleft);
        nugaSubtitle.setAnimation(fromright);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signup:
                Intent intent_gosignup = new Intent(LoginActivity.this, SingupActivity.class);
            // window애니메이션 효과
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(btn_signup, "transition_signup");
                pairs[1] = new Pair<View, String>(mark, "transition_mark");


                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);

                startActivity(intent_gosignup, options.toBundle());

                break;

            case R.id.btn_signin:
                Intent intent_gosignin = new Intent(LoginActivity.this, SigninActivity.class);

                Pair[] pairs2 = new Pair[2];
                pairs2[0] = new Pair<View, String>(btn_signin, "transition_signin");
                pairs2[1] = new Pair<View, String>(mark, "transition_mark");


                ActivityOptions options2 = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs2);
                startActivity(intent_gosignin,options2.toBundle());

                break;
        }
    }
}
