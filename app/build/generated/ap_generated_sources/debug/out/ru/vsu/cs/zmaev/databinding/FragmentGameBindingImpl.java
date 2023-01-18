package ru.vsu.cs.zmaev.databinding;
import ru.vsu.cs.zmaev.R;
import ru.vsu.cs.zmaev.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentGameBindingImpl extends FragmentGameBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.frameLayout, 6);
        sViewsWithIds.put(R.id.questionImage, 7);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentGameBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private FragmentGameBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[2]
            , (android.widget.Button) bindings[4]
            , (android.widget.Button) bindings[3]
            , (android.widget.Button) bindings[5]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[6]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.TextView) bindings[1]
            );
        this.buttonFirstAnswer.setTag(null);
        this.buttonFourthAnswer.setTag(null);
        this.buttonSecondAnswer.setTag(null);
        this.buttonThirdAnswer.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.questionText.setTag(null);
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
        if (BR.game == variableId) {
            setGame((ru.vsu.cs.zmaev.GameFragment) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setGame(@Nullable ru.vsu.cs.zmaev.GameFragment Game) {
        this.mGame = Game;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.game);
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
        java.lang.String gameCurrentQuestionGetText = null;
        java.lang.String gameAnswers3 = null;
        java.lang.String gameAnswers0 = null;
        java.lang.String gameAnswers1 = null;
        ru.vsu.cs.zmaev.model.ImageQuestion gameCurrentQuestion = null;
        java.lang.String gameAnswers2 = null;
        java.util.List<java.lang.String> gameAnswers = null;
        ru.vsu.cs.zmaev.GameFragment game = mGame;

        if ((dirtyFlags & 0x3L) != 0) {



                if (game != null) {
                    // read game.currentQuestion
                    gameCurrentQuestion = game.currentQuestion;
                    // read game.answers
                    gameAnswers = game.answers;
                }


                if (gameCurrentQuestion != null) {
                    // read game.currentQuestion.getText
                    gameCurrentQuestionGetText = gameCurrentQuestion.getText();
                }
                if (gameAnswers != null) {
                    // read game.answers[3]
                    gameAnswers3 = getFromList(gameAnswers, 3);
                    // read game.answers[0]
                    gameAnswers0 = getFromList(gameAnswers, 0);
                    // read game.answers[1]
                    gameAnswers1 = getFromList(gameAnswers, 1);
                    // read game.answers[2]
                    gameAnswers2 = getFromList(gameAnswers, 2);
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.buttonFirstAnswer, gameAnswers0);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.buttonFourthAnswer, gameAnswers3);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.buttonSecondAnswer, gameAnswers1);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.buttonThirdAnswer, gameAnswers2);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.questionText, gameCurrentQuestionGetText);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): game
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}