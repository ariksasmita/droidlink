package com.droidlink.app.di;

import com.droidlink.core.security.CertificateGenerator;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class SecurityModule_ProvideCertificateGeneratorFactory implements Factory<CertificateGenerator> {
  @Override
  public CertificateGenerator get() {
    return provideCertificateGenerator();
  }

  public static SecurityModule_ProvideCertificateGeneratorFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CertificateGenerator provideCertificateGenerator() {
    return Preconditions.checkNotNullFromProvides(SecurityModule.INSTANCE.provideCertificateGenerator());
  }

  private static final class InstanceHolder {
    private static final SecurityModule_ProvideCertificateGeneratorFactory INSTANCE = new SecurityModule_ProvideCertificateGeneratorFactory();
  }
}
