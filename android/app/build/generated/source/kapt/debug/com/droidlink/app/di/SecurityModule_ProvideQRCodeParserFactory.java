package com.droidlink.app.di;

import com.droidlink.core.security.QRCodeParser;
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
public final class SecurityModule_ProvideQRCodeParserFactory implements Factory<QRCodeParser> {
  @Override
  public QRCodeParser get() {
    return provideQRCodeParser();
  }

  public static SecurityModule_ProvideQRCodeParserFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static QRCodeParser provideQRCodeParser() {
    return Preconditions.checkNotNullFromProvides(SecurityModule.INSTANCE.provideQRCodeParser());
  }

  private static final class InstanceHolder {
    private static final SecurityModule_ProvideQRCodeParserFactory INSTANCE = new SecurityModule_ProvideQRCodeParserFactory();
  }
}
