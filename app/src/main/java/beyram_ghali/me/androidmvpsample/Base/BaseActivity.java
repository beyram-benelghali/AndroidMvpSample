package beyram_ghali.me.androidmvpsample.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by beyram on 20/06/17.
 */
public abstract class BaseActivity extends AppCompatActivity {

    Unbinder unbinder;

    protected abstract void initializeMVP();

    public abstract int getLayoutId();

    /**
     * SETUP MVP + Bind View
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initializeMVP();
    }

    /**
     * Unbind View onDestroy
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


}
