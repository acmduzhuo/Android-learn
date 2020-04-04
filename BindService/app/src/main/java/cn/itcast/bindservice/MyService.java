package cn.itcast.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public void methodInService() {
        Log.i("MyService", "执行服务中的methodInService()方法");
    }

    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.i("MyService", "创建服务，执行onCreate（）方法");
        super.onCreate();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("MyService", "绑定服务，执行onUnbind（）方法");
        return new MyBind();
    }
    private class MyBind extends Binder{
        public void  callMethodInService(){
            methodInService();
        }
    }

    public class MyBinder {
        public void callMethodInService() {
        }
    }
}
