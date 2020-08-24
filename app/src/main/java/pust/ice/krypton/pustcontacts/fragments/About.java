package pust.ice.krypton.pustcontacts.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.Fragment;

import pust.ice.krypton.pustcontacts.R;

public class About extends Fragment {
    private TextView textView;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_about, viewGroup, false);
        this.textView = inflate.findViewById(R.id.about_textview);
        return inflate;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent intent = new Intent("android.intent.action.SENDTO");
                StringBuilder sb = new StringBuilder();
                sb.append("mailto:");
                sb.append("manwar.ice@gmail.com");
                intent.setData(Uri.parse(sb.toString()));
                if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        };
        SpannableString spannableString = new SpannableString("Developed by\n");
        SpannableString spannableString2 = new SpannableString("ICE #09 BATCH\n\n");
        SpannableString spannableString3 = new SpannableString("Maintained by\n");
        SpannableString spannableString4 = new SpannableString("ICT Cell, PUST\n\n");
        SpannableString spannableString5 = new SpannableString("Inspired by\n");
        SpannableString spannableString6 = new SpannableString("Md. Anwar Hossain\n");
        SpannableString spannableString7 = new SpannableString("Director, ICT Cell, PUST\n" +
                "&\n" +
                "Assistant Professor\n" +
                "Dept. of ICE, PUST\n" +
                "Email: ");
        SpannableString spannableString8 = new SpannableString("manwar.ice@gmail.com\n\n");
        SpannableString spannableString9 = new SpannableString("www.pust.ac.bd\n");
        spannableString.setSpan(new RelativeSizeSpan(1.5f), 0, spannableString.length(), 33);
        spannableString2.setSpan(new RelativeSizeSpan(1.5f), 0, spannableString2.length(), 33);
        spannableString2.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), 0, spannableString2.length(), 33);
        spannableString3.setSpan(new RelativeSizeSpan(1.5f), 0, spannableString3.length(), 33);
        spannableString4.setSpan(new RelativeSizeSpan(1.5f), 0, spannableString4.length(), 33);
        spannableString4.setSpan(new ForegroundColorSpan(Color.rgb(108, 159, 238)), 0, spannableString4.length(), 33);
        spannableString5.setSpan(new RelativeSizeSpan(1.5f), 0, spannableString5.length(), 33);
        spannableString6.setSpan(new RelativeSizeSpan(1.5f), 0, spannableString6.length(), 33);
        spannableString6.setSpan(new ForegroundColorSpan(-65281), 0, spannableString6.length(), 33);
        spannableString7.setSpan(new RelativeSizeSpan(1.0f), 0, spannableString7.length(), 33);
        spannableString8.setSpan(clickableSpan, 0, spannableString8.length(), 33);
        spannableString9.setSpan(new URLSpan("https://www.pust.ac.bd"), 0, spannableString9.length(), 33);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(spannableString);
        spannableStringBuilder.append(spannableString2);
        spannableStringBuilder.append(spannableString3);
        spannableStringBuilder.append(spannableString4);
        spannableStringBuilder.append(spannableString5);
        spannableStringBuilder.append(spannableString6);
        spannableStringBuilder.append(spannableString7);
        spannableStringBuilder.append(spannableString8);
        spannableStringBuilder.append(spannableString9);
        this.textView.setText(spannableStringBuilder);
        this.textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
