package uzb.smt.presenter.screens.usefull_tab;

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
public final class UseFullViewModel_Factory implements Factory<UseFullViewModel> {
  private final Provider<AppNavigatorImpl> navigatorImplProvider;

  public UseFullViewModel_Factory(Provider<AppNavigatorImpl> navigatorImplProvider) {
    this.navigatorImplProvider = navigatorImplProvider;
  }

  @Override
  public UseFullViewModel get() {
    return newInstance(navigatorImplProvider.get());
  }

  public static UseFullViewModel_Factory create(Provider<AppNavigatorImpl> navigatorImplProvider) {
    return new UseFullViewModel_Factory(navigatorImplProvider);
  }

  public static UseFullViewModel newInstance(AppNavigatorImpl navigatorImpl) {
    return new UseFullViewModel(navigatorImpl);
  }
}
