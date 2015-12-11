package neustadt.presidents;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;

public class PresidentListFragment extends Fragment {
private RecyclerView recyclerView;
private President[] presidents;
private int[] pictures;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_president_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        InputStream in = getResources().openRawResource(R.raw.presidents);

        presidents = gson.fromJson(new InputStreamReader(in), President[].class);
        pictures = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f,
                R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n,
                R.drawable.o, R.drawable.p, R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.t, R.drawable.u, R.drawable.v,
                R.drawable.w, R.drawable.v, R.drawable.x, R.drawable.y, R.drawable.z, R.drawable.za, R.drawable.zb, R.drawable.zc,
                R.drawable.zd, R.drawable.ze, R.drawable.zf, R.drawable.zg, R.drawable.zh, R.drawable.zi, R.drawable.zj, R.drawable.zk,
                R.drawable.zl,R.drawable.zm, R.drawable.zn, R.drawable.zo, R.drawable.zk, R.drawable.zq};
        PresidentAdapter adapter = new PresidentAdapter(presidents, pictures);
        recyclerView.setAdapter(adapter);

        super.onViewCreated(view, savedInstanceState);
    }

}