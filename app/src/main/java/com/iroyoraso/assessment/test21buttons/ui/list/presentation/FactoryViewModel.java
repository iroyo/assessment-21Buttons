package com.iroyoraso.assessment.test21buttons.ui.list.presentation;

import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
@SuppressWarnings("unchecked")
public class FactoryViewModel implements ViewModelProvider.Factory {

    private final ListViewModelInjector injector;

    public FactoryViewModel(ListViewModelInjector injector) {
        this.injector = injector;
    }

    @NonNull
    @Override
    public ListViewModel create(@NonNull Class modelClass) {
        return new ListViewModel(injector);
    }
}
