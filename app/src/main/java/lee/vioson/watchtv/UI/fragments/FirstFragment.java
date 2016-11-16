package lee.vioson.watchtv.UI.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lee.vioson.watchtv.R;

/**
 * Author:李烽
 * Date:2016-11-16
 * FIXME
 * Todo
 */

public class FirstFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_first, null);
        return inflate;
    }
}
