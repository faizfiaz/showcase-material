package com.github.faizf.showcaselibrary;

import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.view.View;

import com.showcase.faizfiaz.MaterialShowcaseView;
import com.showcase.faizfiaz.shape.RectangleShape;


/**
 * Created by faizf on 28/05/2018.
 */

public class ShowCaseUtil {
    public static MaterialShowcaseView showCase(View target, Activity activity, int layout, int width, int height,
                                                boolean drawSpotLight, boolean topBottom, DialogFragment dialogFragment) {
        return new MaterialShowcaseView.Builder(activity, dialogFragment)
                .setTarget(target)
                .setLayout(layout)
                .setShape(new RectangleShape(width, height, drawSpotLight))
                .setShapePadding(0)
                .setTopBottom(topBottom)
                .setMaskColour(activity.getResources().getColor(R.color.blackTrans))
                .show(dialogFragment != null);
    }
}
