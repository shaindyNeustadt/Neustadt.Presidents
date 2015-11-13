package neustadt.presidents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private President[] presidents;
private int[] pictures;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

        InputStream in = getResources().openRawResource(R.raw.presidents);

        presidents = gson.fromJson(new InputStreamReader(in), President[].class);
        pictures = new int[]{R.drawable.a  , R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f,
                R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n,
                R.drawable.o, R.drawable.p, R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.t, R.drawable.u, R.drawable.v,
                R.drawable.w, R.drawable.v, R.drawable.x, R.drawable.y, R.drawable.z, R.drawable.za, R.drawable.zb, R.drawable.zc, R.drawable.zd,
                R.drawable.ze, R.drawable.zf,R.drawable.zg, R.drawable.zh, R.drawable.zi, R.drawable.zj, R.drawable.zk, R.drawable.zl,
                R.drawable.zm, R.drawable.zn,R.drawable.zo, R.drawable.zk, R.drawable.zq};
        PresidentAdapter adapter = new PresidentAdapter(presidents, pictures);
        recyclerView.setAdapter(adapter);



    }
}
