package pust.ice.krypton.pustcontacts.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.squareup.picasso.Picasso;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import pust.ice.krypton.pustcontacts.BuildConfig;
import pust.ice.krypton.pustcontacts.R;
import pust.ice.krypton.pustcontacts.pojo.OfficerPojo;

public class UserListAdapter extends Adapter<UserListAdapter.ViewHolder> {
    private final Context context;
    private boolean bool_pos = true;
    private Deque<OfficerPojo> data;
    private List<OfficerPojo> officerlist;
    private int officersize = 0;
    private Picasso picasso;
    private int residencesize = 0;
    private List<OfficerPojo> teacherlist;
    private int teachersize = 0;

    public UserListAdapter(Context context2) {
        this.context = context2;
        this.data = new LinkedList<>();
        this.picasso = Picasso.get();
        if (BuildConfig.DEBUG) {
            picasso.setLoggingEnabled(true);
        }
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (i == 0) {
            view = LayoutInflater.from(this.context).inflate(R.layout.recyclerview_empty, viewGroup, false);
        } else {
            view = LayoutInflater.from(this.context).inflate(R.layout.details_recycler_view, viewGroup, false);
        }
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (getItemViewType(i) != 0) {
            final OfficerPojo officerPojo = (OfficerPojo) ((LinkedList) this.data).get(i);
            if (officerPojo.getImages() != null) {
                if (BuildConfig.DEBUG) {
                    System.out.println(Constants.geturl(officerPojo.getImages(), officerPojo.getDir()));
                }
                this.picasso.load(Constants.geturl(officerPojo.getImages(), officerPojo.getDir())).placeholder(R.drawable.user).into(viewHolder.imageView);
            } else {
                this.picasso.load(Constants.geturl("",-1000)).placeholder(R.drawable.user).into(viewHolder.imageView);

            }
            viewHolder.name.setText(officerPojo.getName());
            viewHolder.des.setText(officerPojo.getDesignation());
            if (this.bool_pos && officerPojo.getFaculty() != null) {
                viewHolder.pos.setVisibility(View.VISIBLE);
                viewHolder.pos.setText(officerPojo.getFaculty());
            }
            viewHolder.cardview.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(Constants.DATA_KEY, officerPojo);
                    Navigation.findNavController(view).navigate(R.id.profileFragment, bundle);
                }
            });
        }
    }

    public int getItemCount() {
        if (this.data.size() == 0) {
            return 1;
        }
        return this.data.size();
    }

    public int getItemViewType(int i) {
        return this.data.size() == 0 ? 0 : 1;
    }

    public void setteachers(List<OfficerPojo> list) {
        if (list.size() != 0) {
            while (this.teachersize > 0) {
                this.data.removeFirst();
                this.teachersize--;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                this.data.addFirst(list.get(size));
            }
            this.teachersize += list.size();
            notifyDataSetChanged();
        }
    }

    public void setresidence(List<OfficerPojo> list) {
        if (list.size() != 0 && this.teachersize != 0) {
            Toast.makeText(this.context, "Error in Arrangement\n Contact with developer", Toast.LENGTH_LONG).show();
        } else if (list.size() != 0) {
            while (this.residencesize > 0) {
                this.data.removeFirst();
                this.residencesize--;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                this.data.addFirst(list.get(size));
            }
            this.residencesize += list.size();
            notifyDataSetChanged();
        }
    }

    public void setofficer(List<OfficerPojo> list) {
        if (list.size() != 0) {
            while (this.officersize > 0) {
                this.data.removeLast();
                this.officersize--;
            }
            for (OfficerPojo addLast : list) {
                this.data.addLast(addLast);
            }
            this.officersize += list.size();
            notifyDataSetChanged();
        }
    }

    public void enablePos(boolean z) {
        this.bool_pos = z;
    }

    public void setsearchresult(List<OfficerPojo> list) {
        if (list.size() != 0) {
            this.teacherlist = list;
            this.data.addAll(this.teacherlist);
        }
    }

    public void filter(String str) {
        if (this.teacherlist != null) {
            this.data.clear();
            for (OfficerPojo officerPojo : this.teacherlist) {
                if (officerPojo.getName().toLowerCase().contains(str.toLowerCase())) {
                    this.data.add(officerPojo);
                }
            }
            notifyDataSetChanged();
        }
    }

    class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private CardView cardview;
        private TextView des;
        private ImageView imageView;
        private TextView name;
        private TextView pos;

        ViewHolder(@NonNull View view) {
            super(view);
            this.cardview = view.findViewById(R.id.details_card);
            this.name = view.findViewById(R.id.profile_name);
            this.des = view.findViewById(R.id.des);
            this.pos = view.findViewById(R.id.pos);
            this.imageView = view.findViewById(R.id.avatar);
        }
    }
}
