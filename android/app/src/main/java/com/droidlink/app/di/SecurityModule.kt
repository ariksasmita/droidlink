package com.droidlink.app.di

import com.droidlink.core.security.CertificateGenerator
import com.droidlink.core.security.QRCodeParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SecurityModule {
    
    @Provides
    @Singleton
    fun provideCertificateGenerator(): CertificateGenerator {
        return CertificateGenerator()
    }
    
    @Provides
    @Singleton
    fun provideQRCodeParser(): QRCodeParser {
        return QRCodeParser()
    }
}
