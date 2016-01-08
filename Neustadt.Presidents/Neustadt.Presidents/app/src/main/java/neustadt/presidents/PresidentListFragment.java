package neustadt.presidents;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.InputStreamReader;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;


public class PresidentListFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<President> presidents;
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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PresidentsService service = retrofit.create(PresidentsService.class);
        Call<List<President>> call = service.listPresidents();
        call.enqueue(new Callback<List<President>>() {

            @Override
            public void onResponse(Response<List<President>> response) {
                presidents = response.body();

                pictures = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f,
                        R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n,
                        R.drawable.o, R.drawable.p, R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.t, R.drawable.u, R.drawable.v,
                        R.drawable.w, R.drawable.v, R.drawable.x, R.drawable.y, R.drawable.z, R.drawable.za, R.drawable.zb, R.drawable.zc,
                        R.drawable.zd, R.drawable.ze, R.drawable.zf, R.drawable.zg, R.drawable.zh, R.drawable.zi, R.drawable.zj, R.drawable.zk,
                        R.drawable.zl, R.drawable.zm, R.drawable.zn, R.drawable.zo, R.drawable.zk, R.drawable.zq};
                OnPresidentSelectedListener listener = (OnPresidentSelectedListener) getActivity();
                PresidentAdapter adapter = new PresidentAdapter(presidents, pictures, listener);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });


        super.onViewCreated(view, savedInstanceState);
    }

}