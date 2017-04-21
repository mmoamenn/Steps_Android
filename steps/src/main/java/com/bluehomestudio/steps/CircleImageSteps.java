package com.bluehomestudio.steps;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for the main component of steps
 */

public class CircleImageSteps extends RelativeLayout {
    private LinearLayout rootView;
    private List<Integer> stepsImages;
    private int stepNumber, selectedStep, stepSize;

    public CircleImageSteps(Context context) {
        super(context);
        initComponent();
    }

    public CircleImageSteps(Context context, AttributeSet attrs) {
        super(context, attrs);
        handelAttributes(attrs);
        initComponent();
    }

    public CircleImageSteps(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        handelAttributes(attrs);
        initComponent();
    }

    private void initComponent() {
        inflate(getContext(), R.layout.main_step_view, this);

        rootView = (LinearLayout) findViewById(R.id.ll_main_view);
        stepsImages = new ArrayList<>();
    }

    private int activeStepColor, inActiveStepColor;

    /**
     * Function to handel view attributes
     *
     * @param attrs Attrs from xml
     */
    private void handelAttributes(AttributeSet attrs) {

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ImageStep, 0, 0);
        try {
            stepSize = typedArray.getDimensionPixelSize(R.styleable.ImageStep_step_size, 50);
            activeStepColor = typedArray.getColor(R.styleable.ImageStep_active_step_color, Color.parseColor("#E9EBEE"));
            inActiveStepColor = typedArray.getColor(R.styleable.ImageStep_inActive_step_color, Color.DKGRAY);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Function to add view to component
     *
     * @param tag              View tag usually the step number
     * @param drawableResource drawable resource of view
     */
    private void addView(int tag, @DrawableRes int drawableResource) {
        // inflate view to component
        View view = LayoutInflater.from(getContext()).inflate(R.layout.step_view_item, rootView, false);

        //set view size and margins
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(stepSize, stepSize);
        layoutParams.setMargins(10, 10, 10, 10);
        view.findViewById(R.id.iv_main_step_image).setLayoutParams(layoutParams);
        view.setTag(tag);

        //set view background color
        setStepColorStatus(false, view);

        //add Image icon to view and add view
        ((ImageView) view.findViewById(R.id.iv_main_step_image)).setImageResource(drawableResource);
        rootView.addView(view);
    }

    /**
     * Function to set step color status
     *
     * @param isSelected is step selected
     * @param view       View to set
     */
    private void setStepColorStatus(boolean isSelected, View view) {
        //set view background color
        GradientDrawable gd = (GradientDrawable) view.getBackground().getCurrent();
        gd.setColor(isSelected ? activeStepColor : inActiveStepColor);
    }

    /**
     * Function to add steps to component
     *
     * @param drawableResources Array or Drawable resources
     */
    public void addSteps(@DrawableRes int... drawableResources) {
        // add steps to main view
        for (Integer drawableId : drawableResources) {
            stepsImages.add(drawableId);
            addView(stepNumber++, drawableId);
        }
        //get to the 1st step
        goToStep(0);
    }

    /**
     * Function to move to the next step
     */
    public void nextStep() {
        if (stepsImages.size() == selectedStep) return;
        selectedStep++;
        goToStep(selectedStep);
    }

    /**
     * Function to move to previous step
     */
    public void previousStep() {
        if (selectedStep == 0) return;
        selectedStep--;
        goToStep(selectedStep);
    }

    /**
     * Function to go to step by number
     *
     * @param stepNumber Step number
     */
    public void goToStep(int stepNumber) {
        //set all steps in inactive mode
        for (int i = 0; i < stepNumber; i++) {
            rootView.findViewWithTag(i).setBackgroundResource(R.drawable.circle_step_view);
            setStepColorStatus(false, rootView.findViewWithTag(i));
        }
        //change selected step to active mode
        rootView.findViewWithTag(stepNumber).setBackgroundResource(R.drawable.circle_step_view);
        //set view background color
        setStepColorStatus(true, rootView.findViewWithTag(stepNumber));
        selectedStep = stepNumber;
    }

}
