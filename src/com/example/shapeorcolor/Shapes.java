package com.example.shapeorcolor;

import java.text.DecimalFormat;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Shapes extends Activity {
	
	int times = 20;
	int correctAnswers = 0;
	int wrongAnswers = 0;
	public final static String EXTRA_CORRECT_ANSWERS = "com.example.shapeorcolor.CORRECT_ANSWERS";
	public final static String EXTRA_WRONG_ANSWERS = "com.example.shapeorcolor.WRONG_ANSWERS";
	public final static String EXTRA_FINAL_SCORE = "com.example.shapeorcolor.FINAL_SCORE";
	
	final Random r1 = new Random();
	final Random r2 = new Random();
	final Random r3 = new Random();
	final Random r4 = new Random();
	
	int isShapeOrColor = r1.nextInt(2);
	int firstShape = r2.nextInt(3);
	int secondShape = r4.nextInt(3);
	int color = r3.nextInt(2);



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shapes);
		
		final int[][] images = new int[3][2];
		images[0][0] = R.drawable.ic_filled_b;
		images[0][1] = R.drawable.ic_filled_r;
		images[1][0] = R.drawable.ic_plus_b;
		images[1][1] = R.drawable.ic_plus_r;
		images[2][0] = R.drawable.ic_shape_b;
		images[2][1] = R.drawable.ic_shape_r;
		
		final ImageView shape1 = (ImageView) findViewById(R.id.shape1ImageView);       
		final ImageView shape2 = (ImageView) findViewById(R.id.shape2ImageView);
		
		
		while (firstShape==secondShape)
			secondShape = r4.nextInt(3);
		
		if (isShapeOrColor == 1)
		{
			shape1.setImageResource(images[firstShape][0]);
			shape2.setImageResource(images[firstShape][1]);
		}
		else
		{
			shape1.setImageResource(images[firstShape][color]);
			shape2.setImageResource(images[secondShape][color]);
		}
		
		Button choiceShape = (Button) findViewById(R.id.shapeButton);
		Button choiceColor = (Button) findViewById(R.id.colorButton);
		
		choiceShape.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(times==0)
				{
					Intent intent = new Intent(Shapes.this, FinalResults.class);
					double finalScore = (double)correctAnswers/(correctAnswers+wrongAnswers);
		    		DecimalFormat df = new DecimalFormat("#.00");
		    		
		    		String correctAnswersStr = Integer.toString(correctAnswers);
					String wrongAnswersStr = Integer.toString(wrongAnswers);
					String finalScoreStr = df.format(finalScore*100);
					
		    		finalScoreStr += " %";
					
					intent.putExtra(EXTRA_CORRECT_ANSWERS, correctAnswersStr );
		    		intent.putExtra(EXTRA_WRONG_ANSWERS, wrongAnswersStr );
		    		intent.putExtra(EXTRA_FINAL_SCORE, finalScoreStr );
					startActivity(intent);
				}
				else
				{
					if(isShapeOrColor==1)
						correctAnswers++;
					else
						wrongAnswers++;	
					
					times--;
					
					isShapeOrColor = r1.nextInt(2);
					firstShape = r2.nextInt(3);
					secondShape = r4.nextInt(3);
					color = r3.nextInt(2);
	
					while (firstShape==secondShape)
						secondShape = r4.nextInt(3);
					
					if (isShapeOrColor == 1)
					{
						shape1.setImageResource(images[firstShape][0]);
						shape2.setImageResource(images[firstShape][1]);
					}
					else
					{
						shape1.setImageResource(images[firstShape][color]);
						shape2.setImageResource(images[secondShape][color]);
					}
				}
			}
		});
		
		choiceColor.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(times==0)
				{
					Intent intent = new Intent(Shapes.this, FinalResults.class);
					double finalScore = (double)correctAnswers/(correctAnswers+wrongAnswers);
		    		DecimalFormat df = new DecimalFormat("#.00");
		    		
		    		String correctAnswersStr = Integer.toString(correctAnswers);
					String wrongAnswersStr = Integer.toString(wrongAnswers);
					String finalScoreStr = df.format(finalScore*100);
					
		    		finalScoreStr += " %";
					
					intent.putExtra(EXTRA_CORRECT_ANSWERS, correctAnswersStr );
		    		intent.putExtra(EXTRA_WRONG_ANSWERS, wrongAnswersStr );
		    		intent.putExtra(EXTRA_FINAL_SCORE, finalScoreStr );
					startActivity(intent);
				}
				else
				{	
					if(isShapeOrColor!=1)
						correctAnswers++;
					else
						wrongAnswers++;	
					
					times--;				
					isShapeOrColor = r1.nextInt(2);
					firstShape = r2.nextInt(3);
					secondShape = r4.nextInt(3);
					color = r3.nextInt(2);
	
					while (firstShape==secondShape)
						secondShape = r4.nextInt(3);
					
					if (isShapeOrColor == 1)
					{
						shape1.setImageResource(images[firstShape][0]);
						shape2.setImageResource(images[firstShape][1]);
					}
					else
					{
						shape1.setImageResource(images[firstShape][color]);
						shape2.setImageResource(images[secondShape][color]);
					}
				}
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shapes, menu);
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
