package in.ponshere.fintent.sample.fragments.navigate_to;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import in.ponshere.fintent.FIntent;
import in.ponshere.fintent.FIntentFragment;
import in.ponshere.fintent.sample.R;
import in.ponshere.fintent.sample.databinding.BindingUS3FragmentCommonList;

/**
 * Example for handling 2 in 1 fragment
 *
 * @author Ponsuyambu
 * @since 12/4/17.
 */

public class US3FragmenCommonList extends FIntentFragment<BindingUS3FragmentCommonList> implements View.OnClickListener, FIntentNames {

    public static final String NAME_FRUITS = "FRUITS";
    public static final String NAME_VEG = "VEG";

    public static final int TYPE_FRUITS = 1;
    public static final int TYPE_VEGETABLES = 2;
    public static final String KEY_TYPE = "KEY_TYPE";

    private int type = TYPE_FRUITS;

    @Override
    protected void onViewCreated(@Nullable Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        binding.btnNext.setOnClickListener(this);
        if (getArguments().getInt(KEY_TYPE) == TYPE_FRUITS) {
            type = TYPE_FRUITS;
            binding.btnNext.setText("Next Fragment(Vegetables List)");
            binding.lblInfo.setText("Fruits List(via Common List)");
        } else {
            type = TYPE_VEGETABLES;
            getView().setBackgroundColor(getResources().getColor(R.color.bg_fragment_c));
            binding.btnNext.setText("Next Fragment(Details)");
            binding.lblInfo.setText("Veg List(via Common List)");
        }


    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.us3_fragment_base_list;
    }

    @Override
    public void onClick(View view) {
        if (type == TYPE_FRUITS) {
            startFragment(new FIntent(US3FragmenCommonList.class, FRUITS_SCREEN).putExtra(KEY_TYPE, TYPE_VEGETABLES));
        } else {
            startFragment(new FIntent(US3FragmentDetails.class, VEGETABLES_SCREEN));
        }

    }

    @Override
    public String uniqueFragmentName() {
        if (type == TYPE_FRUITS) {
            return NAME_FRUITS;
        } else {
            return NAME_VEG;
        }
    }
}
