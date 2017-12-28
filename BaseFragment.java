import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class BaseFragment extends Fragment {

    public void setActivity(Activity activity) {
        this.me = activity;
    }

    public Activity me = getActivity();

    public BaseFragment() {
    }

    private Toast toast;

    protected void runOnMain(Runnable runnable) {
        me.runOnUiThread(runnable);
    }

    protected final static String NULL = "";

    //简易吐司
    public void toast(final Object obj) {
        try {
            runOnMain(new Runnable() {

                @Override
                public void run() {
                    if (toast == null)
                        toast = Toast.makeText(me, NULL, Toast.LENGTH_SHORT);
                    toast.setText(obj.toString());
                    toast.show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void log(final Object var1) {
        try {
            runOnMain(new Runnable() {
                public void run() {
                    Log.i("log", var1.toString());
                }
            });
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    //位移动画
    public void moveAnimation(Object obj, String perference, float aimValue, long time, long delay) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(obj, perference, aimValue);
        objectAnimator.setDuration(time);
        objectAnimator.setStartDelay(delay);
        objectAnimator.start();
    }

    public void moveAnimation(Object obj, String perference, float aimValue, long time) {
        moveAnimation(obj, perference, aimValue, time, 0);
    }

    public void moveAnimation(Object obj, String perference, float aimValue) {
        moveAnimation(obj, perference, aimValue, 300, 0);
    }

    //用于进行dip和px转换
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    //用于进行px和dip转换
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
