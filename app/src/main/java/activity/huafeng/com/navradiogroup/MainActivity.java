package activity.huafeng.com.navradiogroup;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import activity.huafeng.com.navradiogroup.view.DragPointView;

/**TipButton和DragPointView
 * 仿QQ未读消息拖动红点消失
 * 主要是放置拖拽的TextView的位置setTextView();
 * 设置未读消息 textView.setText(“10”);
 *
 */
public class MainActivity extends AppCompatActivity {
    
    private DragPointView textView;
    private RadioGroup group;

    Manager_FindCar findFrg;
    Manager_Message msgFrg;
    Manager_Mine mineFrg;
    Manager_Order orderFrg;
    FrameLayout f1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //初始化
        textView =(DragPointView)findViewById(R.id.dpv_message);
        group = (RadioGroup)findViewById(R.id.group);
        f1= (FrameLayout) findViewById(R.id.fragment_container);

        //放置拖拽的TexView
        setTextView();

        defaultView();

        group.setOnCheckedChangeListener(listener);

    }

    private RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

            FragmentManager fm=getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            switch (checkedId){

            case R.id.tab_rb_news:

                if (findFrg ==null) {
                    findFrg=new Manager_FindCar();
                }
                ft.replace(R.id.fragment_container, findFrg);
                
            break;

            case  R.id.tab_rb_discover:
                if (msgFrg ==null) {
                    msgFrg=new Manager_Message();
                }
                ft.replace(R.id.fragment_container, msgFrg);
            break;



                case R.id.tab_rb_service:
                    if (orderFrg ==null) {
                        orderFrg=new Manager_Order();

                    }
                    ft.replace(R.id.fragment_container, orderFrg);

                break;

                case  R.id.tab_rb_myself:
                    if (mineFrg ==null) {
                        mineFrg=new Manager_Mine();
                    }
                    ft.replace(R.id.fragment_container, mineFrg );
                break;




            }

            ft.commit();
        }
    };

    private void setTextView() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.leftMargin  = screenWidth * 3/ 20; //设置红点位置
        textView.setLayoutParams(layoutParams);
        textView.setText(" ");//设置红点内容
        textView.setBackgroundColor( Color.RED);
    }

    //默认的fragment
    public void defaultView() {
        findFrg = new Manager_FindCar();
        //获得fragment管理者
        FragmentManager fm = getFragmentManager();
        //获取一个fragment事务
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, findFrg);
        ft.commit();
    }


}
