package pust.ice.krypton.pustcontacts.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;


import com.google.firebase.analytics.FirebaseAnalytics;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import pust.ice.krypton.pustcontacts.BuildConfig;
import pust.ice.krypton.pustcontacts.database.tables.Nocs;
import pust.ice.krypton.pustcontacts.database.tables.Notices;
import pust.ice.krypton.pustcontacts.database.tables.ResultNotices;
import pust.ice.krypton.pustcontacts.databinding.NoticeReItemBinding;
import pust.ice.krypton.pustcontacts.databinding.RecyclerviewEmptyBinding;


public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {

    private FirebaseAnalytics mFirebaseAnalytics;
    private static final int VIEW_EMPTY = 0;
    public static final int VIEW_NOTICE = 1, VIEW_NOC = 2, VIEW_RESULT = 3, VIEW_JOB = 4,VIEW_PRESS=5;
    private final Context context;
    private List<?> datalist;
    private int mode = -1;

    public NoticeAdapter(Context context, @NonNull int mode) {
        this.context = context;
        this.mode = mode;
        datalist = new ArrayList();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_NOTICE:
            case VIEW_NOC:
            case VIEW_RESULT:
            case VIEW_PRESS:
            case VIEW_JOB:
                return new ViewHolder(NoticeReItemBinding.inflate(LayoutInflater.from(context), parent, false));
            default:
                return new ViewHolder(RecyclerviewEmptyBinding.inflate(LayoutInflater.from(context), parent, false));

        }
    }

    public int getItemViewType(int i) {
        return this.datalist.size() == 0 ? VIEW_EMPTY : mode;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (!(holder.binding instanceof RecyclerviewEmptyBinding))
            switch (holder.getItemViewType()) {
                case VIEW_NOTICE:
//                    throw new RuntimeException("Test Crash");
                case VIEW_PRESS:
                    NoticeReItemBinding binding = (NoticeReItemBinding) holder.binding;
                    final Notices data = (Notices) datalist.get(position);
                    binding.title.setText(data.getTitle());

//                    DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
                    DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

//                String string1 = "2020-08-18T13:53:32.000000Z";
                    SimpleDateFormat output = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

                    try {
                        Date temp = df1.parse(data.getUpdated_at());
                        assert temp != null;
                        binding.pdate.setText("P: " + output.format(temp));

                    } catch (Exception e) {
                        Bundle params = new Bundle();
                        params.putString("DATE", data.getUpdated_at());
                        mFirebaseAnalytics.logEvent("Parse_error", params);
                        e.printStackTrace();
                    }
                    binding.dbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            String url = BuildConfig.URL + "includes/images/notices/" + data.getFile();
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            context.startActivity(intent);

                        }
                    });
                    break;
                case VIEW_RESULT:
                    binding = (NoticeReItemBinding) holder.binding;
                    final ResultNotices rdata = (ResultNotices) datalist.get(position);
                    binding.title.setText(rdata.getTitle());
                    binding.title2.setText(rdata.getDept_code());
                    binding.title2.setVisibility(View.VISIBLE);
                    binding.title3.setText(rdata.getSession());
                    binding.title3.setVisibility(View.VISIBLE);


                    df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                    output = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

                    try {
                        Date temp = df1.parse(rdata.getUpdated_at());
                        assert temp != null;
                        binding.pdate.setText("P: " + output.format(temp));

                    } catch (Exception e) {
                        Bundle params = new Bundle();
                        params.putString("DATE", rdata.getUpdated_at());
                        mFirebaseAnalytics.logEvent("Parse_error", params);
                        e.printStackTrace();
                    }
                    binding.dbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            String url = BuildConfig.URL + "includes/images/result-notices/" + rdata.getFile();
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            context.startActivity(intent);
                        }
                    });
                    break;
                case VIEW_NOC:
                    binding = (NoticeReItemBinding) holder.binding;
                    final Nocs datanoc = (Nocs) datalist.get(position);
                    binding.title.setText(datanoc.getName());
                    binding.title2.setText(datanoc.getDesignation());
                    binding.title2.setVisibility(View.VISIBLE);
                    binding.title3.setText(datanoc.getDepartment());
                    binding.title3.setVisibility(View.VISIBLE);

                    df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
//                String string1 = "2020-08-18T13:53:32.000000Z";
                    output = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

                    try {
                        Date temp = df1.parse(datanoc.getUpdated_at());
                        assert temp != null;
                        binding.pdate.setText("P: " + output.format(temp));

                    } catch (Exception e) {
                        Bundle params = new Bundle();
                        params.putString("DATE", datanoc.getUpdated_at());
                        mFirebaseAnalytics.logEvent("Parse_error", params);
                        e.printStackTrace();
                    }
                    binding.dbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            String url = BuildConfig.URL + "includes/images/noc/" + datanoc.getFile();
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            context.startActivity(intent);

                        }
                    });
                    break;
                case VIEW_JOB:
                    binding = (NoticeReItemBinding) holder.binding;
                    final Notices datajob = (Notices) datalist.get(position);
                    binding.title.setText(datajob.getTitle());

                    df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                    output = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

                    try {
                        Date temp = df1.parse(datajob.getUpdated_at());
                        assert temp != null;
                        binding.pdate.setText("P: " + output.format(temp));

                    } catch (Exception e) {
                        Bundle params = new Bundle();
                        params.putString("DATE", datajob.getUpdated_at());
                        mFirebaseAnalytics.logEvent("Parse_error", params);
                        e.printStackTrace();
                    }
                    try {
                        if(datajob.getExpired()!=null)
                        {
                            Date temp = df1.parse(datajob.getExpired());
                            assert temp != null;
                            binding.edate.setText("E: " + output.format(temp));
                            binding.edate.setVisibility(View.VISIBLE);
                        }


                    } catch (Exception e) {
                        Bundle params = new Bundle();
                        params.putString("DATE", datajob.getExpired());
                        mFirebaseAnalytics.logEvent("Parse_error", params);
                        e.printStackTrace();
                    }
                    binding.dbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            String url = BuildConfig.URL + "includes/images/notices/" + datajob.getFile();
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            context.startActivity(intent);
                        }
                    });
                    binding.application.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String url = BuildConfig.URL + "academic/form_download";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            context.startActivity(intent);
                        }
                    });
                    binding.application.setVisibility(View.VISIBLE);
                    break;
            }
    }

    @Override
    public int getItemCount() {
        if (this.datalist.size() == 0) {
            return 1;
        }
        return this.datalist.size();
    }

    public void setData(List<?> notices) {
        datalist = notices;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ViewBinding binding;

        public ViewHolder(@NonNull ViewBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
