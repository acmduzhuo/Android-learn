package cn.itcast.bindservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_bind;
    private Button btn_call;
    private Button btn_unbind;
    private MyService.MyBinder myBinder;
    private MyConn myconn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void init(){
        btn_bind = findViewById(R.id.btn_bind);
        btn_call = findViewById(R.id.btn_call);
        btn_unbind = findViewById(R.id.btn_unbind);
        //三个按钮的点击监听事件
        btn_bind.setOnClickListener(this);
        btn_call.setOnClickListener(this);
        btn_unbind.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bind://绑定服务按钮的绑定事件
                if(myBinder == null){
                    myconn = new MyConn();
                }
                Intent intent = new Intent(MainActivity.this, MyService.class);
                bindService(intent,myconn,BIND_AUTO_CREATE);
                break;
            case  R.id.btn_call:
                myBinder.callMethodInService();
                break;
            case R.id.btn_unbind:
                if(myconn != null){
                    unbindService(myconn);//解绑服务
                    myconn=null;
                }
                break;


        }
    }
    private class  MyConn implements ServiceConnection{


        private Object IBinder;

        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {
            /**
             * 当成功绑定服务时使用的方法，该方法获取Service和bind的对象
             */
            myBinder = (MyService.MyBinder) IBinder;
            Log.i("MainActivity", "服务绑定成功，内存地址为"+myBinder.toString());
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
