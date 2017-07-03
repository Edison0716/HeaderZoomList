package project.com.headerzoomlist;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import project.com.pulltozoomlist.PullToZoomRecyclerViewEx;
import project.com.pulltozoomlist.RecyclerViewHeaderAdapter;


public class MainActivity extends AppCompatActivity implements PullToZoomRecyclerViewEx.OnRefreshingListener{
    private List<ItemBean> name = new ArrayList<>();
    private PullToZoomRecyclerViewEx mRvList;
    private RecyclerViewHeaderAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

       // RelativeLayout view = (RelativeLayout) findViewById(R.id.view);
        StatusBarUtils.setTranslucentImageHeader(this,0,null);
        mRvList = (PullToZoomRecyclerViewEx) findViewById(R.id.rv_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mAdapter = new RecyclerAdapterCustom(this);

        mRvList.setAdapterAndLayoutManager(mAdapter,manager);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        AbsListView.LayoutParams localObject = new AbsListView.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        mRvList.setHeaderLayoutParams(localObject);
        mRvList.setOnRefreshingListener(this);

    }

    private void initData() {
        for (int i = 0;i<50;i++){
            name.add(new ItemBean("haha"+String.valueOf(i)));
        }
    }

    @Override
    public void onRefreshing() {
        Toast.makeText(getApplicationContext(),"刷新中...",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onReleaseToRefreshing() {
        //Toast.makeText(getApplicationContext(),"释放开始刷新哦！",Toast.LENGTH_SHORT).show();
    }

    public class RecyclerAdapterCustom extends RecyclerViewHeaderAdapter<ViewHolderRecyclerPullToZoom> {
        final String[] adapterData = new String[]{"Activity", "Service", "Content Provider", "Intent", "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient",
                "DDMS", "Android Studio", "Fragment", "Loader", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent", "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient",
                "DDMS", "Android Studio", "Fragment", "Loader", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent", "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient",
                "DDMS", "Android Studio", "Fragment", "Loader", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent", "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient",
                "DDMS", "Android Studio", "Fragment", "Loader", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent", "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient",
                "DDMS", "Android Studio", "Fragment", "Loader", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient"};

        public RecyclerAdapterCustom(Context context) {
            super(context);
        }

        @Override
        public int getCount() {
            return adapterData.length;
        }


        @Override
        public ViewHolderRecyclerPullToZoom onCreateContentView(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_layout, null);

            return new ViewHolderRecyclerPullToZoom(view);
        }

        @Override
        public void onBindView(ViewHolderRecyclerPullToZoom view, int position) {

            view.mtextview.setText(adapterData[position]);

//            final StaggeredGridLayoutManager.LayoutParams lp =
//                    (StaggeredGridLayoutManager.LayoutParams) view.mtextview.getLayoutParams();
////
//            lp.span = span;
//            lp.height = size;
//            itemView.setLayoutParams(lp);


        }
    }

    public static class ViewHolderRecyclerPullToZoom extends RecyclerView.ViewHolder {

        TextView mtextview;

        public ViewHolderRecyclerPullToZoom(View view) {
            super(view);
            mtextview = view.findViewById(R.id.tv_name);
        }
    }

}
