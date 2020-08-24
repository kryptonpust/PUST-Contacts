package pust.ice.krypton.pustcontacts.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import java.util.List;

import pust.ice.krypton.pustcontacts.MainViewModel;
import pust.ice.krypton.pustcontacts.R;
import pust.ice.krypton.pustcontacts.adapters.Constants;
import pust.ice.krypton.pustcontacts.adapters.Constants.ORIGIN;
import pust.ice.krypton.pustcontacts.adapters.MainAdapter;
import pust.ice.krypton.pustcontacts.database.tables.Menus;

public class StartFragment extends Fragment {
    private MainAdapter adapter;
    private MainViewModel mainViewModel;
    private ShimmerRecyclerView mainrecyclerview;
    private ORIGIN origin;
    private int lastFirstVisiblePosition;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getArguments() == null) {
            this.origin = ORIGIN.NULL;
        } else {
            this.origin = ORIGIN.valueOf(getArguments().getString(Constants.ORIGIN_KEY, "NULL"));
        }
        this.mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        View inflate = layoutInflater.inflate(R.layout.main_fragment, viewGroup, false);
        this.mainrecyclerview = inflate.findViewById(R.id.recyclerview);
        this.mainrecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        this.adapter = new MainAdapter(this.origin, getContext());
        this.mainrecyclerview.setAdapter(this.adapter);
        this.mainrecyclerview.showShimmerAdapter();
        this.adapter.registerAdapterDataObserver(new AdapterDataObserver() {
            public void onChanged() {
                hideshimmerlayout();
            }
        });
        this.mainViewModel.getmenus().observe(getViewLifecycleOwner(), new Observer<List<Menus>>() {
            public void onChanged(List<Menus> list) {
                StartFragment.this.adapter.setdata(list);
            }
        });
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void hideshimmerlayout() {
        this.mainrecyclerview.hideShimmerAdapter();
        ((LinearLayoutManager) mainrecyclerview.getLayoutManager()).scrollToPositionWithOffset(lastFirstVisiblePosition, 0);
    }


    @Override
    public void onPause() {
        super.onPause();
        lastFirstVisiblePosition = ((LinearLayoutManager) mainrecyclerview.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
    }
}
