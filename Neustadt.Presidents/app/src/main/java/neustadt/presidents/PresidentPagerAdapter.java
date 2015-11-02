package neustadt.presidents;


import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PresidentPagerAdapter extends PagerAdapter {
private President[] presidents;
    public PresidentPagerAdapter(President[] presidents){
        this.presidents = presidents;
    }

    @Override
    public int getCount() {
        return presidents.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object){
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        President president = presidents[position];
        View view = inflater.inflate(R.layout.president_pager_item, null);

        TextView name = (TextView)view.findViewById(R.id.name);
        name.setText("Name: " + president.getPresident());
        TextView number = (TextView)view.findViewById(R.id.number);
        number.setText("Number: " + president.getNumber());
        TextView birthYear = (TextView)view.findViewById(R.id.birthYear);
        birthYear.setText("Birth Year: " + president.getBirthYear());
        TextView deathYear = (TextView)view.findViewById(R.id.deathYear);
        deathYear.setText("Death Year: " + president.getDeathYear());
        TextView tookOffice = (TextView)view.findViewById(R.id.tookOffice);
        tookOffice.setText("Took Office: " + president.getTookOffice());
        TextView leftOffice = (TextView)view.findViewById(R.id.leftOffice);
        leftOffice.setText("Left Office: " + president.getLeftOffice());
        TextView party = (TextView)view.findViewById(R.id.party);
        party.setText("Party: " + president.getParty());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View) object);
    }


}
