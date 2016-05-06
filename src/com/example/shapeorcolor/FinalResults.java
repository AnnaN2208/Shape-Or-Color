package com.example.shapeorcolor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class FinalResults extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_final_results);
		
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		
		int width = dm.widthPixels;
		int height = dm.heightPixels;
		
		getWindow().setLayout((int)(width*.8), (int)(height*.6));
		
		Intent intent = getIntent();
        String rightAnswers = intent.getStringExtra(Shapes.EXTRA_CORRECT_ANSWERS);
        TextView textView1 = (TextView)findViewById(R.id.rightAnswersNrTextView);
        textView1.setText(rightAnswers);
        
        String wrongAnswers = intent.getStringExtra(Shapes.EXTRA_WRONG_ANSWERS);
        TextView textView2 = (TextView)findViewById(R.id.wrongAnswersNrTextView);
        textView2.setText(wrongAnswers);
        
        String finalScore = intent.getStringExtra(Shapes.EXTRA_FINAL_SCORE);        
        TextView textView3 = (TextView)findViewById(R.id.finalScoreNrTextView);
        textView3.setText(finalScore);	
        
        ImageButton replayButton = (ImageButton) findViewById(R.id.replayGameButton);
        ImageButton selectOther = (ImageButton) findViewById(R.id.selectOtherButton);
        
        replayButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(FinalResults.this, Shapes.class);
				startActivity(intent);
			}
		});
        
        selectOther.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
			}
		});
        
        
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.final_results, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
