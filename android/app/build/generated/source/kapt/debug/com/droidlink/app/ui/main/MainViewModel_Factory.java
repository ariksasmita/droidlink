package com.droidlink.app.ui.main;

import com.droidlink.core.security.CertificateGenerator;
import com.droidlink.core.security.QRCodeParser;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<CertificateGenerator> certificateGeneratorProvider;

  private final Provider<QRCodeParser> qrCodeParserProvider;

  public MainViewModel_Factory(Provider<CertificateGenerator> certificateGeneratorProvider,
      Provider<QRCodeParser> qrCodeParserProvider) {
    this.certificateGeneratorProvider = certificateGeneratorProvider;
    this.qrCodeParserProvider = qrCodeParserProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(certificateGeneratorProvider.get(), qrCodeParserProvider.get());
  }

  public static MainViewModel_Factory create(
      Provider<CertificateGenerator> certificateGeneratorProvider,
      Provider<QRCodeParser> qrCodeParserProvider) {
    return new MainViewModel_Factory(certificateGeneratorProvider, qrCodeParserProvider);
  }

  public static MainViewModel newInstance(CertificateGenerator certificateGenerator,
      QRCodeParser qrCodeParser) {
    return new MainViewModel(certificateGenerator, qrCodeParser);
  }
}
