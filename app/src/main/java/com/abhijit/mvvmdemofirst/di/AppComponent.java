package com.abhijit.mvvmdemofirst.di;


import com.abhijit.mvvmdemofirst.App;
import com.abhijit.mvvmdemofirst.di.modules.ActivityBindingModule;
import com.abhijit.mvvmdemofirst.di.modules.AppModule;
import com.abhijit.mvvmdemofirst.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        /* Use AndroidInjectionModule.class if you're not using support library */
        AndroidSupportInjectionModule.class,
        AppModule.class,
        NetworkModule.class,
        ActivityBindingModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App application);

        AppComponent build();
    }

    void inject(App app);
}
