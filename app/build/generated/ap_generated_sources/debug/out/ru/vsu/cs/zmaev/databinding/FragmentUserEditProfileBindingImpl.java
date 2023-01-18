package ru.vsu.cs.zmaev.databinding;
import ru.vsu.cs.zmaev.R;
import ru.vsu.cs.zmaev.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentUserEditProfileBindingImpl extends FragmentUserEditProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.background_profile, 3);
        sViewsWithIds.put(R.id.profile_image, 4);
        sViewsWithIds.put(R.id.linearLayout5, 5);
        sViewsWithIds.put(R.id.countryLinearLayout, 6);
        sViewsWithIds.put(R.id.linearLayout4, 7);
        sViewsWithIds.put(R.id.ageSpinner, 8);
        sViewsWithIds.put(R.id.sex_spinner, 9);
        sViewsWithIds.put(R.id.submit_button, 10);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentUserEditProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private FragmentUserEditProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Spinner) bindings[8]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.Spinner) bindings[2]
            , (android.widget.EditText) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.Spinner) bindings[9]
            , (android.widget.Button) bindings[10]
            );
        this.countrySpinner.setTag(null);
        this.editName.setTag(null);
        this.fragmentUserProfile.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.user == variableId) {
            setUser((ru.vsu.cs.zmaev.UserEditProfileFragment) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setUser(@Nullable ru.vsu.cs.zmaev.UserEditProfileFragment User) {
        this.mUser = User;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.user);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        int userCountry = 0;
        ru.vsu.cs.zmaev.UserEditProfileFragment user = mUser;
        java.lang.String userUsername = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (user != null) {
                    // read user.country
                    userCountry = user.country;
                    // read user.username
                    userUsername = user.username;
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.AdapterViewBindingAdapter.setSelection(this.countrySpinner, userCountry);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editName, userUsername);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): user
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}