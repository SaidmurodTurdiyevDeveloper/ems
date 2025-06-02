package uzb.smt.ems.app;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import uzb.smt.ems.MainActivity;
import uzb.smt.presenter.navigator.AppNavigatorImpl;
import uzb.smt.presenter.screens.chat_details.ChatDetailsViewModel;
import uzb.smt.presenter.screens.chat_details.ChatDetailsViewModel_HiltModules;
import uzb.smt.presenter.screens.chat_tab.ChatViewModel;
import uzb.smt.presenter.screens.chat_tab.ChatViewModel_HiltModules;
import uzb.smt.presenter.screens.home_tab.HomeViewModel;
import uzb.smt.presenter.screens.home_tab.HomeViewModel_HiltModules;
import uzb.smt.presenter.screens.lesson_schedule_tab.LessonScheduleViewModel;
import uzb.smt.presenter.screens.lesson_schedule_tab.LessonScheduleViewModel_HiltModules;
import uzb.smt.presenter.screens.login.LoginViewModel;
import uzb.smt.presenter.screens.login.LoginViewModel_HiltModules;
import uzb.smt.presenter.screens.subject_tab.SubjectViewModel;
import uzb.smt.presenter.screens.subject_tab.SubjectViewModel_HiltModules;
import uzb.smt.presenter.screens.usefull_tab.UseFullViewModel;
import uzb.smt.presenter.screens.usefull_tab.UseFullViewModel_HiltModules;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class DaggerEmsApp_HiltComponents_SingletonC {
  private DaggerEmsApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static EmsApp_HiltComponents.SingletonC create() {
    return new Builder().build();
  }

  public static final class Builder {
    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public EmsApp_HiltComponents.SingletonC build() {
      return new SingletonCImpl();
    }
  }

  private static final class ActivityRetainedCBuilder implements EmsApp_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public EmsApp_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements EmsApp_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public EmsApp_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements EmsApp_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public EmsApp_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements EmsApp_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public EmsApp_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements EmsApp_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public EmsApp_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements EmsApp_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public EmsApp_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements EmsApp_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public EmsApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends EmsApp_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends EmsApp_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends EmsApp_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends EmsApp_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(MapBuilder.<String, Boolean>newMapBuilder(7).put(LazyClassKeyProvider.uzb_smt_presenter_screens_chat_details_ChatDetailsViewModel, ChatDetailsViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.uzb_smt_presenter_screens_chat_tab_ChatViewModel, ChatViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.uzb_smt_presenter_screens_home_tab_HomeViewModel, HomeViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.uzb_smt_presenter_screens_lesson_schedule_tab_LessonScheduleViewModel, LessonScheduleViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.uzb_smt_presenter_screens_login_LoginViewModel, LoginViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.uzb_smt_presenter_screens_subject_tab_SubjectViewModel, SubjectViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.uzb_smt_presenter_screens_usefull_tab_UseFullViewModel, UseFullViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public void injectMainActivity(MainActivity arg0) {
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String uzb_smt_presenter_screens_chat_details_ChatDetailsViewModel = "uzb.smt.presenter.screens.chat_details.ChatDetailsViewModel";

      static String uzb_smt_presenter_screens_subject_tab_SubjectViewModel = "uzb.smt.presenter.screens.subject_tab.SubjectViewModel";

      static String uzb_smt_presenter_screens_usefull_tab_UseFullViewModel = "uzb.smt.presenter.screens.usefull_tab.UseFullViewModel";

      static String uzb_smt_presenter_screens_login_LoginViewModel = "uzb.smt.presenter.screens.login.LoginViewModel";

      static String uzb_smt_presenter_screens_lesson_schedule_tab_LessonScheduleViewModel = "uzb.smt.presenter.screens.lesson_schedule_tab.LessonScheduleViewModel";

      static String uzb_smt_presenter_screens_chat_tab_ChatViewModel = "uzb.smt.presenter.screens.chat_tab.ChatViewModel";

      static String uzb_smt_presenter_screens_home_tab_HomeViewModel = "uzb.smt.presenter.screens.home_tab.HomeViewModel";

      @KeepFieldType
      ChatDetailsViewModel uzb_smt_presenter_screens_chat_details_ChatDetailsViewModel2;

      @KeepFieldType
      SubjectViewModel uzb_smt_presenter_screens_subject_tab_SubjectViewModel2;

      @KeepFieldType
      UseFullViewModel uzb_smt_presenter_screens_usefull_tab_UseFullViewModel2;

      @KeepFieldType
      LoginViewModel uzb_smt_presenter_screens_login_LoginViewModel2;

      @KeepFieldType
      LessonScheduleViewModel uzb_smt_presenter_screens_lesson_schedule_tab_LessonScheduleViewModel2;

      @KeepFieldType
      ChatViewModel uzb_smt_presenter_screens_chat_tab_ChatViewModel2;

      @KeepFieldType
      HomeViewModel uzb_smt_presenter_screens_home_tab_HomeViewModel2;
    }
  }

  private static final class ViewModelCImpl extends EmsApp_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<ChatDetailsViewModel> chatDetailsViewModelProvider;

    private Provider<ChatViewModel> chatViewModelProvider;

    private Provider<HomeViewModel> homeViewModelProvider;

    private Provider<LessonScheduleViewModel> lessonScheduleViewModelProvider;

    private Provider<LoginViewModel> loginViewModelProvider;

    private Provider<SubjectViewModel> subjectViewModelProvider;

    private Provider<UseFullViewModel> useFullViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.chatDetailsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.chatViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.homeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.lessonScheduleViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.loginViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.subjectViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.useFullViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(7).put(LazyClassKeyProvider.uzb_smt_presenter_screens_chat_details_ChatDetailsViewModel, ((Provider) chatDetailsViewModelProvider)).put(LazyClassKeyProvider.uzb_smt_presenter_screens_chat_tab_ChatViewModel, ((Provider) chatViewModelProvider)).put(LazyClassKeyProvider.uzb_smt_presenter_screens_home_tab_HomeViewModel, ((Provider) homeViewModelProvider)).put(LazyClassKeyProvider.uzb_smt_presenter_screens_lesson_schedule_tab_LessonScheduleViewModel, ((Provider) lessonScheduleViewModelProvider)).put(LazyClassKeyProvider.uzb_smt_presenter_screens_login_LoginViewModel, ((Provider) loginViewModelProvider)).put(LazyClassKeyProvider.uzb_smt_presenter_screens_subject_tab_SubjectViewModel, ((Provider) subjectViewModelProvider)).put(LazyClassKeyProvider.uzb_smt_presenter_screens_usefull_tab_UseFullViewModel, ((Provider) useFullViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return Collections.<Class<?>, Object>emptyMap();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String uzb_smt_presenter_screens_chat_tab_ChatViewModel = "uzb.smt.presenter.screens.chat_tab.ChatViewModel";

      static String uzb_smt_presenter_screens_lesson_schedule_tab_LessonScheduleViewModel = "uzb.smt.presenter.screens.lesson_schedule_tab.LessonScheduleViewModel";

      static String uzb_smt_presenter_screens_usefull_tab_UseFullViewModel = "uzb.smt.presenter.screens.usefull_tab.UseFullViewModel";

      static String uzb_smt_presenter_screens_chat_details_ChatDetailsViewModel = "uzb.smt.presenter.screens.chat_details.ChatDetailsViewModel";

      static String uzb_smt_presenter_screens_home_tab_HomeViewModel = "uzb.smt.presenter.screens.home_tab.HomeViewModel";

      static String uzb_smt_presenter_screens_login_LoginViewModel = "uzb.smt.presenter.screens.login.LoginViewModel";

      static String uzb_smt_presenter_screens_subject_tab_SubjectViewModel = "uzb.smt.presenter.screens.subject_tab.SubjectViewModel";

      @KeepFieldType
      ChatViewModel uzb_smt_presenter_screens_chat_tab_ChatViewModel2;

      @KeepFieldType
      LessonScheduleViewModel uzb_smt_presenter_screens_lesson_schedule_tab_LessonScheduleViewModel2;

      @KeepFieldType
      UseFullViewModel uzb_smt_presenter_screens_usefull_tab_UseFullViewModel2;

      @KeepFieldType
      ChatDetailsViewModel uzb_smt_presenter_screens_chat_details_ChatDetailsViewModel2;

      @KeepFieldType
      HomeViewModel uzb_smt_presenter_screens_home_tab_HomeViewModel2;

      @KeepFieldType
      LoginViewModel uzb_smt_presenter_screens_login_LoginViewModel2;

      @KeepFieldType
      SubjectViewModel uzb_smt_presenter_screens_subject_tab_SubjectViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // uzb.smt.presenter.screens.chat_details.ChatDetailsViewModel 
          return (T) new ChatDetailsViewModel(singletonCImpl.appNavigatorImplProvider.get());

          case 1: // uzb.smt.presenter.screens.chat_tab.ChatViewModel 
          return (T) new ChatViewModel(singletonCImpl.appNavigatorImplProvider.get());

          case 2: // uzb.smt.presenter.screens.home_tab.HomeViewModel 
          return (T) new HomeViewModel(singletonCImpl.appNavigatorImplProvider.get());

          case 3: // uzb.smt.presenter.screens.lesson_schedule_tab.LessonScheduleViewModel 
          return (T) new LessonScheduleViewModel(singletonCImpl.appNavigatorImplProvider.get());

          case 4: // uzb.smt.presenter.screens.login.LoginViewModel 
          return (T) new LoginViewModel(singletonCImpl.appNavigatorImplProvider.get());

          case 5: // uzb.smt.presenter.screens.subject_tab.SubjectViewModel 
          return (T) new SubjectViewModel(singletonCImpl.appNavigatorImplProvider.get());

          case 6: // uzb.smt.presenter.screens.usefull_tab.UseFullViewModel 
          return (T) new UseFullViewModel(singletonCImpl.appNavigatorImplProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends EmsApp_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends EmsApp_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends EmsApp_HiltComponents.SingletonC {
    private final SingletonCImpl singletonCImpl = this;

    private Provider<AppNavigatorImpl> appNavigatorImplProvider;

    private SingletonCImpl() {

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.appNavigatorImplProvider = DoubleCheck.provider(new SwitchingProvider<AppNavigatorImpl>(singletonCImpl, 0));
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    @Override
    public void injectEmsApp(EmsApp emsApp) {
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // uzb.smt.presenter.navigator.AppNavigatorImpl 
          return (T) new AppNavigatorImpl();

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
