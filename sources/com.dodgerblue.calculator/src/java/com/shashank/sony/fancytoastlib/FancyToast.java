package com.shashank.sony.fancytoastlib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class FancyToast extends Toast {
    public static final int CONFUSING = 6;
    public static final int DEFAULT = 5;
    public static final int ERROR = 3;
    public static final int INFO = 4;
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    public static final int SUCCESS = 1;
    public static final int WARNING = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LayoutType {
    }

    public FancyToast(@NonNull Context context) {
        super(context);
    }

    public static Toast makeText(@NonNull Context context, CharSequence charSequence, int i, int i2, boolean z) {
        Toast toast = new Toast(context);
        toast.setDuration(i);
        View inflate = LayoutInflater.from(context).inflate(R.layout.fancytoast_layout, null, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.toast_type);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.toast_icon);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.imageView4);
        ((TextView) inflate.findViewById(R.id.toast_text)).setText(charSequence);
        if (z) {
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
        switch (i2) {
            case 1:
                linearLayout.setBackgroundResource(R.drawable.success_shape);
                imageView.setImageResource(R.drawable.ic_check_black_24dp);
                break;
            case WARNING /*2*/:
                linearLayout.setBackgroundResource(R.drawable.warning_shape);
                imageView.setImageResource(R.drawable.ic_pan_tool_black_24dp);
                break;
            case ERROR /*3*/:
                linearLayout.setBackgroundResource(R.drawable.error_shape);
                imageView.setImageResource(R.drawable.ic_clear_black_24dp);
                break;
            case INFO /*4*/:
                linearLayout.setBackgroundResource(R.drawable.info_shape);
                imageView.setImageResource(R.drawable.ic_info_outline_black_24dp);
                break;
            case DEFAULT /*5*/:
                linearLayout.setBackgroundResource(R.drawable.default_shape);
                imageView.setVisibility(8);
                break;
            case CONFUSING /*6*/:
                linearLayout.setBackgroundResource(R.drawable.confusing_shape);
                imageView.setImageResource(R.drawable.ic_refresh_black_24dp);
                break;
        }
        toast.setView(inflate);
        return toast;
    }

    public static Toast makeText(@NonNull Context context, CharSequence charSequence, int i, int i2, @DrawableRes int i3, boolean z) {
        Toast toast = new Toast(context);
        toast.setDuration(i);
        View inflate = LayoutInflater.from(context).inflate(R.layout.fancytoast_layout, null, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.toast_type);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.toast_icon);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.imageView4);
        ((TextView) inflate.findViewById(R.id.toast_text)).setText(charSequence);
        imageView.setImageResource(i3);
        if (z) {
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
        switch (i2) {
            case 1:
                linearLayout.setBackgroundResource(R.drawable.success_shape);
                break;
            case WARNING /*2*/:
                linearLayout.setBackgroundResource(R.drawable.warning_shape);
                break;
            case ERROR /*3*/:
                linearLayout.setBackgroundResource(R.drawable.error_shape);
                break;
            case INFO /*4*/:
                linearLayout.setBackgroundResource(R.drawable.info_shape);
                break;
            case DEFAULT /*5*/:
                linearLayout.setBackgroundResource(R.drawable.default_shape);
                imageView.setVisibility(8);
                break;
            case CONFUSING /*6*/:
                linearLayout.setBackgroundResource(R.drawable.confusing_shape);
                break;
            default:
                linearLayout.setBackgroundResource(R.drawable.default_shape);
                imageView.setVisibility(8);
                break;
        }
        toast.setView(inflate);
        return toast;
    }
}
