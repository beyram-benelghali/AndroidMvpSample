package beyram_ghali.me.androidmvpsample.Base;

/**
 * Created by beyram on 23/08/17.
 */

public abstract class BasePresenter<M, V> {

    public abstract void setModel(M model);

    public abstract void attachView(V view);

    public abstract V getView();

    public abstract void detachView();

}
