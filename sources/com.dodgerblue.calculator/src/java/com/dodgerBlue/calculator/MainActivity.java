package com.dodgerblue.calculator;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shashank.sony.fancytoastlib.*;
import java.io.*;
import java.text.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends Activity {
	
	private Timer _timer = new Timer();
	
	private double Back_count = 0;
	private String Input = "";
	
	private LinearLayout Background;
	private LinearLayout linear7;
	private LinearLayout linear1;
	private TextView Result;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private Button Clear;
	private Button Backspace;
	private Button non;
	private Button Devide;
	private Button One;
	private Button Two;
	private Button Three;
	private Button Times;
	private Button Four;
	private Button Five;
	private Button Six;
	private Button Minus;
	private Button Seven;
	private Button eight;
	private Button Nine;
	private Button Plus;
	private Button nonb;
	private Button Zero;
	private Button nonnn;
	private Button Equal;
	
	private TimerTask Timer_Back;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		Background = findViewById(R.id.Background);
		linear7 = findViewById(R.id.linear7);
		linear1 = findViewById(R.id.linear1);
		Result = findViewById(R.id.Result);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		Clear = findViewById(R.id.Clear);
		Backspace = findViewById(R.id.Backspace);
		non = findViewById(R.id.non);
		Devide = findViewById(R.id.Devide);
		One = findViewById(R.id.One);
		Two = findViewById(R.id.Two);
		Three = findViewById(R.id.Three);
		Times = findViewById(R.id.Times);
		Four = findViewById(R.id.Four);
		Five = findViewById(R.id.Five);
		Six = findViewById(R.id.Six);
		Minus = findViewById(R.id.Minus);
		Seven = findViewById(R.id.Seven);
		eight = findViewById(R.id.eight);
		Nine = findViewById(R.id.Nine);
		Plus = findViewById(R.id.Plus);
		nonb = findViewById(R.id.nonb);
		Zero = findViewById(R.id.Zero);
		nonnn = findViewById(R.id.nonnn);
		Equal = findViewById(R.id.Equal);
		
		Clear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Result.setText("");
			}
		});
		
		Backspace.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Result.getText().toString().length() > 0) {
					Result.setText(Result.getText().toString().substring((int)(0), (int)(Result.getText().toString().length() - 1)));
				}
			}
		});
		
		non.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		Devide.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Add_Text("÷");
			}
		});
		
		One.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Add_Text("1");
			}
		});
		
		Two.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Add_Text("2");
			}
		});
		
		Three.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Add_Text("3");
			}
		});
		
		Times.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Add_Text("x");
			}
		});
		
		Four.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Add_Text("4");
			}
		});
		
		Five.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Add_Text("5");
			}
		});
		
		Six.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Add_Text("6");
			}
		});
		
		Minus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Add_Text("-");
			}
		});
		
		Seven.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Add_Text("7");
			}
		});
		
		eight.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Add_Text("8");
			}
		});
		
		Nine.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Add_Text("9");
			}
		});
		
		Plus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Add_Text("+");
			}
		});
		
		nonb.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		Zero.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Add_Text("0");
			}
		});
		
		nonnn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		Equal.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Input = Result.getText().toString();
				if (Input.contains("÷")) {
					Input = Input.replace("÷", "/");
				}
				if (Input.contains("x")) {
					Input = Input.replace("x", "*");
				}
				if (Input.contains("/0")) {
					FancyToast.makeText(MainActivity.this, "Cannot Devide By Zero", FancyToast.LENGTH_SHORT, FancyToast.ERROR , false).show();
				}
				else {
					try {
						Input = String.valueOf(_letsCalculate(Input));
						Result.setText(Input);
					} catch (Exception e) {
						FancyToast.makeText(MainActivity.this, "ERROR", FancyToast.LENGTH_SHORT, FancyToast.ERROR , false).show();
					}
				}
			}
		});
	}
	
	private void initializeLogic() {
		View decorView = getWindow().getDecorView();
		int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
		decorView.setSystemUiVisibility(uiOptions);
	}
	
	@Override
	public void onBackPressed() {
		Timer_Back = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						Back_count--;
					}
				});
			}
		};
		_timer.schedule(Timer_Back, (int)(2008));
		if (Back_count == 1) {
			finishAffinity();
		}
		else {
			Back_count++;
			FancyToast.makeText(MainActivity.this, "Tap Agains To Exit", FancyToast.LENGTH_SHORT, FancyToast.DEFAULT, false).show();
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		View decorView = getWindow().getDecorView();
		int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
		decorView.setSystemUiVisibility(uiOptions);
	}
	public void _Add_Text(final String _s) {
		Result.setText(Result.getText().toString() + _s);
	}
	
	
	public double _applyOp(final String _operatorX, final double _a, final double _b) {
		switch(_operatorX) {
			case "+":
			return (_b + _a);
			case "-":
			return (_b - _a);
			case "*":
			return (_b * _a);
			case "/":
			if (!(_a == 0)) {
				return (_b / _a);
			}
		}
		return 0;
	}
	
	
	public boolean _checkP(final String _operatorA, final String _operatorB) {
		if (_operatorB == "(" || _operatorB == ")") {
			return (false);
		}
		if ((_operatorA == "+" || _operatorA == "+") && (_operatorB == "*" || _operatorB == "/")) {
			return (false);
		}
		else {
			return (true);
		}
	}
	
	
	public double _letsCalculate(final String _mS) {
		    char[] myChar = _mS.toCharArray();
		
		    Stack<Float> myNumStack = new Stack<>();
		    Stack<Character> operatorStack = new Stack<>();
		
		    for (int i = 0; i < myChar.length; i++) {
			        if (Character.isDigit(myChar[i])) {
				            StringBuilder stringBuffer = new StringBuilder();
				
				            while (i < myChar.length && Character.isDigit(myChar[i])) {
					                stringBuffer.append(myChar[i++]);
					            }
				
				            myNumStack.push(Float.parseFloat(stringBuffer.toString()));
				            i--;
				        } else if (myChar[i] == '(') {
				            operatorStack.push(myChar[i]);
				        } else if (myChar[i] == ')') {
				            while (operatorStack.peek() != '(') {
					                myNumStack.push((float) _applyOp(String.valueOf(operatorStack.pop()), myNumStack.pop(), myNumStack.pop()));
					            }
				            operatorStack.pop();
				        } else if (myChar[i] == '/' || myChar[i] == '*' || myChar[i] == '+' || myChar[i] == '-') {
				            while (!operatorStack.empty() && _checkP(String.valueOf(myChar[i]), String.valueOf(operatorStack.peek()))) {
					                myNumStack.push((float) _applyOp(String.valueOf(operatorStack.pop()), myNumStack.pop(), myNumStack.pop()));
					            }
				            operatorStack.push(myChar[i]);
				        }
			    }
		
		    while (!operatorStack.empty()) {
			        myNumStack.push((float) _applyOp(String.valueOf(operatorStack.pop()), myNumStack.pop(), myNumStack.pop()));
			    }
		
		    return myNumStack.pop();
	}
	
}