package com.example.labtest_2_ui_ci;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


abstract  class vehicle{
   private  int  wheels;
   protected double fuel;
    protected double milage;


    vehicle(int w){
        wheels=w;
        fuel=0;
        milage=0;
    }

   public int wheels(){ return wheels;}
    public  double fuel(){ return fuel;}
   public double milage(){
        return milage;
    }

    public void petrol(double l){fuel+=l;}


   abstract public String drive();




}


class sedan extends vehicle{


//    private double fuel;
//    private double milage;


    sedan(){
        super(4);

    }

    @Override
    public String drive() {
        if (this.fuel >= 2) {
            this.milage += 5;
            this.fuel -= 2;
        }
        return "fuel:"+fuel+"L"+" milage:"+milage+"m";
    }
}

class motorcycle extends vehicle{


//    private double fuel;
//    private double milage;


    motorcycle(){
        super(2);

    }

    @Override
    public String drive() {
        if (this.fuel >= 1.5) {
            this.milage += 0.5;
            this.fuel -= 1.5;
        }
        return "fuel:"+fuel+"L"+" milage:"+milage+"m";

    }
}


class SUV extends vehicle{


//    private double fuel;
//    private double milage;


    SUV(){
        super(4);

    }

    @Override
    public String drive() {
        if (this.fuel >= 4) {
            this.milage += 2.5;
            this.fuel -= 4;
        }
        return "fuel:"+fuel+"L"+" milage:"+milage+"m";

    }
}

class  color{
    private  String name;

    color(String c){
        name=c;
    }

    public String showcolor(){
       return name;
    }
}

class red extends color{
    red(){
        super("red");
    }
}

class green extends color{
    green(){
        super("green");
    }
}

class blue extends color{
    blue(){
        super("blue");
    }
}


public class MainActivity extends AppCompatActivity {


    EditText et4,et5,et6;
    TextView tv3,tv4;
    Button button2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        et4=findViewById(R.id.editTextText4);
        et5=findViewById(R.id.editTextText5);
        et6=findViewById(R.id.editTextText6);
        tv3=findViewById(R.id.textView3);
        tv4=findViewById(R.id.textView4);
        button2=findViewById(R.id.button2);




        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit4,edit5;
                double edit6;
                edit4=et4.getText().toString();
                edit5=et5.getText().toString();
                edit6=Double.parseDouble(et6.getText().toString());
                if(edit4.equals("sedan")){
                    sedan s=new sedan();
                    s.petrol(edit6);
                    tv3.setText(s.drive());

                }
                else if(edit4.equals("motorcycle")){
                    motorcycle s=new motorcycle();
                    s.petrol(edit6);
                    tv3.setText(s.drive());
                }
                else if(edit4.equals("suv")){
                    SUV s=new SUV();
                    s.petrol(edit6);
                    tv3.setText(s.drive());
                }

                if(edit5.toLowerCase().equals("red")){
                    color r=new red();
                    tv4.setText(r.showcolor());
                }
                else if(edit5.toLowerCase().equals("blue")){
                    color r=new blue();
                    tv4.setText(r.showcolor());
                }
                else if(edit5.toLowerCase().equals("green")){
                    color r=new green();
                    tv4.setText(r.showcolor());
                }

            }
        });




    }
}