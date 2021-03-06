package co.humaniq.views;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import co.humaniq.R;
import co.humaniq.Router;


public class ToolbarActivity extends BaseActivity {
    private Toolbar toolbar;
    private TextView toolbarTitle;
    private ActionBar actionBar;
    private ImageView toolbarImage;

    public Toolbar getToolbar() {
        return toolbar;
    }
    public ActionBar getActivityActionBar() {
        return actionBar;
    }

    protected void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();

        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(getTitle());

        toolbarImage = (ImageView) toolbar.findViewById(R.id.toolbar_logo);

        if (getTitle().equals(getString(R.string.app_name))) {
            toolbarTitle.setVisibility(View.GONE);
            toolbarImage.setVisibility(View.VISIBLE);
        } else {
            toolbarTitle.setVisibility(View.VISIBLE);
            toolbarImage.setVisibility(View.GONE);
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        toolbarTitle.setText(title);
        super.setTitle(title);
    }

    @Override
    public void setTitle(@StringRes int titleId) {
        toolbarTitle.setText(titleId);
        super.setTitle(titleId);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            case R.id.help:
                showHelp();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showHelp() {
        Bundle bundle = new Bundle();
        bundle.putInt("gifId", R.drawable.humaniq_1_medium);
        Router.setBundle(bundle);
        Router.goActivity(this, Router.VIDEO);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.default_menu, menu);
        return true;
    }
}
