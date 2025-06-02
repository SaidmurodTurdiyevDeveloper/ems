package uzb.smt.presenter.screens.lesson_schedule_tab;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import uzb.smt.presenter.navigator.AppNavigatorImpl;

@ScopeMetadata
@QualifierMetadata
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
public final class LessonScheduleViewModel_Factory implements Factory<LessonScheduleViewModel> {
  private final Provider<AppNavigatorImpl> appNavigatorImplProvider;

  public LessonScheduleViewModel_Factory(Provider<AppNavigatorImpl> appNavigatorImplProvider) {
    this.appNavigatorImplProvider = appNavigatorImplProvider;
  }

  @Override
  public LessonScheduleViewModel get() {
    return newInstance(appNavigatorImplProvider.get());
  }

  public static LessonScheduleViewModel_Factory create(
      Provider<AppNavigatorImpl> appNavigatorImplProvider) {
    return new LessonScheduleViewModel_Factory(appNavigatorImplProvider);
  }

  public static LessonScheduleViewModel newInstance(AppNavigatorImpl appNavigatorImpl) {
    return new LessonScheduleViewModel(appNavigatorImpl);
  }
}
