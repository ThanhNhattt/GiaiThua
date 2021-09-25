package com.example.giaithua;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bcham, bbang, bchia, bnhan, btru, bcong, bc, bac, bb1, bb2, bb3, bb4;
    TextView soa, sob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);
        bcham = findViewById(R.id.bcham);
        bbang = findViewById(R.id.bbang);
        bchia = findViewById(R.id.bchia);
        bnhan = findViewById(R.id.bnhan);
        btru = findViewById(R.id.btru);
        bcong = findViewById(R.id.bcong);
        bc = findViewById(R.id.bc);
        bac = findViewById(R.id.bac);
        bb1 = findViewById(R.id.bb1);
        bb2 = findViewById(R.id.bb2);
        bb3 = findViewById(R.id.bb3);
        bb4 = findViewById(R.id.bb4);

        soa = findViewById(R.id.soa);
        sob = findViewById(R.id.sob);

        //onclick
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText(soa.getText() + "1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText(soa.getText() + "2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText(soa.getText() + "3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText(soa.getText() + "4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText(soa.getText() + "5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText(soa.getText() + "6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText(soa.getText() + "7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText(soa.getText() + "8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText(soa.getText() + "9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText(soa.getText() + "0");
            }
        });
        bcham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText(soa.getText() + ".");
            }
        });
        bbang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = soa.getText().toString();
                String replacedString = val.replace('÷','/').replace('×', '*');
                double result = eval(replacedString);
                String r = String.valueOf(result);
                soa.setText(r);
                sob.setText(val);
            }
        });
        bchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText(soa.getText() + "÷");
            }
        });
        bnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText(soa.getText() + "x");
            }
        });
        btru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText(soa.getText() + "-");
            }
        });
        bcong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText(soa.getText() + "+");
            }
        });
        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText("");
                sob.setText("");
            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = soa.getText().toString();
                val = val.substring(0, val.length() - 1);
                soa.setText(val);
            }
        });
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText(soa.getText() + "(");
            }
        });
        bb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soa.setText(soa.getText() + ")");
            }
        });
        bb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val = Integer.parseInt(soa.getText().toString());
                int fact = factorial(val);
                soa.setText(String.valueOf(fact));
                sob.setText(val + "!");
            }

            int factorial(int n) {
                // find factorial
                return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
            }

        });
        bb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double d = Double.parseDouble(soa.getText().toString());
                double square = d * d;
                soa.setText(String.valueOf(square));
                sob.setText(d + "²");
            }
        });

    }
        //evaluation

        public static double eval (final String str){
            return new Object() {
                int pos = -1, ch;

                void nextChar() {
                    ch = (++pos < str.length()) ? str.charAt(pos) : -1;
                }

                boolean eat(int charToEat) {
                    while (ch == ' ') nextChar();
                    if (ch == charToEat) {
                        nextChar();
                        return true;
                    }
                    return false;
                }

                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                    return x;
                }

                double parseExpression() {
                    double x = parseTerm();
                    for (; ; ) {
                        if (eat('+')) x += parseTerm(); // addition
                        else if (eat('-')) x -= parseTerm(); // subtraction
                        else return x;
                    }
                }

                double parseTerm() {
                    double x = parseFactor();
                    for (; ; ) {
                        if (eat('x')) x *= parseFactor(); // multiplication
                        else if (eat('/')) x /= parseFactor(); // division
                        else return x;
                    }
                }

                double parseFactor() {
                    if (eat('+')) return parseFactor(); // unary plus
                    if (eat('-')) return -parseFactor(); // unary minus

                    double x = 0;
                    int startPos = this.pos;
                    if (eat('(')) { // parentheses
                        x = parseExpression();
                        eat(')');
                    } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                        while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                        x = Double.parseDouble(str.substring(startPos, this.pos));
                    }

                    if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                    return x;
                }
            }.parse();
        }
    }
