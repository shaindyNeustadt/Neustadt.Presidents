package neustadt.presidents;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnPresidentSelectedListener{
private PresidentListFragment listFragment;
private PresidentDetailFragment detailFragment;
private int[] pictures;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        listFragment =
                (PresidentListFragment) manager.findFragmentById(R.id.PresidentListFragment);
        detailFragment =
                (PresidentDetailFragment)manager.findFragmentById(R.id.detailFragment);

        //should be put into detail activity, and not sent through intent
        pictures = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f,
                R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n,
                R.drawable.o, R.drawable.p, R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.t, R.drawable.u, R.drawable.v,
                R.drawable.w, R.drawable.v, R.drawable.x, R.drawable.y, R.drawable.z, R.drawable.za, R.drawable.zb, R.drawable.zc,
                R.drawable.zd, R.drawable.ze, R.drawable.zf, R.drawable.zg, R.drawable.zh, R.drawable.zi, R.drawable.zj, R.drawable.zk,
                R.drawable.zl,R.drawable.zm, R.drawable.zn, R.drawable.zo, R.drawable.zk, R.drawable.zq};
    }

    @Override
    public void onSelect(President[] presidents, int position, int[] pictures) {
        if(detailFragment != null) {
            detailFragment.showPresidentDetail(presidents, position, pictures);
        }
        else{
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("PRESIDENTS", presidents);
            intent.putExtra("POSITION", position);
            intent.putExtra("PICTURES", pictures);
            this.startActivity(intent);
        }
    }
}
