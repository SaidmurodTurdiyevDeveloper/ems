package uzb.smt.presenter.screens.home_tab;

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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<AppNavigatorImpl> navigatorProvider;

  public HomeViewModel_Factory(Provider<AppNavigatorImpl> navigatorProvider) {
    this.navigatorProvider = navigatorProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(navigatorProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<AppNavigatorImpl> navigatorProvider) {
    return new HomeViewModel_Factory(navigatorProvider);
  }

  public static HomeViewModel newInstance(AppNavigatorImpl navigator) {
    return new HomeViewModel(navigator);
  }
}
