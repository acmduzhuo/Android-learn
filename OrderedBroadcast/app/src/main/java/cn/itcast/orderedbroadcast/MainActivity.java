package cn.itcast.orderedbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyBroadcastReceiverOne one;
    private MyBroadcastReceiverTwo two;
    private MyBroadcastReceiverThree three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver();
    }
    private void registerReceiver(){
        //动态注册MyBroadcastReceiverOne广播接受者
        one = new MyBroadcastReceiverOne();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(1000);//设置广播的优先级别
        filter.addAction("Intercept_Stitch");
        registerReceiver(one,filter);

        two = new MyBroadcastReceiverTwo();
        IntentFilter filter1 = new IntentFilter();
        filter.setPriority(200);//设置广播的优先级别
        filter.addAction("Intercept_Stitch");
        registerReceiver(two,filter1);

        three = new MyBroadcastReceiverThree();
        IntentFilter filter2 = new IntentFilter();
        filter.setPriority(600);//设置广播的优先级别
        filter.addAction("Intercept_Stitch");
        registerReceiver(three,filter2);
    }
    private void init(){
        Button btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("Intercept_S")
            }
        });
    }
}
