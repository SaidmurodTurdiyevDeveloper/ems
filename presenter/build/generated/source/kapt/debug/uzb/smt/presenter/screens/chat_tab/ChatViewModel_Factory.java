package uzb.smt.presenter.screens.chat_tab;

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
public final class ChatViewModel_Factory implements Factory<ChatViewModel> {
  private final Provider<AppNavigatorImpl> appNavigatorImplProvider;

  public ChatViewModel_Factory(Provider<AppNavigatorImpl> appNavigatorImplProvider) {
    this.appNavigatorImplProvider = appNavigatorImplProvider;
  }

  @Override
  public ChatViewModel get() {
    return newInstance(appNavigatorImplProvider.get());
  }

  public static ChatViewModel_Factory create(Provider<AppNavigatorImpl> appNavigatorImplProvider) {
    return new ChatViewModel_Factory(appNavigatorImplProvider);
  }

  public static ChatViewModel newInstance(AppNavigatorImpl appNavigatorImpl) {
    return new ChatViewModel(appNavigatorImpl);
  }
}
