package com.iroyoraso.assessment.test21buttons.ui.detail.presentation;

import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

/**
 * Created by iroyo on 2/2/19.
 * Mail: iroyoraso@gmail.com
 */
@SuppressWarnings("unchecked")
public class FactoryViewModel implements ViewModelProvider.Factory {

    private final InfoDetailViewModelInjector injector;

    public FactoryViewModel(InfoDetailViewModelInjector injector) {
        this.injector = injector;
    }

    @NonNull
    @Override
    public InfoDetailViewModel create(@NonNull Class modelClass) {
        return new InfoDetailViewModel(injector);
    }
}
