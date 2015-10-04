package activitylifecycle.ralph.com.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("SecondActivity", "onCreate");
        setContentView(R.layout.activity_second);
        Button goBackButton = (Button) findViewById(R.id.button2);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText myEditText = (EditText) findViewById(R.id.editText);
                String myText = myEditText.getText().toString();
                if (myText != null) {
                    Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                    intent.putExtra("activityOne", myText);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("SecondActivity", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("SecondActivity", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("SecondActivity", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("SecondActivity", "onResume");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView myTextView = (TextView) findViewById(R.id.textView);
            String myString = extras.getString("activityTwo");
            myTextView.setText(myString);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("SecondActivity", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("SecondActivity", "onPause");
    }



}
