package neustadt.presidents;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        President[] presidents = (President[]) getIntent().getSerializableExtra("PRESIDENTS");
        int position = getIntent().getIntExtra("POSITION", 0);
        int[] pictures = getIntent().getIntArrayExtra("PICTURES");
        PresidentPagerAdapter adapter = new PresidentPagerAdapter(presidents, pictures);
        viewPager.setAdapter(adapter);

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);

    }
}
