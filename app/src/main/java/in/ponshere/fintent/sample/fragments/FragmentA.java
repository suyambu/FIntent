package in.ponshere.fintent.sample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import in.ponshere.fintent.FIntent;
import in.ponshere.fintent.FIntentControllable;
import in.ponshere.fintent.Factory;
import in.ponshere.fintent.sample.BaseFragment;
import in.ponshere.fintent.sample.R;
import in.ponshere.fintent.sample.databinding.BindingFragmentA;

/**
 * @author Ponsuyambu
 * @since 11/4/17.
 */

public class FragmentA extends BaseFragment<BindingFragmentA> {

    public static final String FINTENT_BS_NAME = "FragmentA";

    @Override
    protected void onViewCreated(@Nullable Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Factory.getInstance().getController((FIntentControllable) getActivity())
                        .startFragment(new FIntent(FragmentB.class).setTag(FINTENT_BS_NAME));

            }
        });
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.fragment_a;
    }
}