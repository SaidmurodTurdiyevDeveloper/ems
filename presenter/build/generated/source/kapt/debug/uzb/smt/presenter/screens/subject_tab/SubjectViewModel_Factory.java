package uzb.smt.presenter.screens.subject_tab;

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
public final class SubjectViewModel_Factory implements Factory<SubjectViewModel> {
  private final Provider<AppNavigatorImpl> navigatorImplProvider;

  public SubjectViewModel_Factory(Provider<AppNavigatorImpl> navigatorImplProvider) {
    this.navigatorImplProvider = navigatorImplProvider;
  }

  @Override
  public SubjectViewModel get() {
    return newInstance(navigatorImplProvider.get());
  }

  public static SubjectViewModel_Factory create(Provider<AppNavigatorImpl> navigatorImplProvider) {
    return new SubjectViewModel_Factory(navigatorImplProvider);
  }

  public static SubjectViewModel newInstance(AppNavigatorImpl navigatorImpl) {
    return new SubjectViewModel(navigatorImpl);
  }
}
