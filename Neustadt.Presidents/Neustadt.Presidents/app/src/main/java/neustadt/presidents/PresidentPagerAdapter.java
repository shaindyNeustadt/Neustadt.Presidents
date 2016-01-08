package neustadt.presidents;


import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PresidentPagerAdapter extends PagerAdapter {
    private President[] presidents;

    public PresidentPagerAdapter(President[] presidents) {
        this.presidents = presidents;
    }

    @Override
    public int getCount() {
        return presidents.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        President president = presidents[position];
        View view = inflater.inflate(R.layout.president_pager_item, null);

        ImageView image = (ImageView) view.findViewById(R.id.image);
        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(president.getPresident());
        TextView number = (TextView) view.findViewById(R.id.number);
        number.setText("President #" + president.getNumber());
        TextView years = (TextView) view.findViewById(R.id.years);

        int[] pictures = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f,
                R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l, R.drawable.m, R.drawable.n,
                R.drawable.o, R.drawable.p, R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.t, R.drawable.u, R.drawable.v,
                R.drawable.w, R.drawable.v, R.drawable.x, R.drawable.y, R.drawable.z, R.drawable.za, R.drawable.zb, R.drawable.zc,
                R.drawable.zd, R.drawable.ze, R.drawable.zf, R.drawable.zg, R.drawable.zh, R.drawable.zi, R.drawable.zj, R.drawable.zk,
                R.drawable.zl, R.drawable.zm, R.drawable.zn, R.drawable.zo, R.drawable.zk, R.drawable.zq};

        image.setImageResource(pictures[position]);

        if (president.getDeathYear() == null) {
            years.setText(president.getBirthYear() + "-Present");
        } else {
            years.setText(president.getBirthYear() + "-" + president.getDeathYear());
        }
        TextView officeYears = (TextView) view.findViewById(R.id.officeYears);
        if (president.getLeftOffice() == null) {
            officeYears.setText(president.getTookOffice() + "-Present");
        } else {
            officeYears.setText(president.getTookOffice() + "-" + president.getLeftOffice());
        }
        TextView party = (TextView) view.findViewById(R.id.party);
        party.setText(president.getParty());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


}
