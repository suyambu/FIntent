package in.ponshere.fintent.sample.fragments.navigate_to;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import in.ponshere.fintent.FIntent;
import in.ponshere.fintent.FIntentFragment;
import in.ponshere.fintent.sample.R;
import in.ponshere.fintent.sample.databinding.BindingUS3FragmentA;

import static in.ponshere.fintent.sample.fragments.navigate_to.US3FragmenCommonList.KEY_TYPE;
import static in.ponshere.fintent.sample.fragments.navigate_to.US3FragmenCommonList.TYPE_FRUITS;

/**
 * @author Ponsuyambu
 * @since 12/4/17.
 */

public class US3FragmentA extends FIntentFragment<BindingUS3FragmentA> implements View.OnClickListener, FIntentNames {

    @Override
    protected void onViewCreated(@Nullable Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        binding.btnNext.setOnClickListener(this);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Navigate To");
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.us3_fragment_a;
    }

    @Override
    public void onClick(View view) {
        startFragment(
                new FIntent(US3FragmenCommonList.class, US3FragmentA)
                        .putExtra(KEY_TYPE, TYPE_FRUITS)
        );
    }
}
