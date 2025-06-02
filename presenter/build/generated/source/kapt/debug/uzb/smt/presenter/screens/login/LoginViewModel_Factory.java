package uzb.smt.presenter.screens.login;

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
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<AppNavigatorImpl> navigatorProvider;

  public LoginViewModel_Factory(Provider<AppNavigatorImpl> navigatorProvider) {
    this.navigatorProvider = navigatorProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(navigatorProvider.get());
  }

  public static LoginViewModel_Factory create(Provider<AppNavigatorImpl> navigatorProvider) {
    return new LoginViewModel_Factory(navigatorProvider);
  }

  public static LoginViewModel newInstance(AppNavigatorImpl navigator) {
    return new LoginViewModel(navigator);
  }
}
