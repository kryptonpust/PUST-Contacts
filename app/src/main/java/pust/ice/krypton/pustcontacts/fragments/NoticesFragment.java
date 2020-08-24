package pust.ice.krypton.pustcontacts.fragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pust.ice.krypton.pustcontacts.MainViewModel;
import pust.ice.krypton.pustcontacts.R;
import pust.ice.krypton.pustcontacts.adapters.Constants;
import pust.ice.krypton.pustcontacts.adapters.NoticeAdapter;
import pust.ice.krypton.pustcontacts.database.tables.Nocs;
import pust.ice.krypton.pustcontacts.database.tables.Notices;
import pust.ice.krypton.pustcontacts.database.tables.ResultNotices;
import pust.ice.krypton.pustcontacts.databinding.NoticesFragmentBinding;

public class NoticesFragment extends Fragment {

    private MainViewModel mViewModel;
    private NoticesFragmentBinding binding;
    private Constants.ORIGIN origin;
    private NoticeAdapter adapter;
    public static NoticesFragment newInstance() {
        return new NoticesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding=NoticesFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
        assert getArguments() != null;

        origin= Constants.ORIGIN.valueOf(getArguments().getString(Constants.ORIGIN_KEY));
        switch (origin)
        {
            case NOTICES:
                adapter=new NoticeAdapter(getContext(),NoticeAdapter.VIEW_NOTICE);
                mViewModel.getAllNotices("%general%").observe(getViewLifecycleOwner(), new Observer<List<Notices>>() {
                    @Override
                    public void onChanged(List<Notices> notices) {
                        adapter.setData(notices);
                    }
                });
                break;
            case NOC:
                adapter=new NoticeAdapter(getContext(),NoticeAdapter.VIEW_NOC);
                mViewModel.getAllNoc().observe(getViewLifecycleOwner(), new Observer<List<Nocs>>() {
                    @Override
                    public void onChanged(List<Nocs> nocs) {
                        adapter.setData(nocs);
                    }
                });
                break;
            case JOB:
                adapter=new NoticeAdapter(getContext(),NoticeAdapter.VIEW_JOB);
                mViewModel.getAllNotices("%job%").observe(getViewLifecycleOwner(), new Observer<List<Notices>>() {
                    @Override
                    public void onChanged(List<Notices> notices) {
                        adapter.setData(notices);
                    }
                });
                break;
            case PRESS:
                adapter=new NoticeAdapter(getContext(),NoticeAdapter.VIEW_PRESS);
                mViewModel.getAllNotices("%press%").observe(getViewLifecycleOwner(), new Observer<List<Notices>>() {
                    @Override
                    public void onChanged(List<Notices> notices) {
                        adapter.setData(notices);
                    }
                });
                break;
            case RESULT:
                adapter=new NoticeAdapter(getContext(),NoticeAdapter.VIEW_RESULT);
                mViewModel.getallRNOT().observe(getViewLifecycleOwner(), new Observer<List<ResultNotices>>() {
                    @Override
                    public void onChanged(List<ResultNotices> resultNotices) {
                        adapter.setData(resultNotices);
                    }
                });
                break;
        }
        assert adapter != null;
        binding.recylerView.setAdapter(adapter);
        binding.recylerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}