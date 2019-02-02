package com.iroyoraso.assessment.test21buttons.ui.list;

import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
@SuppressWarnings("unchecked")
public class ListViewModelFactory implements ViewModelProvider.Factory {

    private final ListViewModelInjector injector;

    public ListViewModelFactory(ListViewModelInjector injector) {
        this.injector = injector;
    }

    @NonNull
    @Override
    public ListViewModel create(@NonNull Class modelClass) {
        return new ListViewModel(injector);
    }
}
