import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { AboutUsComponent } from './about-us/about-us.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CheckInComponent } from './check-in/check-in.component';
import { LoginComponent } from './login/login.component';
import { OptionComponent } from './option/option.component';
import { OfferServiceComponent } from './offer-service/offer-service.component';

@NgModule({
  declarations: [
    AppComponent,
    AboutUsComponent,
    CheckInComponent,
    LoginComponent,
    OptionComponent,
    OfferServiceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
