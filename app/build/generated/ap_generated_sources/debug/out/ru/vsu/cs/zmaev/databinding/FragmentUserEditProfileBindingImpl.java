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
        sViewsWithIds.put(R.id.backgroundProfile, 1);
        sViewsWithIds.put(R.id.profileImage, 2);
        sViewsWithIds.put(R.id.linearLayout5, 3);
        sViewsWithIds.put(R.id.edit_name, 4);
        sViewsWithIds.put(R.id.countryLinearLayout, 5);
        sViewsWithIds.put(R.id.countrySpinner, 6);
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
            , (android.widget.ImageView) bindings[1]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.Spinner) bindings[6]
            , (android.widget.EditText) bindings[4]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.Spinner) bindings[9]
            , (android.widget.Button) bindings[10]
            );
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
        // batch finished
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