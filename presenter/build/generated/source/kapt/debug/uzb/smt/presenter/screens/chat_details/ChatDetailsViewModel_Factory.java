package uzb.smt.presenter.screens.chat_details;

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
public final class ChatDetailsViewModel_Factory implements Factory<ChatDetailsViewModel> {
  private final Provider<AppNavigatorImpl> appNavigatorImplProvider;

  public ChatDetailsViewModel_Factory(Provider<AppNavigatorImpl> appNavigatorImplProvider) {
    this.appNavigatorImplProvider = appNavigatorImplProvider;
  }

  @Override
  public ChatDetailsViewModel get() {
    return newInstance(appNavigatorImplProvider.get());
  }

  public static ChatDetailsViewModel_Factory create(
      Provider<AppNavigatorImpl> appNavigatorImplProvider) {
    return new ChatDetailsViewModel_Factory(appNavigatorImplProvider);
  }

  public static ChatDetailsViewModel newInstance(AppNavigatorImpl appNavigatorImpl) {
    return new ChatDetailsViewModel(appNavigatorImpl);
  }
}
