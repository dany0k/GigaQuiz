package ru.vsu.cs.zmaev.databinding;
import ru.vsu.cs.zmaev.R;
import ru.vsu.cs.zmaev.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentUserProfileBindingImpl extends FragmentUserProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.background_profile, 4);
        sViewsWithIds.put(R.id.edit_profile_button, 5);
        sViewsWithIds.put(R.id.profile_image, 6);
        sViewsWithIds.put(R.id.linearLayout, 7);
        sViewsWithIds.put(R.id.profile_username, 8);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentUserProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private FragmentUserProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.ImageButton) bindings[5]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.TextView) bindings[3]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.TextView) bindings[8]
            );
        this.androidResult.setTag(null);
        this.countryIcon.setTag(null);
        this.fragmentUserProfile.setTag(null);
        this.geographicalResult.setTag(null);
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
            setUser((ru.vsu.cs.zmaev.UserProfileFragment) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setUser(@Nullable ru.vsu.cs.zmaev.UserProfileFragment User) {
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
        ru.vsu.cs.zmaev.UserProfileFragment user = mUser;
        android.graphics.drawable.Drawable userCountryIcon = null;
        java.lang.String userGeographicalResult = null;
        java.lang.String userAndroidResult = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (user != null) {
                    // read user.countryIcon
                    userCountryIcon = user.countryIcon;
                    // read user.geographicalResult
                    userGeographicalResult = user.geographicalResult;
                    // read user.androidResult
                    userAndroidResult = user.androidResult;
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.androidResult, userAndroidResult);
            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.countryIcon, userCountryIcon);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.geographicalResult, userGeographicalResult);
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